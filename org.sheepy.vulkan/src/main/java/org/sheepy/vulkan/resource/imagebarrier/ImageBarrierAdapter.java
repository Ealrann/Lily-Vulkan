package org.sheepy.vulkan.resource.imagebarrier;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.ImageBarrier;
import org.sheepy.vulkan.pipeline.PipelineBarrierAdapter;

public class ImageBarrierAdapter extends PipelineBarrierAdapter
{
	private final ImageBarrierExecutor barrierExecutor = new ImageBarrierExecutor();

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		barrierExecutor.allocate((ImageBarrier) target);
	}

	@Override
	public void free()
	{
		barrierExecutor.free();
	}

	@Override
	public void record(AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		barrierExecutor.execute(commandBuffer.getVkCommandBuffer());
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}

}
