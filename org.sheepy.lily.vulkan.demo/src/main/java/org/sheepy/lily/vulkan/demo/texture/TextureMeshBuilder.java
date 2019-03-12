package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.demo.mesh.IIndexedBufferBuilder;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBuffer;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferData;
import org.sheepy.lily.vulkan.resource.texture.TextureVertexDescriptor;
import org.sheepy.lily.vulkan.resource.texture.TextureVertexDescriptor.TextureVertex;

public class TextureMeshBuilder implements IIndexedBufferBuilder<TextureVertex>
{
	private static IndexedBufferData<TextureVertex> getDatas()
	{
		final TextureVertex[] vertices = new TextureVertex[8];
		vertices[0] = new TextureVertex(-0.5f, -0.5f, 0f, 1.0f, 0.0f, 0.0f, 1f, 0f);
		vertices[1] = new TextureVertex(0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0f, 0f);
		vertices[2] = new TextureVertex(0.5f, 0.5f, 0f, 0.0f, 0.0f, 1.0f, 0f, 1f);
		vertices[3] = new TextureVertex(-0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 1f, 1f);

		vertices[4] = new TextureVertex(-0.5f, -0.5f, -0.5f, 1.0f, 0.0f, 0.0f, 0f, 1f);
		vertices[5] = new TextureVertex(0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 1f, 1f);
		vertices[6] = new TextureVertex(0.5f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 1f, 0f);
		vertices[7] = new TextureVertex(-0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 0f, 0f);

		final int[] indices = {
				0, 1, 2, 2, 3, 0, 4, 5, 6, 6, 7, 4
		};

		final IndexedBufferData<TextureVertex> res = new IndexedBufferData<>(vertices, indices,
				new TextureVertexDescriptor());

		return res;
	}

	@Override
	public IndexedBuffer<TextureVertex> build(ExecutionContext executionManager)
	{
		return IndexedBuffer.alloc(executionManager, getDatas(), false);
	}
}
