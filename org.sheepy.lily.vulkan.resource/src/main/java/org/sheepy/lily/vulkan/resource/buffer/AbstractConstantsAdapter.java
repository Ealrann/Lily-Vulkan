package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;

public abstract class AbstractConstantsAdapter implements IVulkanAdapter
{
	public VkPushConstantRange.Buffer allocRange(MemoryStack stack, AbstractConstants constants)
	{
		final int size = getSize();
		final var stages = constants.getStages();

		int stageFlags = 0;
		for (EShaderStage stage : stages)
		{
			stageFlags |= stage.getValue();
		}

		final var pushConstantRange = VkPushConstantRange.callocStack(1, stack);
		pushConstantRange.get(0).set(stageFlags, 0, size);

		return pushConstantRange;
	}

	protected abstract int getSize();

	public abstract ByteBuffer getData();

	public abstract boolean needRecord();

	public static AbstractConstantsAdapter adapt(AbstractConstants constants)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(constants, AbstractConstantsAdapter.class);
	}
}
