package org.sheepy.lily.vulkan.resource.barrier;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.vulkan.model.resource.AbstractImageBarrier;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ImageTransition;
import org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier;
import org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ReferenceImageBarrierImpl;
import org.sheepy.lily.vulkan.resource.barrier.proxy.IImageProxy;
import org.sheepy.lily.vulkan.resource.image.ImageUtil;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public class ImageBarrierExecutor implements IBarrierExecutor
{
	private final AbstractImageBarrier barrier;

	private VkImageMemoryBarrier.Buffer barrierInfos = null;
	private EPipelineStage srcStage;
	private EPipelineStage dstStage;

	ImageBarrierExecutor(AbstractImageBarrier barrier)
	{
		this.barrier = barrier;
	}

	@Override
	public void allocate()
	{
		allocate(VK_QUEUE_FAMILY_IGNORED, VK_QUEUE_FAMILY_IGNORED);
	}

	@Override
	public void allocate(int srcQueueFamillyIndex, int dstQueueFamillyIndex)
	{
		barrierInfos = VkImageMemoryBarrier.calloc(barrier.getTransitions().size());
		srcStage = barrier.getSrcStage();
		dstStage = barrier.getDstStage();
		final var imageProxy = IImageProxy.newProxy(barrier);

		for (final ImageTransition transition : barrier.getTransitions())
		{
			fillBarrierInfo(transition, imageProxy, barrierInfos.get(), srcQueueFamillyIndex,
					dstQueueFamillyIndex);
		}
		barrierInfos.flip();
	}

	@Override
	public void free()
	{
		barrierInfos.free();
		barrierInfos = null;
	}

	@Override
	public void execute(VkCommandBuffer commandBuffer)
	{
		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), dstStage.getValue(), 0, null, null,
				barrierInfos);
	}

	private static void fillBarrierInfo(ImageTransition transition,
										IImageProxy imageProxy,
										VkImageMemoryBarrier barrierInfo,
										int srcQueueFamillyIndex,
										int dstQueueFamillyIndex)
	{
		final var srcLayout = transition.getSrcLayout();
		final var dstLayout = transition.getDstLayout();
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageProxy.getFormat());

		barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrierInfo.oldLayout(srcLayout.getValue());
		barrierInfo.newLayout(dstLayout.getValue());
		barrierInfo.srcQueueFamilyIndex(srcQueueFamillyIndex);
		barrierInfo.dstQueueFamilyIndex(dstQueueFamillyIndex);
		barrierInfo.image(imageProxy.getId());
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(imageProxy.getMipLevels());
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(aspectMask);
		barrierInfo.srcAccessMask(convertAccessListToMask(transition.getSrcAccessMask()));
		barrierInfo.dstAccessMask(convertAccessListToMask(transition.getDstAccessMask()));
	}

	public static void execute(	VkCommandBuffer commandBuffer,
								EPipelineStage srcStage,
								EPipelineStage dstStage,
								EImageLayout srcLayout,
								EImageLayout dstLayout,
								List<EAccess> srcAccessMask,
								List<EAccess> dstAccessMask,
								Image image)
	{
		final ImageBarrier barrier = new ImageBarrierImpl();
		barrier.setImage(image);
		barrier.setSrcStage(srcStage);
		barrier.setDstStage(dstStage);

		final ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(srcLayout);
		transition.setDstLayout(dstLayout);
		transition.getSrcAccessMask().addAll(srcAccessMask);
		transition.getDstAccessMask().addAll(dstAccessMask);

		barrier.getTransitions().add(transition);

		execute(commandBuffer, barrier);
	}

	public static void execute(VkCommandBuffer commandBuffer, AbstractImageBarrier barrier)
	{
		ImageBarrierExecutor executor = new ImageBarrierExecutor(barrier);
		executor.allocate();
		executor.execute(commandBuffer);
		executor.free();
	}

	public static void execute(	VkCommandBuffer commandBuffer,
								EPipelineStage srcStage,
								EPipelineStage dstStage,
								EImageLayout srcLayout,
								EImageLayout dstLayout,
								List<EAccess> srcAccessMask,
								List<EAccess> dstAccessMask,
								long imageId,
								int imageFormat,
								int mipLevels)
	{
		final ReferenceImageBarrier barrier = new ReferenceImageBarrierImpl();
		barrier.setImageId(imageId);
		barrier.setMipLevels(mipLevels);
		barrier.setImageFormat(imageFormat);
		barrier.setSrcStage(srcStage);
		barrier.setDstStage(dstStage);

		final ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(srcLayout);
		transition.setDstLayout(dstLayout);
		transition.getSrcAccessMask().addAll(srcAccessMask);
		transition.getDstAccessMask().addAll(dstAccessMask);

		barrier.getTransitions().add(transition);

		execute(commandBuffer, barrier);
	}

	private static int convertAccessListToMask(List<EAccess> accesses)
	{
		int res = 0;
		for (EAccess access : accesses)
		{
			res |= access.getValue();
		}
		return res;
	}
}
