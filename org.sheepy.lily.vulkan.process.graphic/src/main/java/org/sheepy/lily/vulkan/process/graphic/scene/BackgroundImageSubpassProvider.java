package org.sheepy.lily.vulkan.process.graphic.scene;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.IImage;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

@Statefull
@Adapter(scope = BackgroundImage.class)
public class BackgroundImageSubpassProvider implements IScenePart_SubpassProvider<BackgroundImage>
{
	private ImageBarrier imageBarrier;
	private BlitToSwapImage blit;

	@NotifyChanged(featureIds = ApplicationPackage.BACKGROUND_IMAGE__IMAGE)
	private void imageChanged(Notification notification)
	{
		final var newImage = (IImage) notification.getNewValue();
		setupImage((Image) newImage);
	}

	@Override
	public Subpass build(BackgroundImage part, AttachmentPkg attachmentPkg)
	{
		final var pipeline = buildPipeline(part);
		setupImage((Image) part.getImage());

		final var pipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		pipelinePkg.getPipelines().add(pipeline);
		final var attachmentRefPkg = GraphicFactory.eINSTANCE.createAttachmentRefPkg();

		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(attachmentPkg.getColorAttachment());
		attachmentRefPkg.getAttachmentRefs().add(colorRef);

		final var res = GraphicFactory.eINSTANCE.createSubpass();
		res.getStages().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		res.getAccesses().add(EAccess.COLOR_ATTACHMENT_WRITE_BIT);
		res.getAccesses().add(EAccess.COLOR_ATTACHMENT_READ_BIT);
		res.setAttachmantRefPkg(attachmentRefPkg);
		res.setPipelinePkg(pipelinePkg);
		return res;
	}

	private void setupImage(Image image)
	{
		imageBarrier.setImage(image);
		blit.setImage(image);
	}

	private Pipeline buildPipeline(BackgroundImage part)
	{
		final Pipeline pipeline = ProcessFactory.eINSTANCE.createPipeline();

		imageBarrier = ResourceFactory.eINSTANCE.createImageBarrier();
		imageBarrier.getDstAccessMask().add(EAccess.TRANSFER_READ_BIT);
		imageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
		imageBarrier.setDstLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);

		final var swapImageBarrier = GraphicFactory.eINSTANCE.createSwapImageBarrier();
		swapImageBarrier.getSrcAccessMask().add(EAccess.SHADER_WRITE_BIT);
		swapImageBarrier.getDstAccessMask().add(EAccess.TRANSFER_WRITE_BIT);
		swapImageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
		swapImageBarrier.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);

		final var pipelineBarrier1 = ProcessFactory.eINSTANCE.createPipelineBarrier();
		pipelineBarrier1.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier1.setDstStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier1.getBarriers().add(imageBarrier);
		pipelineBarrier1.getBarriers().add(swapImageBarrier);

		blit = GraphicFactory.eINSTANCE.createBlitToSwapImage();
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
}
