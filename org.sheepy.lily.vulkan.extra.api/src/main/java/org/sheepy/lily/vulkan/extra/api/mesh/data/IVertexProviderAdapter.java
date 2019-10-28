package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;

public interface IVertexProviderAdapter extends IBufferDataProviderAdapter
{
	int getVertexCount();
}
