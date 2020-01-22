package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.CompositeModelExplorer;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.common.allocation.GenericAllocator;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.common.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.common.process.IExecutionProcessAdapter;
import org.sheepy.lily.vulkan.common.process.IProcessContext;
import org.sheepy.lily.vulkan.common.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
public abstract class AbstractProcessAdapter<T extends IProcessContext.IRecorderContext<T>>
		implements IExecutionProcessAdapter, IAllocable<IVulkanContext>
{
	private static final ModelExplorer DERSCRIPTOR_SET_EXPLORER = new ModelExplorer(List.of(ProcessPackage.Literals.ABSTRACT_PROCESS__DESCRIPTOR_SET_PKG,
																							ResourcePackage.Literals.DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS));

	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool = new DescriptorPool();
	protected final T context;

	private final GenericAllocator resourceAllocator;
	private final GenericAllocator pipelineAllocator;
	private final TreeAllocator<IVulkanContext> allocator = new TreeAllocator<IVulkanContext>(this);
	private final CompositeModelExplorer pipelineExplorer;

	protected IAllocationConfigurator config;
	protected List<IPipelineAdapter> pipelineAdapters;

	private long startPrepareNs = 0;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		context = createContext();

		resourceAllocator = new GenericAllocator(getResourceFeatureLists());
		pipelineAllocator = new GenericAllocator(getPipelineFeatureLists());
		pipelineExplorer = new CompositeModelExplorer(getPipelineFeatureLists());
	}

	@Load
	private void load()
	{
		resourceAllocator.start(process);
		pipelineAllocator.start(process);
	}

	@Dispose
	private void dispose()
	{
		pipelineAllocator.stop(process);
		resourceAllocator.stop(process);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IVulkanContext context)
	{
		this.config = config;
		config.setChildrenContext(this.context);

		final List<IAllocable<?>> allocationChildren = new ArrayList<>();

		allocationChildren.addAll(this.context.getAllocationChildren());
		allocationChildren.add(resourceAllocator.getAllocable());
		allocationChildren.add(descriptorPool);
		allocationChildren.add(pipelineAllocator.getAllocable());
		allocationChildren.addAll(getExtraAllocables());

		config.addChildren(allocationChildren);
	}

	@Override
	public void allocate(IVulkanContext context)
	{}

	@Override
	public void free(IVulkanContext context)
	{}

	@Override
	public void start(IVulkanContext context)
	{
		refreshStructure();
		allocator.allocate(context);

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printAllocationTree();
		}
	}

	private void refresh()
	{
		if (pipelineAllocator.isDirty() || resourceAllocator.isDirty())
		{
			waitIdle();

			refreshStructure();
		}
	}

	private void refreshStructure()
	{
		pipelineAdapters = pipelineExplorer.exploreAdapt(process, IPipelineAdapter.class);
		descriptorPool.setDescriptorSets(gatherDescriptorLists());
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
			recorder.record(getStages());
		}

		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
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

	private List<IVkDescriptorSet> gatherDescriptorLists()
	{
		final List<IVkDescriptorSet> res = new ArrayList<>();
		DERSCRIPTOR_SET_EXPLORER.streamAdaptNotNull(process, IDescriptorSetAdapter.class)
								.collect(Collectors.toCollection(() -> res));
		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter instanceof IVkPipelineAdapter<?>)
			{
				((IVkPipelineAdapter<?>) pipelineAdapter).collectDescriptorSets(res);
			}
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
		updatePipelines(index);

		if (isRecordNeeded(index))
		{
			invalidateRecords();
		}
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

		refresh();
		if (allocator.isAllocationDirty())
		{
			waitIdle();
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

	protected boolean prepareDescriptors()
	{
		boolean dirty = false;
		descriptorPool.prepare();
		if (descriptorPool.hasChanged())
		{
			waitIdle();
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				descriptorPool.update(stack);
				dirty = true;
			}
		}

		return dirty;
	}

	private void updatePipelines(int index)
	{
		for (int i = 0; i < pipelineAdapters.size(); i++)
		{
			final var pipelineAdapter = pipelineAdapters.get(i);
			if (pipelineAdapter.isActive())
			{
				pipelineAdapter.update(index);
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

	protected abstract List<List<EStructuralFeature>> getPipelineFeatureLists();
	protected abstract List<List<EStructuralFeature>> getResourceFeatureLists();
	protected abstract List<IAllocable<? super T>> getExtraAllocables();
	protected abstract Integer prepareNextExecution();
	protected abstract List<ECommandStage> getStages();
	protected abstract T createContext();
}
