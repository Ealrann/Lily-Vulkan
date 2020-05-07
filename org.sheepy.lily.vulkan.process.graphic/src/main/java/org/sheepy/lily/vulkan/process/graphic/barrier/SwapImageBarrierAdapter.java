package org.sheepy.lily.vulkan.process.graphic.barrier;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkSwapImageBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = SwapImageBarrier.class)
@Adapter
public final class SwapImageBarrierAdapter implements IImageBarrierAdapter, IAllocableAdapter<ProcessContext>
{
	private final VkSwapImageBarrier vkBarrier;

	private ProcessContext context;

	private SwapImageBarrierAdapter(SwapImageBarrier imageBarrier)
	{

		final var srcLayout = imageBarrier.getSrcLayout().getValue();
		final var dstLayout = imageBarrier.getDstLayout().getValue();
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		vkBarrier = new VkSwapImageBarrier(srcLayout, dstLayout, srcAccessMask, dstAccessMask);
	}

	@Override
	public void update(int index)
	{
		final var graphicProcess = (GraphicProcess) context.getProcess();
		final var imageViews = graphicProcess.getConfiguration().getImageViews();
		final var imageViewAllocation = imageViews.allocationHandle(ImageViewAllocation.class).get();
		final var view = imageViewAllocation.getImageViews().get(index);
		vkBarrier.updatePtr(view.getImagePtr());
	}

	@Override
	public void allocate(ProcessContext context)
	{
		this.context = context;
	}

	@Override
	public void free(ProcessContext context)
	{
	}

	@Override
	public VkSwapImageBarrier getBackend()
	{
		return vkBarrier;
	}
}
