package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.demo.test.composite.grow.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

class TestResourceFactory
{
	public static ResourceContainer build(int partCount)
	{
		final var transferBuffer = buildTransferBuffer();
		final var compositeBuffer = buildCompositeBuffer(partCount);

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
		res.setUsedToFetch(true);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(int partCount)
	{
		final var res = ResourceFactory.eINSTANCE.createCompositeBuffer();

		final var provider = ResourceFactory.eINSTANCE.createBufferDataProvider();
		provider.setName(TestDataProviderAdapter.NAME);
		provider.getUsages().add(EBufferUsage.TRANSFER_SRC_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.TRANSFER_BIT);
		provider.setUsedToFetch(true);

		final var parts = res.getParts();
		for (int i = 0; i < partCount; i++)
		{
			final var bufferPart = ResourceFactory.eINSTANCE.createBufferPart();
			bufferPart.setDataProvider(EcoreUtil.copy(provider));

			parts.add(bufferPart);
		}

		return res;
	}
}
