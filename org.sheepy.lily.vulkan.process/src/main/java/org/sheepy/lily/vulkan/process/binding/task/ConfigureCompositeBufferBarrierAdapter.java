package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@Adapter(scope = ConfigureCompositeBufferBarrier.class)
public final class ConfigureCompositeBufferBarrierAdapter
		implements IConfigureTaskAdapter<ConfigureCompositeBufferBarrier>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigureCompositeBufferBarrier task)
	{
		final var barrier = task.getBarrier();
		final var index = task.getPartIndex();
		final var compositeBuffer = task.getCompositeBuffer();
		final var partIndex = configuration.computeInstance(index);

		barrier.setBuffer(compositeBuffer.getParts().get(partIndex));
	}
}
