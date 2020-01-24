package org.sheepy.lily.vulkan.common.execution;

@FunctionalInterface
public interface ISingleTimeCommand
{
	void execute(InternalExecutionContext context, ICommandBuffer<?> commandBuffer);

	default void postExecute()
	{}
}
