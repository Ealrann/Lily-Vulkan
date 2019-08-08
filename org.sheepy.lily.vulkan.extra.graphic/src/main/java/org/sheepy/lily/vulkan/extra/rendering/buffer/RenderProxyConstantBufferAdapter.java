package org.sheepy.lily.vulkan.extra.rendering.buffer;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

@Statefull
@Adapter(scope = RenderProxyConstantBuffer.class)
public class RenderProxyConstantBufferAdapter implements IVulkanAdapter
{
	private final RenderProxyConstantBuffer proxyConstantBuffer;
	private final ConstantBuffer nestedConstantBuffer;

	private ByteBuffer buffer = null;

	private final AdapterImpl nestedBufferListener = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (notification.getFeature() == ResourcePackage.Literals.CONSTANT_BUFFER__DATA)
			{
				updateBuffer();
			}
		}
	};

	@Autorun
	public RenderProxyConstantBufferAdapter(RenderProxyConstantBuffer constantBuffer)
	{
		this.proxyConstantBuffer = constantBuffer;

		nestedConstantBuffer = constantBuffer.getConstantBuffer();
		if (nestedConstantBuffer != null)
		{
			nestedConstantBuffer.eAdapters().add(nestedBufferListener);
		}

		updateBuffer();
	}

	@Dispose
	public void dispose()
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
			dispose();
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
