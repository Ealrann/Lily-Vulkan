package org.sheepy.lily.vulkan.process.graphic.api;

import org.sheepy.lily.vulkan.api.execution.IExecutionContext;

public interface IGraphicContext extends IExecutionContext
{
	ISurfaceManager getSurfaceManager();
}
