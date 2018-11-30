package org.sheepy.vulkan.process.pool;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IProcessPoolAdapter;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.common.allocation.adapter.IFlatAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;
import org.sheepy.vulkan.resource.ResourceManager;

public abstract class AbstractProcessPoolAdapter extends AbstractDeepAllocableAdapter
		implements IProcessPoolAdapter, IFlatAllocableAdapter
{
	private AbstractProcessPool<?> processPool = null;

	protected ExecutionManager executionManager;
	protected ResourceManager resourceManager;

	@Override
	public void setTarget(Notifier target)
	{
		processPool = (AbstractProcessPool<?>) target;

		final var logicalDevice = ILogicalDeviceAdapter.adapt(processPool)
				.getLogicalDevice(processPool);
		final var resetAllowed = processPool.isResetAllowed();

		executionManager = new ExecutionManager(logicalDevice, getQueueType(), resetAllowed);
		resourceManager = new ResourceManager(logicalDevice, processPool);

		childAllocables.add(resourceManager);
	}

	@Override
	public boolean isRecordNeeded()
	{
		boolean res = false;
		PROCESS_LOOP: for (AbstractProcess process : processPool.getProcesses())
		{
			for (IProcessUnit unit : process.getUnits())
			{
				var adapter = IProcessUnitAdapter.adapt(unit);
				if (adapter.isRecordNeeded())
				{
					res = true;
					break PROCESS_LOOP;
				}
			}
		}
		return res;
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.remove(resourceManager);

		processPool = null;
		resourceManager = null;
		executionManager = null;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		// ExecutionManager is high-priority. we allocate it directly here (before the allocation of
		// resources)
		executionManager.allocate(stack);
	}

	@Override
	public void free()
	{
		executionManager.free();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}

	protected abstract EQueueType getQueueType();

	@Override
	public abstract void execute();

	public static AbstractProcessPoolAdapter adapt(AbstractProcessPool<?> object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessPoolAdapter.class);
	}
}