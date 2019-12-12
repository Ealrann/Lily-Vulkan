package org.sheepy.lily.vulkan.process.graphic.barrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER;

import java.util.List;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.resource.image.ImageUtil;
import org.sheepy.vulkan.util.VkModelUtil;

@Adapter(scope = SwapImageBarrier.class)
public class SwapImageBarrierAdapter
		implements IImageBarrierAdapter<IGraphicContext>, IAllocable<IGraphicContext>
{
	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addDependencies(List.of(context.getImageViewManager()));
	}

	@Override
	public void allocate(IGraphicContext context)
	{}

	@Override
	public void free(IGraphicContext context)
	{}

	@Override
	public void fillInfo(	IGraphicContext context,
							AbstractImageBarrier barrier,
							VkImageMemoryBarrier info,
							int swapIndex)
	{
		final var imageViewManager = context.getImageViewManager();

		final var view = imageViewManager.getImageViews().get(swapIndex);

		final var imageBarrier = (SwapImageBarrier) barrier;

		final int mipLevels = 1;
		final var srcLayout = imageBarrier.getSrcLayout();
		final var dstLayout = imageBarrier.getDstLayout();
		final int imageFormat = view.getImageFormat();
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageFormat);
		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout.getValue());
		info.newLayout(dstLayout.getValue());
		info.image(view.getImagePtr());
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(mipLevels);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(aspectMask);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
	}
}
