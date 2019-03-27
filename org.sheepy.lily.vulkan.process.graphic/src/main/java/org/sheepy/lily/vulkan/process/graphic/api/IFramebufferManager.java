package org.sheepy.lily.vulkan.process.graphic.api;

import java.util.List;

import org.joml.Vector4fc;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;

public interface IFramebufferManager extends IAllocable
{
	List<ClearInfo> getClearInfos();

	List<Long> getFramebufferAddresses();

	boolean hasDepthAttachment();

	public class ClearInfo
	{
		public final boolean isdepthStencil;
		public final Vector4fc color;

		public ClearInfo(boolean isdepthStencil, Vector4fc color)
		{
			this.isdepthStencil = isdepthStencil;
			this.color = color;
		}
	}

}
