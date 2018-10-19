package org.sheepy.vulkan.process.compute;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_COMPUTE;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.execution.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.model.ComputeProcess;
import org.sheepy.vulkan.process.AbstractProcessAdapter;

/**
 * A set of ComputePipelines.
 *
 */
public class ComputeProcessAdapter extends AbstractProcessAdapter<ComputeCommandBuffer>
{
	@Override
	protected int getBindPoint()
	{
		return VK_PIPELINE_BIND_POINT_COMPUTE;
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}

	public static ComputeProcessAdapter adapt(ComputeProcess object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, ComputeProcessAdapter.class);
	}
}
