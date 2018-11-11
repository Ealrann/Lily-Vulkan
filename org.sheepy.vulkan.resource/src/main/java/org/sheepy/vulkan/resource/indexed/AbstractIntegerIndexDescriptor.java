package org.sheepy.vulkan.resource.indexed;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;

public abstract class AbstractIntegerIndexDescriptor<T extends IVertex> implements IIndexBufferDescriptor<T>
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
