package org.sheepy.lily.vulkan.extra.graphic.rendering.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

@Adapter(scope = DescriptorsProvider.class)
public class DescriptorProviderAdapter implements IDescriptorProviderAdapter
{
	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider)
	{
		final List<IDescriptor> descriptors = new ArrayList<>();

		final var providedDescriptors = ((DescriptorsProvider) provider).getDescriptors();
		for (int i = 0; i < providedDescriptors.size(); i++)
		{
			final var descriptor = providedDescriptors.get(i);
			final var newDescriptor = EcoreUtil.copy(descriptor);
			descriptors.add(newDescriptor);
		}

		return new ResourceDescriptor(List.of(), descriptors);
	}

	@Override
	public ResourceDescriptor buildForPart(	ResourceDescriptorProvider provider,
											CompositeBuffer compositeBuffer)
	{
		return null;
	}
}
