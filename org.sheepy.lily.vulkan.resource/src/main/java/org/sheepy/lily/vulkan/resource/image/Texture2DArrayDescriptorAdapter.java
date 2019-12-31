package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.api.resource.ITextureArrayAdapter;
import org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImageArrayDescriptor;

@Statefull
@Adapter(scope = Texture2DArrayDescriptor.class)
@Deprecated
public class Texture2DArrayDescriptorAdapter implements IDescriptorAdapter
{
	@Deprecated
	private static final int MAX_SIZE = 6;
	private final Texture2DArrayDescriptor descriptor;
	private final VkImageArrayDescriptor vkDescriptor;

	public Texture2DArrayDescriptorAdapter(Texture2DArrayDescriptor descriptor)
	{
		this.descriptor = descriptor;

		final var texture2DArray = descriptor.getTextureArray();
		final var initialLayout = texture2DArray.getInitialLayout().getLayout();
		vkDescriptor = new VkImageArrayDescriptor(	MAX_SIZE,
		                                          	initialLayout,
													descriptor.getType(),
													descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var texture2DArray = descriptor.getTextureArray();
		final var adapter = texture2DArray.adaptNotNull(ITextureArrayAdapter.class);

		vkDescriptor.updateViewPtrs(adapter.getViewPtrs());
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
