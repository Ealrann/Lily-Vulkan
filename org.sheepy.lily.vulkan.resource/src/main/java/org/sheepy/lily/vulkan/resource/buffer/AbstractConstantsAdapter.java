package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;

public abstract class AbstractConstantsAdapter extends AbstractStatefullAdapter
		implements IVulkanAdapter
{
	protected AbstractConstants constants;

	@Override
	public void setTarget(Notifier target)
	{
		constants = (AbstractConstants) target;
		super.setTarget(target);
	}

	public VkPushConstantRange.Buffer allocRange(MemoryStack stack)
	{
		final int size = getSize();
		final var stage = constants.getStage();

		final var pushConstantRange = VkPushConstantRange.callocStack(1, stack);
		pushConstantRange.get(0).set(stage.getValue(), 0, size);

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
