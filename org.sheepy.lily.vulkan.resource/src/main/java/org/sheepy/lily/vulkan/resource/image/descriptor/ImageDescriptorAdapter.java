package org.sheepy.lily.vulkan.resource.image.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

@ModelExtender(scope = ImageDescriptor.class)
@Adapter
public final class ImageDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageDescriptor descriptor;

	private ImageDescriptorAdapter(ImageDescriptor descriptor)
	{
		this.descriptor = descriptor;
	}

	@Override
	public int sizeInPool()
	{
		return descriptorCount();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var shaderStages = VulkanModelUtil.getEnumeratedFlag(descriptor.shaderStages(), EShaderStage::value);
		final var descriptorCount = descriptorCount();

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.calloc(stack);
		res.descriptorType(descriptor.type().value());
		res.descriptorCount(descriptorCount);
		res.stageFlags(shaderStages);
		return res;
	}

	private int descriptorCount()
	{
		final int viewCount = descriptor.images().size();
		final int samplerCount = descriptor.sampler() != null ? 1 : 0;
		return Math.max(viewCount, samplerCount);
	}
}
