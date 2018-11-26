package org.sheepy.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;

public class DynamicStateBuilder
{
	private VkPipelineDynamicStateCreateInfo dynamicState;
	private IntBuffer dynamicStates;

	public VkPipelineDynamicStateCreateInfo allocDynamicStateCreateInfo()
	{
		dynamicStates = MemoryUtil.memAllocInt(2);
		dynamicStates.put(VK_DYNAMIC_STATE_VIEWPORT);
		dynamicStates.put(VK_DYNAMIC_STATE_LINE_WIDTH);
		dynamicStates.flip();

		dynamicState = VkPipelineDynamicStateCreateInfo.malloc();
		dynamicState.sType(VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO);
		dynamicState.pDynamicStates(dynamicStates);

		return dynamicState;
	}

	public void freeDynamicStateCreateInfo()
	{
		dynamicState.free();
		MemoryUtil.memFree(dynamicStates);
	}
}
