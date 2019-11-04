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
	public static final int TARGET_BYTES = 100000;
	public static final String NAME = "TestDataProvider";

	private final Random random;

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
		return TARGET_BYTES;
	}

	@Override
	public void fill(long memoryAddress)
	{
		final int size = TARGET_BYTES / 4;
		previous = new int[size];
		final var buffer = MemoryUtil.memIntBuffer(memoryAddress, size);
		for (int i = 0; i < size; i++)
		{
			final int rand = random.nextInt();
			buffer.put(rand);
			previous[i] = rand;
		}
	}

	public boolean check(long memoryAddress)
	{
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
