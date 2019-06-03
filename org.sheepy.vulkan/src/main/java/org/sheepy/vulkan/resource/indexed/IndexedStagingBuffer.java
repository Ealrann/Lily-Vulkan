package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;

public class IndexedStagingBuffer implements IAllocable<IExecutionContext>
{
	private final CPUBufferBackend stagingBuffer;
	private final IndexedBuffer indexedBuffer;
	private final int vertexBufferSize;
	private final int indexBufferSize;

	private long vertexMemoryMap = -1;
	private long indexMemoryMap = -1;

	private ExecutionContext context = null;

	private VkBufferCopy.Buffer vertexCopyInfo;
	private VkBufferCopy.Buffer indexCopyInfo;

	public IndexedStagingBuffer(IndexedBuffer indexedBuffer, boolean coherent)
	{
		this.indexedBuffer = indexedBuffer;
		vertexBufferSize = indexedBuffer.getVertexBufferCapacity();
		indexBufferSize = indexedBuffer.getIndexBufferCapacity();

		final int transferBit = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

		final var info = new BufferInfo(vertexBufferSize + indexBufferSize, transferBit, true);

		stagingBuffer = new CPUBufferBackend(info, coherent);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext allocContext)
	{
		context = (ExecutionContext) allocContext;

		stagingBuffer.allocate(stack, context);

		final int vertexOffset = indexedBuffer.getVertexMemoryOffset();
		final int indexOffset = indexedBuffer.getIndexMemoryOffset();

		vertexCopyInfo = VkBufferCopy.malloc(1);
		vertexCopyInfo.get(0).set(0, vertexOffset, vertexBufferSize);

		indexCopyInfo = VkBufferCopy.malloc(1);
		indexCopyInfo.get(0).set(vertexBufferSize, indexOffset, indexBufferSize);
	}

	@Override
	public void free(IExecutionContext context)
	{
		stagingBuffer.free(context);

		vertexCopyInfo.free();
		indexCopyInfo.free();

		vertexCopyInfo = null;
		indexCopyInfo = null;
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}

	public void mapMemory()
	{
		vertexMemoryMap = stagingBuffer.mapMemory();
		indexMemoryMap = vertexMemoryMap + vertexBufferSize;
	}

	public void unmapMemory()
	{
		stagingBuffer.unmapMemory();
	}

	public long getVertexMemoryMap()
	{
		return vertexMemoryMap;
	}

	public long getIndexMemoryMap()
	{
		return indexMemoryMap;
	}

	public void pushData()
	{
		final var srcBufferAddress = stagingBuffer.getAddress();
		final var dstVertexAddress = indexedBuffer.getVertexBufferAddress();
		final var dstIndexAddress = indexedBuffer.getIndexBufferAddress();

		context.execute((MemoryStack stack, VkCommandBuffer commandBuffer) -> {
			vkCmdCopyBuffer(commandBuffer, srcBufferAddress, dstVertexAddress, vertexCopyInfo);
			vkCmdCopyBuffer(commandBuffer, srcBufferAddress, dstIndexAddress, indexCopyInfo);
		});
	}
}
