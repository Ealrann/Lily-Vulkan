package org.sheepy.lily.vulkan.extra.graphic.rendering.resource;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.util.ModelCopier;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = DataDescriptorsProvider.class)
@Adapter(singleton = true)
public class DataDescriptorsProviderAdapter implements IDescriptorProviderAdapter
{
	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure)
	{
		return null;
	}

	@Override
	public ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, Stream<BufferViewer> bufferViewers)
	{
		final List<BufferViewer> bufferViewerList = bufferViewers.toList();
		final List<IDescriptor> descriptors = new ArrayList<>();
		final var copier = new ModelCopier();

		final var dataDescriptors = ((DataDescriptorsProvider) provider).dataDescriptors();
		for (int i = 0; i < dataDescriptors.size(); i++)
		{
			final var dataDescriptor = dataDescriptors.get(i);

			final var descriptor = BufferDescriptor.builder()
												   .buffer(() -> bufferViewerList.get(dataDescriptor.part()))
												   .type(dataDescriptor.descriptorType())
												   .addShaderStages(dataDescriptor.stages())
												   .build();

			descriptors.add(copier.copyTree(descriptor));
		}

		return new ResourceDescriptor(List.of(), descriptors);
	}
}
