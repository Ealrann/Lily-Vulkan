package org.sheepy.lily.vulkan.process.binding.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor;
import org.sheepy.lily.vulkan.process.binding.BindConfiguration;

@ModelExtender(scope = ConfigureBufferDescriptor.class)
@Adapter(singleton = true)
public final class ConfigureBufferDescriptorAdapter implements IConfigureTaskAdapter<ConfigureBufferDescriptor>
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
