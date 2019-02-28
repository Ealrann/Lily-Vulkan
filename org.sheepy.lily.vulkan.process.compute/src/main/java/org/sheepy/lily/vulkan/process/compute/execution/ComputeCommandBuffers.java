package org.sheepy.lily.vulkan.process.compute.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBuffers;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
{
	private AbstractProcess process;
	private ComputeCommandBuffer commandBuffer;

	@Override
	protected List<ComputeCommandBuffer> allocCommandBuffers(	MemoryStack stack,
																ProcessContext context)
	{
		List<ComputeCommandBuffer> res = new ArrayList<>();

		long commandPoolId = context.commandPool.getId();
		process = context.process;

		// Command Pool Buffers
		// ------------------
		long[] commandBufferIds = allocCommandBuffers(context.getVkDevice(), commandPoolId, 1);

		long commandBufferId = commandBufferIds[0];
		commandBuffer = new ComputeCommandBuffer(context.getLogicalDevice(), commandBufferId);

		res.add(commandBuffer);

		return res;
	}

	public void recordCommands()
	{
		var processAdapter = ComputeProcessAdapter.adapt(process);

		commandBuffer.start();
		processAdapter.recordCommand(commandBuffer, ECommandStage.COMPUTE);
		commandBuffer.end();
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
