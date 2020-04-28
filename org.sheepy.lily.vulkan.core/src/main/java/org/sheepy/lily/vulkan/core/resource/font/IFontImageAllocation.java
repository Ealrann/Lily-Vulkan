package org.sheepy.lily.vulkan.core.resource.font;

import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

import java.util.List;
import java.util.Map;

public interface IFontImageAllocation extends IVkImageAllocation
{
	List<? extends IFontAllocator> getAllocators();
	boolean push(Map<Font, List<String>> characterMap, TransferBuffer transferBuffer);
}
