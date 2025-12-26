package org.sheepy.lily.vulkan.extra.graphic.rendering.resource;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.util.ModelCopier;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = DescriptorsProvider.class)
@Adapter(singleton = true)
public class DescriptorProviderAdapter implements IDescriptorProviderAdapter
{
	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure)
	{
		final List<IDescriptor> descriptors = new ArrayList<>();
		final var copier = new ModelCopier();

		final var providedDescriptors = ((DescriptorsProvider) provider).descriptors();
		for (int i = 0; i < providedDescriptors.size(); i++)
		{
			final var descriptor = providedDescriptors.get(i);
			descriptors.add(copier.copyTree(descriptor));
		}

		return new ResourceDescriptor(List.of(), descriptors);
	}

	@Override
	public ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, Stream<BufferViewer> bufferViewers)
	{
		return null;
	}
}
