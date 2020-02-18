package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@Statefull
@Adapter(scope = ImageDescriptor.class)
public final class ImageDescriptorAdapter implements IDescriptorAdapter
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
		final var imageAdapter = image.adaptNotNull(IVkImageAdapter.class);

		updateView(imageAdapter.getViewPtr());

		imageAdapter.addListener(viewListener, IVkImageAdapter.Features.View.ordinal());
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var image = descriptor.getImage();
		final var imageAdapter = image.adaptNotNull(IVkImageAdapter.class);

		imageAdapter.removeListener(viewListener, IVkImageAdapter.Features.View.ordinal());
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
