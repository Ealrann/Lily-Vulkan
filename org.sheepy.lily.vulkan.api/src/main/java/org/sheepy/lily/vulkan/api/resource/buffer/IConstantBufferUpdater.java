package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;

public interface IConstantBufferUpdater extends IAdapter
{
	void beforePush(ConstantBuffer buffer);
}
