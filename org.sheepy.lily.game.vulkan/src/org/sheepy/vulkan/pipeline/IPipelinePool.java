package org.sheepy.vulkan.pipeline;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;

public interface IPipelinePool
{
	void load(MemoryStack stack, long surface, int width, int height);

	void execute();

	void resize(long surface, int width, int height);

	void free();

	CommandPool getCommandPool();
}
