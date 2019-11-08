package org.sheepy.lily.vulkan.demo.test.model;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.demo.test.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.Buffer;
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
		final var targetBuffers = List.copyOf(buildTargetBuffer(bufferCount));

		return new ResourceContainer(transferBuffer, compositeBuffer, targetBuffers);
	}

	public static final class ResourceContainer
	{
		public final TransferBuffer transferBuffer;
		public final CompositeBuffer compositeBuffer;
		public final List<Buffer> targetBuffers;

		public ResourceContainer(	TransferBuffer transferBuffer,
									CompositeBuffer compositeBuffer,
									List<Buffer> targetBuffers)
		{
			this.transferBuffer = transferBuffer;
			this.compositeBuffer = compositeBuffer;
			this.targetBuffers = List.copyOf(targetBuffers);
		}
	}

	private static TransferBuffer buildTransferBuffer(int bufferCount)
	{
		final var res = ResourceFactory.eINSTANCE.createTransferBuffer();
		res.setSize(TestDataProviderAdapter.MAX_SIZE * bufferCount);
		res.setInstanceCount(1);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(TransferBuffer transferBuffer, int bufferCount)
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

			providers.add(provider);
		}

		return res;
	}

	private static List<Buffer> buildTargetBuffer(int bufferCount)
	{
		final List<Buffer> res = new ArrayList<>();

		for (int i = 0; i < bufferCount; i++)
		{
			final var buffer = ResourceFactory.eINSTANCE.createBuffer();

			buffer.setKeptMapped(true);
			buffer.setHostVisible(true);
			buffer.setSize(TestDataProviderAdapter.MAX_SIZE);
			buffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);

			res.add(buffer);
		}

		return res;
	}
}
