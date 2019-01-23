package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IContextAdapter<T extends ProcessContext> extends IVulkanAdapter
{
	T getContext(EObject target);

	@SuppressWarnings("unchecked")
	static <T extends ProcessContext> IContextAdapter<T> adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IContextAdapter.class);
	}
}
