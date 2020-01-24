package org.sheepy.lily.vulkan.extra.graphic.rendering.data;

import java.util.List;

import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

public interface IStructurePartDrawSetup
{
	List<BufferDataProvider<?>> getDataProviders();

	Structure getStructure();
}
