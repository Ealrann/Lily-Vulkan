package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;

public interface ISubmission
{
	VkSubmitInfo getSubmitInfo();

	IFenceView submit();
	void waitIdle();

	boolean isRunning();
	void checkFence();
}
