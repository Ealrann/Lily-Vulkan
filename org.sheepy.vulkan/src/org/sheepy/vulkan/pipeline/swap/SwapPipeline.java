package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.util.ArrayList;
import java.util.Collection;
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

public class SwapPipeline extends AllocationNode implements ISignalEmitter, IAllocable
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	protected LogicalDevice logicalDevice;
	protected CommandPool commandPool;
	protected SwapConfiguration configuration;

	protected List<ISignalEmitter> waitForSignals = new ArrayList<>();

	protected List<IAllocationObject> subAllocates = new ArrayList<>();

	/**
	 * @param logicalDevice
	 * @param configuration
	 * @param commandPool
	 * @param colorDomain
	 * @param bindType
	 *            VK_PIPELINE_BIND_POINT_COMPUTE or
	 *            VK_PIPELINE_BIND_POINT_GRAPHICS
	 */
	public SwapPipeline(SwapConfiguration configuration, Collection<ISignalEmitter> waitForSignals)
	{
		this.logicalDevice = configuration.logicalDevice;
		this.commandPool = configuration.commandPool;
		this.configuration = configuration;

		this.waitForSignals.add(this);
		if (waitForSignals != null) this.waitForSignals.addAll(waitForSignals);

		configuration.swapChainManager = buildSwapChainManager();

		if (configuration.depthBuffer == true)
		{
			configuration.depthResource = new DepthResource(logicalDevice, commandPool);
		}

		configuration.imageViewManager = new ImageViewManager(logicalDevice,
				configuration.swapChainManager);

		configuration.framebuffers = new Framebuffers(logicalDevice, configuration.swapChainManager,
				configuration.imageViewManager, configuration.renderPass,
				configuration.depthResource);

		configuration.commandBuffers = buildCommandBuffers();

		configuration.frameSubmission = new FrameSubmission(configuration, this.waitForSignals);

		subAllocates.add(configuration.swapChainManager);
		if (configuration.depthResource != null) subAllocates.add(configuration.depthResource);
		subAllocates.add(configuration.imageViewManager);
		subAllocates.add(configuration.renderPass);
		subAllocates.add(configuration.framebuffers);
		subAllocates.add(configuration.commandBuffers);
		subAllocates.add(configuration.frameSubmission);
	}

	private SwapChainManager buildSwapChainManager()
	{
		return new SwapChainManager(logicalDevice, configuration);
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return configuration.imageAvailableSemaphore;
	}

	public void configure(Surface surface)
	{
		configuration.swapChainManager.configure(surface);
		if (configuration.depthResource != null)
		{
			configuration.depthResource.configure(surface.width, surface.height);
		}
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		configuration.renderPass.buildRenderPass(configuration.commandBuffers.getCommandBuffers());
	}

	private GraphicCommandBuffers buildCommandBuffers()
	{
		return new GraphicCommandBuffers(commandPool, configuration);
	}

	@Override
	public void free()
	{
	}

	public SwapChainManager getSwapChain()
	{
		return configuration.swapChainManager;
	}

	public ImageViewManager getImageView()
	{
		return configuration.imageViewManager;
	}

	public DepthResource getDepthResource()
	{
		return configuration.depthResource;
	}

	public Framebuffers getFramebuffers()
	{
		return configuration.framebuffers;
	}

	public FrameSubmission getFrameSubmission()
	{
		return configuration.frameSubmission;
	}

	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	private int[] nextImageArray = new int[1];

	public Integer acquireNextImage()
	{
		int res = vkAcquireNextImageKHR(logicalDevice.getVkDevice(),
				configuration.swapChainManager.getSwapChain(), UINT64_MAX,
				configuration.imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	@Override
	protected Collection<? extends IAllocationObject> getSubAllocables()
	{
		return subAllocates;
	}
}
