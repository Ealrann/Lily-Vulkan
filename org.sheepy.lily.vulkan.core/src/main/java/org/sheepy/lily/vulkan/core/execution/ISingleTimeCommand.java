package org.sheepy.lily.vulkan.core.execution;

@FunctionalInterface
public interface ISingleTimeCommand
{
	void execute(ExecutionContext context, ICommandBuffer commandBuffer);

	default void postExecute()
	{
	}
}
