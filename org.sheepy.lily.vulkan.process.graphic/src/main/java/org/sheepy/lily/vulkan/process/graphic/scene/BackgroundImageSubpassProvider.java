package org.sheepy.lily.vulkan.process.graphic.scene;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.IResource;
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
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

@Statefull
@Adapter(scope = BackgroundImage.class)
public class BackgroundImageSubpassProvider implements IScenePart_SubpassProvider<BackgroundImage>
{
	private Pipeline pipeline = null;
	private Image image = null;
	private boolean createdImage = false;
	private ImageBarrier imageBarrier;
	private BlitToSwapImage blit;

	@NotifyChanged(featureIds = ApplicationPackage.BACKGROUND_IMAGE__RESOURCE)
	private void imageChanged(Notification notification)
	{
		final var newResource = (IResource) notification.getNewValue();
		uninstallImage();
		getOrCreateImage(newResource);
		setupImage();
	}

	private void uninstallImage()
	{
		if (createdImage)
		{
			pipeline.getResourcePkg().getResources().remove(image);
			image = null;
			createdImage = false;
		}
	}

	@Override
	public SubpassData build(BackgroundImage part, SwapImageAttachment colorAttachment)
	{
		buildPipeline(part);

		getOrCreateImage(part.getResource());
		setupImage();

		return new SubpassData(List.of(pipeline), null, null, List.of(), List.of());
	}

	private void setupImage()
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

	private void getOrCreateImage(final IResource resource)
	{
		if (resource instanceof Image)
		{
			createdImage = false;
			image = (Image) resource;
		}
		else if (resource instanceof FileResource)
		{
			createdImage = true;
			image = createImage((FileResource) resource);
		}
	}

	private Image createImage(final FileResource resource)
	{
		if (pipeline.getResourcePkg() == null)
		{
			pipeline.setResourcePkg(ApplicationFactory.eINSTANCE.createResourcePkg());
		}

		final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
		initialLayout.setStage(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		initialLayout.setLayout(EImageLayout.GENERAL);
		initialLayout.getAccessMask().add(EAccess.COLOR_ATTACHMENT_READ_BIT);

		final var image = ResourceFactory.eINSTANCE.createFileImage();
		image.setFile(EcoreUtil.copy(resource));
		image.setInitialLayout(initialLayout);
		image.getUsages().add(EImageUsage.STORAGE);
		image.getUsages().add(EImageUsage.TRANSFER_SRC);
		image.getUsages().add(EImageUsage.TRANSFER_DST);

		pipeline.getResourcePkg().getResources().add(image);

		return image;
	}
}
