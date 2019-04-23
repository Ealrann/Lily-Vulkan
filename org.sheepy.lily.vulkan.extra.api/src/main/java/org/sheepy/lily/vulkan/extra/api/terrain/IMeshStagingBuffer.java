package org.sheepy.lily.vulkan.extra.api.terrain;

import java.util.List;

import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshUniformDataProvider;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshVertexDataProvider;
import org.sheepy.vulkan.resource.indexed.IndexedBufferWithUniform;

public interface IMeshStagingBuffer
{
	void fillBufferWith(IndexedBufferWithUniform<?> buffer,
						IMeshVertexDataProvider vertexDataProvider,
						IMeshVertexDataProvider indexDataProvider,
						List<IMeshUniformDataProvider> uniformDataProviders);
}
