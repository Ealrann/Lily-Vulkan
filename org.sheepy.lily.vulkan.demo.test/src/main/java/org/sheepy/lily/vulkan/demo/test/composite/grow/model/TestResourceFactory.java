package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public class TestResourceFactory
{
	public static final String BUFFER_NAME = "TestDataBuffer";

	static MemoryChunk build(int partCount)
	{
		return buildMemoryChunk(partCount);
	}

	private static MemoryChunk buildMemoryChunk(int partCount)
	{
		final var bufferMemoryBuilder = BufferMemory.builder();

		for (int i = 0; i < partCount; i++)
		{
			bufferMemoryBuilder.addBuffer(() -> BufferViewer.builder()
														   .name(BUFFER_NAME)
														   .dataSourceIdentifier(BUFFER_NAME)
														   .addUsage(EBufferUsage.TRANSFER_DST_BIT)
														   .addUsage(EBufferUsage.TRANSFER_SRC_BIT)
														   .build());
		}

		return MemoryChunk.builder()
						  .addPart(bufferMemoryBuilder::build)
						  .build();
	}
}

