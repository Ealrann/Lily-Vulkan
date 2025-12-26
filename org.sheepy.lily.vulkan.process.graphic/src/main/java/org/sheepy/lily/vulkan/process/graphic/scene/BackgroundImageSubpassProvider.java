package org.sheepy.lily.vulkan.process.graphic.scene;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.ModelPart;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.AbstractBlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.io.IOException;
import java.io.UncheckedIOException;

@ModelExtender(scope = BackgroundImage.class)
@Adapter
public final class BackgroundImageSubpassProvider implements ICompositor_SubpassProvider<BackgroundImage>
{
	private static final String SUBPASS_PATH = "BackgroundImage.subpass.lm";

	private ImageBarrier imageBarrier;
	private AbstractBlitTask blit;
	private VulkanResourcePkg vulkanResourcePkg;

	@NotifyChanged(featureIds = BackgroundImage.FeatureIDs.SRC_IMAGE)
	private void imageChanged(Notification notification)
	{
		final var newImage = (IImage) notification.newValue();
		setupImage(resolveSourceImage(newImage));
	}

	@Override
	public Subpass build(BackgroundImage part, GraphicProcess process, IVulkanApiContext context)
	{
		assert part.srcImage() != null;
		final var subpass = loadSubpass();
		vulkanResourcePkg = subpass.resourcePkg();

		final var swapUsages = context.getPhysicalDevice().supportedSwapUsages();
		final var supportTransfer = swapUsages.contains(EImageUsage.TRANSFER_DST);
		final var dstImage = (IVulkanImage) part.dstImage();
		final boolean toSwap = dstImage instanceof SwapImageAttachment;
		final var pipelines = subpass.pipelinePkg().pipelines();
		refineSubpass(supportTransfer, subpass, toSwap);

		final var blitPipeline = (Pipeline) pipelines.get(0);
		final var tasks = blitPipeline.taskPkgs().get(0).tasks();
		final var pipelineBarrier = (PipelineBarrier) tasks.get(0);
		final var srcImage = resolveSourceImage(part.srcImage());

		imageBarrier = (ImageBarrier) pipelineBarrier.barriers().get(0);
		blit = (AbstractBlitTask) tasks.get(1);
		blit.clearColor(part.clearColor());
		blit.filter(switch (part.sampling())
							   {
								   case Linear -> EFilter.LINEAR;
								   case Nearest -> EFilter.NEAREST;
							   });
		if (!toSwap)
		{
			final var dstImageBarrier = (ImageBarrier) pipelineBarrier.barriers().get(1);
			final var blitTask = (BlitTask) blit;
			dstImageBarrier.image(dstImage);
			blitTask.dstImage(dstImage);
		}
		if (!supportTransfer)
		{
			System.err.println("[BackgroundImage] Transfer to swapchain is unsupported. Using compatibility pipeline.");
			final var colorAttachment = (ColorAttachment) subpass.attachmentPkg().extraAttachments().get(0);
			final var dstImageBarrier = (ImageBarrier) pipelineBarrier.barriers().get(1);
			final var blitTask = (BlitTask) blit;
			final var targetRef = subpass.attachmentRefPkg().attachmentRefs().get(0);
			dstImageBarrier.image(colorAttachment);
			blitTask.dstImage(colorAttachment);

			targetRef.attachment((Attachment) part.dstImage());
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
		final var fileDataProvider = FileImageDataProvider.builder().build();

		fileDataProvider.fileImageReference(image);

		final var imageViewer = ImageViewer.builder()
										   .name("BackgroundSubpass_SrcImage")
										   .addUsage(EImageUsage.TRANSFER_SRC)
										   .addUsage(EImageUsage.TRANSFER_DST)
										   .addUsage(EImageUsage.STORAGE)
										   .initialLayout(EImageLayout.TRANSFER_SRC_OPTIMAL)
										   .dataProvider(() -> fileDataProvider)
										   .build();
		final var memoryChunk = MemoryChunk.builder().build();
		memoryChunk.parts().add(imageViewer);
		vulkanResourcePkg.resources().add(memoryChunk);

		return imageViewer;
	}

	private static void refineSubpass(final boolean supportTransfer, final Subpass subpass, final boolean toSwap)
	{
		final var pipelines = subpass.pipelinePkg().pipelines();
		final var pipelineBlitToSwap = pipelines.get(0);
		final var pipelineBlitToImage = pipelines.get(1);
		final var pipelineCompatibility = pipelines.get(2);
		if (supportTransfer)
		{
			ModelUtil.delete(pipelineCompatibility);
			ModelUtil.delete(subpass.attachmentPkg().extraAttachments().get(0));
			ModelUtil.delete(subpass.attachmentRefPkg().attachmentRefs().get(0));
		}
		if (toSwap && supportTransfer)
		{
			ModelUtil.delete(pipelineBlitToImage);
		}
		else
		{
			ModelUtil.delete(pipelineBlitToSwap);
		}
	}

	private void setupImage(IVulkanImage image)
	{
		imageBarrier.image(image);
		blit.srcImage(image);
	}

	private static Subpass loadSubpass()
	{
		final var module = BackgroundImageSubpassProvider.class.getModule();
		final var resourceLoader = IResourceService.INSTANCE;
		if (resourceLoader == null) throw new IllegalStateException("Cannot load " + SUBPASS_PATH + ": IResourceService is not available");

		try (var inputStream = openResource(module, SUBPASS_PATH))
		{
			if (inputStream == null) throw new IllegalStateException("Cannot load " + SUBPASS_PATH + ": resource not found");
			final var root = resourceLoader.loadResource(inputStream);
			return requireSubpass(root, SUBPASS_PATH);
		}
		catch (final IOException e)
		{
			throw new UncheckedIOException("Failed to load " + SUBPASS_PATH, e);
		}
	}

	private static Subpass requireSubpass(final Object root, final String path)
	{
		if (root instanceof Subpass subpass) return subpass;
		if (root instanceof ModelPart part)
		{
			for (final var child : part.children())
			{
				if (child instanceof Subpass subpass) return subpass;
			}
		}
		throw new IllegalStateException("Cannot load " + path + ": root is not a Subpass");
	}

	private static java.io.InputStream openResource(final Module module, final String path) throws IOException
	{
		if (module == null || path == null) return null;

		var inputStream = module.getResourceAsStream(path);
		if (inputStream != null) return inputStream;

		inputStream = module.getResourceAsStream("/" + path);
		if (inputStream != null) return inputStream;

		final var classLoader = module.getClassLoader();
		return classLoader != null ? classLoader.getResourceAsStream(path) : null;
	}
}
