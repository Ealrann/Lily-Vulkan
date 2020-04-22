package org.sheepy.lily.vulkan.resource.buffer.reference;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.model.resource.FixedBufferReference;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.List;

@ModelExtender(scope = FixedBufferReference.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.FIXED_BUFFER_REFERENCE__BUFFERS, type = IBufferAllocation.class)
public final class FixedBufferReferenceAllocation implements IBufferReferenceAllocation
{
	private final FixedBufferReference bufferReference;
	private final List<IBufferAllocation> bufferAllocations;

	private FixedBufferReferenceAllocation(FixedBufferReference bufferReference,
										   @InjectDependency(index = 0) List<IBufferAllocation> bufferAllocations)
	{
		this.bufferReference = bufferReference;
		this.bufferAllocations = bufferAllocations;
	}

	@Override
	public int getBufferCountPerInstance()
	{
		return bufferReference.getBuffers().size();
	}

	@Override
	public List<IBuffer> getBuffers(final int index, final int indexCount)
	{
		return bufferReference.getBuffers();
	}

	@Override
	public List<IBufferAllocation> getBufferAllocations(final int index, final int indexCount)
	{
		return bufferAllocations;
	}
}
