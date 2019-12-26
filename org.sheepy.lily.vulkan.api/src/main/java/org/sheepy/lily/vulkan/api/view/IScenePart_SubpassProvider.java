package org.sheepy.lily.vulkan.api.view;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface IScenePart_SubpassProvider<T extends IScenePart> extends IAdapter
{
	SubpassData build(T part, SwapImageAttachment colorAttachmentDescriptor);

	final static class SubpassData
	{
		public final List<IPipeline> pipelines;
		public final Subpass subpass;
		public final EPipelineStage stage;
		public final List<EAccess> accesses;
		public final List<ExtraAttachment> extraAttachments;

		public SubpassData(	List<IPipeline> pipelines,
							Subpass subpass,
							EPipelineStage stage,
							List<EAccess> accesses,
							List<ExtraAttachment> extraAttachments)
		{
			this.pipelines = List.copyOf(pipelines);
			this.subpass = subpass;
			this.stage = stage;
			this.accesses = List.copyOf(accesses);
			this.extraAttachments = List.copyOf(extraAttachments);
		}
	}
}
