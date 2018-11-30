package org.sheepy.vulkan.process.process;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractDeepAllocableAdapter
{
	private final int bindPoint = getBindPoint();

	private AbstractProcess process = null;

	@Override
	public void setTarget(Notifier target)
	{
		process = (AbstractProcess) target;
		super.setTarget(target);
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
			if (unit.isEnabled() && unit.getStage() == stage)
			{
				final IProcessUnitAdapter<T> adapter = IProcessUnitAdapter.adapt(unit);
				adapter.record(commandBuffer, bindPoint);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}

	protected abstract int getBindPoint();
}
