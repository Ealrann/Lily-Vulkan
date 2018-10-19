package org.sheepy.vulkan.pipeline.graphic.image;

import static org.lwjgl.vulkan.VK10.VK_ACCESS_TRANSFER_READ_BIT;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IBasicAllocable;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.ImageBarrier;
import org.sheepy.vulkan.model.process.ImagePipeline;
import org.sheepy.vulkan.model.process.ImageTransition;
import org.sheepy.vulkan.model.process.impl.ImageBarrierImpl;
import org.sheepy.vulkan.model.process.impl.ImageTransitionImpl;
import org.sheepy.vulkan.resource.imagebarrier.ImageBarrierExecutor;

public class FinalImagePipelineBarrier implements IBasicAllocable
{
	private final ImagePipeline pipeline;

	private ImageBarrier sourceBarrier = null;

	private final ImageBarrierExecutor sourceExecutor = new ImageBarrierExecutor();

	public FinalImagePipelineBarrier(ImagePipeline pipeline)
	{
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		allocateSourceBarrier();
		
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

	private void allocateSourceBarrier()
	{
		var srcImage = pipeline.getImage();

		sourceBarrier = new ImageBarrierImpl();
		sourceBarrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		sourceBarrier.setDstStage(pipeline.getImageDstStage());
		sourceBarrier.setImage(srcImage);

		ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		transition.setDstLayout(EImageLayout.GENERAL);
		transition.setSrcAccess(VK_ACCESS_TRANSFER_READ_BIT);
		transition.setDstAccess(pipeline.getImageDstAccess());
		
		sourceBarrier.getTransitions().add(transition);
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}
}
