package org.sheepy.lily.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IStatefullAdapter;
import org.sheepy.lily.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.impl.AbstractAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.common.allocation.allocator.AllocationHelper;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;
import org.sheepy.lily.vulkan.common.resource.IResourceAllocableAdapter;
import org.sheepy.lily.vulkan.common.resource.ResourceAllocator;
import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractAllocationDescriptorAdapter implements IStatefullAdapter, IProcessAdapter
{
	private final int bindPoint = getBindPoint();

	protected DescriptorPool descriptorPool;
	protected LogicalDevice logicalDevice;
	protected ExecutionContext executionManager;

	private AbstractProcess process = null;
	private VkSemaphore executionSemaphore = null;
	private boolean firstRecord = true;

	private AllocationHelper allocationHelper;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		process = (AbstractProcess) target;
		logicalDevice = ILogicalDeviceAdapter.adapt(process).getLogicalDevice(process);
		executionManager = new ExecutionContext(logicalDevice, getQueueType(), isResetAllowed());
		descriptorPool = new DescriptorPool(logicalDevice, gatherDescriptorLists());
		allocationHelper = new AllocationHelper(process);

		gatherAllocationServices();
		gatherPipelines();

		allocationList.add(new IAllocable()
		{
			@Override
			public void allocate(MemoryStack stack)
			{
				if (firstRecord
						&& executionSemaphore != null
						&& process.isInitializedSignalizedSemaphore())
				{
					executionSemaphore.signalSemaphore(executionManager);
				}

				recordCommands();
				firstRecord = false;
			}

			@Override
			public void free()
			{
				if (executionSemaphore != null)
				{
					executionSemaphore.free();
				}
			}

			@Override
			public boolean isAllocationDirty()
			{
				return false;
			}
		});
	}

	protected void gatherAllocationServices()
	{
		allocationList.add(executionManager);
		for (IResourceAllocable resource : gatherResources())
		{
			allocationList.add(new ResourceAllocator(executionManager, resource));
		}
		allocationList.add(descriptorPool);
	}

	protected void gatherPipelines()
	{
		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (IPipeline pipeline : pipelinePkg.getPipelines())
			{
				var adapter = IPipelineAdapter.adapt(pipeline);
				if (adapter instanceof IAllocationAdapter)
				{
					allocationList.add(pipeline);
				}
			}
		}
	}

	protected List<IResourceAllocable> gatherResources()
	{
		List<IResourceAllocable> resources = new ArrayList<>();

		var resourcePkg = process.getResourcePkg();
		if (resourcePkg != null)
		{
			for (IResource resource : resourcePkg.getResources())
			{
				resources.add(IResourceAllocableAdapter.adapt(resource));
			}
		}

		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (IPipeline pipeline : pipelinePkg.getPipelines())
			{
				var adapter = AbstractPipelineAdapter.adapt(pipeline);
				resources.addAll(adapter.getResources());
			}
		}
		return resources;
	}

	private List<IVkDescriptorSet> gatherDescriptorLists()
	{
		List<IVkDescriptorSet> res = new ArrayList<>();
		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (IPipeline pipeline : pipelinePkg.getPipelines())
			{
				var adapter = AbstractPipelineAdapter.adapt(pipeline);
				res.addAll(adapter.getDescriptorSets());
			}
		}
		return res;
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		allocationList.clear();
		executionManager = null;
		process = null;
		allocationHelper = null;
		descriptorPool = null;
		super.unsetTarget(oldTarget);
	}

	@Override
	public void prepare()
	{
		boolean needRecord = false;
		if (allocationHelper.isAllocationDirty())
		{
			try (MemoryStack stack = stackPush())
			{
				allocationHelper.reloadDirtyElements(stack);
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
				executionSemaphore = new VkSemaphore(logicalDevice);
				executionSemaphore.allocate(null);
			}
		}

		return executionSemaphore;
	}

	private boolean isRecordNeeded()
	{
		boolean res = false;
		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (IPipeline pipeline : pipelinePkg.getPipelines())
			{
				var adapter = IPipelineAdapter.adapt(pipeline);
				if (adapter.isRecordNeeded())
				{
					res = true;
					adapter.prepare();
				}
			}
		}
		return res;
	}

	public void recordCommand(T commandBuffer, ECommandStage stage)
	{
		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (IPipeline pipeline : pipelinePkg.getPipelines())
			{
				final IPipelineAdapter<T> adapter = IPipelineAdapter.adapt(pipeline);
				if (pipeline.isEnabled() && pipeline.getStage() == stage)
				{
					adapter.record(commandBuffer, bindPoint);
				}
				adapter.setRecordNeeded(false);
			}
		}
	}

	protected abstract EQueueType getQueueType();

	protected boolean isResetAllowed()
	{
		return ((AbstractProcess) target).isResetAllowed();
	}

	protected abstract void recordCommands();

	protected abstract int getBindPoint();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
