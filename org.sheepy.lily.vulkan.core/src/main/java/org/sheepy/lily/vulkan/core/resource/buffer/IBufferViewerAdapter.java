package org.sheepy.lily.vulkan.core.resource.buffer;

import org.logoce.lmf.core.api.extender.IAdapter;

public interface IBufferViewerAdapter extends IAdapter
{
	<T extends IAdapter> T adaptDataSource(final Class<T> type);
}
