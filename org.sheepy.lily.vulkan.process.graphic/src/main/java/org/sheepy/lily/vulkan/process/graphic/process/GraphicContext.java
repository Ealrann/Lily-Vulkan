package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
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
import org.sheepy.lily.vulkan.process.process.ProcessSubmission;
import org.sheepy.lily.vulkan.process.process.WaitData;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;

public class GraphicContext extends ProcessContext
{
	public final GraphicConfiguration configuration;
	public final GraphicProcess graphicProcess;

	public final PhysicalDeviceSurfaceManager surfaceManager = new PhysicalDeviceSurfaceManager();
	public final SwapChainManager swapChainManager = new SwapChainManager();
	public final ImageViewManager imageViewManager = new ImageViewManager();
	public final Framebuffers framebuffers = new Framebuffers();
	public final RenderPass renderPass = new RenderPass();
	public VkSemaphore imageAvailableSemaphore;

	public final FrameSubmission frameSubmission;

	public GraphicContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							GraphicProcess graphicProcess)
	{
		super(queueType, resetAllowed, descriptorPool, new GraphicCommandBuffers(), graphicProcess);

		this.graphicProcess = graphicProcess;
		this.configuration = graphicProcess.getConfiguration();
		frameSubmission = (FrameSubmission) submission;

		allocationList.add(imageAvailableSemaphore);
		allocationList.add(surfaceManager);
		allocationList.add(swapChainManager);
		allocationList.add(imageViewManager);
		allocationList.add(renderPass);
		allocationList.add(framebuffers);
		allocationList.add(commandBuffers);
		allocationList.add(submission);
	}

	@Override
	protected ProcessSubmission createSubmission(AbstractProcess process)
	{
		var graphicProcess = (GraphicProcess) process;
		var processAdapter = GraphicProcessAdapter.adapt(graphicProcess);
		imageAvailableSemaphore = new VkSemaphore();

		List<WaitData> waitForEmitters = new ArrayList<>();
		waitForEmitters.add(createAcquireSemaphoreData(graphicProcess.getConfiguration(),
				imageAvailableSemaphore));
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

	private static WaitData createAcquireSemaphoreData(	GraphicConfiguration configuration,
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
}
