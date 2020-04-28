package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;

public interface IExtraAttachmentAllocation<T extends ExecutionContext> extends IVkImageAllocation,
																				IAllocableAdapter<T>
{
	ClearInfo getClearInfos();
	int getImageFormat();
}
