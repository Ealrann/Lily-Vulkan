package org.sheepy.lily.vulkan.extra.graphic.pipeline.mesh;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.extra.api.terrain.IMeshStagingBuffer;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshUniformDataProvider;
import org.sheepy.lily.vulkan.extra.api.terrain.data.IMeshVertexDataProvider;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.indexed.IndexedBufferWithUniform;

public class MeshStagingBuffer implements IAllocable, IMeshStagingBuffer
{
	private final GraphicProcess process;
	public final CPUBufferBackend vertexBuffer;
	public final CPUBufferBackend indexBuffer;
	public final CPUBufferBackend uniformBuffer;

	public MeshStagingBuffer(	GraphicProcess process,
								long vertexStagingCapacity,
								long indexStagingCapacity,
								long uniformStagingCapacity)
	{
		this.process = process;
		vertexBuffer = createStagingBuffer(vertexStagingCapacity);
		indexBuffer = createStagingBuffer(indexStagingCapacity);
		uniformBuffer = createStagingBuffer(uniformStagingCapacity);
	}

	private static CPUBufferBackend createStagingBuffer(final long uniformStaggingSize)
	{
		final var uniformStagingInfo = new BufferInfo(uniformStaggingSize,
				EBufferUsage.TRANSFER_SRC_BIT.getValue(), true);
		final var uniformStagingBuffer = new CPUBufferBackend(uniformStagingInfo, true);
		return uniformStagingBuffer;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		vertexBuffer.allocate(stack, context);
		indexBuffer.allocate(stack, context);
		uniformBuffer.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		vertexBuffer.free(context);
		indexBuffer.free(context);
		uniformBuffer.free(context);
	}

	@Override
	public void fillBufferWith(	IndexedBufferWithUniform<?> buffer,
								IMeshVertexDataProvider vertexDataProvider,
								IMeshVertexDataProvider indexDataProvider,
								List<IMeshUniformDataProvider> uniformDataProviders)
	{
		final long indexBufferMemoryMap = indexBuffer.getMemoryMap();
		indexDataProvider.fill(process, indexBufferMemoryMap);

		final long vertexBufferMemoryMap = vertexBuffer.getMemoryMap();
		vertexDataProvider.fill(process, vertexBufferMemoryMap);

		final long uniformAddress = uniformBuffer.getMemoryMap();
		int uniformCapacity = 0;
		for (final var dataProvider : uniformDataProviders)
		{
			dataProvider.fill(process, uniformAddress + uniformCapacity);
			uniformCapacity += dataProvider.getCapacity();
		}

		final int indexCount = indexDataProvider.getDataCount();
		final int vertexCount = vertexDataProvider.getDataCount();
		buffer.fillBuffer(indexBuffer, indexCount, vertexBuffer, vertexCount, uniformBuffer);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
