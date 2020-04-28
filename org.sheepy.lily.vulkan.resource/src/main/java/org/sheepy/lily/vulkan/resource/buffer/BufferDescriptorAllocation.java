package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocable;
import org.sheepy.lily.core.api.allocation.up.annotation.Dependency;
import org.sheepy.lily.core.api.allocation.up.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@ModelExtender(scope = BufferDescriptor.class)
@Allocable
public final class BufferDescriptorAllocation implements IDescriptorAllocation
{
	private final VkBufferDescriptor vkDescriptor;

	private BufferDescriptorAllocation(BufferDescriptor descriptor,
									   @Dependency(features = VulkanResourcePackage.BUFFER_DESCRIPTOR__BUFFER, type = IBufferAllocation.class) IBufferAllocation bufferAllocation)
	{
		vkDescriptor = new VkBufferDescriptor(bufferAllocation.getPtr(),
											  bufferAllocation.getBindSize(),
											  bufferAllocation.getBindOffset(),
											  descriptor.getType(),
											  descriptor.getShaderStages());
	}

	@UpdateDependency(features = VulkanResourcePackage.BUFFER_DESCRIPTOR__BUFFER)
	private void update(IBufferAllocation bufferAdapter)
	{
		vkDescriptor.updateBufferPtr(bufferAdapter.getPtr());
		vkDescriptor.updateSize(bufferAdapter.getBindSize());
		vkDescriptor.updateOffset(bufferAdapter.getBindOffset());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
