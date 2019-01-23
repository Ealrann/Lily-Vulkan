package org.sheepy.lily.vulkan.demo.mesh;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.demo.model.MeshBuffer;
import org.sheepy.lily.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.lily.vulkan.resource.ResourceAdapter;
import org.sheepy.lily.vulkan.resource.indexed.IndexBuffer;

public class MeshAdapter extends ResourceAdapter
{
	public static IIndexedBufferBuilder<?> meshBuilder = null;

	private IndexBuffer<?> indexBuffer;

	@Override
	public void allocate(MemoryStack stack, ExecutionManager executionManager)
	{
		indexBuffer = meshBuilder.build(executionManager);
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
	public boolean isAllocationDirty()
	{
		return false;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanDemoPackage.Literals.MESH_BUFFER == eClass;
	}

	public static MeshAdapter adapt(MeshBuffer mesh)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(mesh, MeshAdapter.class);
	}
}
