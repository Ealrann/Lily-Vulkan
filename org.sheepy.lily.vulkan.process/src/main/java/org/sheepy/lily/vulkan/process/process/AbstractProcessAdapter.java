package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.EReference;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.CompositeModelExplorer;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.core.allocation.ModelStaticAllocator;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPoolAllocation;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionRecorder;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;

import java.util.List;

public abstract class AbstractProcessAdapter implements InternalProcessAdapter
{
	protected final AbstractProcess process;
	protected ProcessContext context;

	private final ModelStaticAllocator allocator;

	private long startPrepareNs = 0;
	private IExecutionRecorders recorders = null;

	public AbstractProcessAdapter(AbstractProcess process)
	{
		this.process = process;
		allocator = new ModelStaticAllocator(process);
	}

	@Override
	public void start(final IVulkanContext vulkanContext)
	{
		context = new ProcessContext(vulkanContext, getExecutionQueueType(), isResetAllowed(), process);

		context.beforeChildrenAllocation();
		allocator.allocate(context);
		context.afterChildrenAllocation();

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printAllocationTree();
		}
	}

	@Override
	public void stop(IVulkanContext vulkanContext)
	{
		waitIdle();
		allocator.free(context);
		context.free(vulkanContext);
		context = null;
	}

	private IExecutionRecorders getRecorders()
	{
		return getProcessExecutionRecorder().adapt(IExecutionRecorders.class);
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
		final var recorders = getProcessExecutionRecorder().adapt(IExecutionRecorders.class);
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
			final var descriptorPoolAllocation = descriptorPool.adapt(DescriptorPoolAllocation.class);
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
		context.beforeChildrenAllocation();
		allocator.update(context);
		context.afterChildrenAllocation();

		boolean recorderDirty = false;
		final var recorders = getProcessExecutionRecorder().adapt(IExecutionRecorders.class);
		if (this.recorders != recorders)
		{
			this.recorders = recorders;
			recorderDirty = true;
		}

		return recorderDirty;
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

	protected abstract ProcessExecutionRecorder getProcessExecutionRecorder();
	protected abstract List<List<EReference>> getDescriptorPoolFeatureLists();
}
