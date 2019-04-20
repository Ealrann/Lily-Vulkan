package org.sheepy.lily.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.IBufferBackend;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;

public class CameraUniformDescriptor implements IVkDescriptor
{
	private final IBufferBackend buffer;
	private final long offset;
	private final long size;

	public CameraUniformDescriptor(IBufferBackend buffer, long offset, long size)
	{
		this.buffer = buffer;
		this.offset = offset;
		this.size = size;
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(EDescriptorType.UNIFORM_BUFFER_VALUE);
		poolSize.descriptorCount(1);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(EDescriptorType.UNIFORM_BUFFER_VALUE);
		res.descriptorCount(1);
		res.stageFlags(EShaderStage.VERTEX_BIT_VALUE);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var bufferInfo = allocBufferInfo(stack);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(EDescriptorType.UNIFORM_BUFFER_VALUE);
		writeDescriptor.pBufferInfo(bufferInfo);
		writeDescriptor.pImageInfo(null); // Optional
		writeDescriptor.pTexelBufferView(null); // Optional
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(buffer.getAddress());
		bufferInfo.offset(offset);
		bufferInfo.range(size);

		return bufferInfo;
	}
}
