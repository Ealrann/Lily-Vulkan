package org.sheepy.lily.game.core.allocation;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.api.allocation.IGameAllocationContext;

public class GameAllocationContext implements IGameAllocationContext
{
	private MemoryStack stack = null;

	@Override
	public void beforeChildrenAllocation()
	{
		stackPush();
	}

	@Override
	public void afterChildrenAllocation()
	{
		stackPop();
	}

	public MemoryStack stackPush()
	{
		assert stack == null;
		stack = MemoryStack.stackPush();
		return stack;
	}

	public void stackPop()
	{
		if (stack != null)
		{
			stack.pop();
			stack = null;
		}
	}

	@Override
	public MemoryStack stack()
	{
		return stack;
	}
}
