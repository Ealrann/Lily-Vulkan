package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.resource.CircularBuffer;
import org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryPartAdapter;

import java.util.List;

@ModelExtender(scope = CircularBuffer.class)
@Adapter(lazy = false)
public final class CircularBufferAdapter extends Notifier<IMemoryPartAdapter.Features> implements IMemoryPartAdapter
{
	private final CircularBuffer circularBuffer;
	private final IBufferDataProviderAdapter dataProviderAdapter;

	private CircularBufferAdapter(CircularBuffer circularBuffer, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size));
		dataProviderAdapter = circularBuffer.getDataProvider().adapt(IBufferDataProviderAdapter.class);
		this.circularBuffer = circularBuffer;
		circularBuffer.setSize(computeFreshSize(dataProviderAdapter.size()));

		observatory.explore(VulkanResourcePackage.CIRCULAR_BUFFER__DATA_PROVIDER)
				   .adaptNotifier(IBufferDataProviderAdapter.class)
				   .listenNoParam(this::sizeRequest, IBufferDataProviderAdapter.Features.Size);
	}

	private void sizeRequest()
	{
		final long requestedSize = dataProviderAdapter.size();
		if (needResize(requestedSize))
		{
			final long newSize = computeFreshSize(requestedSize);
			circularBuffer.setSize(newSize);
			notify(Features.Size, newSize);
		}
	}

	@Override
	public long getSize(final IMemoryChunkPart buffer)
	{
		return circularBuffer.getSize();
	}

	@Override
	public int getUsage(final IMemoryChunkPart buffer)
	{
		return VulkanModelUtil.getEnumeratedFlag(circularBuffer.getUsages());
	}

	private boolean needResize(long requestedSize)
	{
		final float growSize = circularBuffer.getSize() * circularBuffer.getGrowThreshold();
		return requestedSize > growSize;
	}

	private long computeFreshSize(long requestedSize)
	{
		final float growFactor = circularBuffer.getGrowFactor();
		final long size = (long) Math.ceil(requestedSize * growFactor);

		return Math.max(size, 1);
	}
}
