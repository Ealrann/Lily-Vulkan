package org.sheepy.lily.vulkan.process.graphic.scene;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.io.IOException;

@ModelExtender(scope = BackgroundImage.class)
@Adapter
public final class BackgroundImageSubpassProvider implements ICompositor_SubpassProvider<BackgroundImage>
{
	private static final String SUBPASS_PATH = "BackgroundImage.subpass";

	private ImageBarrier imageBarrier;
	private AbstractBlitTask blit;
	private VulkanResourcePkg vulkanResourcePkg;

	@NotifyChanged(featureIds = ApplicationPackage.BACKGROUND_IMAGE__SRC_IMAGE)
	private void imageChanged(Notification notification)
	{
		final var newImage = (IImage) notification.getNewValue();
		setupImage(resolveSourceImage(newImage));
	}

	@Override
	public Subpass build(BackgroundImage part, GraphicProcess process, IVulkanApiContext context)
	{
		assert part.getSrcImage() != null;
		final var subpass = loadSubpass();
		vulkanResourcePkg = subpass.getResourcePkg();

		final var swapUsages = context.getPhysicalDevice().supportedSwapUsages();
		final var supportTransfer = swapUsages.contains(EImageUsage.TRANSFER_DST);
		final var dstImage = (IVulkanImage) part.getDstImage();
		final boolean toSwap = dstImage instanceof SwapImageAttachment;
		final var pipelines = subpass.getPipelinePkg().getPipelines();
		refineSubpass(supportTransfer, subpass, toSwap);

		final var blitPipeline = (Pipeline) pipelines.get(0);
		final var tasks = blitPipeline.getTaskPkgs().get(0).getTasks();
		final var pipelineBarrier = (PipelineBarrier) tasks.get(0);
		final var srcImage = resolveSourceImage(part.getSrcImage());

		imageBarrier = (ImageBarrier) pipelineBarrier.getBarriers().get(0);
		blit = (AbstractBlitTask) tasks.get(1);
		blit.setClearColor(part.getClearColor());
		blit.setFilter(switch (part.getSampling())
							   {
								   case LINEAR -> EFilter.LINEAR;
								   case NEAREST -> EFilter.NEAREST;
							   });
		if (!toSwap)
		{
			final var dstImageBarrier = (ImageBarrier) pipelineBarrier.getBarriers().get(1);
			final var blitTask = (BlitTask) blit;
			dstImageBarrier.setImage(dstImage);
			blitTask.setDstImage(dstImage);
		}
		if (!supportTransfer)
		{
			System.err.println("[BackgroundImage] Transfer to swapchain is unsupported. Using compatibility pipeline.");
			final var colorAttachment = (ColorAttachment) subpass.getAttachmentPkg().getExtraAttachments().get(0);
			final var dstImageBarrier = (ImageBarrier) pipelineBarrier.getBarriers().get(1);
			final var blitTask = (BlitTask) blit;
			final var targetRef = subpass.getAttachmentRefPkg().getAttachmentRefs().get(0);
			dstImageBarrier.setImage(colorAttachment);
			blitTask.setDstImage(colorAttachment);

			targetRef.setAttachment((Attachment) part.getDstImage());
		}

		setupImage(srcImage);
		return subpass;
	}

	private IVulkanImage resolveSourceImage(final IImage srcImage)
	{
		if (srcImage instanceof FileImage srcFileImage)
		{
			return createImage(srcFileImage);
		}
		else
		{
			return (IVulkanImage) srcImage;
		}
	}

	private IVulkanImage createImage(final FileImage image)
	{
		final var memoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		final var imageViewer = VulkanResourceFactory.eINSTANCE.createImageViewer();
		final var fileDataProvider = VulkanResourceFactory.eINSTANCE.createFileImageDataProvider();

		fileDataProvider.setFileImageReference(image);

		imageViewer.setName("BackgroundSubpass_SrcImage");
		imageViewer.getUsages().add(EImageUsage.TRANSFER_SRC);
		imageViewer.getUsages().add(EImageUsage.TRANSFER_DST);
		imageViewer.getUsages().add(EImageUsage.STORAGE);
		imageViewer.setInitialLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		imageViewer.setDataProvider(fileDataProvider);
		memoryChunk.getParts().add(imageViewer);
		vulkanResourcePkg.getResources().add(memoryChunk);

		return imageViewer;
	}

	private static void refineSubpass(final boolean supportTransfer, final Subpass subpass, final boolean toSwap)
	{
		final var pipelines = subpass.getPipelinePkg().getPipelines();
		final var pipelineBlitToSwap = pipelines.get(0);
		final var pipelineBlitToImage = pipelines.get(1);
		final var pipelineCompatibility = pipelines.get(2);
		if (supportTransfer)
		{
			EcoreUtil.delete(pipelineCompatibility);
			EcoreUtil.delete(subpass.getAttachmentPkg().getExtraAttachments().get(0));
			EcoreUtil.delete(subpass.getAttachmentRefPkg().getAttachmentRefs().get(0));
		}
		if (toSwap && supportTransfer)
		{
			EcoreUtil.delete(pipelineBlitToImage);
		}
		else
		{
			EcoreUtil.delete(pipelineBlitToSwap);
		}
	}

	private void setupImage(IVulkanImage image)
	{
		imageBarrier.setImage(image);
		blit.setSrcImage(image);
	}

	private static Subpass loadSubpass()
	{
		final var module = ScreenEffectSubpassProvider.class.getModule();
		try
		{
			final var resourceLoader = IResourceService.INSTANCE;
			final var inputStream = module.getResourceAsStream(SUBPASS_PATH);
			final var resource = resourceLoader.loadResource(inputStream);
			final EObject subpass = resource.getContents().get(0);
			return subpass != null ? (Subpass) subpass : GraphicFactory.eINSTANCE.createSubpass();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
			return GraphicFactory.eINSTANCE.createSubpass();
		}
	}
}
