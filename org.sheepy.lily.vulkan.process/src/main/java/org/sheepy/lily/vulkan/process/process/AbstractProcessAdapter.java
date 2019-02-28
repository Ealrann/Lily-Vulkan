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
import org.sheepy.lily.vulkan.common.allocation.adapter.impl.AbstractAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContextProvider;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		extends AbstractAllocationDescriptorAdapter
		implements IStatefullAdapter, IProcessAdapter, IAllocationContextProvider
{
	private final int bindPoint = getBindPoint();
	protected DescriptorPool descriptorPool;
	protected ProcessContext context = null;
	private AbstractProcess process = null;
	private TreeAllocator allocator;
	private boolean recorded = false;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		process = (AbstractProcess) target;
		descriptorPool = new DescriptorPool(gatherDescriptorLists());
		context = createContext();
		allocator = new TreeAllocator(process);

		gatherAllocationServices();
		gatherPipelines();
	}

	@Override
	public ProcessContext getAllocationContext()
	{
		return context;
	}

	protected void gatherAllocationServices()
	{
		allocationList.addAll(gatherResources());
		allocationList.addAll(context.getAllocationChildren());
		allocationList.add(descriptorPool);
	}

	protected void gatherPipelines()
	{
		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			allocationList.addAll(pipelinePkg.getPipelines());
		}
	}

	protected List<Object> gatherResources()
	{
		List<Object> resources = new ArrayList<>();

		var resourcePkg = process.getResourcePkg();
		if (resourcePkg != null)
		{
			resources.addAll(resourcePkg.getResources());
		}

		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (IPipeline pipeline : pipelinePkg.getPipelines())
			{
				var adapter = AbstractPipelineAdapter.adapt(pipeline);
				resources.addAll(adapter.getResources());
				resources.add(adapter.getConstants());
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
		process = null;
		allocator = null;
		descriptorPool = null;
		super.unsetTarget(oldTarget);
	}

	@Override
	public void prepare()
	{
		boolean needRecord = !recorded;

		if (allocator.isAllocationDirty(context))
		{
			try (MemoryStack stack = stackPush())
			{
				allocator.reloadDirtyElements(stack, context);
			}

			needRecord = true;
		}

		if (needRecord || isRecordNeeded())
		{
			context.getQueue().waitIdle();
			recordCommands();
			recorded = true;
		}
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

	protected abstract ProcessContext createContext();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractProcessAdapter<T> adapt(AbstractProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
