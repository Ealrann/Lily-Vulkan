package org.sheepy.lily.vulkan.resource.buffer.reference;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.core.resource.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.core.resource.buffer.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

import java.util.List;

@ModelExtender(scope = BufferReference.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS, type = IVulkanBufferAllocation.class)
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
		final var stride = bufferReference.getStride();
		return stride == 0 ? bufferAllocations.size() : stride;
	}

	@Override
	public List<IBuffer> getBuffers(final int index)
	{
		final var indexType = bufferReference.getIndexType();
		final int contextIndex = (index + indexModifier(indexType)) % indexCount;
		final int stride = bufferReference.getStride();
		final var buffers = bufferReference.getBuffers();
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
		final var indexType = bufferReference.getIndexType();
		final int contextIndex = (index + indexModifier(indexType)) % indexCount;
		final int stride = bufferReference.getStride();
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
					case CONTEXT_INSTANCE -> 0;
					case CONTEXT_INSTANCE_PLUS_ONE -> 1;
					case CONTEXT_INSTANCE_MINUS_ONE -> -1;
				};
	}
}
