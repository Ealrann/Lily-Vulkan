package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = ConfigurePrepareComposite.class)
@Adapter(singleton = true)
public final class ConfigurePrepareCompositeAdapter implements IConfigureTaskAdapter<ConfigurePrepareComposite>
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

		final var bufferRef = (BufferReference) prepareTask.getBufferReference();

		bufferRef.getBuffers().clear();
		bufferRef.getBuffers().addAll(parts);
	}
}
