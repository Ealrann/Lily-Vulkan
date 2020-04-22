package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.vulkan.demo.mesh.AbstractMeshBuilder;

public class TextureMeshBuilder extends AbstractMeshBuilder
{
	public static final String ADAPT_NAME = "TextureVertexBuffer";

	private static final float[] vertices = new float[] {
		-0.5f, -0.5f,  0.0f, 1.0f, 0.0f, 0.0f, 1f, 0f,
		 0.5f, -0.5f,  0.0f, 1.0f, 1.0f, 0.0f, 0f, 0f,
		 0.5f,  0.5f,  0.0f, 0.0f, 0.0f, 1.0f, 0f, 1f,
		-0.5f,  0.5f,  0.0f, 1.0f, 1.0f, 0.0f, 1f, 1f,

		-0.5f, -0.5f, -0.5f, 1.0f, 0.0f, 0.0f, 0f, 1f,
		 0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 1f, 1f,
		 0.5f,  0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 1f, 0f,
		-0.5f,  0.5f, -0.5f, 1.0f, 1.0f, 0.0f, 0f, 0f,


		-0.5f, -0.5f, -1.5f, 1.0f, 0.0f, 0.0f, 0f, 1f,
		 0.5f, -0.5f, -1.5f, 1.0f, 1.0f, 0.0f, 1f, 1f,
		 0.5f,  0.5f, -1.5f, 0.0f, 0.0f, 1.0f, 1f, 0f,
		-0.5f,  0.5f, -1.5f, 1.0f, 1.0f, 0.0f, 0f, 0f,
	};

	private static final int[] indices = {
			0, 1, 2, 2, 3, 0, 4, 5, 6, 6, 7, 4, 8, 9, 10, 10, 11, 8
	};

	public TextureMeshBuilder()
	{
		super(vertices, indices);
	}
}
