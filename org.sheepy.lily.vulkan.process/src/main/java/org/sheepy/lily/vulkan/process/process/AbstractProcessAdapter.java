package org.sheepy.lily.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContextProvider;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

@Statefull
public abstract class AbstractProcessAdapter
		implements IProcessAdapter, IAllocationContextProvider, IAllocationDescriptorAdapter
{
	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool;
	private final TreeAllocator allocator;
	protected final ProcessContext context;

	private long startPrepareNs = 0;

	private boolean recorded = false;

	private final List<Object> allocationList;
	protected final List<IPipelineAdapter> pipelineAdapters = new ArrayList<>();

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		gatherPipelineAdapters(process);
		descriptorPool = new DescriptorPool(gatherDescriptorLists());
		context = createContext();
		allocator = new TreeAllocator(process);

		final List<Object> allocs = new ArrayList<>();
		allocs.addAll(gatherAllocationServices());
		allocs.addAll(gatherPipelines());

		allocationList = List.copyOf(allocs);
	}

	private void gatherPipelineAdapters(AbstractProcess process)
	{
		final PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			final var pipelines = pipelinePkg.getPipelines();
			for (int i = 0; i < pipelines.size(); i++)
			{
				final IPipeline pipeline = pipelines.get(i);
				final IPipelineAdapter adapter = IPipelineAdapter.adapt(pipeline);
				pipelineAdapters.add(adapter);
			}
		}
	}

	@Override
	public ProcessContext getAllocationContext()
	{
		return context;
	}

	protected List<Object> gatherAllocationServices()
	{
		final List<Object> res = new ArrayList<>();

		res.addAll(gatherResources());
		res.addAll(context.getAllocationChildren());
		res.add(descriptorPool);

		return res;
	}

	protected List<IPipeline> gatherPipelines()
	{
		final List<IPipeline> res = new ArrayList<>();

		final PipelinePkg pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			res.addAll(pipelinePkg.getPipelines());
		}

		return res;
	}

	protected List<Object> gatherResources()
	{
		final List<Object> resources = new ArrayList<>();

		final var resourcePkg = process.getResourcePkg();
		if (resourcePkg != null)
		{
			resources.addAll(resourcePkg.getResources());
		}

		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			resources.addAll(pipelineAdapter.getResources());
		}

		return resources;
	}

	private List<IVkDescriptorSet> gatherDescriptorLists()
	{
		final List<IVkDescriptorSet> res = new ArrayList<>();

		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			res.addAll(pipelineAdapter.getDescriptorSets());
		}

		return res;
	}

	public void prepare()
	{
		if (DebugUtil.DEBUG_ENABLED)
		{
			startPrepareNs = System.nanoTime();
		}

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

		if (DebugUtil.DEBUG_ENABLED)
		{
			IStatistics.INSTANCE.addTime(getClass().getSimpleName(),
					System.nanoTime() - startPrepareNs);
		}
	}

	private boolean isRecordNeeded()
	{
		boolean res = false;

		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter.isRecordNeeded())
			{
				res = true;
				pipelineAdapter.prepare();
			}
		}

		return res;
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

	public abstract void recordCommand(	VkCommandBuffer commandBuffer,
										ECommandStage stage,
										int index);

	protected abstract void recordCommands();

	protected abstract ProcessContext createContext();

	public static AbstractProcessAdapter adapt(AbstractProcess object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
