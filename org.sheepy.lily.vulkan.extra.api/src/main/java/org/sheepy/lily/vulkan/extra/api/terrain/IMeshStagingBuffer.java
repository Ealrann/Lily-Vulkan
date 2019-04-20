package org.sheepy.lily.vulkan.extra.api.terrain;

import java.util.List;

import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferWithUniform;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshUniformDataProvider;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshVertexDataProvider;

public interface IMeshStagingBuffer
{
	void fillBufferWith(IndexedBufferWithUniform<?> buffer,
						IMeshVertexDataProvider vertexDataProvider,
						IMeshVertexDataProvider indexDataProvider,
						List<IMeshUniformDataProvider> uniformDataProviders);
}
