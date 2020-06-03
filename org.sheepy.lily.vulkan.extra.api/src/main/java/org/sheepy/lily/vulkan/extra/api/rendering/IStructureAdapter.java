package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public interface IStructureAdapter extends IExtender
{
	int getPartCount(Structure structure);
	int getInstanceCount(Structure structure);
}
