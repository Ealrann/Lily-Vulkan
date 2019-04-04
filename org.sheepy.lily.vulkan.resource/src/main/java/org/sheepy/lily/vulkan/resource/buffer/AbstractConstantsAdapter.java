package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;

public abstract class AbstractConstantsAdapter implements IConstantsAdapter
{
	@Override
	public void fillRange(VkPushConstantRange range, AbstractConstants constants)
	{
		final int size = getSize();
		final var stages = constants.getStages();

		int stageFlags = 0;
		for (final EShaderStage stage : stages)
		{
			stageFlags |= stage.getValue();
		}

		range.set(stageFlags, 0, size);
	}

	protected abstract int getSize();

	public static AbstractConstantsAdapter adapt(AbstractConstants constants)
	{
		return IAdapterFactoryService.INSTANCE.adapt(constants, AbstractConstantsAdapter.class);
	}
}
