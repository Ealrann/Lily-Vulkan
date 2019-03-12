package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;
import org.sheepy.lily.vulkan.model.enumeration.EDynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;

public class DynamicStateBuilder
{
	public VkPipelineDynamicStateCreateInfo allocCreateInfo(MemoryStack stack,
															DynamicState dynamicState)
	{
		int size = dynamicState.getStates().size();
		var dynamicStates = stack.mallocInt(size);
		for (EDynamicState state : dynamicState.getStates())
		{
			dynamicStates.put(state.getValue());
		}
		dynamicStates.flip();

		var vkDynamicState = VkPipelineDynamicStateCreateInfo.mallocStack(stack);
		vkDynamicState.sType(VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO);
		vkDynamicState.pDynamicStates(dynamicStates);
		vkDynamicState.pNext(VK_NULL_HANDLE);
		vkDynamicState.flags(0);

		return vkDynamicState;
	}
}
