package org.sheepy.lily.game.vulkan.swappipeline;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.command.CommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.framebuffer.Framebuffers;
import org.sheepy.lily.game.vulkan.framesubmission.FrameSubmission;
import org.sheepy.lily.game.vulkan.imageview.ImageViewManager;
import org.sheepy.lily.game.vulkan.pipeline.GraphicPipeline;
import org.sheepy.lily.game.vulkan.pipeline.RenderPass;
import org.sheepy.lily.game.vulkan.swapchain.ColorDomain;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.util.VkSemaphore;
import org.sheepy.lily.game.vulkan.vertex.Mesh;
import org.sheepy.lily.game.vulkan.vertex.UniformBufferObject;

public class SwapPipeline
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	private static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private LogicalDevice logicalDevice;

	private SwapChainManager swapChainManager;
	private ImageViewManager imageView;
	private RenderPass renderPass;
	private GraphicPipeline pipeline;
	private Framebuffers framebuffers;
	private CommandBuffers commandBuffers;
	private FrameSubmission frameSubmission;

	private VkSemaphore imageAvailableSemaphore;
	private VkSemaphore renderFinishedSemaphore;

	private DescriptorPool descriptorPool;

	private UniformBufferObject uniformBufferObject;

	private Mesh mesh = null;

	public SwapPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration,
			CommandPool commandPool, ColorDomain targetColorDomain)
	{
		this.logicalDevice = logicalDevice;
		swapChainManager = new SwapChainManager(logicalDevice, targetColorDomain);

		imageView = new ImageViewManager(logicalDevice);
		renderPass = new RenderPass(logicalDevice);
		pipeline = new GraphicPipeline(logicalDevice, configuration);
		framebuffers = new Framebuffers(logicalDevice);

		renderFinishedSemaphore = new VkSemaphore(logicalDevice);
		imageAvailableSemaphore = new VkSemaphore(logicalDevice);

		commandBuffers = new CommandBuffers(commandPool);
		frameSubmission = new FrameSubmission();
	}

	public void attachMesh(Mesh mesh)
	{
		this.mesh = mesh;
	}

	public void load(long surface, int width, int height)
	{
		swapChainManager.load(surface, width, height);

		if (uniformBufferObject != null)
		{
			try (MemoryStack stack = stackPush())
			{
				descriptorPool = DescriptorPool.alloc(stack, logicalDevice, 1);
			}

			uniformBufferObject.load(descriptorPool.get(0));
		}

		imageView.load(swapChainManager);
		renderPass.load(swapChainManager);
		pipeline.load(swapChainManager, mesh.getShaders(), renderPass, descriptorPool);
		framebuffers.load(swapChainManager, imageView, renderPass);

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

		if (descriptorPool != null)
		{
			descriptorPool.destroy();
		}

		if (uniformBufferObject != null)
			uniformBufferObject.free();

		if (full && mesh != null)
			mesh.destroy();

		frameSubmission.free();
		commandBuffers.free();
		framebuffers.free();
		pipeline.free();
		renderPass.free();
		imageView.free();
		swapChainManager.free();

	}

	public SwapChainManager getSwapChain()
	{
		return swapChainManager;
	}

	public ImageViewManager getImageView()
	{
		return imageView;
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
}
