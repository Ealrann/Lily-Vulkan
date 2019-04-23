package org.sheepy.vulkan.resource.indexed;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;

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
		final ByteBuffer res = MemoryUtil.memAlloc(indices.length * Integer.BYTES);
		final IntBuffer sb = res.asIntBuffer();

		for (final int index : indices)
		{
			sb.put(index);
		}

		return res;
	}
}
