package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;

import java.util.List;

@ModelExtender(scope = BufferViewer.class)
@Adapter(lazy = false)
public final class BufferViewerAdapter extends Notifier<IBufferAdapter.Features> implements IBufferAdapter
{
	private final BufferViewer bufferViewer;

	private BufferViewerAdapter(BufferViewer bufferViewer, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size));
		final var dataProviderAdapter = bufferViewer.getDataProvider().adapt(IBufferDataProviderAdapter.class);
		this.bufferViewer = bufferViewer;
		bufferViewer.setSize(computeFreshSize(dataProviderAdapter.size()));

		observatory.explore(VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER)
				   .adaptNotifier(IBufferDataProviderAdapter.class)
				   .listen(this::sizeRequest, IBufferDataProviderAdapter.Features.Size);
	}

	private void sizeRequest(long requestedSize)
	{
		if (needResize(requestedSize))
		{
			final long newSize = computeFreshSize(requestedSize);
			bufferViewer.setSize(newSize);
			notify(Features.Size, newSize);
		}
	}

	@Override
	public long getSize(final IBuffer buffer)
	{
		return bufferViewer.getSize();
	}

	private boolean needResize(long requestedSize)
	{
		final float growSize = bufferViewer.getSize() * bufferViewer.getGrowThreshold();
		return requestedSize > growSize;
	}

	private long computeFreshSize(long requestedSize)
	{
		final float growFactor = bufferViewer.getGrowFactor();
		final long size = (long) Math.ceil(requestedSize * growFactor);

		return Math.max(size, 1);
	}
}
