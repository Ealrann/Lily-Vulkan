package org.sheepy.lily.vulkan.process.graphic.api;

import java.util.List;

import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.nativehelper.ClearInfo;

public interface IFramebufferManager extends IAllocable
{
	List<ClearInfo> getClearInfos();

	List<Long> getFramebufferAddresses();

	boolean hasDepthAttachment();
}
