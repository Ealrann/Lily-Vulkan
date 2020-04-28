package org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

import java.nio.ByteBuffer;
import java.util.Random;

@ModelExtender(scope = BufferDataProvider.class, name = InstanceDataProviderAdapter.NAME)
@Adapter(singleton = true, lazy = false)
public final class InstanceDataProviderAdapter implements IBufferDataProviderAdapter
{
	public static final String NAME = "InstanceDataProvider";
	public static final int SIZE = 4000000;

	private final Random random;

	private int[] previous = null;

	public InstanceDataProviderAdapter()
	{
		random = new Random();
	}

	@Load
	private static void load(BufferDataProvider provider)
	{
		provider.setRequestedSize(SIZE);
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
			final int currentVal = intBuffer.get();
			final int prevIncr = previous[i] + 1;
			if (currentVal != prevIncr)
			{
				System.err.print(String.format("\t- Failed step %d: %d != %d\n", i, currentVal, prevIncr));
				throw new AssertionError("Data are not the same after fetch (is Descriptor updated ?)");
			}
		}
	}

	@Override
	public boolean hasChanged()
	{
		return true;
	}
}
