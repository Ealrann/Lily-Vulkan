package org.sheepy.lily.vulkan.demo.mesh;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;

public abstract class AbstractMeshBuilder
{
	private final ByteBuffer data;
	long indexOffset;
	int indexCount;

	public AbstractMeshBuilder(float[] vertices, int[] indices)
	{
		final var vertexProvider = new VertexProvider(vertices);
		final var indexProvider = new IndexProvider(indices);

		final long size = vertexProvider.getSize() + indexProvider.getSize();
		indexCount = indexProvider.getDataCount();
		indexOffset = vertexProvider.getSize();

		data = MemoryUtil.memAlloc((int) size);
		final long address = MemoryUtil.memAddress(data);
		vertexProvider.fill(address);
		indexProvider.fill(address + indexOffset);
	}

	public ByteBuffer getData()
	{
		return data;
	}

	public long getIndexOffset()
	{
		return indexOffset;
	}

	public int getIndexCount()
	{
		return indexCount;
	}

	private static class VertexProvider
	{
		private final float[] vertices;

		public VertexProvider(float[] vertices)
		{
			this.vertices = vertices;
		}

		public long getSize()
		{
			return vertices.length * 4;
		}

		public void fill(long memoryAddress)
		{
			final var buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) getSize());
			buffer.asFloatBuffer().put(vertices);
		}
	}

	private static class IndexProvider
	{
		private final int[] indices;

		public IndexProvider(int[] indices)
		{
			this.indices = indices;
		}

		public void fill(long memoryAddress)
		{
			final var buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) getSize());
			buffer.asIntBuffer().put(indices);
		}

		public long getSize()
		{
			return indices.length * Integer.BYTES;
		}

		public int getDataCount()
		{
			return indices.length;
		}
	}
}