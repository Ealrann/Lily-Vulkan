package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;

@Statefull
@Adapter(scope = SampledImageDescriptor.class)
public class SampledImageDescriptorAdapter implements IDescriptorAdapter
{
	private final SampledImageDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;

	public SampledImageDescriptorAdapter(SampledImageDescriptor descriptor)
	{
		this.descriptor = descriptor;
		final var sampledImage = descriptor.getSampledImage();
		final var initialLayout = sampledImage.getImage().getInitialLayout();
		final var layout = initialLayout != null
				? initialLayout.getLayout()
				: EImageLayout.SHADER_READ_ONLY_OPTIMAL;

		vkDescriptor = new VkImageDescriptor(	0,
												0,
												layout,
												descriptor.getDescriptorType(),
												descriptor.getShaderStages());
	}

	@Override
	public void allocate()
	{
		final var sampledImage = descriptor.getSampledImage();
		final var imageAdapter = sampledImage.adaptNotNull(ISampledImageAdapter.class);

		vkDescriptor.updateSamplerPtr(imageAdapter.getSamplerPtr());
		vkDescriptor.updateViewPtr(imageAdapter.getViewPtr());
	}

	@Override
	public void free()
	{}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
