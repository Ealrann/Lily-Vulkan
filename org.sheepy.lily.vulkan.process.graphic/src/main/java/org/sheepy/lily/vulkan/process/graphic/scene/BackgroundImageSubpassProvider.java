package org.sheepy.lily.vulkan.process.graphic.scene;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.*;

@Statefull
@Adapter(scope = BackgroundImage.class)
public class BackgroundImageSubpassProvider implements IScenePart_SubpassProvider<BackgroundImage>
{
	private ImageBarrier imageBarrier;
	private AbstractBlitTask blit;

	@NotifyChanged(featureIds = ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE)
	private void imageChanged(Notification notification)
	{
		final var newImage = (IImage) notification.getNewValue();
		setupImage((Image) newImage);
	}

	@Override
	public Subpass build(BackgroundImage part, AttachmentPkg attachmentPkg)
	{
		final var pipeline = buildPipeline(part);
		setupImage((Image) part.getSrcImage());

		final var pipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		pipelinePkg.getPipelines().add(pipeline);

		final var res = GraphicFactory.eINSTANCE.createSubpass();
		res.setPipelinePkg(pipelinePkg);
		return res;
	}

	private void setupImage(Image image)
	{
		imageBarrier.setImage(image);
		blit.setSrcImage(image);
	}

	private Pipeline buildPipeline(BackgroundImage part)
	{
		final Pipeline pipeline = ProcessFactory.eINSTANCE.createPipeline();

		imageBarrier = VulkanResourceFactory.eINSTANCE.createImageBarrier();
		imageBarrier.getDstAccessMask().add(EAccess.TRANSFER_READ_BIT);
		imageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
		imageBarrier.setDstLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);

		final var pipelineBarrier1 = ProcessFactory.eINSTANCE.createPipelineBarrier();
		pipelineBarrier1.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier1.setDstStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier1.getBarriers().add(imageBarrier);

		final IImage dstImage = part.getDstImage();
		if (dstImage instanceof SwapImageAttachment)
		{
			final var swapImageBarrier = GraphicFactory.eINSTANCE.createSwapImageBarrier();
			swapImageBarrier.getSrcAccessMask().add(EAccess.SHADER_WRITE_BIT);
			swapImageBarrier.getDstAccessMask().add(EAccess.TRANSFER_WRITE_BIT);
			swapImageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
			swapImageBarrier.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
			pipelineBarrier1.getBarriers().add(swapImageBarrier);
		}
		else
		{
			final var dstImageBarrier = VulkanResourceFactory.eINSTANCE.createImageBarrier();
			dstImageBarrier.getDstAccessMask().add(EAccess.TRANSFER_WRITE_BIT);
			dstImageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
			dstImageBarrier.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
			dstImageBarrier.setImage(dstImage);
			pipelineBarrier1.getBarriers().add(dstImageBarrier);
		}

		blit = createBlitTask(part);
		blit.setClearColor(part.getClearColor());
		switch (part.getSampling())
		{
			case LINEAR:
				blit.setFilter(EFilter.LINEAR);
				break;
			case NEAREST:
				blit.setFilter(EFilter.NEAREST);
				break;
		}

		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		taskPkg.getTasks().add(pipelineBarrier1);
		taskPkg.getTasks().add(blit);

		pipeline.setStage(ECommandStage.TRANSFER);
		pipeline.setTaskPkg(taskPkg);
		return pipeline;
	}

	private static AbstractBlitTask createBlitTask(BackgroundImage part)
	{
		if (part.getDstImage() instanceof SwapImageAttachment)
		{
			return GraphicFactory.eINSTANCE.createBlitToSwapImage();
		}
		else
		{
			final var res = GraphicFactory.eINSTANCE.createBlitTask();
			res.setDstImage(part.getDstImage());
			return res;
		}
	}
}
