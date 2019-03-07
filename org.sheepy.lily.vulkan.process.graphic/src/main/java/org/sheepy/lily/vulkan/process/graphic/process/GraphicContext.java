package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.concurrent.VkFence;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.extension.HardwareVerticalSynchronization;
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
	public final Framebuffers framebuffers = new Framebuffers();
	public final RenderPass renderPass = new RenderPass();

	public final FrameSubmission frameSubmission;
	public VkFence presentFence;
	public boolean hardwareVSync = false;

	public VkSemaphore imageAvailableSemaphore;

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
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		if (configuration.isVSyncEnabled())
		{
			HardwareVerticalSynchronization vsync = new HardwareVerticalSynchronization();
			if (vsync.isApplicable(this))
			{
				presentFence = new VkFence(true);
				allocationList.add(presentFence);
				vsync.apply(stack, this);
			}
			else
			{
				presentFence = null;
				hardwareVSync = false;
			}
		}
	}

	@Override
	protected ProcessSubmission createSubmission(AbstractProcess process)
	{
		imageAvailableSemaphore = new VkSemaphore();
		List<WaitData> waitForEmitters = gatherWaitDatas();
		List<VkSemaphore> signals = gatherSinalSemaphores();
		return new FrameSubmission(this, waitForEmitters, signals);
	}

	@Override
	protected List<WaitData> gatherWaitDatas()
	{
		var res = super.gatherWaitDatas();
		imageAvailableSemaphore = new VkSemaphore();
		res.add(0, createAcquireSemaphoreData());
		return res;
	}

	private WaitData createAcquireSemaphoreData()
	{
		var graphicProcess = (GraphicProcess) process;
		var acquireWaitStage = graphicProcess.getConfiguration().getAcquireWaitStage();
		return new WaitData(imageAvailableSemaphore, acquireWaitStage);
	}
}
