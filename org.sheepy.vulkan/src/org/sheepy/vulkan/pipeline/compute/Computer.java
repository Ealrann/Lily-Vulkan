package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.pipeline.IPipelineExecutable;
import org.sheepy.vulkan.pipeline.PipelineId;

public class Computer extends PipelineId implements IPipelineExecutable
{
	public final int groupCountX;
	public final int groupCountY;
	public final int groupCountZ;
	
	public Computer(long pipelineId, int groupCountX, int groupCountY, int groupCountZ)
	{
		super(pipelineId);
		this.groupCountX = groupCountX;
		this.groupCountY = groupCountY;
		this.groupCountZ = groupCountZ;
	}

	@Override
	public void execute(VkCommandBuffer commandBuffer)
	{
		vkCmdBindPipeline(commandBuffer, VK_PIPELINE_BIND_POINT_COMPUTE, id);

		vkCmdDispatch(commandBuffer, groupCountX, groupCountY, groupCountZ);
	}
}
