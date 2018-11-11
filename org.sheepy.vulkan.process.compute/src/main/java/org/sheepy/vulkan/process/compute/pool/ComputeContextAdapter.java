package org.sheepy.vulkan.process.compute.pool;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractServiceAdapter;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputeProcessPool;

public class ComputeContextAdapter extends AbstractServiceAdapter implements IComputeContextAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
	
	@Override
	public ComputeContext getComputeContext(EObject target)
	{
		while (!ComputePackage.Literals.COMPUTE_PROCESS_POOL.isSuperTypeOf(target.eClass()))
		{
			target = target.eContainer();
		}

		return ComputeProcessPoolAdapter.adapt((ComputeProcessPool) target).context;
	}
}
