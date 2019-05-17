package org.sheepy.lily.vulkan.api.resource.mesh.data;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public interface IMeshIndexDataProvider extends IMeshDataProvider
{
	@Override
	default int getUsage()
	{
		return EBufferUsage.INDEX_BUFFER_BIT_VALUE;
	}

	int getDataCount();
}
