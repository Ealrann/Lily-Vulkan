package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;

@Statefull
@Adapter(scope = ImageDescriptor.class)
public class ImageDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;

	private ImageDescriptorAdapter(ImageDescriptor descriptor)
	{
		this.descriptor = descriptor;
		this.vkDescriptor = new VkImageDescriptor(	0,
													0,
													EImageLayout.GENERAL,
													descriptor.getDescriptorType(),
													descriptor.getShaderStages());
	}

	@Override
	public void allocate()
	{
		final var image = descriptor.getImage();
		final var imageAdapter = image.adaptNotNull(IImageAdapter.class);

		vkDescriptor.updateViewPtr(imageAdapter.getViewPtr());
	}

	@Override
	public void free()
	{

	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
