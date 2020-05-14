package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.EReference;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.CompositeModelExplorer;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.core.allocation.GenericAllocator;
import org.sheepy.lily.game.core.allocation.ModelAllocator;
import org.sheepy.lily.game.core.allocation.ModelStaticAllocator;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPoolAllocation;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProcessAdapter implements InternalProcessAdapter, IAllocable<IVulkanContext>
{
	protected final AbstractProcess process;
	protected ProcessContext context;

	private final ModelStaticAllocator processAllocator;
	private final GenericAllocator<ProcessContext> resourceAllocator;
	private final ModelAllocator resourceAllocator2;
	private final ModelAllocator descriptorPoolAllocator;
	private final GenericAllocator<ProcessContext> pipelineAllocator;

	protected IAllocationConfigurator config;
	private IRootAllocator<IVulkanContext> allocator;
	private long startPrepareNs = 0;
	private IExecutionRecorders recorders = null;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;

		final var resourceFeatures = getResourceFeatureLists();
		processAllocator = new ModelStaticAllocator(getProcessConfiguration());
		resourceAllocator = new GenericAllocator<>(resourceFeatures);
		resourceAllocator2 = new ModelAllocator(process, resourceFeatures);
		descriptorPoolAllocator = new ModelAllocator(process, getDescriptorPoolFeatureLists());
		pipelineAllocator = new GenericAllocator<>(getPipelineFeatureLists());
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

		allocationChildren.add(processAllocator);
		allocationChildren.add(resourceAllocator.getAllocable());
		allocationChildren.add(resourceAllocator2);
		allocationChildren.add(descriptorPoolAllocator);
		allocationChildren.add(pipelineAllocator.getAllocable());

		config.addChildren(allocationChildren);
	}

	@Override
	public void allocate(IVulkanContext context)
	{
	}

	@Override
	public void free(IVulkanContext context)
	{
	}

	@Override
	public void start(final IVulkanContext vulkanContext, final IRootAllocator<IVulkanContext> rootAllocator)
	{
		context = new ProcessContext(vulkanContext, getExecutionQueueType(), isResetAllowed(), process);
		allocator = IAllocationService.INSTANCE.createAllocator(rootAllocator, this, context);
		allocator.allocate();

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printAllocationTree();
		}
	}

	@Override
	public void stop(IVulkanContext vulkanContext)
	{
		waitIdle();
		allocator.free();
		allocator = null;
		context.free(vulkanContext);
		context = null;
	}

	private IExecutionRecorders getRecorders()
	{
		return getProcessConfiguration().allocationHandle(IExecutionRecorders.class).get();
	}

	@Override
	public void checkFence()
	{
		if (context != null)
		{
			final var recorders = getRecorders();
			recorders.checkFence();
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
		final var recorders = getProcessConfiguration().allocationHandle(IExecutionRecorders.class).get();
		final Integer next = recorders.acquire();
		return next;
	}

	private IFenceView execute(int next)
	{
		final var recorders = getRecorders();
		final var recorder = recorders.prepare(next);

		if (process.isWaitingFenceDuringAcquire())
		{
			recorder.waitIdle();
		}

		return recorder.play();
	}

	@Override
	public void waitIdle()
	{
		final var recorders = getRecorders();
		recorders.waitIdle();
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

	protected boolean prepareDescriptors()
	{
		boolean dirty = false;
		final var pools = new CompositeModelExplorer(getDescriptorPoolFeatureLists()).explore(process,
																							  DescriptorPool.class);
		for (var descriptorPool : pools)
		{
			final var descriptorPoolAllocation = descriptorPool.allocationHandle(DescriptorPoolAllocation.class).get();
			descriptorPoolAllocation.prepare();
			if (descriptorPoolAllocation.hasChanged())
			{
				waitIdle();
				try (final var stack = MemoryStack.stackPush())
				{
					descriptorPoolAllocation.update(stack);
				}
				dirty = true;
			}

		}
		return dirty;
	}

	private void invalidateRecords()
	{
		final var recorders = getRecorders();
		recorders.invalidate();
	}

	private boolean prepareAllocation()
	{
		if (pipelineAllocator.isDirty() || resourceAllocator.isDirty())
		{
			waitIdle();
		}

		context.beforeChildrenAllocation();
		processAllocator.update(context);
		resourceAllocator2.update(context);
		descriptorPoolAllocator.update(context);
		context.afterChildrenAllocation();

		boolean recorderDirty = false;
		final var recorders = getProcessConfiguration().allocationHandle(IExecutionRecorders.class).get();
		if (this.recorders != recorders)
		{
			this.recorders = recorders;
			recorderDirty = true;
		}

		if (allocator.isAllocationDirty() || recorderDirty)
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
	protected abstract ProcessConfiguration getProcessConfiguration();
	protected abstract List<List<EReference>> getResourceFeatureLists();
	protected abstract List<List<EReference>> getDescriptorPoolFeatureLists();
}
