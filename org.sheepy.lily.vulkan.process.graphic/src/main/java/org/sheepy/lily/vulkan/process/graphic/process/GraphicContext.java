package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.List;

import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.frame.Framebuffers;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewManager;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainManager;
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
	public final Framebuffers framebuffers;
	public final RenderPass renderPass = new RenderPass();

	public final FrameSubmission frameSubmission;

	public PresentSemaphore imageAvailableSemaphore;

	public GraphicContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							GraphicProcess graphicProcess)
	{
		super(queueType, resetAllowed, descriptorPool, new GraphicCommandBuffers(), graphicProcess);

		this.graphicProcess = graphicProcess;
		this.configuration = graphicProcess.getConfiguration();
		frameSubmission = (FrameSubmission) submission;

		framebuffers = new Framebuffers(configuration.getFramebufferConfiguration());

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
		List<WaitData> waitForEmitters = gatherWaitDatas();
		List<VkSemaphore> signals = gatherSinalSemaphores();
		return new FrameSubmission(this, waitForEmitters, signals);
	}

	@Override
	protected List<WaitData> gatherWaitDatas()
	{
		var res = super.gatherWaitDatas();
		imageAvailableSemaphore = new PresentSemaphore();
		res.add(0, createAcquireSemaphoreData());
		return res;
	}

	private WaitData createAcquireSemaphoreData()
	{
		var graphicProcess = (GraphicProcess) process;
		var acquireWaitStage = graphicProcess.getConfiguration().getAcquireWaitStage();
		return new WaitData(imageAvailableSemaphore.presentSemaphore, acquireWaitStage);
	}
}
