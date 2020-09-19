package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;
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
		final var res = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		final var bufferMemory = VulkanResourceFactory.eINSTANCE.createBufferMemory();

		for (int i = 0; i < partCount; i++)
		{
			final var bufferViewer = VulkanResourceFactory.eINSTANCE.createBufferViewer();
			bufferViewer.setName(BUFFER_NAME);
			bufferViewer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
			bufferViewer.getUsages().add(EBufferUsage.TRANSFER_SRC_BIT);
			bufferMemory.getBuffers().add(bufferViewer);
		}

		res.getParts().add(bufferMemory);
		return res;
	}
}
