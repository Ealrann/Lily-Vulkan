package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;

public interface IMeshInstances
{
	IMesh getMesh();

	int getInstanceCount();

	IVkDescriptorSet getDescriptorSet();
}
