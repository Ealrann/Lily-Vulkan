package org.sheepy.lily.vulkan.api.graphic;

import org.joml.Vector4fc;

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
