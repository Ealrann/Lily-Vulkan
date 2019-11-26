package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.api.resource.ITexture2DArrayAdapter;
import org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.resource.image.VkImageArrayDescriptor;

@Statefull
@Adapter(scope = Texture2DArrayDescriptor.class)
public class Texture2DArrayDescriptorAdapter implements IDescriptorAdapter
{
	private final Texture2DArrayDescriptor descriptor;
	private final VkImageArrayDescriptor vkDescriptor;

	public Texture2DArrayDescriptorAdapter(Texture2DArrayDescriptor descriptor)
	{
		this.descriptor = descriptor;

		final var texture2DArray = descriptor.getTexture2DArray();
		final var initialLayout = texture2DArray.getInitialLayout().getLayout();
		vkDescriptor = new VkImageArrayDescriptor(	new long[texture2DArray.getFiles().size()],
		                                          	initialLayout,
													descriptor.getDescriptorType(),
													descriptor.getShaderStages());
	}

	@Override
	public void allocate()
	{
		final var texture2DArray = descriptor.getTexture2DArray();
		final var adapter = texture2DArray.adaptNotNull(ITexture2DArrayAdapter.class);

		vkDescriptor.updateViewPtrs(adapter.getViewPtrs());
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
