package org.sheepy.lily.vulkan.api.resource.font;

import java.util.List;
import java.util.Map;

import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

public interface IFontImageAdapter extends IImageAdapter
{
	List<? extends IFontAllocator> getAllocators();
	boolean push(Map<Font, List<String>> characterMap, TransferBuffer transferBuffer);
}