package org.sheepy.lily.vulkan.nuklear.scene;

import java.io.IOException;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@Adapter(scope = UI.class)
public class NuklearSubpassProvider implements IScenePart_SubpassProvider<UI>
{
	private static final String PIPELINE_NO_IMAGE_PATH = "NuklearNoImages.subpass";
	private static final String PIPELINE_PATH = "Nuklear.subpass";

	@Override
	public Subpass build(UI part, AttachmentPkg attachmentPkg)
	{
		final var subpass = loadSubpass(part.isImageSupport());
		final var attachmentRefPkg = subpass.getAttachmantRefPkg();
		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(attachmentPkg.getColorAttachment());
		attachmentRefPkg.getAttachmentRefs().add(colorRef);

		return subpass;
	}

	private static Subpass loadSubpass(boolean imageSupport)
	{
		Subpass res = null;
		final var module = NuklearSubpassProvider.class.getModule();
		try
		{
			final var path = imageSupport ? PIPELINE_PATH : PIPELINE_NO_IMAGE_PATH;
			final var resourceLoader = IResourceLoader.INSTANCE;
			final var inputStream = module.getResourceAsStream(path);
			final var resource = resourceLoader.loadResource(inputStream);
			res = (Subpass) resource.getContents().get(0);
		} catch (final IOException e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
