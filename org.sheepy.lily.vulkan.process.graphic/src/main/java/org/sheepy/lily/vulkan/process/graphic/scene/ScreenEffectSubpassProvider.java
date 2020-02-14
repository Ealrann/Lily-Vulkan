package org.sheepy.lily.vulkan.process.graphic.scene;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.io.IOException;

@Statefull
@Adapter(scope = ScreenEffect.class)
public final class ScreenEffectSubpassProvider implements IScenePart_SubpassProvider<ScreenEffect>
{
	private static final String SUBPASS_PATH = "ScreenEffect.subpass";

	private final Subpass subpass;
	private final GraphicsPipeline graphicPipeline;

	private Shader customShader = null;

	private ScreenEffectSubpassProvider(final ScreenEffect part)
	{
		final var srcAttachment = (ExtraAttachment) part.getSrcImage();
		final var dstAttachment = (Attachment) part.getDstImage();

		subpass = loadSubpass();
		final var attachmentRefPkg = subpass.getAttachmantRefPkg();
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

		final var shaderFile = part.getShader();
		if (shaderFile != null)
		{
			setupCustomShader(shaderFile);
		}
	}

	@NotifyChanged(featureIds = ApplicationPackage.SCREEN_EFFECT__SHADER)
	private void shaderChange(Notification notification)
	{
		final var newShader = (FileResource) notification.getNewValue();
		if (customShader != null)
		{
			uninstallCustomShader();
		}
		if (newShader != null)
		{
			setupCustomShader(newShader);
		}
	}

	@Override
	public Subpass build(final ScreenEffect part, final AttachmentPkg attachmentPkg)
	{
		return subpass;
	}

	private void setupCustomShader(FileResource shaderFile)
	{
		customShader = VulkanResourceFactory.eINSTANCE.createShader();
		customShader.setFile(EcoreUtil.copy(shaderFile));
		customShader.setStage(EShaderStage.FRAGMENT_BIT);

		subpass.getResourcePkg().getResources().add(customShader);
		graphicPipeline.getShaders().remove(1);
		graphicPipeline.getShaders().add(customShader);
	}

	private void uninstallCustomShader()
	{
		final var defaultShader = (Shader) subpass.getResourcePkg().getResources().get(1);
		subpass.getResourcePkg().getResources().remove(customShader);
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
