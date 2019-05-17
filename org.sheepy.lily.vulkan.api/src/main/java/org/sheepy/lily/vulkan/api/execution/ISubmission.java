package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.allocation.IAllocable;

public interface ISubmission<T extends IProcessContext> extends IAllocable<T>
{
	VkSubmitInfo getSubmitInfo();

	void submit();

	void waitIdle();

	boolean isBusy();
}
