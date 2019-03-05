package org.sheepy.lily.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;

@Adapter(scope = PushConstant.class)
public class PushConstantAdapter implements IPipelineUnitAdapter<AbstractCommandBuffer>
{
	@Override
	public void record(IPipelineUnit unit, AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		IPipeline pipeline = (IPipeline) unit.eContainer();
		AbstractPipelineAdapter<?> adapter = AbstractPipelineAdapter.adapt(pipeline);
		final var constants = adapter.getConstants();
		if (constants != null)
		{
			final var pushConstantAdapter = AbstractConstantsAdapter.adapt(constants);
			final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

			final EShaderStage stage = constants.getStage();
			vkCmdPushConstants(vkCommandBuffer, adapter.pipelineLayout, stage.getValue(), 0,
					pushConstantAdapter.getData());
		}
	}
}
