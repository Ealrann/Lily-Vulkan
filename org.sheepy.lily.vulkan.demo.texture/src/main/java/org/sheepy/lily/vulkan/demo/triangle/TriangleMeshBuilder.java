package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.vulkan.demo.mesh.AbstractMeshBuilder;

public class TriangleMeshBuilder extends AbstractMeshBuilder
{
	// {{-0.5f, -0.5f}, {1.0f, 0.0f, 0.0f}},
	// {{0.5f, -0.5f}, {0.0f, 1.0f, 0.0f}},
	// {{0.5f, 0.5f}, {0.0f, 0.0f, 1.0f}},
	// {{-0.5f, 0.5f}, {1.0f, 1.0f, 1.0f}}
	private static final float[] vertices = new float[] {
			-0.5f,
			-0.5f,
			1.0f,
			1.0f,
			1.0f,

			0.5f,
			-0.5f,
			0.0f,
			1.0f,
			0.0f,

			0.5f,
			0.5f,
			0.0f,
			0.0f,
			0.0f,

			-0.5f,
			0.5f,
			0.0f,
			0.0f,
			1.0f,
	};

	private static final int[] indices = {
			0, 1, 2, 2, 3, 0
	};

	public TriangleMeshBuilder()
	{
		super(vertices, indices);
	}
}
