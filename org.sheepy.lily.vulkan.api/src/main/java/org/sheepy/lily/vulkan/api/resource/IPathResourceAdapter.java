package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;

public interface IPathResourceAdapter extends IAdapter
{
	ByteBuffer allocByteBuffer(PathResource resource);
}
