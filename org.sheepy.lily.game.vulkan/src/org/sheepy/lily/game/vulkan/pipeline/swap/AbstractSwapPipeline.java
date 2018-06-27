package org.sheepy.lily.game.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sheepy.lily.game.vulkan.buffer.DepthResource;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.graphic.GraphicCommandBuffers;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.view.ImageViewManager;

public abstract class AbstractSwapPipeline implements ISignalEmitter
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
			depthResource = new DepthResource(logicalDevice);
		}

		imageViewManager = new ImageViewManager(logicalDevice);
		framebuffers = new Framebuffers(logicalDevice, depthResource);

		imageAvailableSemaphore = new VkSemaphore(logicalDevice);

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
		return new FrameSubmission(logicalDevice, swapChainManager,
				VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT);
	}

	public void load(long surface, int width, int height)
	{
		frameSubmission.newSignalSemaphore();

		graphicsPipeline = buildGraphicsPipeline();
		renderPass = buildRenderPass();

		swapChainManager.load(surface, width, height);

		if (depthResource != null)
		{
			depthResource.load(commandPool, width, height);
		}

		imageViewManager.load(swapChainManager);
		renderPass.load(swapChainManager);
		framebuffers.load(swapChainManager, imageViewManager, renderPass);

		commandBuffers = buildCommandBuffers();
		commandBuffers.load();
		frameSubmission.load(commandBuffers, waitForSignals);

		if (graphicsPipeline != null) graphicsPipeline.load(swapChainManager, renderPass);

		renderPass.buildRenderPass(commandBuffers.getCommandBuffers());
	}

	private GraphicCommandBuffers buildCommandBuffers()
	{
		return new GraphicCommandBuffers(commandPool, configuration, this);
	}

	public void destroy(boolean full)
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

	public int acquireNextImage()
	{
		vkAcquireNextImageKHR(logicalDevice.getVkDevice(), swapChainManager.getSwapChain(),
				UINT64_MAX, imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		return nextImageArray[0];
	}

	protected abstract IGraphicsPipeline buildGraphicsPipeline();

	protected abstract IRenderPass buildRenderPass();
}
