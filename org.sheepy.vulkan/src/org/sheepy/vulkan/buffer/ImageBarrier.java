package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.vulkan.pipeline.PipelineBarrier;

public class ImageBarrier extends PipelineBarrier
{
	private int srcStage;
	private int dstStage;

	private boolean lock = false;
	
	private List<IImageTransition> transitions = new ArrayList<>();
	private VkImageMemoryBarrier.Buffer barrierInfos;

	public ImageBarrier(int srcStage, int dstStage)
	{
		this.srcStage = srcStage;
		this.dstStage = dstStage;
	}

	public void addImageBarrier(Image image, int dstLayout, int dstAccess)
	{
		if(lock == true)
		{
			throw new AssertionError("Forbidden call after this object is allocated");
		}
		ImageTransition transition = new ImageTransition();

		transition.image = image;
		transition.dstLayout = dstLayout;
		transition.dstAccess = dstAccess;

		transitions.add(transition);
	}

	public void addImageBarrier(long imageId,
			int imageFormat,
			int mipLevels,
			int srcLayout,
			int dstLayout,
			int srcAccess,
			int dstAccess)
	{
		if(lock == true)
		{
			throw new AssertionError("Forbidden call after this object is allocated");
		}
		ReferenceImageTransition transition = new ReferenceImageTransition();

		transition.imageId = imageId;
		transition.imageFormat = imageFormat;
		transition.mipLevels = mipLevels;
		transition.srcLayout = srcLayout;
		transition.dstLayout = dstLayout;
		transition.srcAccess = srcAccess;
		transition.dstAccess = dstAccess;

		transitions.add(transition);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		lock = true;
		barrierInfos = VkImageMemoryBarrier.calloc(transitions.size());
	}

	@Override
	public void free()
	{
		barrierInfos.free();
		lock = false;
	}

	@Override
	public void execute(VkCommandBuffer commandBuffer)
	{
		boolean destroyInfos = false;
		if(barrierInfos == null)
		{
			barrierInfos = VkImageMemoryBarrier.calloc(transitions.size());
			destroyInfos = true;
		}
		
		for (IImageTransition transition : transitions)
		{
			transition.fillVkImageMemoryBarrier(barrierInfos.get());
		}

		barrierInfos.flip();

		vkCmdPipelineBarrier(commandBuffer, srcStage, dstStage, 0, null, null, barrierInfos);
		
		if(destroyInfos)
		{
			barrierInfos.free();
		}
	}

	public static void execute(VkCommandBuffer commandBuffer,
			Image image,
			int srcStage,
			int dstStage,
			int newLayout,
			int dstAccessMask)
	{
		ImageBarrier barrier = new ImageBarrier(srcStage, dstStage);

		barrier.addImageBarrier(image, newLayout, dstAccessMask);

		barrier.execute(commandBuffer);
	}

	public static void execute(VkCommandBuffer commandBuffer,
			long imageId,
			int imageFormat,
			int oldLayout,
			int newLayout,
			int mipLevels,
			int srcStage,
			int dstStage,
			int srcAccessMask,
			int dstAccessMask)
	{
		ImageBarrier barrier = new ImageBarrier(srcStage, dstStage);

		barrier.addImageBarrier(imageId, imageFormat, mipLevels, oldLayout, newLayout,
				srcAccessMask, dstAccessMask);

		barrier.execute(commandBuffer);
	}

	private interface IImageTransition
	{
		void fillVkImageMemoryBarrier(VkImageMemoryBarrier barrierInfo);
	}

	private class ImageTransition implements IImageTransition
	{
		Image image;
		int dstLayout;
		int dstAccess;

		@Override
		public void fillVkImageMemoryBarrier(VkImageMemoryBarrier barrierInfo)
		{
			int aspectMask = 0;
			if (dstLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
			{
				aspectMask = VK_IMAGE_ASPECT_DEPTH_BIT;

				if (Image.hasStencilComponent(image.getFormat()))
				{
					aspectMask |= VK_IMAGE_ASPECT_STENCIL_BIT;
				}
			}
			else
			{
				aspectMask = VK_IMAGE_ASPECT_COLOR_BIT;
			}

			barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
			barrierInfo.oldLayout(image.getLayout());
			barrierInfo.newLayout(dstLayout);
			barrierInfo.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
			barrierInfo.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
			barrierInfo.image(image.getId());
			barrierInfo.subresourceRange().baseMipLevel(0);
			barrierInfo.subresourceRange().levelCount(image.getMipLevels());
			barrierInfo.subresourceRange().baseArrayLayer(0);
			barrierInfo.subresourceRange().layerCount(1);
			barrierInfo.subresourceRange().aspectMask(aspectMask);
			barrierInfo.srcAccessMask(image.getAccess());
			barrierInfo.dstAccessMask(dstAccess);

			image.setLayout(dstLayout);
			image.setAccess(dstAccess);
		}
	}

	private class ReferenceImageTransition implements IImageTransition
	{
		long imageId;
		int mipLevels;
		int imageFormat;

		int srcLayout;
		int dstLayout;
		int srcAccess;
		int dstAccess;

		@Override
		public void fillVkImageMemoryBarrier(VkImageMemoryBarrier barrierInfo)
		{
			int aspectMask = 0;
			if (dstLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
			{
				aspectMask = VK_IMAGE_ASPECT_DEPTH_BIT;

				if (Image.hasStencilComponent(imageFormat))
				{
					aspectMask |= VK_IMAGE_ASPECT_STENCIL_BIT;
				}
			}
			else
			{
				aspectMask = VK_IMAGE_ASPECT_COLOR_BIT;
			}

			barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
			barrierInfo.oldLayout(srcLayout);
			barrierInfo.newLayout(dstLayout);
			barrierInfo.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
			barrierInfo.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
			barrierInfo.image(imageId);
			barrierInfo.subresourceRange().baseMipLevel(0);
			barrierInfo.subresourceRange().levelCount(mipLevels);
			barrierInfo.subresourceRange().baseArrayLayer(0);
			barrierInfo.subresourceRange().layerCount(1);
			barrierInfo.subresourceRange().aspectMask(aspectMask);
			barrierInfo.srcAccessMask(srcAccess);
			barrierInfo.dstAccessMask(dstAccess);
		}
	}
}
