package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.demo.mesh.IIndexedBufferBuilder;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBuffer;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferData;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferDescriptor;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferDescriptor.Vertex;

public class TriangleMeshBuilder implements IIndexedBufferBuilder<Vertex>
{
	// {{-0.5f, -0.5f}, {1.0f, 0.0f, 0.0f}},
	// {{0.5f, -0.5f}, {0.0f, 1.0f, 0.0f}},
	// {{0.5f, 0.5f}, {0.0f, 0.0f, 1.0f}},
	// {{-0.5f, 0.5f}, {1.0f, 1.0f, 1.0f}}
	private static IndexedBufferData<Vertex> getDatas()
	{
		final Vertex[] vertices = new Vertex[4];
		vertices[0] = new Vertex(-0.5f, -0.5f, 1.0f, 1.0f, 1.0f);
		vertices[1] = new Vertex(0.5f, -0.5f, 0.0f, 1.0f, 0.0f);
		vertices[2] = new Vertex(0.5f, 0.5f, 0.0f, 0.0f, 0.0f);
		vertices[3] = new Vertex(-0.5f, 0.5f, 0.0f, 0.0f, 1.0f);

		final int[] indices = {
				0, 1, 2, 2, 3, 0
		};

		final IndexedBufferData<Vertex> res = new IndexedBufferData<>(vertices, indices,
				new IndexedBufferDescriptor());

		return res;
	}

	@Override
	public IndexedBuffer<Vertex> build(IExecutionContext executionManager)
	{
		return IndexedBuffer.alloc(executionManager, getDatas(), false);
	}
}
