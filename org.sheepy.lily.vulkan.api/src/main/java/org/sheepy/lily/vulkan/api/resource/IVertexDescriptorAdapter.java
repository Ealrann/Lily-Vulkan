package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor;
import org.sheepy.vulkan.resource.indexed.VkVertexDescriptor;

public interface IVertexDescriptorAdapter extends IVulkanAdapter
{
	VkVertexDescriptor buildVertexDescriptor(VertexDescriptor descriptor);

	public static IVertexDescriptorAdapter adapt(VertexDescriptor vertexDescriptor)
	{
		return IAdapterFactoryService.INSTANCE.adapt(vertexDescriptor,
				IVertexDescriptorAdapter.class);
	}
}
