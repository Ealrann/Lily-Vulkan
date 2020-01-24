package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;
import org.sheepy.lily.vulkan.process.binding.AbstractContextConfigurationAdapter;

@Adapter(scope = RotateConfiguration.class)
public final class RotateConfigurationAdapter implements IPipelineTaskAdapter<RotateConfiguration>
{
	@Override
	public void record(RotateConfiguration task, IRecordContext context)
	{
		final var configurations = task.getConfigurations();
		for (int i = 0; i < configurations.size(); i++)
		{
			final var config = configurations.get(i);
			config.adapt(AbstractContextConfigurationAdapter.class).rotate();
		}
	}

	@Override
	public boolean needRecord(RotateConfiguration task, int index)
	{
		return task.isForceRecord();
	}
}
