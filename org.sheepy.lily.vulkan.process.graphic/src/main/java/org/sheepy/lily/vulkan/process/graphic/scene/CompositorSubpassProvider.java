package org.sheepy.lily.vulkan.process.graphic.scene;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.types.ModelPart;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = Compositor.class)
@Adapter(singleton = true)
public class CompositorSubpassProvider implements ICompositor_SubpassProvider<Compositor>
{
	private static final String PIPELINE_PATH = "Compositor.subpass.lm";

	@Override
	public Subpass build(Compositor compositor, GraphicProcess process, IVulkanApiContext context)
	{
		final var colorAttachments = compositor.colorAttachments();
		final var inputAttachments = compositor.inputAttachments();
		final var subpass = loadSubpass();
		final var attachmentRefPkg = subpass.attachmentRefPkg();
		final var genericConstants = (GenericConstantBuffer) subpass.resourcePkg().resources().get(0);
		final var pipeline = (GraphicsPipeline) subpass.pipelinePkg().pipelines().get(0);

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
			final var inputRef = AttachmentRef.builder().build();
			inputRef.layout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
			inputRef.attachment(inputAttachment);
			inputRef.type(EAttachmentType.Input);
			inputRefs.add(inputRef);
		}
		attachmentRefPkg.attachmentRefs().addAll(inputRefs);
	}

	private static void installColorAttachments(final List<Attachment> colorAttachments,
												final AttachmentRefPkg attachmentRefPkg)
	{
		final List<AttachmentRef> colorRefs = new ArrayList<>();
		for (var colorAttachment : colorAttachments)
		{
			final var colorRef = AttachmentRef.builder().build();
			colorRef.layout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
			colorRef.attachment(colorAttachment);
			colorRef.type(EAttachmentType.Color);
			colorRefs.add(colorRef);
		}
		attachmentRefPkg.attachmentRefs().addAll(colorRefs);
	}

	private static void installConstants(final Compositor compositor, final GenericConstantBuffer genericConstants)
	{
		final ModelVariablePkg constantVariables = compositor.constantVariables();
		if (constantVariables != null)
		{
			genericConstants.referencedVariables().addAll(constantVariables.variables());
		}
	}

	private static void installShaders(final Compositor compositor, final GraphicsPipeline pipeline)
	{
		pipeline.shaders().add(compositor.vertexShader());
		pipeline.shaders().add(compositor.fragmentShader());
	}

	private static void installDescriptors(final Compositor compositor, final GraphicsPipeline pipeline)
	{
		final DescriptorPkg descriptorPkg = compositor.descriptorPkg();
		if (descriptorPkg != null)
		{
			final var descriptorSet = pipeline.descriptorPool().descriptorSets().get(0);
			descriptorSet.descriptors().addAll(descriptorPkg.descriptors());
		}
	}

	private static Subpass loadSubpass()
	{
		final var module = CompositorSubpassProvider.class.getModule();
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
