package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.resource.IResource;

import java.util.List;

public interface IStructureResourceAdapter extends IExtender
{
	List<? extends IResource> getResources();
}
