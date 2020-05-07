package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;

@ModelExtender(scope = RenderPass.class)
@Adapter(lazy = false)
public final class RenderPassAdapter
{
	private final RenderPass renderPass;

	private RenderPassAdapter(RenderPass renderPass, IObservatoryBuilder observatory)
	{
		this.renderPass = renderPass;
		observatory.explore(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES)
				   .explore(GraphicPackage.Literals.SUBPASS__ATTACHMENT_REF_PKG)
				   .explore(GraphicPackage.Literals.ATTACHMENT_REF_PKG__ATTACHMENT_REFS)
				   .explore(GraphicPackage.Literals.ATTACHMENT_REF__ATTACHMENT, ExtraAttachment.class)
				   .gather(this::addAttachment, this::removeAttachment);
	}

	private void addAttachment(final ExtraAttachment attachment)
	{
		if (renderPass.getAttachments().contains(attachment) == false)
		{
			renderPass.getAttachments().add(attachment);
		}
	}

	private void removeAttachment(final ExtraAttachment attachment)
	{
		renderPass.getAttachments().remove(attachment);
	}
}
