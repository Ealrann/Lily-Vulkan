package org.sheepy.vulkan.process.compute.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.process.compute.pool.ComputeContext;
import org.sheepy.vulkan.process.compute.process.ComputeProcessAdapter;
import org.sheepy.vulkan.process.execution.AbstractCommandBuffers;

public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
{
	@Deprecated
	private final Map<ComputeProcess, ComputeCommandBuffer> mapBuffers = new HashMap<>();

	private final ComputeContext context;

	public ComputeCommandBuffers(ComputeContext context)
	{
		super(context.getVkDevice(), context.executionManager.commandPool);
		this.context = context;
	}

	@Override
	protected List<ComputeCommandBuffer> allocCommandBuffers(MemoryStack stack)
	{
		List<ComputeCommandBuffer> res = new ArrayList<>();

		long commandPoolId = context.executionManager.commandPool.getId();
		var processPool = context.computeProcessPool;
		var processes = processPool.getProcesses();

		// Command Pool Buffers
		// ------------------
		long[] commandBufferIds = allocCommandBuffers(commandPoolId, processes.size());

		for (int i = 0; i < processes.size(); i++)
		{
			ComputeProcess computeProcess = processes.get(i);
			long commandBufferId = commandBufferIds[i];
			var commandBuffer = new ComputeCommandBuffer(context.logicalDevice, commandBufferId);

			res.add(commandBuffer);
			mapBuffers.put(computeProcess, commandBuffer);
		}

		return res;
	}

	public void recordCommands()
	{
		var processPool = context.computeProcessPool;
		var processes = processPool.getProcesses();
		
		for (int i = 0; i < processes.size(); i++)
		{
			var process = processes.get(i);
			var commandBuffer = mapBuffers.get(process);
			var processAdapter = ComputeProcessAdapter.adapt(process);

			commandBuffer.start();
			processAdapter.recordCommand(commandBuffer, ECommandStage.COMPUTE);
			commandBuffer.end();
		}
	}

	@Deprecated
	public ComputeCommandBuffer getCommandBuffer(ComputeProcess computerPool)
	{
		return mapBuffers.get(computerPool);
	}
	
	@Override
	public boolean isDirty()
	{
		return false;
	}
}
