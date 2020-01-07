package org.sheepy.lily.vulkan.process.binding.task;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@Adapter(scope = ConfigurePrepareComposite.class)
public final class ConfigurePrepareCompositeAdapter
		implements IConfigureTaskAdapter<ConfigurePrepareComposite>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigurePrepareComposite configure)
	{
		final var prepareTask = configure.getPrepareTask();
		final var compositeBuffer = prepareTask.getCompositeBuffer();

		final List<BufferPart> parts = new ArrayList<>();
		for (final var partIndex : configure.getPartIndices())
		{
			final var index = configuration.computeInstance(partIndex);

			parts.add(compositeBuffer.getParts().get(index));
		}

		prepareTask.getParts().clear();
		prepareTask.getParts().addAll(parts);
	}
}
