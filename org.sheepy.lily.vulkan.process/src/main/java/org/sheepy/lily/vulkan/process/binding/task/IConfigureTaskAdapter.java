package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

public interface IConfigureTaskAdapter<T extends IConfigurationTask> extends IExtender
{
	void configure(BindConfiguration configuration, T task);
}
