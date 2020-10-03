package org.sheepy.lily.vulkan.core.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IBufferViewerAdapter extends IExtender
{
	<T extends IExtender> T adaptDataSource(final Class<T> type);
}
