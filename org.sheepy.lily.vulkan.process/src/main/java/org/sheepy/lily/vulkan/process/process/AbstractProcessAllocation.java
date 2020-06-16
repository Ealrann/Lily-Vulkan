package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.EReference;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.CompositeModelExplorer;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPoolAllocation;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionRecorder;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;

import java.util.List;

public abstract class AbstractProcessAllocation implements IProcessAdapter
{
	protected final AbstractProcess process;
	protected final IVulkanContext vulkanContext;
	protected final ProcessContext context;

	private long startPrepareNs = 0;
	private IExecutionRecorders recorders = null;

	public AbstractProcessAllocation(AbstractProcess process, IVulkanContext vulkanContext)
	{
		this.process = process;
		this.vulkanContext = vulkanContext;
		final var executionQueueType = process.adapt(InternalProcessAdapter.class).getExecutionQueueType();
		context = new ProcessContext(vulkanContext, executionQueueType, isResetAllowed(), process);
	}

	@ProvideContext
	private ProcessContext provideContext()
	{
		return context;
	}

	@Free
	private void free()
	{
		context.free(vulkanContext);
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
		boolean recorderDirty = false;

		IAllocationService.INSTANCE.ensureAllocation(process, vulkanContext);

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

	@Override
	public boolean isMultithreadAllowed()
	{
		return context.getQueue().isShared() == false;
	}

	protected abstract ProcessExecutionRecorder getProcessExecutionRecorder();
	protected abstract List<List<EReference>> getDescriptorPoolFeatureLists();
}
