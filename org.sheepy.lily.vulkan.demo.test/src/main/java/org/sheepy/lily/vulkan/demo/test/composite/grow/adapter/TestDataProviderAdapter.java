package org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ModelExtender(scope = BufferDataProvider.class, name = TestDataProviderAdapter.NAME)
@Adapter
public final class TestDataProviderAdapter extends Notifier<IBufferDataProviderAdapter.Features> implements
																								 IBufferDataProviderAdapter
{
	public static final String NAME = "TestDataProvider";
	public static final int MAX_SIZE = 1000000;
	public static final int INITIAL_SIZE = 100000;
	public static final int GROW_SIZE = 50000;

	private final BufferDataProvider provider;
	private final Random random;

	public int currentSize = INITIAL_SIZE;
	private final List<PushData> previousPushs = new ArrayList<>();
	private int pass = 0;
	private boolean dirty = true;

	public TestDataProviderAdapter(BufferDataProvider provider)
	{
		super(List.of(Features.Size, Features.Data));
		this.provider = provider;
		random = new Random();
		provider.setRequestedSize(currentSize);
	}

	@Tick
	private void tick()
	{
		if (dirty == false)
		{
			currentSize += GROW_SIZE;
			currentSize = Math.min(MAX_SIZE, currentSize);
			provider.setRequestedSize(currentSize);

			notify(Features.Data);
			notify(Features.Size, currentSize);

			pass++;
			dirty = true;
//			System.out.println("pass = " + pass);
		}
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		final var intBuffer = buffer.asIntBuffer();
		final int intSize = intBuffer.capacity();

		final int[] previous = new int[intSize];
		for (int i = 0; i < intSize; i++)
		{
			final int rand = random.nextInt();
			intBuffer.put(rand);
			previous[i] = rand;
		}

		previousPushs.add(new PushData(previous, pass));

		dirty = false;
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
		final var intBuffer = buffer.asIntBuffer();
		final int size = intBuffer.capacity();
		final var pushDatas = previousPushs.stream()
										  .filter(p -> p.values.length == size)
										   .filter(p -> p.match(buffer.asIntBuffer()))
										  .collect(Collectors.toUnmodifiableList());

		if(pushDatas.size() != 1) throw new AssertionError();

		previousPushs.removeAll(pushDatas);

	}

	@Override
	public long size()
	{
		return currentSize;
	}

	@Override
	public boolean hasChanged()
	{
		return dirty;
	}

	private static record PushData(int[]values, int pass)
	{
		boolean match(IntBuffer buffer)
		{
			for (int i = 0; i < values.length; i++)
			{
				final int value = buffer.get();
				final int expected = this.values[i];
				if (value != expected)
				{
//					final var message = String.format(
//							"Data are not the same after fetch: value = %d, expected = %d, index = %d, pass = %d",
//							value,
//							expected,
//							i,
//							pass);
//					System.err.println(message);
					return false;
				}
			}
			return true;
		}
	}
}
