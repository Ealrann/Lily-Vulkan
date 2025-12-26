package org.sheepy.lily.vulkan.core.execution;

@FunctionalInterface
public interface ISingleTimeCommand
{
	void execute(IRecordContext recordContext);
}
