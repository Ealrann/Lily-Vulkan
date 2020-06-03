package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;

@ModelExtender(scope = ImageArrayDescriptor.class)
@Adapter
public final class ImageArrayDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageArrayDescriptor descriptor;

	private ImageArrayDescriptorAdapter(ImageArrayDescriptor descriptor)
	{
		this.descriptor = descriptor;
	}

	@Override
	public int sizeInPool()
	{
		return descriptor.getImages().size();
	}
}
