package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

public final class TaskManager
{
	private final List<FetchContext> fetchContexts;

	TaskManager(MemoryChunk memoryChunk)
	{
		this.fetchContexts = memoryChunk.parts()
										.stream()
										.filter(BufferMemory.class::isInstance)
										.map(BufferMemory.class::cast)
										.flatMap(m -> m.buffers().stream())
										.filter(BufferViewer.class::isInstance)
										.map(BufferViewer.class::cast)
										.map(TaskManager::buildFetchContext)
										.toList();
	}

	private static FetchContext buildFetchContext(BufferViewer bufferViewer)
	{
		final var fetchBuffer = FetchBuffer.builder()
										   .bufferReference(() -> buildBufferReference(bufferViewer))
										   .build();

		final var barrier = BufferBarrier.builder()
										 .buffers(() -> buildBufferReference(bufferViewer))
										 .addSrcAccessMask(EAccess.TRANSFER_WRITE_BIT)
										 .addDstAccessMask(EAccess.TRANSFER_READ_BIT)
										 .build();

		return new FetchContext(fetchBuffer, barrier);
	}

	private static BufferReference buildBufferReference(BufferViewer bufferViewer)
	{
		return BufferReference.builder()
							  .addBuffer(() -> bufferViewer)
							  .stride(0)
							  .indexType(EContextIndex.ContextInstance)
							  .build();
	}

	public void install(List<IPipelineTask> tasks)
	{
		final var pipelineBarrier = PipelineBarrier.builder()
												   .srcStage(EPipelineStage.TRANSFER_BIT)
												   .dstStage(EPipelineStage.TRANSFER_BIT)
												   .addBarriers(fetchContexts.stream().map(FetchContext::barrier).map(Barrier.class::cast).toList())
												   .build();

		tasks.add(pipelineBarrier);
		fetchContexts.stream().map(FetchContext::fetchTask).forEach(tasks::add);
	}

	private record FetchContext(FetchBuffer fetchTask, BufferBarrier barrier)
	{
	}
}

