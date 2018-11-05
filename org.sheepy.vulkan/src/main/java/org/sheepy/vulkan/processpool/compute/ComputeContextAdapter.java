package org.sheepy.vulkan.processpool.compute;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractServiceAdapter;
import org.sheepy.vulkan.model.process.ComputeProcessPool;
import org.sheepy.vulkan.model.process.ProcessPackage;

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
		while (!ProcessPackage.Literals.COMPUTE_PROCESS_POOL.isSuperTypeOf(target.eClass()))
		{
			target = target.eContainer();
		}

		return ComputeProcessPoolAdapter.adapt((ComputeProcessPool) target).context;
	}
}
