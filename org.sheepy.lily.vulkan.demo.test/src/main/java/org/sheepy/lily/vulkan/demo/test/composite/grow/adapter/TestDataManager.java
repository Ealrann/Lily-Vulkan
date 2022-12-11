package org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.Tick;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataConsumer;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataSupplier;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ModelExtender(scope = BufferViewer.class, name = TestResourceFactory.BUFFER_NAME)
@Adapter
public final class TestDataManager extends Notifier<IBufferDataSupplier.Features> implements IBufferDataSupplier,
																							 IBufferDataConsumer
{
	public static final int MAX_SIZE = 1000000;
	public static final int INITIAL_SIZE = 100000;
	public static final int GROW_SIZE = 50000;

	private final Random random;

	public int currentSize = INITIAL_SIZE;
	private final List<PushData> previousPushs = new ArrayList<>();
	private int pass = 0;
	//	private int fetchPass = 0;
//	private int pushPass = 0;
	private boolean dirty = true;

	private TestDataManager()
	{
		super(List.of(Features.Size, Features.Data));
		random = new Random();
	}

	@Tick
	private void tick()
	{
		if (dirty == false)
		{
			if (currentSize != MAX_SIZE)
			{
				currentSize += GROW_SIZE;
				currentSize = Math.min(MAX_SIZE, currentSize);
				notify(Features.Size, currentSize);
			}

			notify(Features.Data);

			dirty = true;
//			System.out.println("pass = " + pass);
			pass++;
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

//		System.out.println("pushPass = " + pushPass);
//		pushPass++;
		dirty = false;
		previousPushs.add(new PushData(previous, pass));
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
		if (previousPushs.size() > 0)
		{
			final var intBuffer = buffer.asIntBuffer();
			final int size = intBuffer.capacity();
			final var pushDatas = previousPushs.stream()
											   .filter(p -> p.values.length == size)
											   .filter(p -> p.match(buffer.asIntBuffer()))
											   .toList();

//			System.out.println("fetchPass = " + fetchPass);

//			if(pushDatas.size() != 1)
//				System.out.println(pushDatas.size());
			assert pushDatas.size() == 1;

//			fetchPass++;
			previousPushs.removeAll(pushDatas);
		}
	}

	@Override
	public long size()
	{
		return currentSize;
	}

	private static record PushData(int[] values, int pass)
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
