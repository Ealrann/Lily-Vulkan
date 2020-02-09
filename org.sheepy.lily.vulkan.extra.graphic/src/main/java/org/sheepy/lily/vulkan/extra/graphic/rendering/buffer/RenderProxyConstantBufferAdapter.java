package org.sheepy.lily.vulkan.extra.graphic.rendering.buffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.nio.ByteBuffer;

@Statefull
@Adapter(scope = RenderProxyConstantBuffer.class, lazy = false)
public class RenderProxyConstantBufferAdapter implements IAdapter
{
	private final RenderProxyConstantBuffer proxyConstantBuffer;
	private final ConstantBuffer nestedConstantBuffer;
	private final INotificationListener nestedBufferListener = notification -> updateBuffer();

	private ByteBuffer buffer = null;

	public RenderProxyConstantBufferAdapter(RenderProxyConstantBuffer constantBuffer)
	{
		this.proxyConstantBuffer = constantBuffer;

		nestedConstantBuffer = constantBuffer.getConstantBuffer();
		if (nestedConstantBuffer != null)
		{
			nestedConstantBuffer.addListener(nestedBufferListener, VulkanResourcePackage.CONSTANT_BUFFER__DATA);
		}

		updateBuffer();
	}

	@Dispose
	public void dispose()
	{
		if (nestedConstantBuffer != null)
		{
			nestedConstantBuffer.removeListener(nestedBufferListener, VulkanResourcePackage.CONSTANT_BUFFER__DATA);
		}

		disposeBuffer();
	}

	private void disposeBuffer()
	{
		if (buffer != null)
		{
			MemoryUtil.memFree(buffer);
		}
	}

	private void updateBuffer()
	{
		int newSize = 4;

		if (nestedConstantBuffer != null && nestedConstantBuffer.getData() != null)
		{
			newSize += nestedConstantBuffer.getData().capacity();
		}

		if (buffer == null || buffer.capacity() != newSize)
		{
			disposeBuffer();
			buffer = MemoryUtil.memAlloc(newSize);
		}

		if (nestedConstantBuffer != null && nestedConstantBuffer.getData() != null)
		{
			final var data = nestedConstantBuffer.getData();
			buffer.put(data);
			data.flip();
		}

		buffer.putInt(proxyConstantBuffer.getPartIndex());
		buffer.flip();

		proxyConstantBuffer.setData(buffer);
	}
}
