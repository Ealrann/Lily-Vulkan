package org.sheepy.lily.vulkan.process.compute.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.process.compute.process.ComputeContext;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBuffers;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
{
	@Override
	protected List<ComputeCommandBuffer> allocCommandBuffers(	MemoryStack stack,
																ProcessContext context)
	{
		final List<ComputeCommandBuffer> res = new ArrayList<>();

		res.add(new ComputeCommandBuffer());

		return res;
	}

	public void recordCommands(ComputeContext context)
	{
		var processAdapter = ComputeProcessAdapter.adapt(context.computeProcess);
		var commandBuffer = commandBuffers.get(0);
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
