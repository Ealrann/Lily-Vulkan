package org.sheepy.vulkan.pipeline.graphic;

import java.util.Collections;

import org.sheepy.vulkan.buffer.DepthResource;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.graphic.GraphicCommandBuffers;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.pipeline.Context;
import org.sheepy.vulkan.resource.ResourceManager;
import org.sheepy.vulkan.swapchain.SwapChainManager;
import org.sheepy.vulkan.view.ImageViewManager;

public class GraphicContext extends Context
{
	public final SwapChainManager swapChainManager;
	public final Framebuffers framebuffers;
	public final IRenderPass renderPass;
	public final ImageViewManager imageViewManager;
	public final FrameSubmission submission;
	public final GraphicCommandBuffers commandBuffers;

	public final DepthResource depthResource;
	
	public GraphicConfiguration configuration;

	public GraphicContext(CommandPool commandPool, ResourceManager resourceManager, DescriptorPool descriptorPool,
			GraphicConfiguration configuration, GraphicProcessPool processPool)
	{
		super(configuration, commandPool, resourceManager, descriptorPool);
		this.renderPass = configuration.renderPass;
		this.configuration = configuration;

		swapChainManager = new SwapChainManager(logicalDevice, configuration.targetColorDomain,
				configuration.swapImageUsages, configuration.presentationMode);

		imageViewManager = new ImageViewManager(logicalDevice, swapChainManager);

		if (configuration.depthBuffer == true)
		{
			depthResource = new DepthResource(logicalDevice, commandPool);
		}
		else
		{
			depthResource = null;
		}

		framebuffers = new Framebuffers(logicalDevice, swapChainManager, imageViewManager,
				configuration.renderPass, depthResource);

		commandBuffers = new GraphicCommandBuffers(configuration, commandPool, processPool);

		submission = new FrameSubmission(this, Collections.singletonList(processPool));
		

		renderPass.bindContext(this);

		allocationObjects.add(swapChainManager);
		allocationObjects.add(imageViewManager);
		if (depthResource != null) allocationObjects.add(depthResource);
		allocationObjects.add(renderPass);
		allocationObjects.add(framebuffers);
		allocationObjects.add(commandBuffers);
		allocationObjects.add(submission);
	}
}
