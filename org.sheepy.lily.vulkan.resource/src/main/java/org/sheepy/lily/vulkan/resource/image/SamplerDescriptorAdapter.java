package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.common.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.common.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.common.resource.ISamplerAdapter;
import org.sheepy.lily.vulkan.model.resource.SamplerDescriptor;
import org.sheepy.lily.vulkan.resource.image.backend.VkImageDescriptor;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@Statefull
@Adapter(scope = SamplerDescriptor.class)
public class SamplerDescriptorAdapter implements IDescriptorAdapter
{
	private final VkImageDescriptor vkDescriptor;
	private final SamplerDescriptor descriptor;

	public SamplerDescriptorAdapter(SamplerDescriptor descriptor)
	{
		this.descriptor = descriptor;

		vkDescriptor = new VkImageDescriptor(	0,
												0,
												EImageLayout.GENERAL,
												descriptor.getType(),
												descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var sampler = descriptor.getSampler();
		final var samplerAdapter = sampler.adaptNotNull(ISamplerAdapter.class);

		vkDescriptor.updateSamplerPtr(samplerAdapter.getSamplerPtr());
		vkDescriptor.updateViewPtr(samplerAdapter.getViewPtr());
	}

	@Override
	public void free(IExecutionContext context)
	{}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
