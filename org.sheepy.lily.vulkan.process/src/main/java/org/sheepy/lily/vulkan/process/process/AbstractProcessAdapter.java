package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.process.IProcessPartAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessPartPkg;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
public abstract class AbstractProcessAdapter<T extends IProcessContext.IRecorderContext<T>>
		implements IProcessAdapter, IAllocable<IVulkanContext>
{
	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool;
	protected final T context;
	protected final List<IAllocable<? super T>> allocationList;
	protected final List<IProcessPartAdapter> partAdapters = new ArrayList<>();

	private final TreeAllocator<IVulkanContext> allocator;

	private long startPrepareNs = 0;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		gatherProcessPartAdapters(process);
		descriptorPool = new DescriptorPool(gatherDescriptorLists());
		context = createContext();
		allocator = new TreeAllocator<IVulkanContext>(this);

		allocationList = gatherAllocationList();
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, IVulkanContext context)
	{
		config.setChildrenContext(this.context);
		config.addChildren(allocationList);
	}

	@Override
	public void allocate(IVulkanContext context)
	{}

	@Override
	public void free(IVulkanContext context)
	{}

	protected List<IAllocable<? super T>> gatherAllocationList()
	{
		final List<IAllocable<? super T>> res = new ArrayList<>();

		res.addAll(gatherResources());
		res.addAll(context.getAllocationChildren());
		res.add(descriptorPool);

		collectAllocationPipelines(res);

		assert res.contains(null) == false;
		return res;
	}

	private void gatherProcessPartAdapters(AbstractProcess process)
	{
		final ProcessPartPkg partPkg = process.getPartPkg();
		if (partPkg != null)
		{
			final var parts = partPkg.getParts();
			for (int i = 0; i < parts.size(); i++)
			{
				final var part = parts.get(i);
				final var adapter = IProcessPartAdapter.adapt(part);
				if (adapter != null)
				{
					partAdapters.add(adapter);
				}
			}
		}
	}

	@Override
	public void start(IVulkanContext context)
	{
		allocator.allocate(context);
	}

	@Override
	public void stop(IVulkanContext context)
	{
		allocator.free();
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
			recorder.record(partAdapters, getStages());
		}

		for (int i = 0; i < partAdapters.size(); i++)
		{
			final var pipelineAdapter = partAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				pipelineAdapter.prepareExecution(context);
			}
		}

		recorder.play();
	}

	@SuppressWarnings("unchecked")
	protected void collectAllocationPipelines(List<? super IAllocable<? super T>> collectIn)
	{
		final var partPkg = process.getPartPkg();
		if (partPkg != null)
		{
			for (final var part : partPkg.getParts())
			{
				final var adapter = IAllocableAdapter.adapt(part);
				if (adapter != null)
				{
					collectIn.add((IAllocable<? super T>) adapter);
				}
			}
		}
	}

	protected List<IAllocable<? super IExecutionContext>> gatherResources()
	{
		final List<IAllocable<? super IExecutionContext>> resources = new ArrayList<>();

		final var resourcePkg = process.getResourcePkg();
		if (resourcePkg != null)
		{
			for (final IResource resource : resourcePkg.getResources())
			{
				final IResourceAdapter resourceAdapter = IResourceAdapter.adapt(resource);
				if (resourceAdapter != null)
				{
					resources.add(resourceAdapter);
				}
			}
		}

		for (int i = 0; i < partAdapters.size(); i++)
		{
			final var pipelineAdapter = partAdapters.get(i);
			pipelineAdapter.collectResources(resources);
		}

		return resources;
	}

	private List<IVkDescriptorSet> gatherDescriptorLists()
	{
		final List<IVkDescriptorSet> res = new ArrayList<>();

		for (int i = 0; i < partAdapters.size(); i++)
		{
			final var pipelineAdapter = partAdapters.get(i);
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

		if (allocator.isAllocationDirty())
		{
			context.getQueue().waitIdle();
			try
			{
				context.stackPush();
				allocator.reloadDirtyElements();
			} finally
			{
				context.stackPop();
			}
			dirty = true;
		}
		return dirty;
	}

	private void updatePipelines()
	{
		for (int i = 0; i < partAdapters.size(); i++)
		{
			final var pipelineAdapter = partAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				pipelineAdapter.update();
			}
		}
	}

	private boolean isRecordNeeded(int index)
	{
		boolean res = false;
		for (int i = 0; i < partAdapters.size(); i++)
		{
			final var pipelineAdapter = partAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				res |= pipelineAdapter.isRecordNeeded(index);
			}
		}
		return res;
	}

	protected boolean isResetAllowed()
	{
		return process.isResetAllowed();
	}

	protected abstract Integer prepareNextExecution();

	protected abstract List<ECommandStage> getStages();

	protected abstract T createContext();
}
