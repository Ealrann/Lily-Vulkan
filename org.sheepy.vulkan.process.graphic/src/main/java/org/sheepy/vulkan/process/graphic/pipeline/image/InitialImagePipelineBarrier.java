package org.sheepy.vulkan.process.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.model.resource.ImageTransition;
import org.sheepy.vulkan.model.resource.ReferenceImageBarrier;
import org.sheepy.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl;
import org.sheepy.vulkan.model.resource.impl.ReferenceImageBarrierImpl;
import org.sheepy.vulkan.resource.image.barrier.ImageBarrierExecutor;
import org.sheepy.vulkan.resource.nativehelper.VkImageView;

public class InitialImagePipelineBarrier implements IBasicAllocable
{
	private final ImagePipeline pipeline;
	private final VkImageView view;

	private ImageBarrier sourceBarrier = null;
	private ReferenceImageBarrier targetBarrier = null;

	private final ImageBarrierExecutor sourceExecutor = new ImageBarrierExecutor();
	private final ImageBarrierExecutor targetExecutor = new ImageBarrierExecutor();

	public InitialImagePipelineBarrier(ImagePipeline pipeline, VkImageView view)
	{
		this.pipeline = pipeline;
		this.view = view;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		allocateInitialSourceBarrier();
		allocateInitialTargetBarrier();

		sourceExecutor.allocate(sourceBarrier);
		targetExecutor.allocate(targetBarrier);
	}

	@Override
	public void free()
	{
		sourceExecutor.free();
		targetExecutor.free();

		sourceBarrier = null;
		targetBarrier = null;
	}

	public void execute(VkCommandBuffer commandBuffer)
	{
		sourceExecutor.execute(commandBuffer);
		targetExecutor.execute(commandBuffer);
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

	private void allocateInitialTargetBarrier()
	{
		targetBarrier = new ReferenceImageBarrierImpl();
		targetBarrier.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		targetBarrier.setDstStage(EPipelineStage.TRANSFER_BIT);
		targetBarrier.setImageId(view.getImageId());
		targetBarrier.setImageFormat(view.getImageFormat());
		targetBarrier.setMipLevels(1);

		ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.UNDEFINED);
		transition.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		transition.setSrcAccess(0);
		transition.setDstAccess(VK_ACCESS_TRANSFER_WRITE_BIT);

		targetBarrier.getTransitions().add(transition);
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
