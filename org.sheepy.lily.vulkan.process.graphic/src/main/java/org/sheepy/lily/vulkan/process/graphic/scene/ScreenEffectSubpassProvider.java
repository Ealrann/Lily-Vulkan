package org.sheepy.lily.vulkan.process.graphic.scene;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.notification.Notification;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.types.ModelPart;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.io.IOException;
import java.io.UncheckedIOException;

@ModelExtender(scope = ScreenEffect.class)
@Adapter
public final class ScreenEffectSubpassProvider implements ICompositor_SubpassProvider<ScreenEffect>
{
	private static final String SUBPASS_PATH = "ScreenEffect.subpass.lm";

	private final Subpass subpass;
	private final GraphicsPipeline graphicPipeline;
	private final GenericConstantBuffer constantBuffer;

	private Shader shader = null;

	private ScreenEffectSubpassProvider(final ScreenEffect part)
	{
		final var srcAttachment = (ExtraAttachment) part.srcImage();
		final var dstAttachment = (Attachment) part.dstImage();

		subpass = loadSubpass();
		final var attachmentRefPkg = subpass.attachmentRefPkg();

		attachmentRefPkg.attachmentRefs().get(0).attachment(dstAttachment);
		attachmentRefPkg.attachmentRefs().get(1).attachment(srcAttachment);

		final var descriptor = (ImageDescriptor) subpass.descriptorPkg().descriptors().get(0);
		descriptor.images().add(srcAttachment);

		graphicPipeline = (GraphicsPipeline) subpass.pipelinePkg().pipelines().get(0);
		constantBuffer = (GenericConstantBuffer) subpass.resourcePkg().resources().get(2);

		final var effect = part.effect();
		if (effect != null)
		{
			setupEffect(effect);
		}
	}

	@NotifyChanged(featureIds = ScreenEffect.FeatureIDs.EFFECT)
	private void effectChange(Notification notification)
	{
		final var newEffect = (SpecialEffect) notification.newValue();
		if (shader != null)
		{
			uninstallEffect();
		}
		if (newEffect != null)
		{
			setupEffect(newEffect);
		}
	}

	@Override
	public Subpass build(final ScreenEffect part, GraphicProcess process, IVulkanApiContext context)
	{
		return subpass;
	}

	private void setupEffect(SpecialEffect effect)
	{
		shader = Shader.builder().build();
		shader.file(copy(effect.shader()));
		shader.stage(EShaderStage.FRAGMENT_BIT);

		subpass.resourcePkg().resources().add(shader);
		graphicPipeline.shaders().remove(1);
		graphicPipeline.shaders().add(shader);

		constantBuffer.referencedVariables().clear();
		constantBuffer.referencedVariables().addAll(effect.inputs());
	}

	private void uninstallEffect()
	{
		final var defaultShader = (Shader) subpass.resourcePkg().resources().get(1);
		subpass.resourcePkg().resources().remove(shader);
		graphicPipeline.shaders().remove(1);
		graphicPipeline.shaders().add(defaultShader);
	}

	private static Subpass loadSubpass()
	{
		final var module = ScreenEffectSubpassProvider.class.getModule();
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

	private static FileResource copy(final FileResource src)
	{
		if (src == null) return null;
		return FileResource.builder().name(src.name()).path(src.path()).build();
	}
}
