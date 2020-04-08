package org.sheepy.lily.vulkan.resource.image.backend;

import org.lwjgl.vulkan.VkSamplerCreateInfo;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.image.SamplerInfo;

import static org.lwjgl.vulkan.VK10.*;

public class VkSampler
{
	private static final String FAILED_TO_CREATE_SAMPLER = "Failed to create texture sampler";

	private final SamplerInfo info;

	private long samplerPtr;

	public VkSampler()
	{
		this(ImageFactory.eINSTANCE.createSamplerInfo());
	}

	public VkSampler(SamplerInfo info)
	{
		this.info = info;
	}

	public void allocate(IVulkanContext context)
	{
		final var stack = context.stack();
		final var samplerInfo = VkSamplerCreateInfo.callocStack(stack);
		samplerInfo.sType(VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO);
		samplerInfo.magFilter(info.getMagFilter().getValue());
		samplerInfo.minFilter(info.getMinFilter().getValue());
		samplerInfo.addressModeU(info.getAddressMode().getValue());
		samplerInfo.addressModeV(info.getAddressMode().getValue());
		samplerInfo.addressModeW(info.getAddressMode().getValue());

		samplerInfo.anisotropyEnable(info.isAnisotropyEnabled());
		samplerInfo.maxAnisotropy(info.getMaxAnisotropy());

		samplerInfo.borderColor(info.getBorderColor().getValue());
		samplerInfo.unnormalizedCoordinates(info.isUnnormalizedCoordinates());
		samplerInfo.compareEnable(info.isCompareEnable());
		samplerInfo.compareOp(VK_COMPARE_OP_ALWAYS);
		samplerInfo.mipmapMode(info.getMipmapMode().getValue());
		samplerInfo.mipLodBias(info.getLodBias());
		samplerInfo.minLod(info.getMinLod());
		samplerInfo.maxLod(info.getMaxLod());

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
