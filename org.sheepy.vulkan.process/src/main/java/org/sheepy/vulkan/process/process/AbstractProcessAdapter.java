package org.sheepy.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.engine.AbstractEnginePartAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;
import org.sheepy.vulkan.resource.ResourceManager;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractEnginePartAdapter implements IDeepAllocableAdapter, IProcessAdapter
{
	private final int bindPoint = getBindPoint();

	protected ResourceManager resourceManager;

	private AbstractProcess process = null;

	@Override
	public void setTarget(Notifier target)
	{
		process = (AbstractProcess) target;
		LogicalDevice logicalDevice = ILogicalDeviceAdapter.adapt(process)
				.getLogicalDevice(process);

		resourceManager = new ResourceManager(logicalDevice, process);

		childAllocables.add(resourceManager);
		super.setTarget(target);
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		childAllocables.remove(resourceManager);

		process = null;
		resourceManager = null;
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
		return process.isResetAllowed();
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

	@Override
	public abstract void execute();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
