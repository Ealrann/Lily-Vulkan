package org.sheepy.vulkan.process.graphic.pipeline.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.model.resource.ImageTransition;
import org.sheepy.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.vulkan.resource.barrier.BarrierExecutorFactory;
import org.sheepy.vulkan.resource.barrier.IBarrierExecutor;

public class FinalImagePipelineBarrier implements IBasicAllocable
{
	private final ImagePipeline pipeline;

	private IBarrierExecutor sourceExecutor;

	public FinalImagePipelineBarrier(ImagePipeline pipeline)
	{
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		ImageBarrier barrier = allocateSourceBarrier();

		sourceExecutor = BarrierExecutorFactory.create(barrier);
		sourceExecutor.allocate();
	}

	@Override
	public void free()
	{
		sourceExecutor.free();
	}

	public void execute(VkCommandBuffer commandBuffer)
	{
		sourceExecutor.execute(commandBuffer);
	}

	private ImageBarrier allocateSourceBarrier()
	{
		var srcImage = pipeline.getImage();

		ImageBarrier barrier = new ImageBarrierImpl();
		barrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		barrier.setDstStage(pipeline.getImageDstStage());
		barrier.setImage(srcImage);

		ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		transition.setDstLayout(EImageLayout.GENERAL);
		transition.getSrcAccessMask().add(EAccess.TRANSFER_READ_BIT);
		transition.getDstAccessMask().addAll(pipeline.getImageDstAccessMask());

		barrier.getTransitions().add(transition);

		return barrier;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
