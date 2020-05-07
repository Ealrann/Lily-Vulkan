package org.sheepy.lily.game.api.allocation;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public interface IGameAllocationContext extends IAllocationContext
{
	MemoryStack stack();
}
