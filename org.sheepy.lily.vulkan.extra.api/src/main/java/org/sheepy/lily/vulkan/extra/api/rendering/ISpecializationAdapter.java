package org.sheepy.lily.vulkan.extra.api.rendering;

import java.nio.ByteBuffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;

public interface ISpecializationAdapter extends IVulkanAdapter
{
	int byteCount(ISpecialization specialization);
	void fillBuffer(ISpecialization specialization, ByteBuffer buffer);
}
