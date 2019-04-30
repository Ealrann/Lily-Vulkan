package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptor;

public class VkUniformBuffer implements IVkDescriptor, IAllocable
{
	private final GPUBufferBackend uniformBuffer;
	private final int shaderStages;

	private final long offset = 0;

	public VkUniformBuffer(BufferInfo info, int shaderStages)
	{
		this.shaderStages = shaderStages;
		uniformBuffer = new GPUBufferBackend(info, false);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		uniformBuffer.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		uniformBuffer.free(context);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return uniformBuffer.isAllocationDirty(context);
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT);
		poolSize.descriptorCount(getDescriptorCount());
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT);
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(shaderStages);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var bufferInfo = allocBufferInfo(stack);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT);
		writeDescriptor.pBufferInfo(bufferInfo);
		writeDescriptor.pImageInfo(null);
		writeDescriptor.pTexelBufferView(null);
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(uniformBuffer.getAddress());
		bufferInfo.offset(offset);
		bufferInfo.range(uniformBuffer.getInfos().size);

		return bufferInfo;
	}

	protected static int getDescriptorCount()
	{
		return 1;
	}

	public GPUBufferBackend getBuffer()
	{
		return uniformBuffer;
	}

}
