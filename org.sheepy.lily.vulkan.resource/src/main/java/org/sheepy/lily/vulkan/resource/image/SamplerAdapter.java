package org.sheepy.lily.vulkan.resource.image;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.api.resource.ISamplerAdapter;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;
import org.sheepy.vulkan.resource.image.VkSampler;

@Statefull
@Adapter(scope = Sampler.class)
public class SamplerAdapter implements ISamplerAdapter
{
	private final VkSampler vkSampler;
	private final Sampler sampler;
	private final IImageAdapter imageAdapter;

	private List<IVkDescriptor> descriptors;

	public SamplerAdapter(Sampler sampler)
	{
		this.sampler = sampler;

		final var image = sampler.getImage();
		imageAdapter = image != null ? IImageAdapter.adapt(image) : null;

		if (imageAdapter != null)
		{
			final int mipLevels = imageAdapter.getVkImage().mipLevels;
			sampler.setMaxLod(Math.max(mipLevels, sampler.getMaxLod()));
		}

		vkSampler = new VkSampler(sampler);
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
	public long getSamplerPtr()
	{
		return vkSampler.getPtr();
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			IVkDescriptor descriptor = null;
			final var descriptorObject = sampler.getDescriptor();

			final long samplerPtr = vkSampler.getPtr();
			final long viewPtrPtr = imageAdapter != null ? imageAdapter.getViewPtr() : -1;
			final var layout = EImageLayout.GENERAL;
			final var shaderStages = descriptorObject.getShaderStages();
			final var descriptorType = descriptorObject.getDescriptorType();

			descriptor = new VkImageDescriptor(viewPtrPtr, samplerPtr, layout, descriptorType, shaderStages);

			descriptors = List.of(descriptor);
		}

		return descriptors;
	}
}
