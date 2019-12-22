package org.sheepy.lily.vulkan.nuklear.scene;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.model.presentation.UI;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

@Adapter(scope = UI.class)
public class NuklearSubpassProvider implements IScenePart_SubpassProvider<UI>
{
	private static final String PIPELINE_PATH = "NuklearPipeline.nuklear";

	@Override
	public SubpassData build(UI part, SwapImageAttachment colorAttachmentDescriptor)
	{
		final var pipeline = loadPipeline();
		final var subpass = buildSubpass(colorAttachmentDescriptor);

		return new SubpassData(	List.of(pipeline),
								subpass,
								EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT,
								List.of(EAccess.COLOR_ATTACHMENT_WRITE_BIT,
										EAccess.COLOR_ATTACHMENT_READ_BIT),
								List.of());
	}

	private static GraphicsPipeline loadPipeline()
	{
		GraphicsPipeline res = null;
		final var module = NuklearSubpassProvider.class.getModule();
		try
		{
			var resourceLoader = IResourceLoader.INSTANCE;
			final var inputStream = module.getResourceAsStream(PIPELINE_PATH);
			final var resource = resourceLoader.loadResource(inputStream);
			res = (GraphicsPipeline) resource.getContents().get(0);
		} catch (final IOException e)
		{
			e.printStackTrace();
		}
		return EcoreUtil.copy(res);
	}

	private static Subpass buildSubpass(SwapImageAttachment colorAttachment)
	{
		final var subpass = GraphicFactory.eINSTANCE.createSubpass();

		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(colorAttachment);
		subpass.getRefs().add(colorRef);

		return subpass;
	}
}
