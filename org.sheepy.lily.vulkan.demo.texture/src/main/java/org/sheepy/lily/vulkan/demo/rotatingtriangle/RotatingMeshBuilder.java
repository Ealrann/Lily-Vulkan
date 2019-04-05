package org.sheepy.lily.vulkan.demo.rotatingtriangle;

import org.sheepy.lily.vulkan.demo.adapter.CameraMatrixComputer;
import org.sheepy.lily.vulkan.demo.mesh.AbstractMeshBuilder;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferData;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferDescriptor;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferDescriptor.Vertex;

public class RotatingMeshBuilder extends AbstractMeshBuilder<Vertex>
{
	// {{-0.5f, -0.5f}, {1.0f, 0.0f, 0.0f}},
	// {{0.5f, -0.5f}, {0.0f, 1.0f, 0.0f}},
	// {{0.5f, 0.5f}, {0.0f, 0.0f, 1.0f}},
	// {{-0.5f, 0.5f}, {1.0f, 1.0f, 1.0f}}

	@Override
	protected IndexedBufferData<Vertex> buildData()
	{
		final Vertex[] vertices = new Vertex[4];
		vertices[0] = new Vertex(-0.5f, -0.5f, 1.0f, 1.0f, 1.0f);
		vertices[1] = new Vertex(0.5f, -0.5f, 0.0f, 1.0f, 0.0f);
		vertices[2] = new Vertex(0.5f, 0.5f, 0.0f, 0.0f, 0.0f);
		vertices[3] = new Vertex(-0.5f, 0.5f, 0.0f, 0.0f, 1.0f);

		final int[] indices = {
				0, 1, 2, 2, 3, 0
		};

		final byte[] uniformData = new byte[CameraMatrixComputer.SIZE_OF];

		final IndexedBufferData<Vertex> res = new IndexedBufferData<>(vertices, indices,
				uniformData, new IndexedBufferDescriptor());

		return res;
	}
}
