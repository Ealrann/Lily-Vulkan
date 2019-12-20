package org.sheepy.lily.vulkan.demo.mesh;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

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

		data = BufferUtils.createByteBuffer((int) size);
		vertexProvider.fill(data);
		indexProvider.fill(data);
		data.flip();
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

		public void fill(ByteBuffer buffer)
		{
			for (final float vertice : vertices)
			{
				buffer.putFloat(vertice);
			}
		}
	}

	private static class IndexProvider
	{
		private final int[] indices;

		public IndexProvider(int[] indices)
		{
			this.indices = indices;
		}

		public void fill(ByteBuffer buffer)
		{
			for (final int index : indices)
			{
				buffer.putInt(index);
			}
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