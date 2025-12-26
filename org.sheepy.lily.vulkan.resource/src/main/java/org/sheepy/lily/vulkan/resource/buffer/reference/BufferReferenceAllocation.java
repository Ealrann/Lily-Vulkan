package org.sheepy.lily.vulkan.resource.buffer.reference;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.core.resource.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.core.resource.buffer.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

import java.util.List;

@ModelExtender(scope = BufferReference.class)
@Allocation
@AllocationDependency(features = BufferReference.FeatureIDs.BUFFERS, type = IVulkanBufferAllocation.class)
public final class BufferReferenceAllocation implements IBufferReferenceAllocation
{
	private final BufferReference bufferReference;
	private final List<IVulkanBufferAllocation> bufferAllocations;
	private final int indexCount;

	private BufferReferenceAllocation(BufferReference bufferReference,
									 @InjectDependency(index = 0) List<IVulkanBufferAllocation> bufferAllocations)
	{
		final var process = ModelUtil.findParent(bufferReference, AbstractProcess.class);
		final var executionManager = process.adapt(InternalProcessAdapter.class);
		indexCount = executionManager.getExecutionCount();

		this.bufferReference = bufferReference;
		this.bufferAllocations = bufferAllocations;
	}

	@Override
	public int getBufferCountPerInstance()
	{
		final var stride = bufferReference.stride();
		return stride == 0 ? bufferAllocations.size() : stride;
	}

	@Override
	public List<IBuffer> getBuffers(final int index)
	{
		final var indexType = bufferReference.indexType();
		final int contextIndex = (index + indexModifier(indexType)) % indexCount;
		final int stride = bufferReference.stride();
		final var buffers = bufferReference.buffers();
		if (stride == 0)
		{
			return buffers;
		}
		else
		{
			final int start = contextIndex * stride;
			final int end = start + stride;
			return buffers.subList(start, end);
		}
	}

	@Override
	public List<IVulkanBufferAllocation> getBufferAllocations(final int index)
	{
		final var indexType = bufferReference.indexType();
		final int contextIndex = (index + indexModifier(indexType)) % indexCount;
		final int stride = bufferReference.stride();
		if (stride == 0)
		{
			return bufferAllocations;
		}
		else
		{
			final int start = contextIndex * stride;
			final int end = start + stride;
			return bufferAllocations.subList(start, end);
		}
	}

	private static int indexModifier(final EContextIndex indexType)
	{
		return switch (indexType)
				{
					case ContextInstance -> 0;
					case ContextInstance_PlusOne -> 1;
					case ContextInstance_MinusOne -> -1;
				};
	}
}

