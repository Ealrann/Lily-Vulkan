package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferData;
import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferDescriptor;
import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferDescriptor.Vertex;
import org.sheepy.lily.vulkan.demo.mesh.AbstractMeshBuilder;

public class TriangleMeshBuilder extends AbstractMeshBuilder<Vertex>
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

		return new IndexedBufferData<>(vertices, indices, null, new IndexedBufferDescriptor());
	}
}
