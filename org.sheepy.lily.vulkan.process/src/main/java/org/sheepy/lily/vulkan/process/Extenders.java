package org.sheepy.lily.vulkan.process;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAllocation;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAllocation;
import org.sheepy.lily.vulkan.process.cadence.SwapBindingsTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.*;
import org.sheepy.lily.vulkan.process.pipeline.task.*;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(PipelineBarrierRecorder.class,
					   PushConstantBufferRecorder.class,
					   BufferBarrierAllocation.class,
					   ImageBarrierAllocation.class,
					   PipelineAllocation.class,
					   TaskPkgAllocation.class,
					   TaskPkgRecorder.class,
					   FetchBufferRecorder.class,
					   PipelineRecorder.class,
					   BindDescriptorSetsRecorder.class,
					   CompositeTaskRecorder.class,
					   FlushTransferBufferTaskRecorder.class,
					   CopyBufferTaskRecorder.class,
					   SwapBindingsTaskAdapter.class,
					   CompositePipelineAllocation.class,
					   CompositePipelineRecorder.class);
	}
}
