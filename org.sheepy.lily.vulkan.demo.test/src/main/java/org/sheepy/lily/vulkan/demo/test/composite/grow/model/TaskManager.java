package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.resource.CircularBuffer;
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
									   .map(CircularBuffer.class::cast)
									   .map(TaskManager::buildFetchBuffer)
									   .collect(Collectors.toUnmodifiableList());
	}

	private static FetchBuffer buildFetchBuffer(CircularBuffer circularBuffer)
	{
		final var bufferReference = VulkanResourceFactory.eINSTANCE.createFixedBufferReference();
		bufferReference.getBuffers().add(circularBuffer);

		final var fetchBuffer = ProcessFactory.eINSTANCE.createFetchBuffer();

		fetchBuffer.setDataProvider(circularBuffer.getDataProvider());
		fetchBuffer.setBufferReference(bufferReference);

		return fetchBuffer;
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.addAll(fetchBuffers);
	}
}
