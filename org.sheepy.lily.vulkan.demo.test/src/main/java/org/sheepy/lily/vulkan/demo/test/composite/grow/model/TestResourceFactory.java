package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.demo.test.composite.grow.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

class TestResourceFactory
{
	public static ResourceContainer build(int instanceCount)
	{
		final var transferBuffer = buildTransferBuffer();
		final var compositeBuffer = buildCompositeBuffer(transferBuffer, instanceCount);

		return new ResourceContainer(transferBuffer, compositeBuffer);
	}

	public static final class ResourceContainer
	{
		public final TransferBuffer transferBuffer;
		public final CompositeBuffer compositeBuffer;

		public ResourceContainer(TransferBuffer transferBuffer, CompositeBuffer compositeBuffer)
		{
			this.transferBuffer = transferBuffer;
			this.compositeBuffer = compositeBuffer;
		}
	}

	private static TransferBuffer buildTransferBuffer()
	{
		final var res = ResourceFactory.eINSTANCE.createTransferBuffer();
		res.setSize(TestDataProviderAdapter.MAX_SIZE);
		res.setInstanceCount(1);
		res.setUsedToFetch(true);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(TransferBuffer transferBuffer,
														int instanceCount)
	{
		final var res = ResourceFactory.eINSTANCE.createCompositeBuffer();

		res.setTransferBuffer(transferBuffer);

		final var providers = res.getDataProviders();
		final var provider = ResourceFactory.eINSTANCE.createBufferDataProvider();
		provider.setName(TestDataProviderAdapter.NAME);
		provider.setUsage(EBufferUsage.TRANSFER_SRC_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.TRANSFER_BIT);
		provider.setUsedToFetch(true);
		provider.setInstanceCount(instanceCount);

		providers.add(provider);

		return res;
	}
}
