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
import org.sheepy.lily.vulkan.api.nativehelper.resource.IVkDescriptor;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.resource.buffer.GPUBufferBackend;

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
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		final var poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(EDescriptorType.UNIFORM_BUFFER_VALUE);
		poolSize.descriptorCount(getDescriptorCount());
		return poolSize;
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
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final var bufferInfo = allocBufferInfo(stack);

		final var descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(EDescriptorType.UNIFORM_BUFFER_VALUE);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null);
		descriptorWrite.pTexelBufferView(null);
		return descriptorWrite;
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
