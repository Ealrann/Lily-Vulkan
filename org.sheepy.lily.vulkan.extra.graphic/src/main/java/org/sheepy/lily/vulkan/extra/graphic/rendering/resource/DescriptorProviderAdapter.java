package org.sheepy.lily.vulkan.extra.graphic.rendering.resource;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.BufferMemory;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = DescriptorsProvider.class)
@Adapter(singleton = true)
public class DescriptorProviderAdapter implements IDescriptorProviderAdapter
{
	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure)
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
	public ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, BufferMemory bufferMemory)
	{
		return null;
	}
}
