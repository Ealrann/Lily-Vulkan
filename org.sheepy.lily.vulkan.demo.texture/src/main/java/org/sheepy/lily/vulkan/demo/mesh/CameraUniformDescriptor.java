package org.sheepy.lily.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptor;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.resource.buffer.IBufferBackend;

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
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		final var poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(EDescriptorType.UNIFORM_BUFFER_VALUE);
		poolSize.descriptorCount(1);
		return poolSize;
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
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		final var descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(EDescriptorType.UNIFORM_BUFFER_VALUE);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
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
