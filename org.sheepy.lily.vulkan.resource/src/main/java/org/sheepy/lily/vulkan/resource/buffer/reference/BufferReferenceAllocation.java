package org.sheepy.lily.vulkan.resource.buffer.reference;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.model.resource.EContextIndex;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.List;

@ModelExtender(scope = BufferReference.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS, type = IBufferAllocation.class)
public final class BufferReferenceAllocation implements IBufferReferenceAllocation
{
	private final BufferReference bufferReference;
	private final List<IBufferAllocation> bufferAllocations;

	private BufferReferenceAllocation(BufferReference bufferReference,
									  @InjectDependency(index = 0) List<IBufferAllocation> bufferAllocations)
	{
		this.bufferReference = bufferReference;
		this.bufferAllocations = bufferAllocations;
	}

	@Override
	public int getBufferCountPerInstance()
	{
		return bufferReference.getStride();
	}

	@Override
	public List<IBuffer> getBuffers(final int index, final int indexCount)
	{
		final var indexType = bufferReference.getIndexType();
		final int contextIndex = (index + indexModifier(indexType)) % indexCount;
		final int stride = bufferReference.getStride();
		final var buffers = bufferReference.getBuffers();
		final int effectiveStride = stride == 0 ? buffers.size() : stride;
		final int start = contextIndex * effectiveStride;
		final int end = start + effectiveStride;

		return buffers.subList(start, end);
	}

	@Override
	public List<IBufferAllocation> getBufferAllocations(final int index, final int indexCount)
	{
		final var indexType = bufferReference.getIndexType();
		final int contextIndex = (index + indexModifier(indexType)) % indexCount;
		final int stride = bufferReference.getStride();
		final int start = contextIndex * stride;
		final int end = start + stride;

		return bufferAllocations.subList(start, end);
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
