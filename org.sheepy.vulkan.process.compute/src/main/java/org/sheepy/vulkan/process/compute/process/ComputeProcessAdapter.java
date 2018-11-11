package org.sheepy.vulkan.process.compute.process;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_COMPUTE;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.vulkan.process.process.AbstractProcessAdapter;

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
	
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ComputePackage.Literals.COMPUTE_PROCESS == eClass;
	}

	public static ComputeProcessAdapter adapt(ComputeProcess object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, ComputeProcessAdapter.class);
	}
}
