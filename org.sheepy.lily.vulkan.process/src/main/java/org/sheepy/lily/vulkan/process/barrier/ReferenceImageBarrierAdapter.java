package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.barrier.IImageBarrierAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.ReferenceImageBarrier;
import org.sheepy.vulkan.resource.image.ImageUtil;
import org.sheepy.vulkan.util.VkModelUtil;

@Adapter(scope = ReferenceImageBarrier.class)
public class ReferenceImageBarrierAdapter implements IImageBarrierAdapter<IExecutionContext>
{
	@Override
	public void fillInfo(	IExecutionContext context,
							AbstractImageBarrier barrier,
							VkImageMemoryBarrier info,
							int swapIndex)
	{
		final var refImageBarrier = (ReferenceImageBarrier) barrier;

		final int mipLevels = refImageBarrier.getMipLevels();
		final var srcLayout = refImageBarrier.getSrcLayout();
		final var dstLayout = refImageBarrier.getDstLayout();
		final int imageFormat = refImageBarrier.getImageFormat();
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageFormat);
		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout.getValue());
		info.newLayout(dstLayout.getValue());
		info.image(refImageBarrier.getImagePtr());
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(mipLevels);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(aspectMask);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
	}
}
