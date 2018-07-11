package org.sheepy.vulkan.pipeline;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.window.Surface;

public abstract class SurfacePipelinePool extends PipelinePool
{
	public SurfacePipelinePool(LogicalDevice logicalDevice, int queueIndex)
	{
		super(logicalDevice, queueIndex);
	}
	
	public abstract void configure(Surface surface);
	public abstract void resize(MemoryStack stack, Surface surface);
}
