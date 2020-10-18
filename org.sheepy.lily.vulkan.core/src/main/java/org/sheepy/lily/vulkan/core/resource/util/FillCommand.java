package org.sheepy.lily.vulkan.core.resource.util;

import org.sheepy.lily.vulkan.core.resource.image.ImageBackend;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Consumer;

public sealed interface FillCommand permits FillCommand.FillBufferCommand, FillCommand.FillImageCommand
{
	long size();
	void fill(ByteBuffer toBuffer);

	record FillBufferCommand(long bufferPtr, List<RegionFillInfo> fillInfo) implements FillCommand
	{
		@Override
		public void fill(final ByteBuffer buffer)
		{
			int position = 0;
			for (final var fill : fillInfo)
			{
				final long size = fill.size;
				final var slice = buffer.slice(position, (int) size);
				slice.order(buffer.order());
				fill.dataProvider.fillBuffer(slice);
				position += size;
			}
			buffer.limit(position);
			buffer.position(0);
		}

		@Override
		public long size()
		{
			return fillInfo.stream().mapToLong(RegionFillInfo::size).sum();
		}
	}

	record RegionFillInfo(DataProvider dataProvider, long offset, long size) {}

	record FillImageCommand(DataProvider dataProvider, ImageBackend image, boolean generateMipmap) implements
																								   FillCommand
	{
		@Override
		public void fill(final ByteBuffer buffer)
		{
			dataProvider.fillBuffer(buffer);
		}

		@Override
		public long size()
		{
			return image().size();
		}
	}

	@FunctionalInterface
	interface DataProvider extends Consumer<ByteBuffer>
	{
		void fillBuffer(ByteBuffer buffer);

		@Override
		default void accept(ByteBuffer byteBuffer)
		{
			fillBuffer(byteBuffer);
		}
	}
}
