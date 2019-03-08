package org.sheepy.lily.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationDescriptorAdapter;
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

@Statefull
public abstract class AbstractProcessAdapter<T extends AbstractCommandBuffer>
		implements IProcessAdapter, IAllocationContextProvider, IAllocationDescriptorAdapter
{
	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool;
	private final int bindPoint = getBindPoint();
	private final TreeAllocator allocator;
	protected final ProcessContext context;

	private boolean recorded = false;

	private final List<Object> allocationList;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		descriptorPool = new DescriptorPool(gatherDescriptorLists());
		context = createContext();
		allocator = new TreeAllocator(process);

		List<Object> allocs = new ArrayList<>();
		allocs.addAll(gatherAllocationServices());
		allocs.addAll(gatherPipelines());

		allocationList = List.copyOf(allocs);
	}

	@Override
	public ProcessContext getAllocationContext()
	{
		return context;
	}

	protected List<Object> gatherAllocationServices()
	{
		List<Object> res = new ArrayList<>();

		res.addAll(gatherResources());
		res.addAll(context.getAllocationChildren());
		res.add(descriptorPool);

		return res;
	}

	protected List<IPipeline> gatherPipelines()
	{
		List<IPipeline> res = new ArrayList<>();

		PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			res.addAll(pipelinePkg.getPipelines());
		}

		return res;
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

	@Dispose
	public void unsetTarget()
	{
		allocationList.clear();
	}

	@Override
	public void prepare()
	{
		boolean needRecord = !recorded;

		if (allocator.isAllocationDirty(context))
		{
			context.getQueue().waitIdle();
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

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	protected abstract EQueueType getQueueType();

	protected boolean isResetAllowed()
	{
		return process.isResetAllowed();
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
