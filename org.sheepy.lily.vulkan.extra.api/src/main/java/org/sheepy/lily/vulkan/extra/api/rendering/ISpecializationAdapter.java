package org.sheepy.lily.vulkan.extra.api.rendering;

import java.nio.ByteBuffer;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;

public interface ISpecializationAdapter extends IAdapter
{
	int byteCount(ISpecialization specialization);
	void fillBuffer(ISpecialization specialization, ByteBuffer buffer);
}
