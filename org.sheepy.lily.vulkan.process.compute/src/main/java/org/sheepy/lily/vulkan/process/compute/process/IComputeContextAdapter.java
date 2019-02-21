package org.sheepy.lily.vulkan.process.compute.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.process.process.IContextAdapter;

public interface IComputeContextAdapter extends IContextAdapter<ComputeContext>
{
	@Override
	ComputeContext getContext(EObject target);

	static IComputeContextAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IComputeContextAdapter.class);
	}
}