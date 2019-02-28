package org.sheepy.lily.vulkan.common.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IStatefullAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.impl.AbstractAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.common.execution.ExecutionManagerUtils;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;
import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanPackage;

@Deprecated
public class ResourcePkgAdapter extends AbstractAllocationDescriptorAdapter
		implements IResourcePkgAdapter, IStatefullAdapter
{
	private ResourcePkg resourcePkg;

	@Override
	public void setTarget(Notifier target)
	{
		resourcePkg = (ResourcePkg) target;
		super.setTarget(target);

		var executionContext = ExecutionManagerUtils.getExecutionContext(resourcePkg);
		for (IResourceAllocable resource : gatherResources())
		{
//			allocationList.add(new ResourceAllocator(executionContext, resource));
		}
	}

	protected List<IResourceAllocable> gatherResources()
	{
		List<IResourceAllocable> resources = new ArrayList<>();
		for (IResource resource : resourcePkg.getResources())
		{
			gatherResource(resources, resource);
		}

		return resources;
	}

	private static void gatherResource(List<IResourceAllocable> resources, IResource resource)
	{
		var adapter = IResourceAdapter.adapt(resource);
		if (adapter != null)
		{
			resources.add(adapter);
		}
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.IRESOURCE_CONTAINER == eClass;
	}

	public static ResourcePkgAdapter adapt(ResourcePkg object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ResourcePkgAdapter.class);
	}
}
