package org.sheepy.lily.vulkan.process.compute.process;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffers;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@Statefull
@Adapter(scope = ComputeProcess.class)
public class ComputeProcessAdapter extends AbstractProcessAdapter
{
	private static final String FAILED_SUBMIT_COMPUTE = "Failed to submit compute command buffer";

	public ComputeProcessAdapter(ComputeProcess process)
	{
		super(process);
	}

	@Override
	protected ProcessContext createContext()
	{
		return new ComputeContext(getQueueType(), isResetAllowed(), descriptorPool,
				(ComputeProcess) process);
	}

	@Override
	public void recordCommands()
	{
		((ComputeCommandBuffers) context.commandBuffers).recordCommands((ComputeContext) context);
	}

	@Override
	public void recordCommand(VkCommandBuffer commandBuffer, ECommandStage stage, int index)
	{
		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter.shouldRecord(stage))
			{
				pipelineAdapter.record(commandBuffer, VK_PIPELINE_BIND_POINT_COMPUTE, index);
			}
			pipelineAdapter.setRecordNeeded(false);
		}
	}

	@Override
	public void execute()
	{
		execute(null);
	}

	@Override
	public void execute(IFence fence)
	{
		prepare();

		final var computeContext = (ComputeContext) context;
		final var queue = context.getQueue().vkQueue;
		final var submission = computeContext.submission;
		final var submitInfo = submission.getSubmitInfo(0);
		final long fenceId = fence != null ? fence.getId() : VK_NULL_HANDLE;

		Logger.check(vkQueueSubmit(queue, submitInfo, fenceId), FAILED_SUBMIT_COMPUTE);
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.getQueue();
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Compute;
	}

	public static ComputeProcessAdapter adapt(ComputeProcess object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputeProcessAdapter.class);
	}
}
