package org.sheepy.lily.vulkan.nuklear.builder.internal;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearPushConstantsAdapter;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;

public final class PushContantsBuilder
{
	public static final void setup(GraphicsPipeline pipeline)
	{

		final var range = PipelineFactory.eINSTANCE.createPushConstantRange();
		range.getStages().add(EShaderStage.VERTEX_BIT);
		range.setSize(NuklearPushConstantsAdapter.SIZE);
		pipeline.getPushConstantRanges().add(range);
	}

	private PushContantsBuilder()
	{}
}
