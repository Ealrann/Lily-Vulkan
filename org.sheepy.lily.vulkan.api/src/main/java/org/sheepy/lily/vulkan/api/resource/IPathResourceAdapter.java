package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;

public interface IPathResourceAdapter extends IVulkanAdapter
{
	ByteBuffer allocByteBuffer(PathResource resource);
}
