package org.sheepy.vulkan.process.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.VK_ACCESS_TRANSFER_READ_BIT;

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
import org.sheepy.vulkan.resource.image.barrier.ImageBarrierExecutor;

public class FinalImagePipelineBarrier implements IBasicAllocable
{
	private final ImageBarrierExecutor sourceExecutor = new ImageBarrierExecutor();

	private final ImagePipeline pipeline;

	private ImageBarrier sourceBarrier = null;

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

		int dstAccessMask = 0;
		for (EAccess access : pipeline.getImageDstAccessMask())
		{
			dstAccessMask |= access.getValue();
		}

		ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		transition.setDstLayout(EImageLayout.GENERAL);
		transition.setSrcAccess(VK_ACCESS_TRANSFER_READ_BIT);
		transition.setDstAccess(dstAccessMask);

		sourceBarrier.getTransitions().add(transition);
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
