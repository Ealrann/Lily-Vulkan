package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

@ModelExtender(scope = RenderPass.class)
@Adapter
@AutoLoad
public final class RenderPassAdapter implements IAdapter
{
	private final RenderPass renderPass;

	private RenderPassAdapter(RenderPass renderPass, IObservatoryBuilder observatory)
	{
		this.renderPass = renderPass;
		observatory.exploreParent(GraphicConfiguration.class)
				   .exploreParent(GraphicProcess.class)
				   .explore(GraphicProcess.FeatureIDs.SUBPASSES)
				   .explore(Subpass.FeatureIDs.ATTACHMENT_REF_PKG)
				   .explore(AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS)
				   .explore(AttachmentRef.FeatureIDs.ATTACHMENT, ExtraAttachment.class)
				   .gather(this::addAttachment, this::removeAttachment);
	}

	private void addAttachment(final ExtraAttachment attachment)
	{
		if (renderPass.attachments()
					  .contains(attachment) == false)
		{
			renderPass.attachments()
					  .add(attachment);
		}
	}

	private void removeAttachment(final ExtraAttachment attachment)
	{
		renderPass.attachments()
				  .remove(attachment);
	}
}
