package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;
import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;

public class DynamicStateBuilder
{
	public VkPipelineDynamicStateCreateInfo allocCreateInfo(MemoryStack stack,
															DynamicState dynamicState)
	{
		final int size = dynamicState.getStates().size();
		final var dynamicStates = stack.mallocInt(size);
		for (final EDynamicState state : dynamicState.getStates())
		{
			dynamicStates.put(state.getValue());
		}
		dynamicStates.flip();

		final var vkDynamicState = VkPipelineDynamicStateCreateInfo.malloc(stack);
		vkDynamicState.sType(VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO);
		vkDynamicState.pDynamicStates(dynamicStates);
		vkDynamicState.pNext(VK_NULL_HANDLE);
		vkDynamicState.flags(0);

		return vkDynamicState;
	}
}
