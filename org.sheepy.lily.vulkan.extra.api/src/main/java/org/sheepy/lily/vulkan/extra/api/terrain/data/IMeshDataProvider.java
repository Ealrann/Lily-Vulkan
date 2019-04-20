package org.sheepy.lily.vulkan.extra.api.terrain.data;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

public interface IMeshDataProvider
{
	int getCapacity();
	int getDataCount();
	void fill(GraphicProcess process, long bufferAddress);

	boolean hasChanged();
}
