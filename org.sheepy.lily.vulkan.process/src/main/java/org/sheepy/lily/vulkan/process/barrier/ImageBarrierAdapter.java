package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.resource.image.ImageUtil;
import org.sheepy.vulkan.util.VkModelUtil;

@Adapter(scope = ImageBarrier.class)
public class ImageBarrierAdapter implements IImageBarrierAdapter<IExecutionContext>
{
	@Override
	public void fillInfo(	IExecutionContext context,
							AbstractImageBarrier barrier,
							VkImageMemoryBarrier info,
							int swapIndex)
	{
		final var imageBarrier = (ImageBarrier) barrier;
		final var image = imageBarrier.getImage();
		final var imageAdapter = IImageAdapter.adapt(image);
		final var imageInfo = imageAdapter.getVkImage();

		final int mipLevels = imageInfo.mipLevels;
		final var srcLayout = imageBarrier.getSrcLayout();
		final var dstLayout = imageBarrier.getDstLayout();
		final int imageFormat = imageInfo.format;
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageFormat);
		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout.getValue());
		info.newLayout(dstLayout.getValue());
		info.image(imageAdapter.getImagePtr());
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(mipLevels);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(aspectMask);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
	}
}
