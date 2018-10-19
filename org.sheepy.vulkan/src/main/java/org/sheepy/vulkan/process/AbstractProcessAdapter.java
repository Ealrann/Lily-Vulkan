package org.sheepy.vulkan.process;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.AbstractProcess;
import org.sheepy.vulkan.model.IProcessUnit;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.pipeline.IProcessUnitAdapter;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractDeepAllocableAdapter
{
	private final int bindPoint = getBindPoint();

	private AbstractProcess process = null;

	@Override
	protected void load()
	{
		process = (AbstractProcess) target;
	}

	@Override
	protected void unload()
	{
		process = null;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{}

	@Override
	public void free()
	{}

	public void recordCommand(T commandBuffer, ECommandStage stage)
	{
		for (final IProcessUnit unit : process.getUnits())
		{
			if (unit.getStage() == stage)
			{
				final IProcessUnitAdapter<T> adapter = IProcessUnitAdapter.adapt(unit);
				adapter.record(commandBuffer, bindPoint);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}

	protected abstract int getBindPoint();
}
