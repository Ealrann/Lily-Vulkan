package org.sheepy.lily.vulkan.demo.test.model;

import org.sheepy.lily.vulkan.demo.test.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

class TestResourceFactory
{
	public static ResourceContainer build(int bufferCount)
	{
		final var transferBuffer = buildTransferBuffer(bufferCount);
		final var compositeBuffer = buildCompositeBuffer(transferBuffer, bufferCount);

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

	private static TransferBuffer buildTransferBuffer(int bufferCount)
	{
		final var res = ResourceFactory.eINSTANCE.createTransferBuffer();
		res.setSize(TestDataProviderAdapter.MAX_SIZE * bufferCount);
		res.setInstanceCount(1);
		res.setUsedToFetch(true);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(TransferBuffer transferBuffer,
														int bufferCount)
	{
		final var res = ResourceFactory.eINSTANCE.createCompositeBuffer();

		res.setTransferBuffer(transferBuffer);

		final var providers = res.getDataProviders();
		for (int i = 0; i < bufferCount; i++)
		{
			final var provider = ResourceFactory.eINSTANCE.createBufferDataProvider();
			provider.setName(TestDataProviderAdapter.NAME);
			provider.setUsage(EBufferUsage.TRANSFER_SRC_BIT);
			provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
			provider.setStageBeforeFetch(EPipelineStage.TRANSFER_BIT);
			provider.setUsedToFetch(true);

			providers.add(provider);
		}

		return res;
	}
}
