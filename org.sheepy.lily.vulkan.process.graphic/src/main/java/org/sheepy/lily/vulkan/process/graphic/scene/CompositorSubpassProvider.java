package org.sheepy.lily.vulkan.process.graphic.scene;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.api.device.IVulkanContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Adapter(scope = Compositor.class)
public class CompositorSubpassProvider implements ICompositor_SubpassProvider<Compositor>
{
	private static final String PIPELINE_PATH = "com/isotropy/materia/asset/model/Compositor.subpass";

	@Override
	public Subpass build(Compositor compositor, IVulkanContext context)
	{
		final var colorAttachments = compositor.getColorAttachments();
		final var inputAttachments = compositor.getInputAttachments();
		final var subpass = loadSubpass();
		final var attachmentRefPkg = subpass.getAttachmentRefPkg();
		final var genericConstants = (GenericConstantBuffer) subpass.getResourcePkg().getResources().get(0);
		final var pipeline = (GraphicsPipeline) subpass.getPipelinePkg().getPipelines().get(0);

		installShaders(compositor, pipeline);
		installDescriptors(compositor, pipeline);
		installConstants(compositor, genericConstants);
		installColorAttachments(colorAttachments, attachmentRefPkg);
		installInputAttachments(inputAttachments, attachmentRefPkg);

		return subpass;
	}

	private static void installInputAttachments(final List<ExtraAttachment> inputAttachments,
												final AttachmentRefPkg attachmentRefPkg)
	{
		final List<AttachmentRef> inputRefs = new ArrayList<>();
		for (var inputAttachment : inputAttachments)
		{
			final var inputRef = GraphicFactory.eINSTANCE.createAttachmentRef();
			inputRef.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
			inputRef.setAttachment(inputAttachment);
			inputRef.setType(EAttachmentType.INPUT);
			inputRefs.add(inputRef);
		}
		attachmentRefPkg.getAttachmentRefs().addAll(inputRefs);
	}

	private static void installColorAttachments(final List<Attachment> colorAttachments,
												final AttachmentRefPkg attachmentRefPkg)
	{
		final List<AttachmentRef> colorRefs = new ArrayList<>();
		for (var colorAttachment : colorAttachments)
		{
			final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
			colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
			colorRef.setAttachment(colorAttachment);
			colorRef.setType(EAttachmentType.COLOR);
			colorRefs.add(colorRef);
		}
		attachmentRefPkg.getAttachmentRefs().addAll(colorRefs);
	}

	private static void installConstants(final Compositor compositor, final GenericConstantBuffer genericConstants)
	{
		final ModelVariablePkg constantVariables = compositor.getConstantVariables();
		if (constantVariables != null)
		{
			genericConstants.getReferencedVariables().addAll(constantVariables.getVariables());
		}
	}

	private static void installShaders(final Compositor compositor, final GraphicsPipeline pipeline)
	{
		pipeline.getShaders().add(compositor.getVertexShader());
		pipeline.getShaders().add(compositor.getFragmentShader());
	}

	private static void installDescriptors(final Compositor compositor, final GraphicsPipeline pipeline)
	{
		final DescriptorPkg descriptorPkg = compositor.getDescriptorPkg();
		if (descriptorPkg != null)
		{
			final var descriptorSet = pipeline.getDescriptorSetPkg().getDescriptorSets().get(0);
			descriptorSet.getDescriptors().addAll(descriptorPkg.getDescriptors());
		}
	}

	private static Subpass loadSubpass()
	{
		final var module = CompositorSubpassProvider.class.getModule();
		try
		{
			final var path = PIPELINE_PATH;
			final var resourceLoader = IResourceLoader.INSTANCE;
			final var inputStream = module.getResourceAsStream(path);
			final var resource = resourceLoader.loadResource(inputStream);
			final var res = (Subpass) resource.getContents().get(0);
			return EcoreUtil.copy(res);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		return GraphicFactory.eINSTANCE.createSubpass();
	}
}
