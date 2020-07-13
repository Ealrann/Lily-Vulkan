package org.sheepy.lily.game.api.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocationState;

import java.util.function.Consumer;

public interface IRecordContext
{
	MemoryStack stack();
	int index();
	void listenExecution(Consumer<EExecutionStatus> listener);
	void lockAllocationDuringExecution(IAllocationState allocationState);
}
