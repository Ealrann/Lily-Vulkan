package org.sheepy.lily.vulkan.resource.image;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.ISamplerAdapter;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkSampler;
import org.sheepy.vulkan.resource.image.VkSamplerDescriptor;

@Statefull
@Adapter(scope = Sampler.class)
public class SamplerAdapter implements ISamplerAdapter
{
	private final VkSampler vkSampler;

	private List<IVkDescriptor> descriptors;

	public SamplerAdapter(Sampler sampler)
	{
		vkSampler = new VkSampler(sampler.getInfo());
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		vkSampler.allocate(stack, context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkSampler.free(context);
	}

	@Override
	public VkSampler getVkSampler()
	{
		return vkSampler;
	}
	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			descriptors = List.of(new VkSamplerDescriptor(vkSampler));
		}

		return descriptors;
	}
}
