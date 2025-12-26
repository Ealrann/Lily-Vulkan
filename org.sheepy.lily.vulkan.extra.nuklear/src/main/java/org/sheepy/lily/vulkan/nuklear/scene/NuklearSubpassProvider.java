package org.sheepy.lily.vulkan.nuklear.scene;

import org.lwjgl.BufferUtils;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.ModelPart;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.io.IOException;
import java.io.UncheckedIOException;

@ModelExtender(scope = UI.class)
@Adapter(singleton = true)
public final class NuklearSubpassProvider implements ICompositor_SubpassProvider<UI>
{
	public static final String IMAGE_MEMORY_CHUNK_NAME = "UIImages";

	private static final String PIPELINE_PATH = "Nuklear.subpass.lm";

	@Override
	public Subpass build(final UI part, final GraphicProcess process, final IVulkanApiContext context)
	{
		if (part.dstImage() == null) throw new IllegalStateException("UI dstImage is not set");

		final var colorAttachment = (Attachment) part.dstImage();
		final var subpass = loadSubpass();
		final var attachmentRefPkg = subpass.attachmentRefPkg();
		final var colorRef = AttachmentRef.builder().build();
		colorRef.layout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.attachment(colorAttachment);
		attachmentRefPkg.attachmentRefs().add(colorRef);

		setupImages(subpass, part);

		return subpass;
	}

	private static void setupImages(final Subpass subpass, final UI part)
	{
		final var memoryChunk = MemoryChunk.builder().name(IMAGE_MEMORY_CHUNK_NAME).build();
		final var graphicsPipeline = (GraphicsPipeline) subpass.pipelinePkg().pipelines().get(0);
		final var constantBuffer = (ConstantBuffer) graphicsPipeline.resourcePkg().resources().get(6);
		final var imageDescriptor = (ImageDescriptor) graphicsPipeline.descriptorPkg().descriptors().get(3);
		final var descriptorImages = imageDescriptor.images();

		part.images().stream().map(image -> resolveVulkanImage(memoryChunk, image)).forEach(descriptorImages::add);

		if (memoryChunk.parts().isEmpty() == false)
		{
			subpass.resourcePkg().resources().add(memoryChunk);
		}

		final var specializationBuffer = BufferUtils.createByteBuffer(4);
		specializationBuffer.putInt(part.images().size());
		specializationBuffer.flip();
		constantBuffer.data(specializationBuffer);
	}

	private static IVulkanImage resolveVulkanImage(final MemoryChunk imageMemoryChunk, final IImage image)
	{
		if (image instanceof IVulkanImage vulkanImage)
		{
			return vulkanImage;
		}
		else if (image instanceof FileImage fileImage)
		{
			final var res = buildImage(fileImage);
			imageMemoryChunk.parts().add(res);
			return res;
		}
		else
		{
			throw new IllegalArgumentException("Unsupported image type: " + image.getClass());
		}
	}

	private static ImageViewer buildImage(final FileImage fileImage)
	{
		final var dataProvider = FileImageDataProvider.builder().build();
		dataProvider.fileImageReference(fileImage);

		return ImageViewer.builder()
						  .name(fileImage.name())
						  .initialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL)
						  .addUsage(EImageUsage.TRANSFER_DST)
						  .addUsage(EImageUsage.SAMPLED)
						  .dataProvider(() -> dataProvider)
						  .build();
	}

	private static Subpass loadSubpass()
	{
		final var module = NuklearSubpassProvider.class.getModule();
		final var resourceLoader = IResourceService.INSTANCE;
		if (resourceLoader == null) throw new IllegalStateException("Cannot load " + PIPELINE_PATH + ": IResourceService is not available");

		try (final var inputStream = openResource(module, PIPELINE_PATH))
		{
			if (inputStream == null) throw new IllegalStateException("Cannot load " + PIPELINE_PATH + ": resource not found");
			final var root = resourceLoader.loadResource(inputStream);
			return requireSubpass(root, PIPELINE_PATH);
		}
		catch (final IOException e)
		{
			throw new UncheckedIOException("Failed to load " + PIPELINE_PATH, e);
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
