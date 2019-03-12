package org.sheepy.lily.vulkan.process.execution;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.CommandPool;
import org.sheepy.lily.vulkan.common.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public abstract class AbstractCommandBuffers<CB extends ICommandBuffer>
		implements Iterable<CB>, IAllocable
{
	protected List<CB> commandBuffers = Collections.emptyList();

	protected CommandPool commandPool;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		ProcessContext processContext = (ProcessContext) context;
		this.commandPool = processContext.commandPool;

		commandBuffers = List.copyOf(allocCommandBuffers(stack, processContext));

		for (CB commandBuffer : commandBuffers)
		{
			commandBuffer.allocate(stack, context);
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		for (final CB commandBuffer : commandBuffers)
		{
			commandBuffer.free(context);
		}

		commandBuffers = null;
	}

	public List<CB> getCommandBuffers()
	{
		return commandBuffers;
	}

	@Override
	public Iterator<CB> iterator()
	{
		return getCommandBuffers().iterator();
	}

	public int size()
	{
		return getCommandBuffers().size();
	}

	public CB get(int index)
	{
		return getCommandBuffers().get(index);
	}

	protected abstract List<CB> allocCommandBuffers(MemoryStack stack, ProcessContext context);
}
