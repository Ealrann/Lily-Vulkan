package org.sheepy.vulkan.pipeline.compute;

import org.sheepy.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.pipeline.IProcessUnit;

public interface IComputeExecutable extends IProcessUnit
{
	void execute(ComputeCommandBuffer commandBuffer);
}
