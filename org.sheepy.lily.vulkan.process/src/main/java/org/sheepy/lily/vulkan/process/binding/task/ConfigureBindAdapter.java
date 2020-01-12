package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.binding.ConfigureBind;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@Adapter(scope = ConfigureBind.class)
public final class ConfigureBindAdapter implements IConfigureTaskAdapter<ConfigureBind>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigureBind task)
	{
		final var bindTasks = task.getBindTasks();
		final var dSets = configuration.descriptorSets;

		for (int i = 0; i < bindTasks.size(); i++)
		{
			final var bindTask = bindTasks.get(i);
			bindTask.getDescriptorSets().clear();
			bindTask.getDescriptorSets().addAll(dSets);
		}
	}
}
