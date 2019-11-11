package org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;

@Statefull
@Adapter(scope = DescribedDataProvider.class, name = InstanceDataProviderAdapter.NAME)
public class InstanceDataProviderAdapter implements IBufferDataProviderAdapter
{
	public static final String NAME = "InstanceDataProvider";

	public static final int SIZE = 4000000;

	private final Random random;

	private int[] previous = null;

	public InstanceDataProviderAdapter(DescribedDataProvider<?> provider)
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
		return SIZE;
	}

	int index = 0;

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
	{
		final var buffer = MemoryUtil.memIntBuffer(memoryAddress, previous.length);
		for (int i = 0; i < previous.length; i++)
		{
			final int currentVal = buffer.get();
			final int prevIncr = previous[i] + 1;
			if (currentVal != prevIncr)
			{
				System.out.print(String.format(	"\t- Failed step %d: %d != %d",
												i,
												currentVal,
												prevIncr));

				i = previous.length;
				throw new AssertionError("Data are not the same after fetch");
			}
		}
	}

	@Override
	public boolean hasChanged()
	{
		return true;
	}

}
