package org.sheepy.lily.vulkan.process;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAllocation;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAllocation;
import org.sheepy.lily.vulkan.process.execution.SubmissionAllocation;
import org.sheepy.lily.vulkan.process.pipeline.*;
import org.sheepy.lily.vulkan.process.pipeline.task.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
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
					   CompositePipelineAllocation.class,
					   CompositePipelineRecorder.class,
					   SubmissionAllocation.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
