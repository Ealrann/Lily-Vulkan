package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
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
		Vertex[] vertices = new Vertex[4];
		vertices[0] = new Vertex(-0.5f, -0.5f, 1.0f, 1.0f, 1.0f);
		vertices[1] = new Vertex(0.5f, -0.5f, 0.0f, 1.0f, 0.0f);
		vertices[2] = new Vertex(0.5f, 0.5f, 0.0f, 0.0f, 0.0f);
		vertices[3] = new Vertex(-0.5f, 0.5f, 0.0f, 0.0f, 1.0f);

		int[] indices = {
				0, 1, 2, 2, 3, 0
		};

		IndexedBufferData<Vertex> res = new IndexedBufferData<>(vertices, indices,
				new IndexedBufferDescriptor());

		return res;
	}

	@Override
	public IndexedBuffer<Vertex> build(ExecutionContext executionManager)
	{
		return IndexedBuffer.alloc(executionManager, getDatas(), false);
	}
}
