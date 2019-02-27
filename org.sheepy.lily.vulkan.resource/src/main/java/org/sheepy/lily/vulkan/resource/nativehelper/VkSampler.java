package org.sheepy.lily.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkSamplerCreateInfo;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl;

public class VkSampler
{
	private final LogicalDevice logicalDevice;
	private final Sampler sampler;

	private long samplerId;

	public VkSampler(LogicalDevice logicalDevice)
	{
		this(logicalDevice, new SamplerImpl());
	}

	public VkSampler(LogicalDevice logicalDevice, Sampler sampler)
	{
		this.logicalDevice = logicalDevice;
		this.sampler = sampler;
	}

	public void load()
	{
		VkSamplerCreateInfo samplerInfo = VkSamplerCreateInfo.calloc();
		samplerInfo.sType(VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO);
		samplerInfo.magFilter(sampler.getMagFilter().getValue());
		samplerInfo.minFilter(sampler.getMinFilter().getValue());
		samplerInfo.addressModeU(sampler.getAddressMode().getValue());
		samplerInfo.addressModeV(sampler.getAddressMode().getValue());
		samplerInfo.addressModeW(sampler.getAddressMode().getValue());

		samplerInfo.anisotropyEnable(sampler.isAnisotropyEnabled());
		samplerInfo.maxAnisotropy(sampler.getMaxAnisotropy());

		samplerInfo.borderColor(sampler.getBorderColor().getValue());
		samplerInfo.unnormalizedCoordinates(sampler.isUnnormalizedCoordinates());
		samplerInfo.compareEnable(sampler.isCompareEnable());
		samplerInfo.compareOp(VK_COMPARE_OP_ALWAYS);
		samplerInfo.mipmapMode(sampler.getMipmapMode().getValue());
		samplerInfo.mipLodBias(sampler.getLodBias());
		samplerInfo.minLod(sampler.getMinLod());
		samplerInfo.maxLod(sampler.getMaxLod());

		long[] aSamplerId = new long[1];
		Logger.check(vkCreateSampler(logicalDevice.getVkDevice(), samplerInfo, null, aSamplerId),
				"Failed to create texture sampler");
		samplerId = aSamplerId[0];
	}

	public long getId()
	{
		return samplerId;
	}

	public void free()
	{
		vkDestroySampler(logicalDevice.getVkDevice(), samplerId, null);
		samplerId = -1;
	}
}
