package org.sheepy.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;
import org.sheepy.vulkan.resource.ResourceManager;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractFlatAllocableAdapter implements IProcessAdapter, IDeepAllocableAdapter
{
	private static final String UNALLOCATED_PROCESS = "Process not allocated";

	private final int bindPoint = getBindPoint();

	protected ExecutionManager executionManager;
	protected ResourceManager resourceManager;

	private AbstractProcess process = null;
	private TreeAllocator allocator;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		process = (AbstractProcess) target;
		allocator = new TreeAllocator(process);

		var logicalDevice = ILogicalDeviceAdapter.adapt(process).getLogicalDevice(process);
		boolean resetAllowed = process.isResetAllowed();

		executionManager = new ExecutionManager(logicalDevice, getQueueType(), resetAllowed);
		resourceManager = new ResourceManager(logicalDevice, process);

		childAllocables.add(resourceManager);
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.remove(resourceManager);

		process = null;
		resourceManager = null;
		executionManager = null;
	}

	@Override
	public void allocateProcess()
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			allocator.allocate(stack);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void freeProcess()
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
	public void deepAllocate(MemoryStack stack)
	{
		recordCommands();
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		// ExecutionManager is high-priority. we allocate it directly here (before the allocation of
		// resources)
		executionManager.allocate(stack);
	}

	@Override
	public void prepare()
	{
		checkAllocation();

		boolean needRecord = false;

		if (allocator.isAllocationDirty())
		{
			try (MemoryStack stack = stackPush())
			{
				allocator.reloadDirtyElements(stack);
			}

			needRecord = true;
		}

		if (needRecord || isRecordNeeded())
		{
			recordCommands();
		}
	}

	private boolean isRecordNeeded()
	{
		boolean res = false;
		for (EObject child : process.eContents())
		{
			if (child instanceof IProcessUnit)
			{
				var adapter = IProcessUnitAdapter.adapt((IProcessUnit) child);
				if (adapter.isRecordNeeded())
				{
					res = true;
					break;
				}
			}
		}
		return res;
	}

	@Override
	public final boolean isAllocationDirty()
	{
		return false;
	}

	public void recordCommand(T commandBuffer, ECommandStage stage)
	{
		for (EObject child : process.eContents())
		{
			if (child instanceof IProcessUnit)
			{
				IProcessUnit unit = (IProcessUnit) child;
				final IProcessUnitAdapter<T> adapter = IProcessUnitAdapter.adapt(unit);
				if (unit.isEnabled() && unit.getStage() == stage)
				{
					adapter.record(commandBuffer, bindPoint);
				}
				adapter.setRecordNeeded(false);
			}
		}
	}

	protected void checkAllocation() throws AssertionError
	{
		if (allocator.isAllocated() == false)
		{
			throw new AssertionError(UNALLOCATED_PROCESS);
		}
	}

	protected abstract void recordCommands();

	protected abstract EQueueType getQueueType();

	protected abstract int getBindPoint();

	@Override
	public abstract void execute();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
