package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;
import org.sheepy.lily.vulkan.process.binding.AbstractContextConfigurationAdapter;

@ModelExtender(scope = RotateConfiguration.class)
@Adapter
@Deprecated
public final class RotateConfigurationRecorder implements IPipelineTaskRecorder
{
	private final RotateConfiguration task;

	public RotateConfigurationRecorder(RotateConfiguration task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
//		final var configurations = task.getConfigurations();
//		for (int i = 0; i < configurations.size(); i++)
//		{
//			final var config = configurations.get(i);
//			config.adapt(AbstractContextConfigurationAdapter.class).rotate();
//		}
	}
}
