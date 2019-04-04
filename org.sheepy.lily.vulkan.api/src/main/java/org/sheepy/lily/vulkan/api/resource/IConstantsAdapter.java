package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;

public interface IConstantsAdapter extends IVulkanAdapter
{
	void fillRange(VkPushConstantRange range, AbstractConstants constants);

	ByteBuffer getData();

	boolean needRecord();

	public static IConstantsAdapter adapt(AbstractConstants constants)
	{
		return IAdapterFactoryService.INSTANCE.adapt(constants, IConstantsAdapter.class);
	}
}