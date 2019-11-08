package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;
import org.sheepy.vulkan.resource.staging.TransferBufferBackend;

@Statefull
@Adapter(scope = TransferBuffer.class)
public class TransferBufferAdapter implements ITransferBufferAdapter, IResourceAdapter
{
	private final TransferBufferBackend backendBuffer;

	public TransferBufferAdapter(TransferBuffer transferBuffer)
	{
		final long size = transferBuffer.getSize();
		final int instanceCount = transferBuffer.getInstanceCount();
		final boolean usedToPush = transferBuffer.isUsedToPush();
		final boolean usedToFetch = transferBuffer.isUsedToFetch();

		backendBuffer = new TransferBufferBackend(size, instanceCount, usedToPush, usedToFetch);
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		backendBuffer.allocate(context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		backendBuffer.free(context);
	}

	@Override
	public ITransferBuffer getTransferBufferBackend()
	{
		return backendBuffer;
	}
}
