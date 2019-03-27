package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkSubmitInfo;

public interface ISubmission
{
	VkSubmitInfo getSubmitInfo();

	void submit();

	void waitIdle();

	boolean isBusy();
}
