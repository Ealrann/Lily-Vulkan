package org.sheepy.vulkan.resource.indexed;

public class IndexedBufferData<T extends IVertex>
{
	public final T[] vertices;
	public final int[] indices;
	public final byte[] uniformData;
	
	public final IIndexedBufferDescriptor<T> meshDescriptor;

	public IndexedBufferData(T[] vertices, int[] indices, byte[] uniformData, IIndexedBufferDescriptor<T> meshDescriptor)
	{
		this.vertices = vertices;
		this.indices = indices;
		this.uniformData = uniformData;
		this.meshDescriptor = meshDescriptor;
	}
}