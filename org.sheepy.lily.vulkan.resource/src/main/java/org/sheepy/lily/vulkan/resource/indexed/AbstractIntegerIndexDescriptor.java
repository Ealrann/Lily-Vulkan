package org.sheepy.lily.vulkan.resource.indexed;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.IIndexedBufferDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVertex;

public abstract class AbstractIntegerIndexDescriptor<T extends IVertex> implements IIndexedBufferDescriptor<T>
{

	@Override
	public int sizeOfIndex()
	{
		return Integer.BYTES;
	}

	@Override
	public ByteBuffer toIndexBuffer(int[] indices)
	{
		ByteBuffer res = MemoryUtil.memAlloc(indices.length * Integer.BYTES);
		IntBuffer sb = res.asIntBuffer();

		for (int index : indices)
		{
			sb.put(index);
		}

		return res;
	}
}
