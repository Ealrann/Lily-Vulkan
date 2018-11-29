package org.sheepy.vulkan.api.window;

public class Surface
{

	public final long id;
	public final int width;
	public final int height;
	
	public final int[] size;
	
	public Surface(long id, int width, int height)
	{
		this.id = id;
		this.width = width;
		this.height = height;
		
		size = new int[] { width, height } ;
	}
}
