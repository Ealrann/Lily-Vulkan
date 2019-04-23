package org.sheepy.lily.vulkan.nuklear.pipeline.factory;

import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.impl.DynamicStateImpl;

public class DynamicStateFactory
{

	public static final DynamicState create()
	{
		var dynamicState = new DynamicStateImpl();
		dynamicState.getStates().add(EDynamicState.VIEWPORT);
		dynamicState.getStates().add(EDynamicState.SCISSOR);

		return dynamicState;
	}
}
