package org.sheepy.vulkan.demo.mesh;

import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.impl.SheepyAdapterWrapper;
import org.sheepy.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.vulkan.resource.indexed.IIndexedBufferBuilder;

public class MeshAdapterWrapper extends SheepyAdapterWrapper
{
	private final MeshAdapter<?> adapter;

	public MeshAdapterWrapper(IIndexedBufferBuilder<?> meshBuilder)
	{
		super(MeshAdapter.class, VulkanDemoPackage.Literals.MESH_BUFFER);
		adapter = new MeshAdapter<>(meshBuilder);
	}

	@Override
	protected ISheepyAdapter instanciateNew()
	{
		return adapter;
	}

}
