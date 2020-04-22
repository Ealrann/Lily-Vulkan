package org.sheepy.lily.vulkan.process.binding;

import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.model.binding.IContextConfiguration;
import org.sheepy.lily.vulkan.process.binding.task.IConfigureTaskAdapter;

public abstract class AbstractContextConfigurationAdapter implements IExtender
{
	protected final IContextConfiguration config;

	protected BindConfiguration currentConfiguration;

	protected AbstractContextConfigurationAdapter(IContextConfiguration config)
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
		final int stride = getStride();
		int instance = currentConfiguration.instance;
		instance += stride;
		if (instance >= getIndexCount()) instance = 0;

		currentConfiguration = newConfiguration(instance);
		executeTasks();
	}

	protected void executeTasks()
	{
		for (final var task : config.getTasks())
		{
			executeTask(task);
		}
	}

	private <T extends IConfigurationTask> void executeTask(final T task)
	{
		final var adapter = task.<IConfigureTaskAdapter<T>>adaptNotNullGeneric(IConfigureTaskAdapter.class);
		adapter.configure(currentConfiguration, task);
	}

	protected abstract int getStride();
	protected abstract int getIndexCount();
	protected abstract BindConfiguration newConfiguration(int instance);

}
