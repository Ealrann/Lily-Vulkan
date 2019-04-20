package org.sheepy.lily.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;

public class VkUniformBuffer implements IVkDescriptor, IAllocable
{
	private final GPUBufferBackend uniformBuffer;
	private final List<EShaderStage> stages;

	public VkUniformBuffer(BufferInfo info, List<EShaderStage> stages)
	{
		this.stages = stages;
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
		poolSize.type(EDescriptorType.UNIFORM_BUFFER_VALUE);
		poolSize.descriptorCount(getDescriptorCount());
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final int stageFlags = VulkanModelUtil.getEnumeratedFlag(stages);
		final var res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(EDescriptorType.UNIFORM_BUFFER_VALUE);
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(stageFlags);
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
		writeDescriptor.pImageInfo(null);
		writeDescriptor.pTexelBufferView(null);
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(uniformBuffer.getAddress());
		bufferInfo.offset(0);
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
