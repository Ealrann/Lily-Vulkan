package org.sheepy.vulkan.resource.buffer;

public interface IBufferDataProvider
{
	int getUsage();
	long getSize();
	default int getInstanceCount()
	{
		return 1;
	}

	boolean hasChanged();

	void fill(long memoryAddress);
}
