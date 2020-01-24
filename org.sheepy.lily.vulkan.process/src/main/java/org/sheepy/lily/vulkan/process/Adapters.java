package org.sheepy.lily.vulkan.process;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.binding.BindingConfigurationAdapter;
import org.sheepy.lily.vulkan.process.binding.IndexConfigurationAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureBindAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureBufferDescriptorAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureCompositeBufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigurePrepareCompositeAdapter;
import org.sheepy.lily.vulkan.process.cadence.SwapBindingsTaskAdapter;
import org.sheepy.lily.vulkan.process.descriptor.DescriptorSetAdapter;
import org.sheepy.lily.vulkan.process.pipeline.PipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.BindDescriptorSetsAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.CompositeTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.CopyBufferTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.FlushTransferBufferTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PipelineBarrierAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PrepareCompositeTransferAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PushConstantBufferAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.RotateConfigurationAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	PipelineBarrierAdapter.class,
						PushConstantBufferAdapter.class,
						DescriptorSetAdapter.class,
						BufferBarrierAdapter.class,
						ImageBarrierAdapter.class,
						PipelineAdapter.class,
						BindDescriptorSetsAdapter.class,
						CompositeTaskAdapter.class,
						FlushTransferBufferTaskAdapter.class,
						CopyBufferTaskAdapter.class,
						PrepareCompositeTransferAdapter.class,
						SwapBindingsTaskAdapter.class,
						RotateConfigurationAdapter.class,
						ConfigureBindAdapter.class,
						BindingConfigurationAdapter.class,
						IndexConfigurationAdapter.class,
						ConfigureCompositeBufferBarrierAdapter.class,
						ConfigurePrepareCompositeAdapter.class,
						ConfigureBufferDescriptorAdapter.class);
	}
}
