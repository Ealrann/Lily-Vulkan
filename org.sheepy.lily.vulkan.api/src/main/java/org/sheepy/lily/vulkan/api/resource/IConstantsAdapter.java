package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.pipeline.IConstantsFiller;

public interface IConstantsAdapter extends IVulkanAdapter, IConstantsFiller
{
	ByteBuffer getData();

	boolean needRecord();

	public static IConstantsAdapter adapt(AbstractConstants constants)
	{
		return IAdapterFactoryService.INSTANCE.adapt(constants, IConstantsAdapter.class);
	}
}
