package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.resource.BufferMemory;
import org.sheepy.lily.vulkan.model.resource.BufferViewer;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;

import java.util.List;
import java.util.stream.Collectors;

public final class TaskManager
{
	public final List<FetchBuffer> fetchBuffers;

	TaskManager(MemoryChunk memoryChunk)
	{
		this.fetchBuffers = memoryChunk.getParts()
									   .stream()
									   .map(BufferMemory.class::cast)
									   .map(BufferMemory::getBuffers)
									   .flatMap(List::stream)
									   .map(BufferViewer.class::cast)
									   .map(TaskManager::buildFetchBuffer)
									   .collect(Collectors.toUnmodifiableList());
	}

	private static FetchBuffer buildFetchBuffer(BufferViewer bufferViewer)
	{
		final var bufferReference = VulkanResourceFactory.eINSTANCE.createBufferReference();
		bufferReference.getBuffers().add(bufferViewer);
		bufferReference.setStride(0);

		final var fetchBuffer = ProcessFactory.eINSTANCE.createFetchBuffer();
		fetchBuffer.setDataProvider(bufferViewer.getDataProvider());
		fetchBuffer.setBufferReference(bufferReference);

		return fetchBuffer;
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.addAll(fetchBuffers);
	}
}
