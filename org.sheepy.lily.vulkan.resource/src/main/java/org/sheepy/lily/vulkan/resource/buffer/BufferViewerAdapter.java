package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataSupplier;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferViewerAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;

import java.util.List;
import java.util.function.LongConsumer;

@ModelExtender(scope = BufferViewer.class)
@Adapter
public final class BufferViewerAdapter extends Notifier<IBufferAdapter.Features> implements IBufferAdapter,
																							IBufferViewerAdapter
{
	private final BufferViewer bufferViewer;

	@SuppressWarnings("unchecked")
	private BufferViewerAdapter(BufferViewer bufferViewer, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size));
		this.bufferViewer = bufferViewer;

		final var dataProviderAdapter = adaptDataSource(IGenericBufferDataSupplier.class);
		bufferViewer.setSize(computeFreshSize(dataProviderAdapter.size()));

		observatory.focus(dataProviderAdapter)
				   .listen((LongConsumer) this::sizeRequest, IGenericBufferDataSupplier.Features.Size);
	}

	@Override
	public <T extends IExtender> T adaptDataSource(final Class<T> type)
	{
		final var identifier = bufferViewer.getDataSourceIdentifier();
		final var dataSource = bufferViewer.getDataSource() != null ? bufferViewer.getDataSource() : bufferViewer;
		final var dataProviderAdapter = identifier == null
				? dataSource.adaptNotNull(type)
				: dataSource.adaptNotNull(type, identifier);
		return dataProviderAdapter;
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
