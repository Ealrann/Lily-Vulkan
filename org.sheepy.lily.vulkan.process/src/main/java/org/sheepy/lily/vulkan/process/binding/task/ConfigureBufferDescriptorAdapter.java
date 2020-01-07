package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@Adapter(scope = ConfigureBufferDescriptor.class)
public final class ConfigureBufferDescriptorAdapter
		implements IConfigureTaskAdapter<ConfigureBufferDescriptor>
{
	@Override
	public void configure(BindConfiguration configuration, ConfigureBufferDescriptor task)
	{
		final var descriptor = task.getDescriptor();
		final var index = task.getPartIndex();
		final var compositeBuffer = task.getCompositeBuffer();
		final var partIndex = configuration.computeInstance(index);

		descriptor.setBuffer(compositeBuffer.getParts().get(partIndex));
	}
}
