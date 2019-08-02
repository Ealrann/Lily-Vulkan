package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

public final class StructureContext
{
	public final CompositeBuffer buffer;
	public final int part;

	public StructureContext(CompositeBuffer buffer, int part)
	{
		this.buffer = buffer;
		this.part = part;
	}
}