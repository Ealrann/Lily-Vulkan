package org.sheepy.lily.vulkan.nuklear.scene;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.BufferUtils;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.vulkanresource.*;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.io.IOException;

@ModelExtender(scope = UI.class)
@Adapter(singleton = true)
public final class NuklearSubpassProvider implements ICompositor_SubpassProvider<UI>
{
	public static final String IMAGE_MEMORY_CHUNK_NAME = "UIImages";

	private static final String PIPELINE_PATH = "Nuklear.subpass";

	@Override
	public Subpass build(UI part, GraphicProcess process, IVulkanApiContext context)
	{
		final var colorAttachment = (Attachment) part.getDstImage();
		final var subpass = loadSubpass();
		final var attachmentRefPkg = subpass.getAttachmentRefPkg();
		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(colorAttachment);
		attachmentRefPkg.getAttachmentRefs().add(colorRef);

		setupImages(subpass, part);

		return subpass;
	}

	private static void setupImages(final Subpass subpass, final UI part)
	{
		final var memoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		final var graphicsPipeline = (GraphicsPipeline) subpass.getPipelinePkg().getPipelines().get(0);
		final var constantBuffer = (ConstantBuffer) graphicsPipeline.getResourcePkg().getResources().get(6);
		final var imageDescriptor = (ImageDescriptor) graphicsPipeline.getDescriptorPkg().getDescriptors().get(3);
		final var descriptorImages = imageDescriptor.getImages();

		memoryChunk.setName(IMAGE_MEMORY_CHUNK_NAME);

		part.getImages().stream().map(image -> resolveVulkanImage(memoryChunk, image)).forEach(descriptorImages::add);

		if (memoryChunk.getParts().isEmpty() == false)
		{
			subpass.getResourcePkg().getResources().add(memoryChunk);
		}

		final var specializationBuffer = BufferUtils.createByteBuffer(4);
		specializationBuffer.putInt(part.getImages().size() + 1);
		specializationBuffer.flip();
		constantBuffer.setData(specializationBuffer);
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
			imageMemoryChunk.getParts().add(res);
			return res;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	private static ImageViewer buildImage(final FileImage fileImage)
	{
		final var res = VulkanResourceFactory.eINSTANCE.createImageViewer();
		final var dataProvider = VulkanResourceFactory.eINSTANCE.createFileImageDataProvider();

		dataProvider.setFileImageReference(fileImage);
		res.setInitialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		res.getUsages().add(EImageUsage.TRANSFER_DST);
		res.getUsages().add(EImageUsage.SAMPLED);
		res.setDataProvider(dataProvider);

		return res;
	}

	private static Subpass loadSubpass()
	{
		final var module = NuklearSubpassProvider.class.getModule();
		try
		{
			final var resourceLoader = IResourceService.INSTANCE;
			final var inputStream = module.getResourceAsStream(PIPELINE_PATH);
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
