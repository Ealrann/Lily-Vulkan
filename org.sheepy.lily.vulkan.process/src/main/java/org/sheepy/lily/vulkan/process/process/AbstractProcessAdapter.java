package org.sheepy.lily.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.engine.AbstractEnginePartAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IProcessUnit;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IProcessUnitAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractEnginePartAdapter implements IDeepAllocableAdapter, IProcessAdapter
{
	private final int bindPoint = getBindPoint();

	protected DescriptorPool descriptorPool;
	protected LogicalDevice logicalDevice;

	private AbstractProcess process = null;
	private VkSemaphore executionSemaphore = null;
	private boolean firstRecord = true;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		process = (AbstractProcess) target;
		logicalDevice = ILogicalDeviceAdapter.adapt(process).getLogicalDevice(process);

		descriptorPool = new DescriptorPool(logicalDevice, gatherDescriptorLists());

		childAllocables.add(descriptorPool);
	}

	@Override
	protected List<IResourceAllocable> gatherResources()
	{
		List<IResourceAllocable> resources = super.gatherResources();
		for (IProcessUnit unit : ((AbstractProcess) target).getUnits())
		{
			if (unit instanceof IPipeline)
			{
				var adapter = IPipelineAdapter.adapt((IPipeline) unit);
				resources.addAll(adapter.getResources());
			}
		}
		return resources;
	}

	private List<IVkDescriptorSet> gatherDescriptorLists()
	{
		List<IVkDescriptorSet> res = new ArrayList<>();
		for (EObject eo : process.eContents())
		{
			if (eo instanceof IPipeline)
			{
				var adapter = IPipelineAdapter.adapt((IPipeline) eo);
				res.addAll(adapter.getDescriptorSets());
			}

		}
		return res;
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.clear();

		process = null;
		descriptorPool = null;
		super.unsetTarget(oldTarget);
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		super.flatAllocate(stack);
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		if (firstRecord && executionSemaphore != null && process.isInitializedSignalizedSemaphore())
		{
			executionSemaphore.signalSemaphore(executionManager);
		}

		recordCommands();
		firstRecord = false;
	}

	@Override
	public void free()
	{
		super.free();

		if (executionSemaphore != null)
		{
			executionSemaphore.free(logicalDevice);
		}
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
			executionManager.getQueue().waitIdle();
			recordCommands();
		}
	}

	public VkSemaphore getExecutionSemaphore()
	{
		if (executionSemaphore == null)
		{
			if (process.getDependentProcesses().isEmpty() == false)
			{
				executionSemaphore = new VkSemaphore();
				executionSemaphore.allocate(logicalDevice);
			}
		}

		return executionSemaphore;
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
					adapter.prepare();
				}
			}
		}
		return res;
	}

	@Override
	protected boolean isResetAllowed()
	{
		return ((AbstractProcess) target).isResetAllowed();
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

	protected abstract void recordCommands();

	protected abstract int getBindPoint();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
