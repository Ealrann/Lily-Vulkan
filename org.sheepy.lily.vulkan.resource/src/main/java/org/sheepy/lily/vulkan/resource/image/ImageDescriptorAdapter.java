package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.util.function.LongConsumer;

@Statefull
@Adapter(scope = ImageDescriptor.class)
public final class ImageDescriptorAdapter implements IDescriptorAdapter, IAllocableAdapter<IExecutionContext>
{
	private final ImageDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;
	private final LongConsumer viewListener = this::updateView;

	private ImageDescriptorAdapter(ImageDescriptor descriptor)
	{
		this.descriptor = descriptor;
		this.vkDescriptor = new VkImageDescriptor(0,
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

		imageAdapter.listen(viewListener, IVkImageAdapter.Features.View);
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var image = descriptor.getImage();
		final var imageAdapter = image.adaptNotNull(IVkImageAdapter.class);

		imageAdapter.sulk(viewListener, IVkImageAdapter.Features.View);
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
