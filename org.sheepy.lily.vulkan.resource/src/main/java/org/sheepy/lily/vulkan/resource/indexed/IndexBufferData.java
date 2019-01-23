package org.sheepy.lily.vulkan.resource.indexed;

public class IndexBufferData<T extends IVertex>
{
	public final T[] vertices;
	public final int[] indices;
	public final IIndexBufferDescriptor<T> indexDescriptor;

	public IndexBufferData(T[] vertices, int[] indices, IIndexBufferDescriptor<T> indexDescriptor)
	{
		this.vertices = vertices;
		this.indices = indices;
		this.indexDescriptor = indexDescriptor;
	}
}