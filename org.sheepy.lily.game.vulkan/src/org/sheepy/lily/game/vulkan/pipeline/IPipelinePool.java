package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.command.CommandPool;

public interface IPipelinePool
{

	void execute();
	
	void resize(long surface, int width, int height);
	
	void free();
	
	CommandPool getCommandPool();

	void load(MemoryStack stack, long surface, int width, int height);
}
