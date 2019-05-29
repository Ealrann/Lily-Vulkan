package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public interface IMeshVertexDataProvider extends IMeshDataProvider
{
	@Override
	default int getUsage()
	{
		return EBufferUsage.VERTEX_BUFFER_BIT_VALUE;
	}
}
