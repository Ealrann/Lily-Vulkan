package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.demo.test.composite.grow.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

class TestResourceFactory
{
	public static MemoryChunk build(int partCount)
	{
		return buildMemoryChunk(partCount);
	}

	private static MemoryChunk buildMemoryChunk(int partCount)
	{
		final var res = VulkanResourceFactory.eINSTANCE.createMemoryChunk();

		final var provider = VulkanResourceFactory.eINSTANCE.createBufferDataProvider();
		provider.setName(TestDataProviderAdapter.NAME);
		provider.getUsages().add(EBufferUsage.TRANSFER_SRC_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.TRANSFER_BIT);
		provider.getAccessBeforeFetch().add(EAccess.TRANSFER_WRITE_BIT);
		provider.setUsedToFetch(true);

		final var parts = res.getParts();
		for (int i = 0; i < partCount; i++)
		{
			final var bufferViewer = VulkanResourceFactory.eINSTANCE.createBufferViewer();
			bufferViewer.setDataProvider(EcoreUtil.copy(provider));
			parts.add(bufferViewer);
		}

		return res;
	}
}
