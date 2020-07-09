package org.sheepy.lily.vulkan.process.process;

import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractProcessAllocation implements IProcessAdapter
{
	protected final AbstractProcess process;
	protected final IVulkanContext vulkanContext;
	protected final ProcessContext context;
	private final List<IExecutionPlayer> runningRecorders = new LinkedList<>();

	private long startPrepareNs = 0;

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
		return getProcessExecutionManager().adapt(IExecutionRecorders.class);
	}

	@Override
	public IFenceView run()
	{
		final var nextPlayer = prepareNext();
		if (nextPlayer != null)
		{
			return execute(nextPlayer);
		}
		else
		{
			return null;
		}
	}

	private IExecutionPlayer prepareNext()
	{
		if (DebugUtil.DEBUG_ENABLED)
		{
			startPrepareNs = System.nanoTime();
		}

		checkFences();
		IAllocationService.INSTANCE.updateAllocation(process, vulkanContext, IProcessAdapter.class);

		final var nextPlayer = acquireNextPlayer();

		if (DebugUtil.DEBUG_ENABLED)
		{
			IStatistics.INSTANCE.addTime(getClass().getSimpleName(), System.nanoTime() - startPrepareNs);
		}

		return nextPlayer;
	}

	@Override
	public void checkFences()
	{
		runningRecorders.removeIf(IExecutionPlayer::checkFence);
	}

	private IExecutionPlayer acquireNextPlayer()
	{
		final var recorders = getProcessExecutionManager().adapt(IExecutionRecorders.class);
		return recorders.acquire();
	}

	private IFenceView execute(IExecutionPlayer next)
	{
		if (process.isWaitingFenceDuringAcquire())
		{
			next.waitIdle();
		}
		runningRecorders.add(next);
		return next.play();
	}

	@Override
	public void waitIdle()
	{
		runningRecorders.forEach(IExecutionPlayer::waitIdle);
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

	protected abstract ProcessExecutionManager getProcessExecutionManager();
}
