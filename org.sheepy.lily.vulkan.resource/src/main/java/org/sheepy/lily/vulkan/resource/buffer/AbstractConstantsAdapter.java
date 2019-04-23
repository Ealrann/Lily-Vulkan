package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public abstract class AbstractConstantsAdapter implements IConstantsAdapter
{
	private final AbstractConstants constants;

	public AbstractConstantsAdapter(AbstractConstants constants)
	{
		this.constants = constants;
	}

	@Override
	public void fillRange(VkPushConstantRange range)
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
