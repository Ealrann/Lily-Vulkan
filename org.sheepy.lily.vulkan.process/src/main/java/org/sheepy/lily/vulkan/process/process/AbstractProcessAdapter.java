package org.sheepy.lily.vulkan.process.process;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.vulkan.allocation.IAllocationContextProvider;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.queue.EQueueType;

@Statefull
public abstract class AbstractProcessAdapter
		implements IProcessAdapter, IAllocationContextProvider, IAllocationDescriptorAdapter
{
	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool;
	private final TreeAllocator allocator;
	protected final ProcessContext context;

	private long startPrepareNs = 0;

	protected final List<Object> allocationList;
	protected final List<IPipelineAdapter> pipelineAdapters = new ArrayList<>();

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		gatherPipelineAdapters(process);
		descriptorPool = new DescriptorPool(gatherDescriptorLists());
		context = createContext();
		allocator = new TreeAllocator(process);

		allocationList = new ArrayList<>();
		allocationList.addAll(gatherAllocationServices());
		allocationList.addAll(gatherPipelines());
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

	@Override
	public void prepareNextAndExecute()
	{
		final Integer next = prepareNext();

		if (next != null)
		{
			execute(next);
		}
	}

	@Override
	public Integer prepareNext()
	{
		if (DebugUtil.DEBUG_ENABLED)
		{
			startPrepareNs = System.nanoTime();
		}

		prepareProcess();

		final var nextIndex = acquireNextPlayer();

		if (DebugUtil.DEBUG_ENABLED)
		{
			IStatistics.INSTANCE.addTime(getClass().getSimpleName(),
					System.nanoTime() - startPrepareNs);
		}

		return nextIndex;
	}

	private Integer acquireNextPlayer()
	{
		final Integer next = prepareNextExecution();

		if (next != null && next != -1)
		{
			prepareRecord(next);
		}

		if (process.isWaitingFenceDuringAcquire())
		{
			final var recorders = context.getRecorders();
			final var recorder = recorders.get(next);

			recorder.waitIdle();
		}

		return next;
	}

	@Override
	public void execute(int next)
	{
		final var recorders = context.getRecorders();
		final var recorder = recorders.get(next);

		if (recorder.isDirty())
		{
			recorder.record(pipelineAdapters, getStages());
		}

		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				pipelineAdapter.prepareExecution(context);
			}
		}

		recorder.play();
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
			pipelineAdapter.collectResources(resources);
		}

		return resources;
	}

	private List<IVkDescriptorSet> gatherDescriptorLists()
	{
		final List<IVkDescriptorSet> res = new ArrayList<>();

		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			pipelineAdapter.collectDescriptorSets(res);
		}

		return res;
	}

	private void prepareProcess()
	{
		final boolean allocationDirty = prepareAllocation();
		final boolean descriptorsDirty = prepareDescriptors();

		if (allocationDirty || descriptorsDirty)
		{
			invalidateRecords();
		}
	}

	private void prepareRecord(int index)
	{
		updatePipelines();

		if (isRecordNeeded(index))
		{
			invalidateRecords();
		}
	}

	protected boolean prepareDescriptors()
	{
		boolean res = false;

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			descriptorPool.prepare(stack);
		}

		if (descriptorPool.hasChanged())
		{
			res = true;
		}

		return res;
	}

	private void invalidateRecords()
	{
		final var records = context.getRecorders();
		for (int i = 0; i < records.size(); i++)
		{
			records.get(i).setDirty(true);
		}
	}

	private boolean prepareAllocation()
	{
		boolean dirty = false;
		if (allocator.isAllocationDirty(context))
		{
			context.getQueue().waitIdle();
			try (MemoryStack stack = stackPush())
			{
				allocator.reloadDirtyElements(stack, context);
			}
			dirty = true;
		}
		return dirty;
	}

	private void updatePipelines()
	{
		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				pipelineAdapter.update();
			}
		}
	}

	private boolean isRecordNeeded(int index)
	{
		boolean res = false;
		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				res |= pipelineAdapter.isRecordNeeded(index);
			}
		}
		return res;
	}

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	protected boolean isResetAllowed()
	{
		return process.isResetAllowed();
	}

	protected abstract Integer prepareNextExecution();

	protected abstract EQueueType getQueueType();

	protected abstract List<ECommandStage> getStages();

	protected abstract ProcessContext createContext();

	public static AbstractProcessAdapter adapt(AbstractProcess object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, AbstractProcessAdapter.class);
	}
}
