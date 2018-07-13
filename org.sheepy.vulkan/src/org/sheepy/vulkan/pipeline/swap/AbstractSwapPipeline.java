package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.buffer.DepthResource;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.graphic.GraphicCommandBuffers;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.swapchain.SwapChainManager;
import org.sheepy.vulkan.view.ImageViewManager;
import org.sheepy.vulkan.window.Surface;

public abstract class AbstractSwapPipeline extends AllocationNode
		implements ISignalEmitter, IAllocable
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	protected LogicalDevice logicalDevice;
	protected CommandPool commandPool;
	protected SwapConfiguration configuration;

	protected SwapChainManager swapChainManager;
	protected ImageViewManager imageViewManager;
	protected IRenderPass renderPass;
	protected Framebuffers framebuffers;
	protected GraphicCommandBuffers commandBuffers;
	protected FrameSubmission frameSubmission;
	protected IGraphicsPipeline graphicsPipeline;

	protected DepthResource depthResource = null;

	protected List<ISignalEmitter> waitForSignals = new ArrayList<>();
	protected VkSemaphore imageAvailableSemaphore;

	/**
	 * @param logicalDevice
	 * @param configuration
	 * @param commandPool
	 * @param colorDomain
	 * @param bindType
	 *            VK_PIPELINE_BIND_POINT_COMPUTE or
	 *            VK_PIPELINE_BIND_POINT_GRAPHICS
	 */
	public AbstractSwapPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration,
			CommandPool commandPool, Collection<ISignalEmitter> waitForSignals)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;
		this.configuration = configuration;

		this.waitForSignals.add(this);
		if (waitForSignals != null) this.waitForSignals.addAll(waitForSignals);

		swapChainManager = buildSwapChainManager();

		if (configuration.depthBuffer == true)
		{
			depthResource = new DepthResource(logicalDevice, commandPool);
		}

		imageViewManager = new ImageViewManager(logicalDevice);
		framebuffers = new Framebuffers(logicalDevice, depthResource);

		imageAvailableSemaphore = new VkSemaphore(logicalDevice);

		commandBuffers = buildCommandBuffers();
		frameSubmission = buildFrameSubmission();
	}

	private SwapChainManager buildSwapChainManager()
	{
		return new SwapChainManager(logicalDevice, configuration);
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return imageAvailableSemaphore;
	}

	protected FrameSubmission buildFrameSubmission()
	{
		return new FrameSubmission(logicalDevice, commandBuffers, swapChainManager, waitForSignals,
				VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT);
	}

	public void configure(Surface surface)
	{
		swapChainManager.configure(surface);
		if (depthResource != null)
		{
			depthResource.configure(surface.width, surface.height);
		}
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		graphicsPipeline = buildGraphicsPipeline();
		renderPass = buildRenderPass();

		swapChainManager.allocate(stack);

		if (depthResource != null)
		{
			depthResource.allocate(stack);
		}

		imageViewManager.load(swapChainManager);
		renderPass.load(swapChainManager);
		framebuffers.load(swapChainManager, imageViewManager, renderPass);

		commandBuffers.allocate(stack);
		frameSubmission.allocate(stack);

		if (graphicsPipeline != null) graphicsPipeline.load(swapChainManager, renderPass);

		renderPass.buildRenderPass(commandBuffers.getCommandBuffers());
	}

	private GraphicCommandBuffers buildCommandBuffers()
	{
		return new GraphicCommandBuffers(commandPool, configuration, this);
	}

	@Override
	public void free()
	{
		free(true);
	}

	public void free(boolean full)
	{
		if (full)
		{
			imageAvailableSemaphore.free();
		}

		if (depthResource != null) depthResource.free();
		if (graphicsPipeline != null) graphicsPipeline.free();
		frameSubmission.free();
		commandBuffers.free();
		framebuffers.free();
		renderPass.free();
		imageViewManager.free();
		swapChainManager.free();
	}

	public SwapChainManager getSwapChain()
	{
		return swapChainManager;
	}

	public ImageViewManager getImageView()
	{
		return imageViewManager;
	}

	public IRenderPass getRenderPass()
	{
		return renderPass;
	}

	public Framebuffers getFramebuffers()
	{
		return framebuffers;
	}

	public FrameSubmission getFrameSubmission()
	{
		return frameSubmission;
	}

	public IGraphicsPipeline getGraphicPipeline()
	{
		return graphicsPipeline;
	}

	private int[] nextImageArray = new int[1];

	public Integer acquireNextImage()
	{
		int res = vkAcquireNextImageKHR(logicalDevice.getVkDevice(),
				swapChainManager.getSwapChain(), UINT64_MAX, imageAvailableSemaphore.getId(),
				VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	@Override
	protected Collection<? extends IAllocationObject> getSubAllocables()
	{
		// TODO
		return Collections.emptyList();
	}

	protected abstract IGraphicsPipeline buildGraphicsPipeline();

	protected abstract IRenderPass buildRenderPass();
}
