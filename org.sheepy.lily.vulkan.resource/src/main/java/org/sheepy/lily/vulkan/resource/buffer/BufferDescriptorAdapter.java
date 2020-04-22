package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;

@ModelExtender(scope = BufferDescriptor.class)
@Adapter
public final class BufferDescriptorAdapter implements IDescriptorAdapter
{
	private final int descriptorType;
	private final int shaderStages;

	private BufferDescriptorAdapter(BufferDescriptor descriptor)
	{
		this.descriptorType = descriptor.getType().getValue();
		this.shaderStages = VulkanModelUtil.getEnumeratedFlag(descriptor.getShaderStages());
	}

	@Override
	public int sizeInPool()
	{
		return 1;
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(1);
		res.stageFlags(shaderStages);
		return res;
	}
}
