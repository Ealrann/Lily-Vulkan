package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.ISamplerAllocation;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.resource.image.backend.VkSampler;

@ModelExtender(scope = Sampler.class)
@Allocation(context = IVulkanContext.class)
public final class SamplerAllocation implements ISamplerAllocation
{
	private final VkSampler vkSampler;
	private final IVkImageAllocation imageAdapter;
	private final IAllocationState allocationState;

	public SamplerAllocation(Sampler sampler, IVulkanContext context, IAllocationState allocationState)
	{
		this.allocationState = allocationState;
		final var image = sampler.image();
		imageAdapter = image != null ? image.adapt(IVkImageAllocation.class) : null;

		if (imageAdapter != null)
		{
			final int mipLevels = imageAdapter.getVkImage().mipLevels();
			sampler.maxLod(Math.max(mipLevels, sampler.maxLod()));
		}

		vkSampler = new VkSampler(sampler);
		vkSampler.allocate(context);
	}

	public void attach(final IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	@Free
	public void free(IVulkanContext context)
	{
		vkSampler.free(context);
	}

	@Override
	public long getSamplerPtr()
	{
		return vkSampler.getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageAdapter != null ? imageAdapter.getViewPtr() : 0;
	}
}

