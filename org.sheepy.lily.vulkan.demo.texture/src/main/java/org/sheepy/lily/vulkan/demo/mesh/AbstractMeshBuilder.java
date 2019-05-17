package org.sheepy.lily.vulkan.demo.mesh;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.mesh.data.IMeshIndexDataProvider;
import org.sheepy.lily.vulkan.api.resource.mesh.data.IMeshVertexDataProvider;

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

	private static class VertexProvider implements IMeshVertexDataProvider
	{
		private final float[] vertices;

		public VertexProvider(float[] vertices)
		{
			this.vertices = vertices;
		}

		@Override
		public long getSize()
		{
			return vertices.length * 4;
		}

		@Override
		public void fill(long memoryAddress)
		{
			final var buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) getSize());
			buffer.asFloatBuffer().put(vertices);
		}

		@Override
		public boolean hasChanged()
		{
			return false;
		}
	}

	private static class IndexProvider implements IMeshIndexDataProvider
	{
		private final int[] indices;

		public IndexProvider(int[] indices)
		{
			this.indices = indices;
		}

		@Override
		public void fill(long memoryAddress)
		{
			final var buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) getSize());
			buffer.asIntBuffer().put(indices);
		}

		@Override
		public long getSize()
		{
			return indices.length * Integer.BYTES;
		}

		@Override
		public int getDataCount()
		{
			return indices.length;
		}

		@Override
		public boolean hasChanged()
		{
			return false;
		}
	}
}