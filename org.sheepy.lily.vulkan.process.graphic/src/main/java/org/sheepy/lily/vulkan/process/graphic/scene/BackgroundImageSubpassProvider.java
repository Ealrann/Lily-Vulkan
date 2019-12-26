package org.sheepy.lily.vulkan.process.graphic.scene;

import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.vulkan.api.resource.IVulkanResource_Deployer;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

@Adapter(scope = BackgroundImage.class)
public class BackgroundImageSubpassProvider implements IScenePart_SubpassProvider<BackgroundImage>
{
	@Override
	public SubpassData build(BackgroundImage part, SwapImageAttachment colorAttachment)
	{
		final var pipeline = buildPipeline(part);
		return new SubpassData(List.of(pipeline), null, null, List.of(), List.of());
	}

	private static Pipeline buildPipeline(BackgroundImage part)
	{
		final var imagePipeline = ProcessFactory.eINSTANCE.createPipeline();
		final var backgroundImage = getOrCreateImage(part.getResource(), imagePipeline);

		final var imageBarrier1 = ResourceFactory.eINSTANCE.createImageBarrier();
		imageBarrier1.setImage(backgroundImage);
		imageBarrier1.getDstAccessMask().add(EAccess.TRANSFER_READ_BIT);
		imageBarrier1.setSrcLayout(EImageLayout.UNDEFINED);
		imageBarrier1.setDstLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);

		final var swapImageBarrier = GraphicFactory.eINSTANCE.createSwapImageBarrier();
		swapImageBarrier.getSrcAccessMask().add(EAccess.SHADER_WRITE_BIT);
		swapImageBarrier.getDstAccessMask().add(EAccess.TRANSFER_WRITE_BIT);
		swapImageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
		swapImageBarrier.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);

		final var pipelineBarrier1 = ProcessFactory.eINSTANCE.createPipelineBarrier();
		pipelineBarrier1.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier1.setDstStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier1.getBarriers().add(imageBarrier1);
		pipelineBarrier1.getBarriers().add(swapImageBarrier);

		final var blit = GraphicFactory.eINSTANCE.createBlitToSwapImage();
		blit.setImage(backgroundImage);
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

		imagePipeline.setStage(ECommandStage.TRANSFER);
		imagePipeline.setTaskPkg(taskPkg);

		return imagePipeline;
	}

	private static Image getOrCreateImage(final IResource resource, Pipeline imagePipeline)
	{
		if (resource instanceof Image)
		{
			return (Image) resource;
		}
		else
		{
			return createImage(resource, imagePipeline);
		}
	}

	private static Image createImage(final IResource resource, Pipeline imagePipeline)
	{
		if (imagePipeline.getResourcePkg() == null)
		{
			imagePipeline.setResourcePkg(ApplicationFactory.eINSTANCE.createResourcePkg());
		}

		final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
		initialLayout.setStage(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		initialLayout.setLayout(EImageLayout.GENERAL);
		initialLayout.getAccessMask().add(EAccess.COLOR_ATTACHMENT_READ_BIT);

		final var resourceDeployer = resource.adapt(IVulkanResource_Deployer.class);
		final var boardImage = resourceDeployer.deployImageFromFile(imagePipeline.getResourcePkg(),
																	initialLayout,
																	false);
		return boardImage;
	}
}
