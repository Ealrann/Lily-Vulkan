package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.List;

import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.graphic.IFramebufferManager;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicExecutionRecorders;
import org.sheepy.lily.vulkan.api.graphic.IImageViewManager;
import org.sheepy.lily.vulkan.api.graphic.IRenderPass;
import org.sheepy.lily.vulkan.api.graphic.ISurfaceManager;
import org.sheepy.lily.vulkan.api.graphic.ISwapChainManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicExecutionRecorders;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferManager;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewManager;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.queue.EQueueType;

final class GraphicContext extends ProcessContext<IGraphicContext> implements IGraphicContext
{
	public final GraphicConfiguration configuration;
	public final GraphicProcess graphicProcess;

	public final PhysicalDeviceSurfaceManager surfaceManager = new PhysicalDeviceSurfaceManager();
	public final SwapChainManager swapChainManager = new SwapChainManager();
	public final ImageViewManager imageViewManager = new ImageViewManager();
	public final FramebufferManager framebuffers = new FramebufferManager();
	public final GraphicExecutionRecorders executionRecorders = new GraphicExecutionRecorders();

	public final RenderPass renderPass = new RenderPass();

	public GraphicContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							GraphicProcess graphicProcess)
	{
		super(queueType, resetAllowed, descriptorPool, graphicProcess);

		this.graphicProcess = graphicProcess;
		this.configuration = graphicProcess.getConfiguration();

		allocationList.add(surfaceManager);
		allocationList.add(swapChainManager);
		allocationList.add(imageViewManager);
		allocationList.add(renderPass);
		allocationList.add(framebuffers);
		allocationList.add(executionRecorders);
	}

	@Override
	public ISurfaceManager getSurfaceManager()
	{
		return surfaceManager;
	}

	@Override
	public GraphicConfiguration getConfiguration()
	{
		return configuration;
	}

	@Override
	public ISwapChainManager getSwapChainManager()
	{
		return swapChainManager;
	}

	@Override
	public GraphicProcess getGraphicProcess()
	{
		return graphicProcess;
	}

	@Override
	public GraphicExecutionRecorders getExecutionRecorders()
	{
		return executionRecorders;
	}

	@Override
	public List<IExecutionRecorder<? super IGraphicContext>> getRecorders()
	{
		return executionRecorders.getRecorders();
	}

	@Override
	public IImageViewManager getImageViewManager()
	{
		return imageViewManager;
	}

	@Override
	public IRenderPass getRenderPass()
	{
		return renderPass;
	}

	@Override
	public IFramebufferManager getFramebufferManager()
	{
		return framebuffers;
	}

	@Override
	public IGraphicExecutionRecorders getGraphicExecutionRecorders()
	{
		return executionRecorders;
	}

	@Override
	public int getSwapCount()
	{
		return swapChainManager.getImageCount();
	}
}
