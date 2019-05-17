package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.demo.mesh.AbstractMeshBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.MeshProvider;

@Statefull
@Adapter(scope = MeshProvider.class, name = TextureMeshBuilder.ADAPT_NAME)
public class TextureMeshBuilder extends AbstractMeshBuilder 
{
	public static final String ADAPT_NAME = "TextureVertexBuffer";

	private static final float[] vertices = new float[] {
		-0.5f, -0.5f, 0f, 1.0f, 0.0f, 0.0f, 1f, 0f,
		0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0f, 0f,
		0.5f, 0.5f, 0f, 0.0f, 0.0f, 1.0f, 0f, 1f,
		-0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 1f, 1f,

		-0.5f, -0.5f, -0.5f, 1.0f, 0.0f, 0.0f, 0f, 1f,
		0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 1f, 1f,
		0.5f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 1f, 0f,
		-0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 0f, 0f
	};

	private static final int[] indices = {
			0, 1, 2, 2, 3, 0, 4, 5, 6, 6, 7, 4
	};

	public TextureMeshBuilder()
	{
		super(vertices, indices);
	}
}
