package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public interface IStructureAdapter extends IVulkanAdapter
{
	int getPartCount(Structure structure);
	int getInstanceCount(Structure structure);
}
