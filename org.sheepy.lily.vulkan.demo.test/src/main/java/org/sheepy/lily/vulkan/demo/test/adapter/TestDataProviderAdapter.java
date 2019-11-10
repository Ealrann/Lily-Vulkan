package org.sheepy.lily.vulkan.demo.test.adapter;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

@Statefull
@Adapter(scope = BufferDataProvider.class, name = TestDataProviderAdapter.NAME)
public class TestDataProviderAdapter implements IBufferDataProviderAdapter
{
	public static final String NAME = "TestDataProvider";

	public static final int MAX_SIZE = 1000000;

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
	public long getSize()
	{
		return currentSize;
	}

	@Override
	public void fill(long memoryAddress, int size)
	{
		final int intSize = size / 4;
		previous = new int[intSize];
		final var buffer = MemoryUtil.memIntBuffer(memoryAddress, intSize);
		for (int i = 0; i < intSize; i++)
		{
			final int rand = random.nextInt();
			buffer.put(rand);
			previous[i] = rand;
		}
	}

	@Override
	public void fetch(long memoryAddress, int size)
	{}

	public boolean check(long memoryAddress)
	{
		currentSize += 5000;
		currentSize = Math.min(MAX_SIZE, currentSize);

		final var buffer = MemoryUtil.memIntBuffer(memoryAddress, previous.length);
		for (int i = 0; i < previous.length; i++)
		{
			final int prev = buffer.get();
			if (prev != previous[i])
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean hasChanged()
	{
		return true;
	}

}
