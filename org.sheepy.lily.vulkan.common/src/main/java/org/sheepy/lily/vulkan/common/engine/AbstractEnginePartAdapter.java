package org.sheepy.lily.vulkan.common.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IStatefullAdapter;
import org.sheepy.lily.vulkan.api.adapter.IEnginePartAdapter;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.adapter.IFlatAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.impl.AbstractAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocableAdapter;
import org.sheepy.lily.vulkan.common.execution.ResourceAllocator;
import org.sheepy.lily.vulkan.model.IEnginePart;
import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.VulkanPackage;

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

		var resourceAllocator = new ResourceAllocator(executionManager, gatherResources());
		childAllocables.add(resourceAllocator);
	}

	protected List<IResourceAllocable> gatherResources()
	{
		List<IResourceAllocable> resources = new ArrayList<>();

		for (EObject child : target.eContents())
		{
			if (child instanceof IResource)
			{
				IResource resource = (IResource) child;
				var adapter = IResourceAllocableAdapter.adapt(resource);
				if (adapter != null)
				{
					resources.add(adapter);
				}
			}
		}

		return resources;
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
