package org.sheepy.lily.vulkan.resource.image.backend;

import org.lwjgl.vulkan.VkSamplerCreateInfo;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.image.SamplerInfo;

import static org.lwjgl.vulkan.VK10.*;

public final class VkSampler
{
	private static final String FAILED_TO_CREATE_SAMPLER = "Failed to create texture sampler";

	private final SamplerInfo info;

	private long samplerPtr;

	public VkSampler()
	{
		this(SamplerInfo.builder().build());
	}

	public VkSampler(SamplerInfo info)
	{
		this.info = info;
	}

	public void allocate(IVulkanContext context)
	{
		final var stack = context.stack();
		final var samplerInfo = VkSamplerCreateInfo.calloc(stack);
		samplerInfo.sType(VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO);
		samplerInfo.magFilter(info.magFilter().value());
		samplerInfo.minFilter(info.minFilter().value());
		samplerInfo.addressModeU(info.addressMode().value());
		samplerInfo.addressModeV(info.addressMode().value());
		samplerInfo.addressModeW(info.addressMode().value());

		samplerInfo.anisotropyEnable(info.anisotropyEnabled());
		samplerInfo.maxAnisotropy(info.maxAnisotropy());

		samplerInfo.borderColor(info.borderColor().value());
		samplerInfo.unnormalizedCoordinates(info.unnormalizedCoordinates());
		samplerInfo.compareEnable(info.compareEnable());
		samplerInfo.compareOp(VK_COMPARE_OP_ALWAYS);
		samplerInfo.mipmapMode(info.mipmapMode().value());
		samplerInfo.mipLodBias(info.lodBias());
		samplerInfo.minLod(info.minLod());
		samplerInfo.maxLod(info.maxLod());

		final long[] aSamplerId = new long[1];
		Logger.check(vkCreateSampler(context.getVkDevice(), samplerInfo, null, aSamplerId), FAILED_TO_CREATE_SAMPLER);
		samplerPtr = aSamplerId[0];
	}

	public long getPtr()
	{
		return samplerPtr;
	}

	public void free(IVulkanContext context)
	{
		vkDestroySampler(context.getVkDevice(), samplerPtr, null);
		samplerPtr = -1;
	}

	@Override
	public String toString()
	{
		return "VkSampler [samplerPtr=" + samplerPtr + ", info=" + info + "]";
	}
}

