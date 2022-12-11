package org.sheepy.lily.vulkan.core.resource.buffer;

import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public interface IBufferBackend
{
	void free(IVulkanContext context);

	long getAddress();

	void pushData(IRecordContext recordContext, ByteBuffer data);
	void pushData(IRecordContext context, Consumer<ByteBuffer> dataProvider);
}
