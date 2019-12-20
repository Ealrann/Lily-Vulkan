package org.sheepy.lily.vulkan.extra.api.nuklear;

import java.util.List;

import org.joml.Vector3fc;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider;

public interface ISelectorInputProviderAdapter extends IAdapter
{
	List<? extends Object> getElements(IInputProvider inputProvider);

	String getName(Object element);

	FileResource getImage(Object element);

	Vector3fc getColor(Object element);
}
