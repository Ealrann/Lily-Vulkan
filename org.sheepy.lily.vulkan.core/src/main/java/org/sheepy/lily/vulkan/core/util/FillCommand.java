package org.sheepy.lily.vulkan.core.util;

public record FillCommand(DataProvider dataProvider, long bufferPtr, long offset, long size)
{
	@FunctionalInterface
	public interface DataProvider
	{
		void fillBuffer(long memoryPtr);
	}
}
