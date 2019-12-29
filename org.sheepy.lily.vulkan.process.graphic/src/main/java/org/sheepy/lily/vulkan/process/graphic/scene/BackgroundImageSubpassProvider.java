package org.sheepy.lily.vulkan.process.graphic.scene;

import java.util.List;

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
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
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
	private Pipeline pipeline = null;
	private ImageBarrier imageBarrier;
	private BlitToSwapImage blit;

	@NotifyChanged(featureIds = ApplicationPackage.BACKGROUND_IMAGE__IMAGE)
	private void imageChanged(Notification notification)
	{
		final var newImage = (IImage) notification.getNewValue();
		setupImage((Image) newImage);
	}

	@Override
	public SubpassData build(BackgroundImage part, SwapImageAttachment colorAttachment)
	{
		buildPipeline(part);
		setupImage((Image) part.getImage());
		return new SubpassData(List.of(pipeline), null, null, List.of(), List.of());
	}

	private void setupImage(Image image)
	{
		imageBarrier.setImage(image);
		blit.setImage(image);
	}

	private void buildPipeline(BackgroundImage part)
	{
		pipeline = ProcessFactory.eINSTANCE.createPipeline();

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
	}
}
