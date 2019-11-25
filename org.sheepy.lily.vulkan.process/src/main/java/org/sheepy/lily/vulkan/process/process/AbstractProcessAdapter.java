package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.process.IProcessPartAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.common.process.IExecutionProcessAdapter;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
public abstract class AbstractProcessAdapter<T extends IProcessContext.IRecorderContext<T>>
		implements IExecutionProcessAdapter, IAllocable<IVulkanContext>
{
	private final ModelExplorer RESOURCE_EXPLORER = new ModelExplorer(List.of(	VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																				VulkanPackage.Literals.RESOURCE_PKG__RESOURCES));
	private final ModelExplorer PARTS_EXPLORER = new ModelExplorer(List.of(	ProcessPackage.Literals.ABSTRACT_PROCESS__PART_PKG,
																			ProcessPackage.Literals.PROCESS_PART_PKG__PARTS));

	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool;
	protected final T context;
	protected final List<IAllocable<? super T>> allocationList;
	protected final List<IProcessPartAdapter> partAdapters;

	private final TreeAllocator<IVulkanContext> allocator;

	private long startPrepareNs = 0;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		partAdapters = PARTS_EXPLORER.exploreAdapt(process, IProcessPartAdapter.class);
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

	@Override
	public void start(IVulkanContext context)
	{
		allocator.allocate(context);

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printAllocationTree();
		}
	}

	@Override
	public void stop(IVulkanContext context)
	{
		waitIdle();
		allocator.free();
	}

	@Override
	public void checkFence()
	{
		if (context != null)
		{
			final var recorders = context.getRecorders();
			for (int i = 0; i < recorders.size(); i++)
			{
				final var recorder = recorders.get(i);
				recorder.checkFence();
			}
		}
	}

	@Override
	public IFenceView run()
	{
		final Integer next = prepareNext();

		if (next != null)
		{
			return execute(next);
		}
		else
		{
			return null;
		}
	}

	private Integer prepareNext()
	{
		if (DebugUtil.DEBUG_ENABLED)
		{
			startPrepareNs = System.nanoTime();
		}

		prepareProcess();

		final var nextIndex = acquireNextPlayer();

		if (DebugUtil.DEBUG_ENABLED)
		{
			IStatistics.INSTANCE.addTime(	getClass().getSimpleName(),
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

	private IFenceView execute(int next)
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

		return recorder.play();
	}

	@Override
	public void waitIdle()
	{
		final var recorders = context.getRecorders();
		for (int i = 0; i < recorders.size(); i++)
		{
			final var recorder = recorders.get(i);
			recorder.waitIdle();
		}
	}

	protected void collectAllocationPipelines(List<? super IAllocable<? super T>> collectIn)
	{
		final var partPkg = process.getPartPkg();
		if (partPkg != null)
		{
			for (final var part : partPkg.getParts())
			{
				final var adapter = part.<IAllocableAdapter<? super T>> adaptGeneric(IAllocableAdapter.class);
				if (adapter != null)
				{
					collectIn.add(adapter);
				}
			}
		}
	}

	private List<IAllocable<? super IExecutionContext>> gatherResources()
	{
		final List<IAllocable<? super IExecutionContext>> resources = new ArrayList<>();
		RESOURCE_EXPLORER	.streamAdapt(process, IResourceAdapter.class)
							.collect(Collectors.toCollection(() -> resources));
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

	private void printAllocationTree()
	{
		System.out.println(process.eClass().getName()
				+ " "
				+ process.getName()
				+ " Allocation tree:");
		System.out.println(allocator.toString());
	}

	@Override
	public boolean isMultithreadAllowed()
	{
		return context.getQueue().isShared() == false;
	}

	protected abstract Integer prepareNextExecution();
	protected abstract List<ECommandStage> getStages();
	protected abstract T createContext();
}
