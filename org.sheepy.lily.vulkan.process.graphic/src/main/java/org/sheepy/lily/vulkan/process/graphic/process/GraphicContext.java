package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicExecutionRecorders;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferManager;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewManager;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainManager;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPass;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

public final class GraphicContext extends ProcessContext<GraphicContext> implements IGraphicContext
{
	public final GraphicConfiguration configuration;
	public final GraphicProcess graphicProcess;

	public final PhysicalDeviceSurfaceManager surfaceManager = new PhysicalDeviceSurfaceManager();
	public final SwapChainManager swapChainManager;
	public final ImageViewManager imageViewManager = new ImageViewManager();
	public final FramebufferManager framebuffers = new FramebufferManager();
	public final GraphicExecutionRecorders executionRecorders = new GraphicExecutionRecorders();

	public final RenderPass renderPass;

	public GraphicContext(IVulkanContext vulkanContext,
						  EQueueType queueType,
						  boolean resetAllowed,
						  GraphicProcess graphicProcess)
	{
		super(vulkanContext, queueType, resetAllowed, graphicProcess);
		this.graphicProcess = graphicProcess;
		this.configuration = graphicProcess.getConfiguration();
		this.renderPass = new RenderPass(graphicProcess);
		this.swapChainManager = new SwapChainManager(graphicProcess.getColorAttachment());

		allocationList.add(surfaceManager);
		allocationList.add(swapChainManager);
		allocationList.add(imageViewManager);
		allocationList.add(renderPass);
		allocationList.add(framebuffers);
		allocationList.add(executionRecorders);
	}

	@Override
	public PhysicalDeviceSurfaceManager getSurfaceManager()
	{
		return surfaceManager;
	}

	@Override
	public GraphicConfiguration getConfiguration()
	{
		return configuration;
	}

	@Override
	public SwapChainManager getSwapChainManager()
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
	public List<IExecutionRecorder<? super GraphicContext>> getRecorders()
	{
		return executionRecorders.getRecorders();
	}

	public ImageViewManager getImageViewManager()
	{
		return imageViewManager;
	}

	public RenderPass getRenderPass()
	{
		return renderPass;
	}

	@Override
	public FramebufferManager getFramebufferManager()
	{
		return framebuffers;
	}

	@Override
	public GraphicExecutionRecorders getGraphicExecutionRecorders()
	{
		return executionRecorders;
	}

	@Override
	public int getSwapCount()
	{
		return swapChainManager.getImageCount();
	}
}
