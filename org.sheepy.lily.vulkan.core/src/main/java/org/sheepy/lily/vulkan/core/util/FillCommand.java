package org.sheepy.lily.vulkan.core.util;

import java.nio.ByteBuffer;

public record FillCommand(DataProvider dataProvider, long bufferPtr, long offset, long size)
{
	@FunctionalInterface
	public interface DataProvider
	{
		void fillBuffer(ByteBuffer buffer);
	}
}
