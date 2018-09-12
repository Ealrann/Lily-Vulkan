package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.pipeline.PipelineId;

public class Computer extends PipelineId implements IComputeExecutable
{
	public int groupCountX;
	public int groupCountY;
	public int groupCountZ;

	public Computer(long pipelineId, int groupCountX, int groupCountY, int groupCountZ)
	{
		super(pipelineId);
		this.groupCountX = groupCountX;
		this.groupCountY = groupCountY;
		this.groupCountZ = groupCountZ;
	}

	@Override
	public void execute(ComputeCommandBuffer commandBuffer)
	{
		vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_COMPUTE, id);

		vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCountX, groupCountY, groupCountZ);
	}
}
