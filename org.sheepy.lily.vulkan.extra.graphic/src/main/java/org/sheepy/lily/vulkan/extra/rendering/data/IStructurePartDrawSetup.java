package org.sheepy.lily.vulkan.extra.rendering.data;

import java.util.List;

import org.sheepy.lily.vulkan.extra.api.mesh.data.IRenderDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public interface IStructurePartDrawSetup
{
	List<? extends IRenderDataProviderAdapter> getDataProviders();

	void update();

	Structure getStructure();
}
