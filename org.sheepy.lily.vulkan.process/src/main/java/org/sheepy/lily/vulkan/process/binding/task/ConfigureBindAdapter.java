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
		final var bindTask = task.getBindTask();
		final var dSets = configuration.descriptorSets;

		bindTask.getDescriptorSets().clear();
		bindTask.getDescriptorSets().addAll(dSets);
	}
}
