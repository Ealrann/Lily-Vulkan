package org.sheepy.vulkan.process.graphic.barrier;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.resource.ImageBarrier;
import org.sheepy.vulkan.process.pipeline.PipelineBarrierAdapter;
import org.sheepy.vulkan.resource.image.barrier.ImageBarrierExecutor;

public class PipelineImageBarrierAdapter extends PipelineBarrierAdapter
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return GraphicPackage.Literals.PIPELINE_IMAGE_BARRIER == eClass;
	}
}
