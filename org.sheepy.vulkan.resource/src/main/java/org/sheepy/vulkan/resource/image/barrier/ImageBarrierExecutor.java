package org.sheepy.vulkan.resource.image.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.resource.AbstractImageBarrier;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.model.resource.ImageTransition;
import org.sheepy.vulkan.model.resource.ReferenceImageBarrier;
import org.sheepy.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.vulkan.model.resource.impl.ReferenceImageBarrierImpl;
import org.sheepy.vulkan.resource.image.ImageUtil;
import org.sheepy.vulkan.resource.image.barrier.proxy.IImageProxy;

public class ImageBarrierExecutor
{
	private VkImageMemoryBarrier.Buffer barrierInfos = null;
	private EPipelineStage srcStage;
	private EPipelineStage dstStage;

	public void allocate(AbstractImageBarrier barrier)
	{
		barrierInfos = VkImageMemoryBarrier.calloc(barrier.getTransitions().size());
		srcStage = barrier.getSrcStage();
		dstStage = barrier.getDstStage();
		final var imageProxy = IImageProxy.newProxy(barrier);

		for (final ImageTransition transition : barrier.getTransitions())
		{
			fillBarrierInfo(transition, imageProxy, barrierInfos.get());
		}
		barrierInfos.flip();
	}

	public void free()
	{
		barrierInfos.free();
		barrierInfos = null;
	}

	public void execute(VkCommandBuffer commandBuffer)
	{
		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), dstStage.getValue(), 0, null, null,
				barrierInfos);
	}

	private static void fillBarrierInfo(ImageTransition transition,
										IImageProxy imageProxy,
										VkImageMemoryBarrier barrierInfo)
	{
		final var srcLayout = transition.getSrcLayout();
		final var dstLayout = transition.getDstLayout();
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageProxy.getFormat());

		barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrierInfo.oldLayout(srcLayout.getValue());
		barrierInfo.newLayout(dstLayout.getValue());
		barrierInfo.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrierInfo.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrierInfo.image(imageProxy.getId());
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(imageProxy.getMipLevels());
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(aspectMask);
		barrierInfo.srcAccessMask(transition.getSrcAccess());
		barrierInfo.dstAccessMask(transition.getDstAccess());
	}

	public static void execute(	VkCommandBuffer commandBuffer,
								EPipelineStage srcStage,
								EPipelineStage dstStage,
																																																																																																					EImageLayout srcLayout,
								EImageLayout dstLayout,
								int srcAccessMask,
								int dstAccessMask,
								Image image)
	{
		final ImageBarrier barrier = new ImageBarrierImpl();
		barrier.setImage(image);
		barrier.setSrcStage(srcStage);
		barrier.setDstStage(dstStage);

		final ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(srcLayout);
		transition.setDstLayout(dstLayout);
		transition.setSrcAccess(srcAccessMask);
		transition.setDstAccess(dstAccessMask);

		barrier.getTransitions().add(transition);

		execute(commandBuffer, barrier);
	}

	public static void execute(VkCommandBuffer commandBuffer, AbstractImageBarrier barrier)
	{
		ImageBarrierExecutor executor = new ImageBarrierExecutor();
		executor.allocate(barrier);
		executor.execute(commandBuffer);
		executor.free();
	}
	
	public static void execute(	VkCommandBuffer commandBuffer,
								EPipelineStage srcStage,
								EPipelineStage dstStage,
								EImageLayout srcLayout,
								EImageLayout dstLayout,
								int srcAccessMask,
								int dstAccessMask,
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
		transition.setSrcAccess(srcAccessMask);
		transition.setDstAccess(dstAccessMask);

		barrier.getTransitions().add(transition);

		execute(commandBuffer, barrier);
	}
}
