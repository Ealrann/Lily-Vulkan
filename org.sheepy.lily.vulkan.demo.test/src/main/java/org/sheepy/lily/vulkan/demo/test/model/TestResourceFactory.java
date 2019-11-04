package org.sheepy.lily.vulkan.demo.test.model;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.demo.test.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

class TestResourceFactory
{
	public static ResourceContainer build(int bufferCount)
	{
		final var pushBuffer = buildPushBuffer(bufferCount);
		final var compositeBuffer = buildCompositeBuffer(pushBuffer, bufferCount);
		final var targetBuffers = List.copyOf(buildTargetBuffer(bufferCount));

		return new ResourceContainer(pushBuffer, compositeBuffer, targetBuffers);
	}

	public static final class ResourceContainer
	{
		public final PushBuffer pushBuffer;
		public final CompositeBuffer compositeBuffer;
		public final List<Buffer> targetBuffers;

		public ResourceContainer(	PushBuffer pushBuffer,
									CompositeBuffer compositeBuffer,
									List<Buffer> targetBuffers)
		{
			this.pushBuffer = pushBuffer;
			this.compositeBuffer = compositeBuffer;
			this.targetBuffers = List.copyOf(targetBuffers);
		}
	}

	private static PushBuffer buildPushBuffer(int bufferCount)
	{
		final var res = ResourceFactory.eINSTANCE.createPushBuffer();
		res.setSize(TestDataProviderAdapter.TARGET_BYTES * bufferCount);
		res.setInstanceCount(1);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(PushBuffer pushBuffer, int bufferCount)
	{
		final var res = ResourceFactory.eINSTANCE.createCompositeBuffer();

		res.setPushBuffer(pushBuffer);

		final var providers = res.getDataProviders();
		for (int i = 0; i < bufferCount; i++)
		{
			final var provider = ResourceFactory.eINSTANCE.createBufferDataProvider();
			provider.setName(TestDataProviderAdapter.NAME);
			provider.setUsage(EBufferUsage.TRANSFER_SRC_BIT);

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
			buffer.setSize(TestDataProviderAdapter.TARGET_BYTES);
			buffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);

			res.add(buffer);
		}

		return res;
	}
}
