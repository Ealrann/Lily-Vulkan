package org.sheepy.vulkan.process.compute.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.process.process.IContextAdapter;

public interface IComputeContextAdapter extends IContextAdapter<ComputeContext>
{
	@Override
	ComputeContext getContext(EObject target);

	static IComputeContextAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IComputeContextAdapter.class);
	}
}
