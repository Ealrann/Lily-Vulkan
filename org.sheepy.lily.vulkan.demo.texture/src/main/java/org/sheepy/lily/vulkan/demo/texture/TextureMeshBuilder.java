package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferData;
import org.sheepy.lily.vulkan.demo.adapter.CameraMatrixComputer;
import org.sheepy.lily.vulkan.demo.mesh.AbstractMeshBuilder;
import org.sheepy.lily.vulkan.resource.texture.TextureVertexDescriptor;
import org.sheepy.lily.vulkan.resource.texture.TextureVertexDescriptor.TextureVertex;

public class TextureMeshBuilder extends AbstractMeshBuilder<TextureVertex>
{
	@Override
	protected IndexedBufferData<TextureVertex> buildData()
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

		final byte[] uniformData = new byte[CameraMatrixComputer.SIZE_OF];

		return new IndexedBufferData<>(vertices, indices, uniformData,
				new TextureVertexDescriptor());
	}
}
