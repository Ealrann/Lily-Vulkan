package org.sheepy.lily.game.api.execution;

import org.lwjgl.system.MemoryStack;

public interface IRecordContext
{
	MemoryStack stack();
	int index();
	void listenExecution(Runnable whenExecutionDone);
}
