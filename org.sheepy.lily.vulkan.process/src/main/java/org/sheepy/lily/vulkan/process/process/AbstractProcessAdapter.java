package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.EReference;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.CompositeModelExplorer;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.game.core.allocation.GenericAllocator;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.core.process.IProcessContext.IRecorderContext;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.core.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Statefull
public abstract class AbstractProcessAdapter<T extends IRecorderContext<T>> implements InternalProcessAdapter,
																					   IAllocable<VulkanContext>
{
	private static final ModelExplorer DERSCRIPTOR_SET_EXPLORER = new ModelExplorer(List.of(ProcessPackage.Literals.ABSTRACT_PROCESS__DESCRIPTOR_SET_PKG,
																							VulkanResourcePackage.Literals.DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS));

	protected final AbstractProcess process;
	protected final DescriptorPool descriptorPool = new DescriptorPool();
	protected final T context;

	private final GenericAllocator<T> resourceAllocator;
	private final GenericAllocator<T> pipelineAllocator;
	private final CompositeModelExplorer pipelineExplorer;

	protected IAllocationConfigurator config;
	protected List<IPipelineAdapter> pipelineAdapters;
	private IRootAllocator<VulkanContext> allocator;
	private long startPrepareNs = 0;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		context = createContext();

		resourceAllocator = new GenericAllocator<>(getResourceFeatureLists());
		pipelineAllocator = new GenericAllocator<>(getPipelineFeatureLists());
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
	public void configureAllocation(IAllocationConfigurator config, VulkanContext context)
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
	public void allocate(VulkanContext context)
	{
	}

	@Override
	public void free(VulkanContext context)
	{
	}

	@Override
	public void start(final VulkanContext vulkanContext, final IRootAllocator<VulkanContext> rootAllocator)
	{
		refreshStructure();
		allocator = IAllocationService.INSTANCE.createAllocator(rootAllocator, this, vulkanContext);
		allocator.allocate();

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
	public void stop(VulkanContext vulkanContext)
	{
		waitIdle();
		allocator.free();
		allocator = null;
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
			IStatistics.INSTANCE.addTime(getClass().getSimpleName(), System.nanoTime() - startPrepareNs);
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
		refresh();
		if (allocator.isAllocationDirty())
		{
			waitIdle();
			allocator.reloadDirtyElements();
			return true;
		}
		else
		{
			return false;
		}
	}

	protected boolean prepareDescriptors()
	{
		boolean dirty = false;
		descriptorPool.prepare();
		if (descriptorPool.hasChanged())
		{
			waitIdle();
			try (final var stack = MemoryStack.stackPush())
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
		System.out.println(process.eClass().getName() + " " + process.getName() + " Allocation tree:");
		System.out.println(allocator.toString());
	}

	@Override
	public boolean isMultithreadAllowed()
	{
		return context.getQueue().isShared() == false;
	}

	protected abstract List<List<EReference>> getPipelineFeatureLists();
	protected abstract List<List<EReference>> getResourceFeatureLists();
	protected abstract List<IAllocable<? super T>> getExtraAllocables();
	protected abstract Integer prepareNextExecution();
	protected abstract List<ECommandStage> getStages();
	protected abstract T createContext();
}
