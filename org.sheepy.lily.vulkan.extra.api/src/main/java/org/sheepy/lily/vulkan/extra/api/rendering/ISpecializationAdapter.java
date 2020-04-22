package org.sheepy.lily.vulkan.extra.api.rendering;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;

public interface ISpecializationAdapter extends IExtender
{
	int byteCount(ISpecialization specialization);
	void fillBuffer(ISpecialization specialization, ByteBuffer buffer);
}
