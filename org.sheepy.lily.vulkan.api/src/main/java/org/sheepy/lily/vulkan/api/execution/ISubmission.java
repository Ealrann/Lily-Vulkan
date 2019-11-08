package org.sheepy.lily.vulkan.api.execution;

import java.util.List;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.execution.IRecordable.RecordContext.IExecutionIdleListener;

public interface ISubmission<T extends IProcessContext> extends IAllocable<T>
{
	VkSubmitInfo getSubmitInfo();

	IFenceView submit();

	void waitIdle();

	boolean isBusy();

	void setExecutionIdleListeners(List<IExecutionIdleListener> listeners);

	void checkFence();
}
