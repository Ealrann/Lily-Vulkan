package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.BufferMemory;
import org.sheepy.lily.vulkan.model.resource.BufferViewer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferObjectAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.nio.ByteBuffer;

@ModelExtender(scope = BufferViewer.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = BufferMemory.class, type = BufferMemoryAllocation.class)
public final class BufferViewerAllocation implements IBufferObjectAllocation
{
	private final BufferViewer bufferViewer;
	private final long bufferPtr;
	private final BufferMemoryAllocation bufferMemoryAllocation;
	private final AlignmentData alignmentData;
	private boolean needPush = true;

	private BufferViewerAllocation(BufferViewer bufferViewer,
								   IObservatoryBuilder observatory,
								   @InjectDependency(index = 0) BufferMemoryAllocation bufferMemoryAllocation)
	{
		this.bufferViewer = bufferViewer;
		this.bufferPtr = bufferMemoryAllocation.getBufferPtr();
		this.bufferMemoryAllocation = bufferMemoryAllocation;
		this.alignmentData = bufferMemoryAllocation.getAlignmentData(bufferViewer);

		final var dataProviderObservatory = observatory.explore(VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER)
													   .adaptNotifier(IBufferDataProviderAdapter.class);
		dataProviderObservatory.listenNoParam(this::requestPush, IBufferDataProviderAdapter.Features.Data);
	}

	private void requestPush()
	{
		needPush = true;
		bufferMemoryAllocation.requestPush();
	}

	@Override
	public void fillData(ByteBuffer buffer)
	{
		final var bufferDataProvider = bufferViewer.getDataProvider().adapt(IBufferDataProviderAdapter.class);
		bufferDataProvider.fill(buffer);
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
	public long getMemoryPtr()
	{
		return 0;
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

	@Override
	public void flush()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void invalidate()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void pushData(ByteBuffer data)
	{
		throw new AssertionError("Unsupported Operation");
	}
}
