package org.sheepy.lily.vulkan.resource.buffer.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

@ModelExtender(scope = BufferDescriptor.class)
@Adapter
public final class BufferDescriptorAdapter implements IDescriptorAdapter
{
	private final int descriptorType;
	private final int shaderStages;

	private BufferDescriptorAdapter(BufferDescriptor descriptor)
	{
		this.descriptorType = descriptor.type().value();
		this.shaderStages = VulkanModelUtil.getEnumeratedFlag(descriptor.shaderStages(), EShaderStage::value);
	}

	@Override
	public int sizeInPool()
	{
		return 1;
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var res = VkDescriptorSetLayoutBinding.calloc(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(1);
		res.stageFlags(shaderStages);
		return res;
	}
}

