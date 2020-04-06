package org.sheepy.lily.vulkan.core.graphic;

import java.util.List;

public interface IRenderPass
{
	long getPtr();

	List<ClearInfo> getClearInfos();
}
