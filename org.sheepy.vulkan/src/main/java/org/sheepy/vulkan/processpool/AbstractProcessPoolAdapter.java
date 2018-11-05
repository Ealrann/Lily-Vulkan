package org.sheepy.vulkan.processpool;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IProcessPoolAdapter;
import org.sheepy.vulkan.allocation.adapter.IFlatAllocableAdapter;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.execution.ExecutionManager;
import org.sheepy.vulkan.execution.queue.EQueueType;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.resource.ResourceManager;

public abstract class AbstractProcessPoolAdapter extends AbstractDeepAllocableAdapter
		implements IProcessPoolAdapter, IFlatAllocableAdapter
{
	private AbstractProcessPool<?> processPool = null;

	protected ExecutionManager executionManager;
	protected ResourceManager resourceManager;

	private boolean dirty = false;

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
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.remove(resourceManager);

		processPool = null;
		resourceManager = null;
		executionManager = null;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		dirty = false;
	}

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
	public boolean isDirty()
	{
		return dirty;
	}

	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}
	
	protected abstract EQueueType getQueueType();
	
	@Override
	public abstract void execute();

	public static AbstractProcessPoolAdapter adapt(AbstractProcessPool<?> object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessPoolAdapter.class);
	}
}