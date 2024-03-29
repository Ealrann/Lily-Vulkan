package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public final class RecordContext extends VulkanContext implements IRecordContext
{
	public final VkCommandBuffer commandBuffer;
	public final ECommandStage stage;
	public final int executionID;
	public final int recordIndex;

	private final List<Consumer<EExecutionStatus>> listeners = new ArrayList<>();

	public RecordContext(final IVulkanContext vulkanContext,
						 final VkCommandBuffer commandBuffer,
						 final ECommandStage stage,
						 final int executionID,
						 final int recordIndex)
	{
		super(vulkanContext);
		this.commandBuffer = commandBuffer;
		this.stage = stage;
		this.executionID = executionID;
		this.recordIndex = recordIndex;
	}

	@Override
	public void lockAllocationDuringExecution(final IAllocationState allocationState)
	{
		final var recordLocker = new RecordLocker(allocationState);
		listenExecution(recordLocker::onStatusChange);
	}

	@Override
	public void listenExecution(Consumer<EExecutionStatus> listener)
	{
		listeners.add(listener);
	}

	public List<Consumer<EExecutionStatus>> getExecutionListeners()
	{
		return Collections.unmodifiableList(listeners);
	}

	@Override
	public VkCommandBuffer vkCommandBuffer()
	{
		return commandBuffer;
	}

	@Override
	public ECommandStage stage()
	{
		return stage;
	}

	private static final class RecordLocker
	{
		private final IAllocationState allocationState;
		private IAllocationState.Lock lock = null;

		public RecordLocker(IAllocationState allocationState)
		{
			this.allocationState = allocationState;
		}

		public void onStatusChange(EExecutionStatus status)
		{
			switch (status)
			{
				case Started -> lock();
				case Done, Canceled -> unlock();
			}
		}

		private void lock()
		{
			assert lock == null;
			lock = allocationState.lockUntil();
		}

		private void unlock()
		{
			lock.unlock();
			lock = null;
		}
	}
}
