package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.common.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.common.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;

@Statefull
@Adapter(scope = ImageDescriptor.class)
public class ImageDescriptorAdapter implements IDescriptorAdapter
{
	private final ImageDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;
	private final INotificationListener viewListener = n -> updateView(n.getNewLongValue());

	private ImageDescriptorAdapter(ImageDescriptor descriptor)
	{
		this.descriptor = descriptor;
		this.vkDescriptor = new VkImageDescriptor(	0,
													0,
													EImageLayout.GENERAL,
													descriptor.getType(),
													descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var image = descriptor.getImage();
		final var imageAdapter = image.adaptNotNull(IImageAdapter.class);

		updateView(imageAdapter.getViewPtr());

		imageAdapter.addListener(viewListener, IImageAdapter.Features.View.ordinal());
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var image = descriptor.getImage();
		final var imageAdapter = image.adaptNotNull(IImageAdapter.class);

		imageAdapter.removeListener(viewListener, IImageAdapter.Features.View.ordinal());
	}

	public void updateView(long viewPtr)
	{
		vkDescriptor.updateViewPtr(viewPtr);
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
