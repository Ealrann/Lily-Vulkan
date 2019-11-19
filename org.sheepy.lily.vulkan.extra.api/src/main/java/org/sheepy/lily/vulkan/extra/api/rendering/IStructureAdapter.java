package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public interface IStructureAdapter extends IAdapter
{
	int getPartCount(Structure structure);
	int getInstanceCount(Structure structure);
}
