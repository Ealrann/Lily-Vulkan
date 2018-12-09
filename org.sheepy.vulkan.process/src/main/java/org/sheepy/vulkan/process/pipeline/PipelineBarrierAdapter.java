package org.sheepy.vulkan.process.pipeline;

import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;

public abstract class PipelineBarrierAdapter extends AbstractDeepAllocableAdapter implements
		IProcessUnitAdapter<AbstractCommandBuffer>, IPipelineUnitAdapter<AbstractCommandBuffer>
{
	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
