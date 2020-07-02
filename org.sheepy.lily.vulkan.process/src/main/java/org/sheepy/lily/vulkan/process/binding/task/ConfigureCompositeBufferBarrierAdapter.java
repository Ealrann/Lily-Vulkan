package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.FixedBufferReference;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@ModelExtender(scope = ConfigureCompositeBufferBarrier.class)
@Adapter(singleton = true)
public final class ConfigureCompositeBufferBarrierAdapter implements IConfigureTaskAdapter<ConfigureCompositeBufferBarrier>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigureCompositeBufferBarrier task)
	{
		final var barriers = task.getBarriers();
		final var index = task.getPartIndex();
		final var compositeBuffer = task.getCompositeBuffer();
		final var partIndex = configuration.computeInstance(index);

		for (final var barrier : barriers)
		{
			final var reference = (FixedBufferReference) barrier.getBuffers();
			final BufferPart bufferPart = compositeBuffer.getParts().get(partIndex);
			reference.getBuffers().clear();
			reference.getBuffers().add(bufferPart);
		}
	}
}
