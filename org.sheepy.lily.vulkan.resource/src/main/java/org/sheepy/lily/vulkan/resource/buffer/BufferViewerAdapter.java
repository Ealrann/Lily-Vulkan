package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.resource.BufferViewer;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferObjectAdapter;

import java.util.List;

@ModelExtender(scope = BufferViewer.class)
@Adapter(lazy = false)
public final class BufferViewerAdapter extends Notifier<IBufferObjectAdapter.Features> implements IBufferObjectAdapter
{
	private final BufferViewer bufferViewer;
	private final IBufferDataProviderAdapter dataProviderAdapter;

	private BufferViewerAdapter(BufferViewer bufferViewer, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size));
		dataProviderAdapter = bufferViewer.getDataProvider().adapt(IBufferDataProviderAdapter.class);
		this.bufferViewer = bufferViewer;
		bufferViewer.setSize(computeFreshSize(dataProviderAdapter.size()));

		observatory.explore(VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER)
				   .adaptNotifier(IBufferDataProviderAdapter.class)
				   .listenNoParam(this::sizeRequest, IBufferDataProviderAdapter.Features.Size);
	}

	private void sizeRequest()
	{
		final long requestedSize = dataProviderAdapter.size();
		if (needResize(requestedSize))
		{
			final long newSize = computeFreshSize(requestedSize);
			bufferViewer.setSize(newSize);
			notify(Features.Size, newSize);
		}
	}

	@Override
	public long getSize(final IBufferObject buffer)
	{
		return bufferViewer.getSize();
	}

	@Override
	public int getUsage(final IBufferObject buffer)
	{
		return VulkanModelUtil.getEnumeratedFlag(bufferViewer.getUsages());
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
