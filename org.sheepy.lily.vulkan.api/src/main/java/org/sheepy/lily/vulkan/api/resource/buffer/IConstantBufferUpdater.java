package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

public interface IConstantBufferUpdater extends IExtender
{
	void beforePush(ConstantBuffer buffer);
}
