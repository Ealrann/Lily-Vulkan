package org.sheepy.lily.vulkan.process.graphic.scene;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.io.IOException;

@ModelExtender(scope = ScreenEffect.class)
@Adapter
public final class ScreenEffectSubpassProvider implements ICompositor_SubpassProvider<ScreenEffect>
{
	private static final String SUBPASS_PATH = "ScreenEffect.subpass";

	private final Subpass subpass;
	private final GraphicsPipeline graphicPipeline;
	private final GenericConstantBuffer constantBuffer;

	private Shader shader = null;

	private ScreenEffectSubpassProvider(final ScreenEffect part)
	{
		final var srcAttachment = (ExtraAttachment) part.getSrcImage();
		final var dstAttachment = (Attachment) part.getDstImage();

		subpass = loadSubpass();
		final var attachmentRefPkg = subpass.getAttachmentRefPkg();
		final var srcRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		srcRef.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		srcRef.setAttachment(srcAttachment);
		srcRef.setType(EAttachmentType.INPUT);
		final var dstRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		dstRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		dstRef.setAttachment(dstAttachment);
		dstRef.setType(EAttachmentType.COLOR);

		attachmentRefPkg.getAttachmentRefs().add(dstRef);
		attachmentRefPkg.getAttachmentRefs().add(srcRef);

		final var descriptor = (AttachmentDescriptor) subpass.getDescriptorPkg().getDescriptors().get(0);
		descriptor.setAttachment(srcAttachment);

		graphicPipeline = (GraphicsPipeline) subpass.getPipelinePkg().getPipelines().get(0);
		constantBuffer = (GenericConstantBuffer) subpass.getResourcePkg().getResources().get(2);

		final var effect = part.getEffect();
		if (effect != null)
		{
			setupEffect(effect);
		}
	}

	@NotifyChanged(featureIds = ApplicationPackage.SCREEN_EFFECT__EFFECT)
	private void effectChange(Notification notification)
	{
		final var newEffect = (SpecialEffect) notification.getNewValue();
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
		shader = VulkanResourceFactory.eINSTANCE.createShader();
		shader.setFile(EcoreUtil.copy(effect.getShader()));
		shader.setStage(EShaderStage.FRAGMENT_BIT);

		subpass.getVulkanResourcePkg().getResources().add(shader);
		graphicPipeline.getShaders().remove(1);
		graphicPipeline.getShaders().add(shader);

		constantBuffer.getReferencedVariables().clear();
		constantBuffer.getReferencedVariables().addAll(effect.getInputs());
	}

	private void uninstallEffect()
	{
		final var defaultShader = (Shader) subpass.getResourcePkg().getResources().get(1);
		subpass.getResourcePkg().getResources().remove(shader);
		graphicPipeline.getShaders().remove(1);
		graphicPipeline.getShaders().add(defaultShader);
	}

	private static Subpass loadSubpass()
	{
		final var module = ScreenEffectSubpassProvider.class.getModule();
		try
		{
			final var resourceLoader = IResourceLoader.INSTANCE;
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
