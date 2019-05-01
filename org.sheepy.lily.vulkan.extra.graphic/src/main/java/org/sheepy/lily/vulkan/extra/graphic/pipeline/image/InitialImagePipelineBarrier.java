package org.sheepy.lily.vulkan.extra.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.resource.barrier.BarrierExecutorFactory;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.barrier.ImageTransition;
import org.sheepy.vulkan.model.barrier.ReferenceImageBarrier;
import org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl;
import org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.barrier.IBarrierExecutor;
import org.sheepy.vulkan.resource.image.VkImageView;

public class InitialImagePipelineBarrier implements IAllocable
{
	private final ImagePipeline pipeline;
	private final VkImageView view;
	private final int srcQueueFamilly;
	private final int dstQueueFamilly;

	private ImageBarrier sourceBarrier = null;
	private ReferenceImageBarrier targetBarrier = null;

	private IBarrierExecutor sourceExecutor;
	private IBarrierExecutor targetExecutor;

	public InitialImagePipelineBarrier(ImagePipeline pipeline, VkImageView view)
	{
		this.pipeline = pipeline;
		this.view = view;

		if (pipeline.getSrcQueue() != null)
		{
			final var imageProcess = getProcess(pipeline);
			final var srcProcessAdapter = AbstractProcessAdapter.adapt(pipeline.getSrcQueue());
			final var dstProcessAdapter = AbstractProcessAdapter.adapt(imageProcess);

			srcQueueFamilly = srcProcessAdapter.getQueue().index;
			dstQueueFamilly = dstProcessAdapter.getQueue().index;
		}
		else
		{
			srcQueueFamilly = VK_QUEUE_FAMILY_IGNORED;
			dstQueueFamilly = VK_QUEUE_FAMILY_IGNORED;
		}
	}

	private static final AbstractProcess getProcess(ImagePipeline pipeline)
	{
		EObject course = pipeline;
		while (course instanceof AbstractProcess == false)
		{
			course = course.eContainer();
		}

		return (AbstractProcess) course;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		allocateInitialSourceBarrier();
		allocateInitialTargetBarrier();

		sourceExecutor = BarrierExecutorFactory.create(sourceBarrier);
		targetExecutor = BarrierExecutorFactory.create(targetBarrier);

		sourceExecutor.allocate(srcQueueFamilly, dstQueueFamilly);
		targetExecutor.allocate();
	}

	@Override
	public void free(IAllocationContext context)
	{
		sourceExecutor.free();
		targetExecutor.free();

		sourceExecutor = null;
		targetExecutor = null;

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
		final var srcImage = pipeline.getImage();

		sourceBarrier = new ImageBarrierImpl();
		sourceBarrier.setSrcStage(pipeline.getImageSrcStage());
		sourceBarrier.setDstStage(EPipelineStage.TRANSFER_BIT);
		sourceBarrier.setImage(srcImage);

		final ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.GENERAL);
		transition.setDstLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		transition.getSrcAccessMask().addAll(pipeline.getImageSrcAccessMask());
		transition.getDstAccessMask().add(EAccess.TRANSFER_READ_BIT);

		sourceBarrier.getTransitions().add(transition);
	}

	private void allocateInitialTargetBarrier()
	{
		targetBarrier = new ReferenceImageBarrierImpl();
		targetBarrier.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		targetBarrier.setDstStage(EPipelineStage.TRANSFER_BIT);
		targetBarrier.setImageId(view.getImageAddress());
		targetBarrier.setImageFormat(view.getImageFormat());
		targetBarrier.setMipLevels(1);

		final ImageTransition transition = new ImageTransitionImpl();
		transition.setSrcLayout(EImageLayout.UNDEFINED);
		transition.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		transition.getDstAccessMask().add(EAccess.TRANSFER_WRITE_BIT);

		targetBarrier.getTransitions().add(transition);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
