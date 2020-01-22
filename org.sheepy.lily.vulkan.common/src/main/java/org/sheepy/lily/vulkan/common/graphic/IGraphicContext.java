package org.sheepy.lily.vulkan.common.graphic;

import org.sheepy.lily.vulkan.common.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

public interface IGraphicContext extends IProcessContext.IRecorderContext<IGraphicContext>
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
