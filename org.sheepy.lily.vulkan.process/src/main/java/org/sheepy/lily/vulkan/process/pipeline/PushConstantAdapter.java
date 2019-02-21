package org.sheepy.lily.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;

public class PushConstantAdapter extends AbstractStatefullAdapter
		implements IPipelineUnitAdapter<AbstractCommandBuffer>
{

	@Override
	public void record(AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		IPipeline pipeline = (IPipeline) target.eContainer();
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ProcessPackage.Literals.PUSH_CONSTANT == eClass;
	}
}
