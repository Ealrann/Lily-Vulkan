package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IGraphicContext extends IExecutionContext
{
	GraphicConfiguration getConfiguration();

	GraphicProcess getGraphicProcess();

	ISurfaceManager getSurfaceManager();

	ISwapChainManager getSwapChainManager();

	IImageViewManager getImageViewManager();

	IFramebufferManager getFramebufferManager();

	IRenderPass getRenderPass();

	IGraphicExecutionRecorders getGraphicExecutionRecorders();
}
