package org.sheepy.lily.vulkan.resource.buffer.descriptor;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor;

@ModelExtender(scope = BufferDescriptor.class)
@Allocation
@AllocationDependency(features = BufferDescriptor.FeatureIDs.BUFFER, type = IVulkanBufferAllocation.class)
public final class BufferDescriptorAllocation implements IDescriptorAllocation
{
	private final VkBufferDescriptor vkDescriptor;
	private final IVulkanBufferAllocation bufferAllocation;

	private BufferDescriptorAllocation(BufferDescriptor descriptor,
									   @InjectDependency(index = 0) IVulkanBufferAllocation bufferAllocation)
	{
		this.bufferAllocation = bufferAllocation;
		vkDescriptor = new VkBufferDescriptor(bufferAllocation.getPtr(),
											  bufferAllocation.getBindSize(),
											  bufferAllocation.getBindOffset(),
											  descriptor.type());
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		bufferAllocation.attach(recordContext);
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}

