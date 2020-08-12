package org.sheepy.lily.vulkan.core.execution;

@FunctionalInterface
public interface ISingleTimeFunction<Result>
{
	Result execute(IRecordContext recordContext);
}
