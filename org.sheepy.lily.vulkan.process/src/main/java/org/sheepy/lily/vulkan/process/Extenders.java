package org.sheepy.lily.vulkan.process;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.binding.BindingConfigurationAdapter;
import org.sheepy.lily.vulkan.process.binding.IndexConfigurationAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureBindAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureBufferDescriptorAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureCompositeBufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigurePrepareCompositeAdapter;
import org.sheepy.lily.vulkan.process.cadence.SwapBindingsTaskAdapter;
import org.sheepy.lily.vulkan.process.descriptor.DescriptorSetAllocation;
import org.sheepy.lily.vulkan.process.pipeline.PipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.*;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(PipelineBarrierAdapter.class,
					   PushConstantBufferAdapter.class,
					   DescriptorSetAllocation.class,
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
