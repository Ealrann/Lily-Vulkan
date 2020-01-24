package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.common.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.common.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.common.resource.IImageAdapter;
import org.sheepy.lily.vulkan.common.resource.image.VkImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;

@Statefull
@Adapter(scope = ImageArrayDescriptor.class)
public class ImageArrayDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageArrayDescriptor descriptor;
	private final VkImageArrayDescriptor vkDescriptor;

	public ImageArrayDescriptorAdapter(ImageArrayDescriptor descriptor)
	{
		this.descriptor = descriptor;

		final var images = descriptor.getImages();
		final var initialLayout = descriptor.getInitialLayout();
		vkDescriptor = new VkImageArrayDescriptor(	images.size(),
													initialLayout,
													descriptor.getType(),
													descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var images = descriptor.getImages();
		final long[] viewPtrs = new long[images.size()];

		for (int i = 0; i < images.size(); i++)
		{
			final var image = images.get(i);
			final var adapter = image.adaptNotNull(IImageAdapter.class);
			viewPtrs[i] = adapter.getViewPtr();
		}

		vkDescriptor.updateViewPtrs(viewPtrs);
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
