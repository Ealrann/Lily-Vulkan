package org.sheepy.lily.vulkan.common.execution;

import java.util.List;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.common.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.lily.vulkan.common.process.IProcessContext;

public interface ISubmission<T extends IProcessContext> extends IAllocable<T>
{
	VkSubmitInfo getSubmitInfo();

	IFenceView submit();

	void waitIdle();

	boolean isBusy();

	void setExecutionIdleListeners(List<IExecutionIdleListener> listeners);

	void checkFence();
}
