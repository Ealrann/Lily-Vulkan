package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.vulkanresource.*;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;
import java.util.stream.Collectors;

public final class TaskManager
{
	private final List<FetchContext> fetchContexts;

	TaskManager(MemoryChunk memoryChunk)
	{
		this.fetchContexts = memoryChunk.getParts()
										.stream()
										.map(BufferMemory.class::cast)
										.map(BufferMemory::getBuffers)
										.flatMap(List::stream)
										.map(BufferViewer.class::cast)
										.map(TaskManager::buildFetchContext)
										.collect(Collectors.toUnmodifiableList());
	}

	private static FetchContext buildFetchContext(BufferViewer bufferViewer)
	{
		final var bufferReference = VulkanResourceFactory.eINSTANCE.createBufferReference();
		bufferReference.getBuffers().add(bufferViewer);
		bufferReference.setStride(0);

		final var fetchBuffer = ProcessFactory.eINSTANCE.createFetchBuffer();
		fetchBuffer.setDataProvider(bufferViewer.getDataProvider());
		fetchBuffer.setBufferReference(bufferReference);

		final var barrier = VulkanResourceFactory.eINSTANCE.createBufferBarrier();
		barrier.setBuffers(EcoreUtil.copy(bufferReference));
		barrier.getSrcAccessMask().add(EAccess.TRANSFER_WRITE_BIT);
		barrier.getDstAccessMask().add(EAccess.TRANSFER_READ_BIT);

		return new FetchContext(fetchBuffer, barrier);
	}

	public void install(List<IPipelineTask> tasks)
	{
		final var pipelineBarrier = ProcessFactory.eINSTANCE.createPipelineBarrier();
		pipelineBarrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier.setDstStage(EPipelineStage.TRANSFER_BIT);

		final EList<Barrier> barriers = pipelineBarrier.getBarriers();
		fetchContexts.stream().map(FetchContext::barrier).forEach(barriers::add);

		tasks.add(pipelineBarrier);
		fetchContexts.stream().map(FetchContext::fetchTask).forEach(tasks::add);
	}

	private record FetchContext(FetchBuffer fetchTask, BufferBarrier barrier)
	{
	}
}
