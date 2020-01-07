package org.sheepy.lily.vulkan.demo.mesh;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

public abstract class AbstractMeshBuilder
{
	private final ByteBuffer vertexData;
	private final ByteBuffer indexData;
	int indexCount;

	public AbstractMeshBuilder(float[] vertices, int[] indices)
	{
		final var vertexProvider = new VertexProvider(vertices);
		final var indexProvider = new IndexProvider(indices);

		indexCount = indexProvider.getDataCount();

		vertexData = BufferUtils.createByteBuffer((int) vertexProvider.getSize());
		indexData = BufferUtils.createByteBuffer((int) indexProvider.getSize());
		vertexProvider.fill(vertexData);
		indexProvider.fill(indexData);
		vertexData.flip();
		indexData.flip();
	}

	public ByteBuffer getVertexData()
	{
		return vertexData;
	}

	public ByteBuffer getIndexData()
	{
		return indexData;
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