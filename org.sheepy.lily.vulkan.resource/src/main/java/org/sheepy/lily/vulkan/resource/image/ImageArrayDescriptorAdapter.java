package org.sheepy.lily.vulkan.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;

@ModelExtender(scope = ImageArrayDescriptor.class)
@Adapter
public final class ImageArrayDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageArrayDescriptor descriptor;

	private ImageArrayDescriptorAdapter(ImageArrayDescriptor descriptor)
	{
		this.descriptor = descriptor;
	}

	@Override
	public int sizeInPool()
	{
		return descriptor.getImages().size();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var shaderStages = VulkanModelUtil.getEnumeratedFlag(descriptor.getShaderStages());
		final int descriptorType = descriptor.getType().getValue();
		final int count = descriptor.getImages().size();

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(count);
		res.stageFlags(shaderStages);
		return res;
	}
}
