package org.sheepy.lily.vulkan.resource.buffer;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notifier;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
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

	@SuppressWarnings({"unchecked", "rawtypes"})
	private BufferViewerAdapter(BufferViewer bufferViewer, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size));
		this.bufferViewer = bufferViewer;

		final var dataProviderAdapter = adaptDataSource(IGenericBufferDataSupplier.class);
		bufferViewer.size(computeFreshSize(dataProviderAdapter.size()));

		observatory.focus((org.logoce.lmf.core.api.notification.INotifier) dataProviderAdapter)
				   .listen((LongConsumer) this::sizeRequest, IGenericBufferDataSupplier.Features.Size);
	}

	@Override
	public <T extends IAdapter> T adaptDataSource(final Class<T> type)
	{
		final var identifier = bufferViewer.dataSourceIdentifier();
		final var dataSource = bufferViewer.dataSource() != null ? bufferViewer.dataSource() : bufferViewer;
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
			bufferViewer.size(newSize);
			notify(Features.Size, newSize);
		}
	}

	@Override
	public long getSize(final IBuffer buffer)
	{
		return bufferViewer.size();
	}

	private boolean needResize(long requestedSize)
	{
		final float growSize = bufferViewer.size() * bufferViewer.growThreshold();
		return requestedSize > growSize;
	}

	private long computeFreshSize(long requestedSize)
	{
		final float growFactor = bufferViewer.growFactor();
		final long size = (long) Math.ceil(requestedSize * growFactor);

		return Math.max(size, 1);
	}
}

