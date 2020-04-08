package org.sheepy.lily.vulkan.nuklear.scene;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.io.IOException;

@Adapter(scope = UI.class)
public final class NuklearSubpassProvider implements ICompositor_SubpassProvider<UI>
{
	private static final String PIPELINE_NO_IMAGE_PATH = "NuklearNoImages.subpass";
	private static final String PIPELINE_PATH = "Nuklear.subpass";

	@Override
	public Subpass build(UI part, GraphicProcess process, IVulkanApiContext context)
	{
		final var colorAttachment = (Attachment) part.getDstImage();
		final var subpass = loadSubpass(part.isImageSupport());
		final var attachmentRefPkg = subpass.getAttachmentRefPkg();
		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(colorAttachment);
		attachmentRefPkg.getAttachmentRefs().add(colorRef);

		return subpass;
	}

	private static Subpass loadSubpass(boolean imageSupport)
	{
		final var module = NuklearSubpassProvider.class.getModule();
		try
		{
			final var path = imageSupport ? PIPELINE_PATH : PIPELINE_NO_IMAGE_PATH;
			final var resourceLoader = IResourceLoader.INSTANCE;
			final var inputStream = module.getResourceAsStream(path);
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
