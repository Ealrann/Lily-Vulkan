package org.sheepy.vulkan.command.compute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.AbstractCommandBuffers;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.ECommandStage;
import org.sheepy.vulkan.pipeline.compute.ComputeProcess;
import org.sheepy.vulkan.pipeline.compute.ComputeProcessPool;

public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
{
	private ComputeProcessPool computeProcesses;

	private Map<ComputeProcess, ComputeCommandBuffer> mapBuffers = new HashMap<>();

	public ComputeCommandBuffers(CommandPool commandPool, ComputeProcessPool computeProcesses)
	{
		super(commandPool);
		this.computeProcesses = computeProcesses;
	}

	@Override
	protected List<ComputeCommandBuffer> allocCommandBuffers(MemoryStack stack)
	{
		List<ComputeCommandBuffer> res = new ArrayList<>();
		
		long commandPoolId = commandPool.getId();

		// Command Pool Buffers
		// ------------------
		long[] commandBufferIds = allocCommandBuffers(commandPoolId,
				computeProcesses.getProcesses().size());

		for (int i = 0; i < computeProcesses.getProcesses().size(); i++)
		{
			ComputeProcess computeProcess = computeProcesses.getProcesses().get(i);
			long commandBufferId = commandBufferIds[i];

			ComputeCommandBuffer commandBuffer = new ComputeCommandBuffer(
					commandPool.getLogicalDevice(), commandBufferId);

			res.add(commandBuffer);
			mapBuffers.put(computeProcess, commandBuffer);
		}

		return res;
	}

	public void recordCommands()
	{
		for (int i = 0; i < computeProcesses.getProcesses().size(); i++)
		{
			ComputeProcess computeProcess = computeProcesses.getProcesses().get(i);
			ComputeCommandBuffer commandBuffer = mapBuffers.get(computeProcess);
			
			commandBuffer.start();
			computeProcess.recordCommand(commandBuffer, ECommandStage.Compute);
			commandBuffer.end();
		}
	}

	public ComputeCommandBuffer getCommandBuffer(ComputeProcess computerPool)
	{
		return mapBuffers.get(computerPool);
	}
}
