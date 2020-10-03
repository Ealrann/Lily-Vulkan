package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataSupplier;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferViewerAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.nio.ByteBuffer;

@ModelExtender(scope = BufferViewer.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = BufferMemory.class, type = BufferMemoryAllocation.class)
public final class BufferViewerAllocation implements IBufferAllocation
{
	private final BufferViewer bufferViewer;
	private final long bufferPtr;
	private final BufferMemoryAllocation bufferMemoryAllocation;
	private final AlignmentData alignmentData;
	private boolean needPush = true;

	@SuppressWarnings("unchecked")
	private BufferViewerAllocation(final BufferViewer bufferViewer,
								   final IObservatoryBuilder observatory,
								   final @InjectDependency(index = 0) BufferMemoryAllocation bufferMemoryAllocation)
	{
		this.bufferViewer = bufferViewer;
		this.bufferPtr = bufferMemoryAllocation.getBufferPtr();
		this.bufferMemoryAllocation = bufferMemoryAllocation;
		this.alignmentData = bufferMemoryAllocation.getAlignmentData(bufferViewer);

		final var dataSupplier = bufferViewer.adapt(IBufferViewerAdapter.class)
											 .adaptDataSource(IGenericBufferDataSupplier.class);

		observatory.focus(dataSupplier).listenNoParam(this::requestPush, IGenericBufferDataSupplier.Features.Data);
	}

	private void requestPush()
	{
		needPush = true;
		bufferMemoryAllocation.requestPush();
	}

	@Override
	public void fillData(ByteBuffer buffer)
	{
		final var dataSupplier = bufferViewer.adapt(IBufferViewerAdapter.class)
											 .adaptDataSource(IGenericBufferDataSupplier.class);
		dataSupplier.fill(buffer);
		needPush = false;
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		bufferMemoryAllocation.attach(recordContext);
	}

	@Override
	public boolean needPush()
	{
		return needPush;
	}

	@Override
	public long getPtr()
	{
		return bufferPtr;
	}

	@Override
	public long getBindOffset()
	{
		return alignmentData.offset();
	}

	@Override
	public long getBindSize()
	{
		return alignmentData.size();
	}
}
