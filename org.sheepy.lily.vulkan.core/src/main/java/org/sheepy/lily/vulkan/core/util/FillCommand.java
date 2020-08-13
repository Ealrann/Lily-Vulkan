package org.sheepy.lily.vulkan.core.util;

import org.sheepy.lily.vulkan.core.resource.image.VkImage;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public interface FillCommand
{
	long size();
	DataProvider dataProvider();

	record FillBufferCommand(DataProvider dataProvider, long bufferPtr, long offset, long size) implements FillCommand
	{
	}

	record FillImageCommand(DataProvider dataProvider, VkImage vkImage, int mipLevel) implements FillCommand
	{
		@Override
		public long size()
		{
			return vkImage().getSize();
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
