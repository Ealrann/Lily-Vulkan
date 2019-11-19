package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;

public interface ITransferBufferAdapter extends IAdapter
{
	ITransferBuffer getTransferBufferBackend();
}
