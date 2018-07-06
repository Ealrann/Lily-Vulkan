package org.sheepy.lily.game.vulkan.command.compute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.pipeline.compute.ComputeProcess;
import org.sheepy.lily.game.vulkan.pipeline.compute.ComputeProcessPool;

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
	protected List<ComputeCommandBuffer> allocCommandBuffers()
	{
		List<ComputeCommandBuffer> res = new ArrayList<>();
		long commandPoolId = commandPool.getId();

		long[] commandBufferIds = allocCommandBuffers(commandPoolId,
				computeProcesses.getProcesses().size());

		for (int i = 0; i < computeProcesses.getProcesses().size(); i++)
		{
			ComputeProcess computeProcess = computeProcesses.getProcesses().get(i);
			long commandBufferId = commandBufferIds[i];

			ComputeCommandBuffer commandBuffer = new ComputeCommandBuffer(
					commandPool.getLogicalDevice(), commandBufferId);

			commandBuffer.start();

			computeProcess.recordCommand(commandBuffer);

			commandBuffer.end();

			res.add(commandBuffer);
			mapBuffers.put(computeProcess, commandBuffer);
		}

		return res;
	}

	public ComputeCommandBuffer getCommandBuffer(ComputeProcess computerPool)
	{
		return mapBuffers.get(computerPool);
	}
}
