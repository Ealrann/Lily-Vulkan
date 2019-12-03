package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EInstance;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@Adapter(scope = ConfigurePrepareComposite.class)
public final class ConfigurePrepareCompositeAdapter
		implements IConfigureTaskAdapter<ConfigurePrepareComposite>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigurePrepareComposite task)
	{
		final var prepareTasks = task.getPrepareTasks();
		final var instance = computeInstance(configuration, task.getTargetInstance());

		for (final var prepareTask : prepareTasks)
		{
			prepareTask.setInstance(instance);
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
