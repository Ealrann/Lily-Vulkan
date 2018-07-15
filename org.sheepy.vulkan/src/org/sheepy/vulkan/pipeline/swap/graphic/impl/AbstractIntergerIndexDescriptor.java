package org.sheepy.vulkan.pipeline.swap.graphic.impl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.buffer.IVertex;
import org.sheepy.vulkan.pipeline.swap.graphic.IIndexBufferDescriptor;

public abstract class AbstractIntergerIndexDescriptor<T extends IVertex> implements IIndexBufferDescriptor<T>
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
