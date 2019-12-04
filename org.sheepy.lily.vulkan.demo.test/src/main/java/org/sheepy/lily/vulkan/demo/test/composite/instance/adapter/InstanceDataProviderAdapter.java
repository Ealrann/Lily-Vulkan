package org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

@Statefull
@Adapter(scope = BufferDataProvider.class, name = InstanceDataProviderAdapter.NAME)
public class InstanceDataProviderAdapter implements IBufferDataProviderAdapter
{
	public static final String NAME = "InstanceDataProvider";

	public static final int SIZE = 4000000;

	private final Random random;

	private int[] previous = null;

	public InstanceDataProviderAdapter(BufferDataProvider<?> provider)
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
		return SIZE;
	}

	int index = 0;

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
			final int currentVal = intBuffer.get();
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
