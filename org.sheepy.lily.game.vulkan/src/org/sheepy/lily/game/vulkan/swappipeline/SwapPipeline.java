package org.sheepy.lily.game.vulkan.swappipeline;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.buffer.DepthResource;
import org.sheepy.lily.game.vulkan.buffer.Mesh;
import org.sheepy.lily.game.vulkan.buffer.Texture;
import org.sheepy.lily.game.vulkan.buffer.UniformBufferObject;
import org.sheepy.lily.game.vulkan.command.CommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.framebuffer.Framebuffers;
import org.sheepy.lily.game.vulkan.framesubmission.FrameSubmission;
import org.sheepy.lily.game.vulkan.pipeline.GraphicPipeline;
import org.sheepy.lily.game.vulkan.pipeline.RenderPass;
import org.sheepy.lily.game.vulkan.swapchain.ColorDomain;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.util.VkSemaphore;
import org.sheepy.lily.game.vulkan.view.ImageViewManager;

public class SwapPipeline
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	private static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private LogicalDevice logicalDevice;

	private SwapChainManager swapChainManager;
	private ImageViewManager imageViewManager;
	private RenderPass renderPass;
	private GraphicPipeline pipeline;
	private Framebuffers framebuffers;
	private CommandBuffers commandBuffers;
	private FrameSubmission frameSubmission;

	private DepthResource depthResource = null;

	private VkSemaphore imageAvailableSemaphore;
	private VkSemaphore renderFinishedSemaphore;

	private DescriptorPool descriptorPool;

	private UniformBufferObject uniformBufferObject;
	private Texture texture;

	private Mesh mesh = null;

	public SwapPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration,
			CommandPool commandPool, ColorDomain targetColorDomain)
	{
		this.logicalDevice = logicalDevice;

		swapChainManager = new SwapChainManager(logicalDevice, targetColorDomain);

		if (configuration.depthBuffer == true)
		{
			depthResource = new DepthResource(logicalDevice);
		}

		imageViewManager = new ImageViewManager(logicalDevice);
		renderPass = new RenderPass(logicalDevice, depthResource);
		pipeline = new GraphicPipeline(logicalDevice, configuration);
		framebuffers = new Framebuffers(logicalDevice, depthResource);

		renderFinishedSemaphore = new VkSemaphore(logicalDevice);
		imageAvailableSemaphore = new VkSemaphore(logicalDevice);

		commandBuffers = new CommandBuffers(commandPool, configuration);
		frameSubmission = new FrameSubmission();

		logicalDevice.attachSwapPipeline(this);
	}

	public void attachMesh(Mesh mesh)
	{
		this.mesh = mesh;
	}

	public void load(long surface, int width, int height)
	{
		swapChainManager.load(surface, width, height);

		if (depthResource != null)
		{
			depthResource.load(width, height);
		}

		if (uniformBufferObject != null || texture != null)
		{
			try (MemoryStack stack = stackPush())
			{
				descriptorPool = DescriptorPool.alloc(stack, logicalDevice, uniformBufferObject,
						texture);
			}
		}

		imageViewManager.load(swapChainManager);
		renderPass.load(swapChainManager);
		pipeline.load(swapChainManager, mesh.getShaders(), renderPass, descriptorPool);
		framebuffers.load(swapChainManager, imageViewManager, renderPass);

		commandBuffers.load(swapChainManager, framebuffers, renderPass, pipeline,
				mesh.getIndexBuffer(), descriptorPool);
		frameSubmission.load(commandBuffers.size(), swapChainManager, commandBuffers,
				imageAvailableSemaphore, renderFinishedSemaphore);
	}

	public void destroy(boolean full)
	{
		if (full)
		{
			imageAvailableSemaphore.free();
			renderFinishedSemaphore.free();
		}

		if (descriptorPool != null) descriptorPool.destroy();
		if (uniformBufferObject != null) uniformBufferObject.free();
		if (full && texture != null) texture.free();
		if (full && mesh != null) mesh.free();
		if (depthResource != null) depthResource.free();
		frameSubmission.free();
		commandBuffers.free();
		framebuffers.free();
		pipeline.free();
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

	public RenderPass getRenderPass()
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

	private int[] nextImageArray = new int[1];

	public int acquireNextImage()
	{
		vkAcquireNextImageKHR(logicalDevice.getVkDevice(), swapChainManager.getSwapChain(),
				UINT64_MAX, imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		return nextImageArray[0];
	}

	public void attachUniformBuffer(UniformBufferObject ubo)
	{
		this.uniformBufferObject = ubo;
	}

	public void attachTexture(Texture texture)
	{
		this.texture = texture;
	}
}
