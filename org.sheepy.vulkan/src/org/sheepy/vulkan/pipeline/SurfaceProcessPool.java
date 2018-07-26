package org.sheepy.vulkan.pipeline;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.window.Surface;

public abstract class SurfaceProcessPool<T extends AbstractProcess<?>> extends AbstractProcessPool<T>
{
	public SurfaceProcessPool(Configuration configuration, int queueIndex, boolean allowReset)
	{
		super(configuration, queueIndex, allowReset);
	}

	public SurfaceProcessPool(Configuration configuration, int queueIndex)
	{
		super(configuration, queueIndex);
	}
	
	public abstract void configure(Surface surface);
	public abstract void resize(MemoryStack stack, Surface surface);
}
