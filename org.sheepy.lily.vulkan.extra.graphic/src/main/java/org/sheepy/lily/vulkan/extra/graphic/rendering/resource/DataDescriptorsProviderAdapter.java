package org.sheepy.lily.vulkan.extra.graphic.rendering.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

@Adapter(scope = DataDescriptorsProvider.class)
public class DataDescriptorsProviderAdapter implements IDescriptorProviderAdapter
{
	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider)
	{
		return null;
	}

	@Override
	public ResourceDescriptor buildForPart(	ResourceDescriptorProvider provider,
											CompositeBuffer compositeBuffer)
	{
		final List<IDescriptor> descriptors = new ArrayList<>();

		final var dataDescriptors = ((DataDescriptorsProvider) provider).getDataDescriptors();
		for (int i = 0; i < dataDescriptors.size(); i++)
		{
			final var dataDescriptor = dataDescriptors.get(i);

			final var descriptor = ResourceFactory.eINSTANCE.createBufferDescriptor();
			descriptor.setBuffer(compositeBuffer.getParts().get(dataDescriptor.getPart()));
			descriptor.setType(dataDescriptor.getDescriptorType());
			descriptor.getShaderStages().addAll(dataDescriptor.getStages());

			final var newDescriptor = EcoreUtil.copy(descriptor);
			descriptors.add(newDescriptor);
		}

		return new ResourceDescriptor(List.of(), descriptors);
	}
}
