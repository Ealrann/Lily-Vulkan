package org.sheepy.lily.vulkan.resource.indexed;

public class IndexedBufferData<T extends IVertex>
{
	public final T[] vertices;
	public final int[] indices;
	public final IIndexedBufferDescriptor<T> meshDescriptor;

	public IndexedBufferData(T[] vertices, int[] indices, IIndexedBufferDescriptor<T> meshDescriptor)
	{
		this.vertices = vertices;
		this.indices = indices;
		this.meshDescriptor = meshDescriptor;
	}
}
