package org.sheepy.lily.vulkan.resource.image;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;
import org.sheepy.vulkan.resource.image.VkSampler;

@Statefull
@Adapter(scope = SampledImage.class)
public class SampledImageAdapter implements ISampledImageAdapter
{
	private final SampledImage sampledImage;
	private final IImageAdapter imageAdapter;

	private VkSampler vkSampler;
	private List<IVkDescriptor> descriptors = null;

	public SampledImageAdapter(SampledImage sampledImage)
	{
		this.sampledImage = sampledImage;
		final var image = sampledImage.getImage();
		imageAdapter = image != null ? IImageAdapter.adapt(image) : null;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		imageAdapter.allocate(stack, context);
		final var samplerInfo = sampledImage.getSampler();

		if (imageAdapter != null)
		{
			final int mipLevels = imageAdapter.getVkImage().mipLevels;
			samplerInfo.setMaxLod(Math.max(mipLevels, samplerInfo.getMaxLod()));
		}

		vkSampler = new VkSampler(samplerInfo);
		vkSampler.allocate(stack, context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkSampler.free(context);
		imageAdapter.free(context);

		vkSampler = null;
	}

	@Override
	public long getImagePtr()
	{
		return imageAdapter.getImagePtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageAdapter.getViewPtr();
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
	public VkImage getVkImage()
	{
		return imageAdapter.getVkImage();
	}

	@Override
	public long getMemoryPtr()
	{
		return imageAdapter.getMemoryPtr();
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			IVkDescriptor descriptor = null;
			final var descriptorObject = sampledImage.getDescriptor();

			final long samplerPtr = vkSampler.getPtr();
			final long viewPtrPtr = imageAdapter.getViewPtr();
			final var initialLayout = sampledImage.getImage().getInitialLayout();
			final var layout = initialLayout != null
					? initialLayout.getLayout()
					: EImageLayout.SHADER_READ_ONLY_OPTIMAL;
			final var shaderStages = descriptorObject.getShaderStages();
			final var descriptorType = descriptorObject.getDescriptorType();

			descriptor = new VkImageDescriptor(viewPtrPtr, samplerPtr, layout, descriptorType, shaderStages);

			descriptors = List.of(descriptor);
		}

		return descriptors;
	}
}
