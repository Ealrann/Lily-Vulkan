package org.sheepy.lily.vulkan.extra.api.nuklear;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider;
import org.sheepy.lily.vulkan.model.resource.PathResource;

public interface IInputProviderAdapter extends IAdapter
{
	List<? extends Object> getElements(IInputProvider inputProvider);

	String getName(Object element);

	PathResource getImage(Object element);
}