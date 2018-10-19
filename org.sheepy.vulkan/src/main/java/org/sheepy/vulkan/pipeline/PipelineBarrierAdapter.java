package org.sheepy.vulkan.pipeline;

import org.sheepy.vulkan.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;

public abstract class PipelineBarrierAdapter extends AbstractDeepAllocableAdapter
		implements IProcessUnitAdapter<AbstractCommandBuffer>
{

}
