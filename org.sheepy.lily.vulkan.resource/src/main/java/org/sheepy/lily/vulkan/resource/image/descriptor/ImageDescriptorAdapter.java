package org.sheepy.lily.vulkan.resource.image.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;

@ModelExtender(scope = ImageDescriptor.class)
@Adapter
public final class ImageDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageDescriptor descriptor;
	private final int descriptorCount;

	private ImageDescriptorAdapter(ImageDescriptor descriptor)
	{
		this.descriptor = descriptor;

		final int viewCount = descriptor.getImages().size();
		final int samplerCount = descriptor.getSampler() != null ? 1 : 0;
		descriptorCount = Math.max(viewCount, samplerCount);
	}

	@Override
	public int sizeInPool()
	{
		return descriptorCount;
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var shaderStages = VulkanModelUtil.getEnumeratedFlag(descriptor.getShaderStages());

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.calloc(stack);
		res.descriptorType(descriptor.getType().getValue());
		res.descriptorCount(descriptorCount);
		res.stageFlags(shaderStages);
		return res;
	}
}
