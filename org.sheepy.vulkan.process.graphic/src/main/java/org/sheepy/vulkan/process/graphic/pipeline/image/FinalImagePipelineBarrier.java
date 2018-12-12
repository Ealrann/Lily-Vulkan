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

public class FinalImagePipelineBarrier implements IBasicAllocable
{
	private final ImagePipeline pipeline;
	private final VkImageView view;

	private ImageBarrier sourceBarrier = null;
	private ReferenceImageBarrier targetBarrier = null;

	private final ImageBarrierExecutor sourceExecutor = new ImageBarrierExecutor();
	private final ImageBarrierExecutor targetExecutor = new ImageBarrierExecutor();

	public FinalImagePipelineBarrier(ImagePipeline pipeline, VkImageView view)
	{
		this.pipeline = pipeline;
		this.view = view;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		allocateSourceBarrier();
		allocateTargetBarrier();

		sourceExecutor.allocate(sourceBarrier);
		targetExecutor.allocate(targetBarrier);
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
		targetExecutor.execute(commandBuffer);
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

	private void allocateTargetBarrier()
	{
		targetBarrier = new ReferenceImageBarrierImpl();
		targetBarrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		targetBarrier.setDstStage(EPipelineStage.FRAGMENT_SHADER_BIT);
		targetBarrier.setImageId(view.getImageId());
		targetBarrier.setImageFormat(view.getImageFormat());
		targetBarrier.setMipLevels(1);

		ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		transition.setDstLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		transition.setSrcAccess(VK_ACCESS_TRANSFER_WRITE_BIT);
		transition.setDstAccess(VK_ACCESS_SHADER_WRITE_BIT);

		targetBarrier.getTransitions().add(transition);
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
