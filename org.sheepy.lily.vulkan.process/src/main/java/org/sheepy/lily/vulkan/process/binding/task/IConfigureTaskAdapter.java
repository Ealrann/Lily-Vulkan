package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

public interface IConfigureTaskAdapter<T extends IConfigurationTask> extends IAdapter
{
	void configure(BindConfiguration configuration, T task);
}
