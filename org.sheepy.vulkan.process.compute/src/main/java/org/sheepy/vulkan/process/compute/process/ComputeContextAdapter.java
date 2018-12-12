package org.sheepy.vulkan.process.compute.process;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;

public class ComputeContextAdapter extends AbstractSingletonAdapter
		implements IComputeContextAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}

	@Override
	public ComputeContext getContext(EObject target)
	{
		while (!ComputePackage.Literals.COMPUTE_PROCESS.isSuperTypeOf(target.eClass()))
		{
			target = target.eContainer();
		}

		return ComputeProcessAdapter.adapt((ComputeProcess) target).context;
	}
}
