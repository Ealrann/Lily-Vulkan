package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;

public interface ISamplerAdapter extends IAllocableAdapter<InternalExecutionContext>
{
	long getSamplerPtr();
	long getViewPtr();
}
