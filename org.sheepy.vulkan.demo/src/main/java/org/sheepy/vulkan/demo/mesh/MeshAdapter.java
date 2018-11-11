package org.sheepy.vulkan.demo.mesh;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.demo.model.MeshBuffer;
import org.sheepy.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.vulkan.process.graphic.pipeline.render.IIndexedBufferBuilder;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.indexed.IndexBuffer;

public class MeshAdapter extends ResourceAdapter
{
	public static IIndexedBufferBuilder<?> meshBuilder = null;

	private IndexBuffer<?> indexBuffer;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var context = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		indexBuffer = meshBuilder.build(context);
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanDemoPackage.Literals.MESH_BUFFER == eClass;
	}

	public static MeshAdapter adapt(MeshBuffer mesh)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(mesh, MeshAdapter.class);
	}
}
