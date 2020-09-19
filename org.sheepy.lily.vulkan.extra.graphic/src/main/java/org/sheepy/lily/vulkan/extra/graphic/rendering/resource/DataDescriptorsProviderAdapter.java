package org.sheepy.lily.vulkan.extra.graphic.rendering.resource;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
		final List<BufferViewer> bufferViewerList = bufferViewers.collect(Collectors.toUnmodifiableList());
		final List<IDescriptor> descriptors = new ArrayList<>();

		final var dataDescriptors = ((DataDescriptorsProvider) provider).getDataDescriptors();
		for (int i = 0; i < dataDescriptors.size(); i++)
		{
			final var dataDescriptor = dataDescriptors.get(i);

			final var descriptor = VulkanResourceFactory.eINSTANCE.createBufferDescriptor();
			descriptor.setBuffer(bufferViewerList.get(dataDescriptor.getPart()));
			descriptor.setType(dataDescriptor.getDescriptorType());
			descriptor.getShaderStages().addAll(dataDescriptor.getStages());

			final var newDescriptor = EcoreUtil.copy(descriptor);
			descriptors.add(newDescriptor);
		}

		return new ResourceDescriptor(List.of(), descriptors);
	}
}
