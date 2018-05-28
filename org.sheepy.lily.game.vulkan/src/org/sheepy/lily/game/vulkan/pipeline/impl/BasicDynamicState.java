package org.sheepy.lily.game.vulkan.pipeline.impl;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;
import org.sheepy.lily.game.vulkan.pipeline.IDynamicState;

public class BasicDynamicState implements IDynamicState
{

	private VkPipelineDynamicStateCreateInfo dynamicState;
	private IntBuffer dynamicStates;

	@Override
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

	@Override
	public void freeDynamicStateCreateInfo()
	{
		dynamicState.free();
		MemoryUtil.memFree(dynamicStates);
	}

	@Override
	public void free()
	{
	}

}
