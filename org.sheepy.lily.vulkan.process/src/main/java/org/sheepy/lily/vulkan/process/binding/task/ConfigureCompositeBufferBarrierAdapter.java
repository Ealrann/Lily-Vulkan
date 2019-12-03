package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.binding.EInstance;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@Adapter(scope = ConfigureCompositeBufferBarrier.class)
public final class ConfigureCompositeBufferBarrierAdapter
		implements IConfigureTaskAdapter<ConfigureCompositeBufferBarrier>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigureCompositeBufferBarrier task)
	{
		final var barriers = task.getBarriers();
		final var instance = computeInstance(configuration, task.getTargetInstance());

		for (final var barrier : barriers)
		{
			barrier.setInstance(instance);
		}
	}

	private static int computeInstance(BindConfiguration configuration, EInstance type)
	{
		final int size = configuration.descriptorSets.size();

		switch (type)
		{
		case CONTEXT_INSTANCE:
			return configuration.instance;
		case CONTEXT_INSTANCE_MINUS_ONE:
			return (configuration.instance - 1) % size;
		case CONTEXT_INSTANCE_PLUS_ONE:
			return (configuration.instance + 1) % size;
		default:
			return 0;
		}
	}
}
