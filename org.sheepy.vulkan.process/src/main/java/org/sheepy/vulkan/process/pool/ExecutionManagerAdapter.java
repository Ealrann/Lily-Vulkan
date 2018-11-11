package org.sheepy.vulkan.process.pool;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractServiceAdapter;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.process.ProcessPackage;

public class ExecutionManagerAdapter extends AbstractServiceAdapter
		implements IExecutionManagerAdapter
{
	@Override
	public ExecutionManager getExecutionManager(EObject target)
	{
		var current = target;
		while (!ProcessPackage.Literals.ABSTRACT_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractProcessPoolAdapter.adapt((AbstractProcessPool<?>) current).executionManager;
	}
	
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
}
