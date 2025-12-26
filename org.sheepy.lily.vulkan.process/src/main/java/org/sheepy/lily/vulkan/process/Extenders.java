package org.sheepy.lily.vulkan.process;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.IAdapterProvider;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAllocation;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAllocation;
import org.sheepy.lily.vulkan.process.execution.SubmissionAllocation;
import org.sheepy.lily.vulkan.process.pipeline.CompositePipelineAllocation;
import org.sheepy.lily.vulkan.process.pipeline.CompositePipelineRecorder;
import org.sheepy.lily.vulkan.process.pipeline.PipelineAllocation;
import org.sheepy.lily.vulkan.process.pipeline.PipelineRecorder;
import org.sheepy.lily.vulkan.process.pipeline.TaskPkgAllocation;
import org.sheepy.lily.vulkan.process.pipeline.TaskPkgRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.BindDescriptorSetsRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.CompositeTaskRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.CopyBufferTaskRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.FetchBufferRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.FlushTransferBufferTaskRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.PipelineBarrierRecorder;
import org.sheepy.lily.vulkan.process.pipeline.task.PushConstantBufferRecorder;

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

