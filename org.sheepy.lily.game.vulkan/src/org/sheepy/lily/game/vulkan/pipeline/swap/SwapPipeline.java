package org.sheepy.lily.game.vulkan.pipeline.swap;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;

import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.UniformBufferObject;
import org.sheepy.lily.game.vulkan.buffer.DepthResource;
import org.sheepy.lily.game.vulkan.buffer.Mesh;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.graphic.GraphicCommandBuffers;
import org.sheepy.lily.game.vulkan.descriptor.BasicDescriptorSetConfiguration;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.GraphicPipeline;
import org.sheepy.lily.game.vulkan.swapchain.ColorDomain;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.texture.Texture;
import org.sheepy.lily.game.vulkan.util.VkSemaphore;
import org.sheepy.lily.game.vulkan.view.ImageViewManager;

public class SwapPipeline
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	private static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	protected LogicalDevice logicalDevice;
	protected CommandPool commandPool;
	private SwapConfiguration configuration;

	protected SwapChainManager swapChainManager;
	protected ImageViewManager imageViewManager;
	protected RenderPass renderPass;
	protected GraphicPipeline pipeline;
	protected Framebuffers framebuffers;
	protected GraphicCommandBuffers commandBuffers;
	protected FrameSubmission frameSubmission;
	protected DescriptorPool descriptorPool;

	private DepthResource depthResource = null;

	private VkSemaphore imageAvailableSemaphore;
	private VkSemaphore renderFinishedSemaphore;

	private UniformBufferObject uniformBufferObject;
	private Texture texture;
	private Mesh mesh = null;

	public SwapPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration,
			CommandPool commandPool, ColorDomain targetColorDomain)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;
		this.configuration = configuration;

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
				BasicDescriptorSetConfiguration<IDescriptor> configuration = new BasicDescriptorSetConfiguration<>();
				if (uniformBufferObject != null) configuration.add(uniformBufferObject);
				if (texture != null) configuration.add(texture);

				descriptorPool = DescriptorPool.alloc(stack, logicalDevice,
						Collections.singletonList(configuration));
			}
		}

		imageViewManager.load(swapChainManager);
		renderPass.load(swapChainManager);
		pipeline.load(swapChainManager, mesh.getShaders(), renderPass, descriptorPool);
		framebuffers.load(swapChainManager, imageViewManager, renderPass);

		commandBuffers = new GraphicCommandBuffers(commandPool, configuration, this,
				mesh.getIndexBuffer());
		commandBuffers.load();
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
		if (full && uniformBufferObject != null) uniformBufferObject.free();
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

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	public GraphicPipeline getGraphicPipeline()
	{
		return pipeline;
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
