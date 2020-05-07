package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext.IExecutionIdleListener;

import java.util.List;

public interface ISubmission
{
	VkSubmitInfo getSubmitInfo();

	IFenceView submit();
	void waitIdle();

	boolean isBusy();
	void setExecutionIdleListeners(List<IExecutionIdleListener> listeners);
	void checkFence();
}
