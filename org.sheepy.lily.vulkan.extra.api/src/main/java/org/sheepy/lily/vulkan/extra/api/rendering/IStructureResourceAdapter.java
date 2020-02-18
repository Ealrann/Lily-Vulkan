package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.resource.IResource;

import java.util.List;

public interface IStructureResourceAdapter extends IAdapter
{
	List<? extends IResource> getResources();
}
