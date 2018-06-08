package org.sheepy.lily.game.vulkan.sampler;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkSamplerCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class Sampler
{
	private LogicalDevice logicalDevice;
	private boolean anisotropy;

	private long samplerId;

	public Sampler(LogicalDevice logicalDevice, boolean anisotropy)
	{
		this.logicalDevice = logicalDevice;
		this.anisotropy = anisotropy;
		load();
	}

	private void load()
	{
		VkSamplerCreateInfo samplerInfo = VkSamplerCreateInfo.calloc();
		samplerInfo.sType(VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO);
		samplerInfo.magFilter(VK_FILTER_LINEAR);
		samplerInfo.minFilter(VK_FILTER_LINEAR);
		samplerInfo.addressModeU(VK_SAMPLER_ADDRESS_MODE_REPEAT);
		samplerInfo.addressModeV(VK_SAMPLER_ADDRESS_MODE_REPEAT);
		samplerInfo.addressModeW(VK_SAMPLER_ADDRESS_MODE_REPEAT);

		if (anisotropy)
		{
			samplerInfo.anisotropyEnable(true);
			samplerInfo.maxAnisotropy(16);
		}
		else
		{
			samplerInfo.anisotropyEnable(false);
			samplerInfo.maxAnisotropy(1);
		}

		samplerInfo.borderColor(VK_BORDER_COLOR_INT_OPAQUE_BLACK);
		samplerInfo.unnormalizedCoordinates(false);
		samplerInfo.compareEnable(false);
		samplerInfo.compareOp(VK_COMPARE_OP_ALWAYS);
		samplerInfo.mipmapMode(VK_SAMPLER_MIPMAP_MODE_LINEAR);
		samplerInfo.mipLodBias(0.0f);
		samplerInfo.minLod(0.0f);
		samplerInfo.maxLod(0.0f);

		long[] aSamplerId = new long[1];
		if (vkCreateSampler(logicalDevice.getVkDevice(), samplerInfo, null,
				aSamplerId) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create texture sampler!");
		}
		samplerId = aSamplerId[0];
	}

	public long getId()
	{
		return samplerId;
	}

	public void free()
	{
		vkDestroySampler(logicalDevice.getVkDevice(), samplerId, null);
	}
}
