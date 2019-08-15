package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.process.IProcessContext;

public interface ISubmission<T extends IProcessContext> extends IAllocable<T>
{
	VkSubmitInfo getSubmitInfo();

	void submit();

	void waitIdle();

	boolean isBusy();
}
