package org.sheepy.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;
import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.process.graphic.DynamicState;

public class DynamicStateBuilder
{
	private VkPipelineDynamicStateCreateInfo vkDynamicState;
	private IntBuffer dynamicStates;

	private boolean allocated = false;

	public VkPipelineDynamicStateCreateInfo allocCreateInfo(DynamicState dynamicState)
	{
		dynamicStates = MemoryUtil.memAllocInt(dynamicState.getStates().size());
		for (EDynamicState state : dynamicState.getStates())
		{
			dynamicStates.put(state.getValue());
			dynamicStates.get();
		}
		dynamicStates.flip();

		vkDynamicState = VkPipelineDynamicStateCreateInfo.malloc();
		vkDynamicState.sType(VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO);
		vkDynamicState.pDynamicStates(dynamicStates);
		vkDynamicState.pNext(VK_NULL_HANDLE);
		vkDynamicState.flags(0);

		allocated = true;

		return vkDynamicState;
	}

	public void freeDynamicStateCreateInfo()
	{
		if (allocated == true)
		{
			vkDynamicState.free();
			MemoryUtil.memFree(dynamicStates);
			allocated = false;
		}
	}
}
