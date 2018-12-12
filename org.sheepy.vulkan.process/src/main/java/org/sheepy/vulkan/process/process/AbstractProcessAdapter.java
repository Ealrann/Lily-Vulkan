package org.sheepy.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.engine.AbstractEnginePartAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.common.execution.IResourceAllocable;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.IPipeline;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractEnginePartAdapter implements IDeepAllocableAdapter, IProcessAdapter
{
	private final int bindPoint = getBindPoint();

	protected DescriptorPool descriptorPool;

	private AbstractProcess process = null;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		process = (AbstractProcess) target;
		LogicalDevice logicalDevice = ILogicalDeviceAdapter.adapt(process)
				.getLogicalDevice(process);

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
	public void deepAllocate(MemoryStack stack)
	{
		recordCommands();
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
