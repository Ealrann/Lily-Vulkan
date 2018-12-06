package org.sheepy.vulkan.common.engine;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.vulkan.api.adapter.IEnginePartAdapter;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.common.allocation.adapter.IFlatAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractAllocableAdapter;
import org.sheepy.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.IEnginePart;
import org.sheepy.vulkan.model.VulkanPackage;

public abstract class AbstractEnginePartAdapter extends AbstractAllocableAdapter
		implements IEnginePartAdapter, IStatefullAdapter, IFlatAllocableAdapter
{
	private static final String UNALLOCATED_PROCESS = "Process not allocated";

	protected TreeAllocator allocator;
	protected ExecutionManager executionManager;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		IEnginePart enginePart = (IEnginePart) target;
		allocator = new TreeAllocator(enginePart);

		LogicalDevice logicalDevice = ILogicalDeviceAdapter.adapt(enginePart)
				.getLogicalDevice(enginePart);

		executionManager = new ExecutionManager(logicalDevice, getQueueType(), isResetAllowed());
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		allocator = null;
		executionManager = null;
	}

	@Override
	public void allocatePart()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			allocator.allocate(stack);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		// ExecutionManager is high-priority. we allocate it directly here (before the allocation of
		// resources)
		executionManager.allocate(stack);
	}

	@Override
	public void freePart()
	{
		executionManager.getQueue().waitIdle();
		allocator.free();
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

	protected void checkAllocation() throws AssertionError
	{
		if (allocator.isAllocated() == false)
		{
			throw new AssertionError(UNALLOCATED_PROCESS);
		}
	}

	protected abstract boolean isResetAllowed();

	protected abstract EQueueType getQueueType();

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.IENGINE_PART == eClass;
	}

	public static AbstractEnginePartAdapter adapt(IEnginePart object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractEnginePartAdapter.class);
	}
}
