package org.sheepy.lily.vulkan.process.binding;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.binding.BindingConfiguration;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.process.binding.task.IConfigureTaskAdapter;

@Statefull
@Adapter(scope = BindingConfiguration.class, lazy = false)
public final class BindingConfigurationAdapter implements IAdapter
{
	private final BindingConfiguration config;

	private BindConfiguration currentConfiguration;

	private BindingConfigurationAdapter(BindingConfiguration config)
	{
		this.config = config;
	}

	@Load
	private void load()
	{
		currentConfiguration = newConfiguration(0);
		executeTasks();
	}

	public void rotate()
	{
		final int stride = config.getDescriptorSetStride();
		final var ds = config.getDescriptorsSets();
		int instance = currentConfiguration.instance;
		instance += stride;
		if (instance >= ds.size()) instance = 0;

		currentConfiguration = newConfiguration(instance);
		executeTasks();
	}

	private void executeTasks()
	{
		for (final var task : config.getTasks())
		{
			executeTask(task);
		}
	}

	private <T extends IConfigurationTask> void executeTask(final T task)
	{
		final var adapter = task.<IConfigureTaskAdapter<T>> adaptNotNullGeneric(IConfigureTaskAdapter.class);
		adapter.configure(currentConfiguration, task);
	}

	private BindConfiguration newConfiguration(int instance)
	{
		final List<DescriptorSet> res = new ArrayList<>();
		final int stride = config.getDescriptorSetStride();
		final var ds = config.getDescriptorsSets();
		final int first = stride * instance;
		final int count = stride > 0 ? stride : ds.size();

		for (int i = 0; i < count; i++)
		{
			final int index = i + first;
			if (index < ds.size())
			{
				final var descriptorSet = ds.get(index);
				res.add(descriptorSet);
			}
		}

		return new BindConfiguration(instance, List.copyOf(res));
	}
}
