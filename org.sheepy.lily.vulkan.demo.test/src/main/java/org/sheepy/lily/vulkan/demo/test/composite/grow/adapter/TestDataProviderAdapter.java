package org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

@Statefull
@Adapter(scope = BufferDataProvider.class, name = TestDataProviderAdapter.NAME)
public class TestDataProviderAdapter implements IBufferDataProviderAdapter
{
	public static final String NAME = "TestDataProvider";

	public static final int MAX_SIZE = 4000000;

	private final Random random;

	public int currentSize = 100000;
	private int[] previous = null;

	public TestDataProviderAdapter(BufferDataProvider<?> provider)
	{
		@SuppressWarnings("unchecked")
		final var parentList = (List<EObject>) provider	.eContainer()
														.eGet(provider.eContainingFeature());
		final int index = parentList.indexOf(provider);

		random = new Random(index);
	}

	@Override
	public long requestedSize()
	{
		return currentSize;
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		final var intBuffer = buffer.asIntBuffer();
		final int intSize = intBuffer.capacity();
		previous = new int[intSize];
		for (int i = 0; i < intSize; i++)
		{
			final int rand = random.nextInt();
			intBuffer.put(rand);
			previous[i] = rand;
		}
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
		final var intBuffer = buffer.asIntBuffer();
		for (int i = 0; i < previous.length; i++)
		{
			final int prev = intBuffer.get();
			if (prev != previous[i])
			{
				throw new AssertionError("Data are not the same after fetch");
			}
		}

		currentSize += 40000;
		currentSize = Math.min(MAX_SIZE, currentSize);
		// System.out.println(currentSize);
	}

	@Override
	public boolean hasChanged()
	{
		return true;
	}

}
