package test.vulkan.mesh;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.demo.model.MeshBuffer;
import org.sheepy.vulkan.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.indexed.IIndexedBufferBuilder;
import org.sheepy.vulkan.resource.indexed.IVertex;
import org.sheepy.vulkan.resource.indexed.IndexBuffer;

public class MeshAdapter<T extends IVertex> extends ResourceAdapter
{
	private final IIndexedBufferBuilder<T> meshBuilder;

	private IndexBuffer<T> indexBuffer;

	public MeshAdapter(IIndexedBufferBuilder<T> meshBuilder)
	{
		this.meshBuilder = meshBuilder;
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var datas = meshBuilder.getDatas();
		final var vertices = datas.vertices;
		final var indices = datas.indices;
		final var indexDescriptor = datas.indexDescriptor;
		final var context = IExecutionManagerAdapter.adapt(target).getExecutionManager();

		indexBuffer = IndexBuffer.alloc(context, indexDescriptor, vertices, indices);
	}

	@Override
	public void free()
	{
		indexBuffer.free();
	}

	public IndexBuffer<?> getIndexBuffer()
	{
		return indexBuffer;
	}

	public static MeshAdapter<?> adapt(MeshBuffer mesh)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(mesh, MeshAdapter.class);
	}
}
