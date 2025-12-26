package org.sheepy.lily.vulkan.api.resource.buffer;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

public interface IConstantBufferUpdater extends IAdapter
{
	void beforePush(ConstantBuffer buffer);
}
