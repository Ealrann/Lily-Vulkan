package test.vulkan.texture;

import org.sheepy.vulkan.resource.indexed.IIndexedBufferBuilder;
import org.sheepy.vulkan.resource.indexed.IndexBufferData;
import org.sheepy.vulkan.resource.texture.TextureVertexDescriptor;
import org.sheepy.vulkan.resource.texture.TextureVertexDescriptor.TextureVertex;

public class TextureMeshBuilder implements IIndexedBufferBuilder<TextureVertex>
{
	@Override
	public IndexBufferData<TextureVertex> getDatas()
	{
		final TextureVertex[] vertices = new TextureVertex[8];
		vertices[0] = new TextureVertex(-0.5f, -0.5f, 0f, 1.0f, 0.0f, 0.0f, 1f, 0f);
		vertices[1] = new TextureVertex(0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0f, 0f);
		vertices[2] = new TextureVertex(0.5f, 0.5f, 0f, 0.0f, 0.0f, 1.0f, 0f, 1f);
		vertices[3] = new TextureVertex(-0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 1f, 1f);

		vertices[4] = new TextureVertex(-0.5f, -0.5f, -0.5f, 1.0f, 0.0f, 0.0f, 1f, 0f);
		vertices[5] = new TextureVertex(0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 0f, 0f);
		vertices[6] = new TextureVertex(0.5f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0f, 1f);
		vertices[7] = new TextureVertex(-0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 1f, 1f);

		final int[] indices = {
				0, 1, 2, 2, 3, 0, 4, 5, 6, 6, 7, 4
		};

		final IndexBufferData<TextureVertex> res = new IndexBufferData<>(vertices, indices,
				new TextureVertexDescriptor());

		return res;
	}
}
