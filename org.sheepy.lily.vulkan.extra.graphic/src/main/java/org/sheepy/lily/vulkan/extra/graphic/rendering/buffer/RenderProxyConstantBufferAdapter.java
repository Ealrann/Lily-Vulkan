package org.sheepy.lily.vulkan.extra.graphic.rendering.buffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.resource.buffer.IConstantBufferUpdater;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.nio.ByteBuffer;

@ModelExtender(scope = RenderProxyConstantBuffer.class)
@Adapter(lazy = false)
public class RenderProxyConstantBufferAdapter implements IConstantBufferUpdater
{
	private final RenderProxyConstantBuffer proxyConstantBuffer;
	private final ConstantBuffer nestedConstantBuffer;
	private final Runnable nestedBufferListener = this::updateBuffer;

	private IConstantBufferUpdater updater;
	private ByteBuffer buffer = null;

	public RenderProxyConstantBufferAdapter(RenderProxyConstantBuffer constantBuffer)
	{
		this.proxyConstantBuffer = constantBuffer;
		nestedConstantBuffer = constantBuffer.getConstantBuffer();
		updateBuffer();
	}

	@Load
	private void load()
	{
		if (nestedConstantBuffer != null)
		{
			nestedConstantBuffer.listenNoParam(nestedBufferListener, VulkanResourcePackage.CONSTANT_BUFFER__DATA);
			updater = nestedConstantBuffer.adapt(IConstantBufferUpdater.class);
		}
	}

	@Dispose
	public void dispose()
	{
		if (nestedConstantBuffer != null)
		{
			nestedConstantBuffer.sulkNoParam(nestedBufferListener, VulkanResourcePackage.CONSTANT_BUFFER__DATA);
		}

		disposeBuffer();
	}

	@Override
	public void beforePush(final ConstantBuffer buffer)
	{
		if (updater != null) updater.beforePush(nestedConstantBuffer);
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
