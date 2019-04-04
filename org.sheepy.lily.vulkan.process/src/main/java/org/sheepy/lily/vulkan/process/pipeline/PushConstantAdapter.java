package org.sheepy.lily.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;

@Adapter(scope = PushConstant.class)
public class PushConstantAdapter implements IPipelineUnitAdapter
{
	@Override
	public void record(IPipelineUnit unit, VkCommandBuffer commandBuffer, int bindPoint)
	{
		final var pipeline = (IPipeline) unit.eContainer();
		final var pipelineAdapter = AbstractPipelineAdapter.adapt(pipeline);
		final var constants = pipelineAdapter.getConstants();
		if (constants != null)
		{
			final long layoutId = pipelineAdapter.getPipelineLayout();
			final IConstantsAdapter pushConstantAdapter = AbstractConstantsAdapter.adapt(constants);
			final var stages = constants.getStages();
			final var data = pushConstantAdapter.getData();

			int stageFlags = 0;
			for (final EShaderStage stage : stages)
			{
				stageFlags |= stage.getValue();
			}

			vkCmdPushConstants(commandBuffer, layoutId, stageFlags, 0, data);
		}
	}
}
