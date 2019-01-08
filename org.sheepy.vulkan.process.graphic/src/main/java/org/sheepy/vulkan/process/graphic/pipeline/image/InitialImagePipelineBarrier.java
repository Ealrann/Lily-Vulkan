package org.sheepy.vulkan.process.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.VK_ACCESS_TRANSFER_READ_BIT;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.model.resource.ImageTransition;
import org.sheepy.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.vulkan.resource.image.barrier.ImageBarrierExecutor;

public class InitialImagePipelineBarrier implements IBasicAllocable
{
	private final ImageBarrierExecutor sourceExecutor = new ImageBarrierExecutor();

	private final ImagePipeline pipeline;

	private ImageBarrier sourceBarrier = null;

	public InitialImagePipelineBarrier(ImagePipeline pipeline)
	{
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		allocateInitialSourceBarrier();

		sourceExecutor.allocate(sourceBarrier);
	}

	@Override
	public void free()
	{
		sourceExecutor.free();

		sourceBarrier = null;
	}

	public void execute(VkCommandBuffer commandBuffer)
	{
		sourceExecutor.execute(commandBuffer);
	}

	private void allocateInitialSourceBarrier()
	{
		var srcImage = pipeline.getImage();

		sourceBarrier = new ImageBarrierImpl();
		sourceBarrier.setSrcStage(pipeline.getImageSrcStage());
		sourceBarrier.setDstStage(EPipelineStage.TRANSFER_BIT);
		sourceBarrier.setImage(srcImage);

		ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.GENERAL);
		transition.setDstLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		transition.setSrcAccess(pipeline.getImageSrcAccess());
		transition.setDstAccess(VK_ACCESS_TRANSFER_READ_BIT);

		sourceBarrier.getTransitions().add(transition);
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
