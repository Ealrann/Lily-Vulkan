package org.sheepy.vulkan.process.process;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.ProcessPackage;

public class ExecutionManagerAdapter extends AbstractSingletonAdapter
		implements IExecutionManagerAdapter
{
	@Override
	public ExecutionManager getExecutionManager(EObject target)
	{
		var current = target;
		while (!ProcessPackage.Literals.ABSTRACT_PROCESS.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractProcessAdapter.adapt((AbstractProcess) current).executionManager;
	}
	
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
}
