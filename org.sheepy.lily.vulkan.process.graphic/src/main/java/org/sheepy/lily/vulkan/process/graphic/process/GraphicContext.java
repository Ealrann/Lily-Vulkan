package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.ProcessSemaphore;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.frame.Framebuffers;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewManager;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainManager;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.lily.vulkan.process.process.WaitData;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;

public class GraphicContext extends ProcessContext
{
	public final GraphicConfiguration configuration;
	public final GraphicProcess graphicProcess;

	public final PhysicalDeviceSurfaceManager surfaceManager;
	public final SwapChainManager swapChainManager;
	public final ImageViewManager imageViewManager;
	public final Framebuffers framebuffers;
	public final RenderPass renderPass;
	public final FrameSubmission submission;
	public final GraphicCommandBuffers commandBuffers;

	private List<IAllocable> allocationList;

	public GraphicContext(	ExecutionContext executionManager,
							DescriptorPool descriptorPool,
							GraphicProcess graphicProcess,
							VkSemaphore imageAcquireSemaphore)
	{
		super(executionManager, descriptorPool, graphicProcess);

		this.graphicProcess = graphicProcess;
		this.configuration = graphicProcess.getConfiguration();

		surfaceManager = new PhysicalDeviceSurfaceManager(this);
		swapChainManager = new SwapChainManager(this);
		framebuffers = new Framebuffers(this);
		renderPass = new RenderPass(this);
		imageViewManager = new ImageViewManager(this);
		commandBuffers = new GraphicCommandBuffers(this);

		submission = createSubmission(graphicProcess, imageAcquireSemaphore);

		buildAllocationList();
	}

	private FrameSubmission createSubmission(	GraphicProcess graphicProcess,
												VkSemaphore imageAcquireSemaphore)
	{
		var processAdapter = GraphicProcessAdapter.adapt(graphicProcess);

		List<WaitData> waitForEmitters = new ArrayList<>();
		waitForEmitters.add(createAcquireSemaphoreData(processAdapter, imageAcquireSemaphore));
		for (ProcessSemaphore waitFor : graphicProcess.getSemaphores())
		{
			waitForEmitters.add(convertToSemaphoreData(waitFor));
		}

		List<VkSemaphore> signals = null;
		var executionSemaphore = processAdapter.getExecutionSemaphore();
		if (executionSemaphore != null)
		{
			signals = List.of(executionSemaphore);
		}
		else
		{
			signals = Collections.emptyList();
		}

		return new FrameSubmission(this, waitForEmitters, signals);
	}

	private WaitData createAcquireSemaphoreData(@SuppressWarnings("unused") GraphicProcessAdapter processAdapter,
												VkSemaphore imageAcquireSemaphore)
	{
		var acquireWaitStage = configuration.getAcquireWaitStage();
		return new WaitData(imageAcquireSemaphore, acquireWaitStage);
	}

	private static WaitData convertToSemaphoreData(ProcessSemaphore waitFor)
	{
		var targetProcessAdapter = AbstractProcessAdapter.adapt(waitFor.getProcess());
		var waitStage = waitFor.getWaitStage();
		return new WaitData(targetProcessAdapter.getExecutionSemaphore(), waitStage);
	}

	public void buildAllocationList()
	{
		var tmpList = new ArrayList<IAllocable>();

		tmpList.add(surfaceManager);
		tmpList.add(swapChainManager);
		tmpList.add(imageViewManager);
		tmpList.add(renderPass);
		tmpList.add(framebuffers);
		tmpList.add(commandBuffers);
		tmpList.add(submission);

		allocationList = List.copyOf(tmpList);
	}

	public List<IAllocable> getAllocationList()
	{
		return allocationList;
	}
}
