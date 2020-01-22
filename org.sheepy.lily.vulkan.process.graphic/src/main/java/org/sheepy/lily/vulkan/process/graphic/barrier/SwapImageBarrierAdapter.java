package org.sheepy.lily.vulkan.process.graphic.barrier;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.vulkan.barrier.VkSwapImageBarrier;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = SwapImageBarrier.class)
public class SwapImageBarrierAdapter
		implements IImageBarrierAdapter, IAllocableAdapter<IGraphicContext>
{
	private final VkSwapImageBarrier vkBarrier;

	private IGraphicContext context;

	private SwapImageBarrierAdapter(SwapImageBarrier imageBarrier)
	{
		final var srcLayout = imageBarrier.getSrcLayout().getValue();
		final var dstLayout = imageBarrier.getDstLayout().getValue();
		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		vkBarrier = new VkSwapImageBarrier(srcLayout, dstLayout, srcAccessMask, dstAccessMask);
	}

	@Override
	public void update(int index)
	{
		final var imageViewManager = context.getImageViewManager();
		final var view = imageViewManager.getImageViews().get(index);
		vkBarrier.updatePtr(view.getImagePtr());
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void free(IGraphicContext context)
	{}

	@Override
	public VkSwapImageBarrier getBackend()
	{
		return vkBarrier;
	}
}
