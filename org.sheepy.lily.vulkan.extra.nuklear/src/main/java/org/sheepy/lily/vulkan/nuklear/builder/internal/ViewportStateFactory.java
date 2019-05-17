package org.sheepy.lily.vulkan.nuklear.builder.internal;

import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl;

public class ViewportStateFactory
{
	public static final ViewportState create()
	{
		final DynamicViewportState res = new DynamicViewportStateImpl();
		res.setScissorCount(1);
		res.setViewportCount(1);
		return res;
	}
}
