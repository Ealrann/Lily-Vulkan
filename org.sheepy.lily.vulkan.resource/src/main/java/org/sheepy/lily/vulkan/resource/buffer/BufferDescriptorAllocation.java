package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@ModelExtender(scope = BufferDescriptor.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.BUFFER_DESCRIPTOR__BUFFER, type = IBufferAllocation.class)
public final class BufferDescriptorAllocation implements IDescriptorAllocation
{
	private final VkBufferDescriptor vkDescriptor;

	private BufferDescriptorAllocation(BufferDescriptor descriptor,
									   @InjectDependency(index = 0) IBufferAllocation bufferAllocation)
	{
		vkDescriptor = new VkBufferDescriptor(bufferAllocation.getPtr(),
											  bufferAllocation.getBindSize(),
											  bufferAllocation.getBindOffset(),
											  descriptor.getType());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
