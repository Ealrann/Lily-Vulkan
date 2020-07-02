package org.sheepy.lily.vulkan.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor;

@ModelExtender(scope = SampledImageDescriptor.class)
@Adapter
public final class SampledImageDescriptorAdapter implements IDescriptorAdapter
{
	private final SampledImageDescriptor descriptor;

	private SampledImageDescriptorAdapter(SampledImageDescriptor descriptor)
	{
		this.descriptor = descriptor;
	}

	@Override
	public int sizeInPool()
	{
		return 1;
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var shaderStages = VulkanModelUtil.getEnumeratedFlag(descriptor.getShaderStages());

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptor.getType().getValue());
		res.descriptorCount(1);
		res.stageFlags(shaderStages);
		return res;
	}
}
