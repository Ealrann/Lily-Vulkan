package org.sheepy.vulkan.process.graphic.pool;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.vulkan.model.process.graphic.GraphicProcessPool;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager;
import org.sheepy.vulkan.process.graphic.view.ImageViewManager;
import org.sheepy.vulkan.process.pool.ProcessContext;
import org.sheepy.vulkan.resource.ResourceManager;

public class GraphicContext extends ProcessContext
{
	public final GraphicConfiguration configuration;
	public final GraphicProcessPool graphicProcessPool;
	
	public final SwapChainManager swapChainManager;
	public final ImageViewManager imageViewManager;
	public final Framebuffers framebuffers;
	public final RenderPass renderPass;
	public final FrameSubmission submission;
	public final GraphicCommandBuffers commandBuffers;

	private List<IBasicAllocable> allocationList;

	public GraphicContext(	ExecutionManager executionManager,
							ResourceManager resourceManager,
							GraphicProcessPool graphicProcessPool)
	{
		super(executionManager, resourceManager);

		this.graphicProcessPool = graphicProcessPool;
		this.configuration = graphicProcessPool.getConfiguration();

		swapChainManager = new SwapChainManager(this);
		framebuffers = new Framebuffers(this);
		renderPass = new RenderPass(this);
		imageViewManager = new ImageViewManager(this);
		commandBuffers = new GraphicCommandBuffers(this);

		final var poolAdapter = GraphicProcessPoolAdapter.adapt(graphicProcessPool);
		submission = new FrameSubmission(this, List.of(poolAdapter));

		buildAllocationList();
	}

	public void buildAllocationList()
	{
		var tmpList = new ArrayList<IBasicAllocable>();

		tmpList.add(swapChainManager);
		tmpList.add(imageViewManager);
		tmpList.add(renderPass);
		tmpList.add(framebuffers);
		tmpList.add(commandBuffers);
		tmpList.add(submission);
		
		allocationList = List.copyOf(tmpList);
	}

	public List<IBasicAllocable> getAllocationList()
	{
		return allocationList;
	}
}
