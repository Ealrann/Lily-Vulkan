package org.sheepy.lily.vulkan.extra.graphic.pipeline.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline;
import org.sheepy.lily.vulkan.model.enumeration.EAccess;
import org.sheepy.lily.vulkan.model.enumeration.EImageLayout;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ImageTransition;
import org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.lily.vulkan.resource.barrier.BarrierExecutorFactory;
import org.sheepy.lily.vulkan.resource.barrier.IBarrierExecutor;

public class FinalImagePipelineBarrier implements IAllocable
{
	private final ImagePipeline pipeline;

	private IBarrierExecutor sourceExecutor;

	public FinalImagePipelineBarrier(ImagePipeline pipeline)
	{
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final ImageBarrier barrier = allocateSourceBarrier();

		sourceExecutor = BarrierExecutorFactory.create(barrier);
		sourceExecutor.allocate();
	}

	@Override
	public void free(IAllocationContext context)
	{
		sourceExecutor.free();
		sourceExecutor = null;
	}

	public void execute(VkCommandBuffer commandBuffer)
	{
		sourceExecutor.execute(commandBuffer);
	}

	private ImageBarrier allocateSourceBarrier()
	{
		final var srcImage = pipeline.getImage();

		final ImageBarrier barrier = new ImageBarrierImpl();
		barrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		barrier.setDstStage(pipeline.getImageDstStage());
		barrier.setImage(srcImage);

		final ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		transition.setDstLayout(EImageLayout.GENERAL);
		transition.getSrcAccessMask().add(EAccess.TRANSFER_READ_BIT);
		transition.getDstAccessMask().addAll(pipeline.getImageDstAccessMask());

		barrier.getTransitions().add(transition);

		return barrier;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
