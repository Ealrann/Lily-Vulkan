package org.sheepy.lily.vulkan.api.resource.buffer;

import java.util.List;

import org.sheepy.lily.vulkan.model.resource.CompositePartReference;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;

public interface ICompositeBufferAdapter extends IBufferAdapter
{
	void recordFlush(EFlushMode mode, List<CompositePartReference> refs);
	
	long getOffset(int componentIndex, int instance);
	boolean needRecord();
}
