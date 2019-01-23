package org.sheepy.vulkan.common.engine;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.IEnginePart;
import org.sheepy.vulkan.model.VulkanPackage;

public class ExecutionManagerAdapter extends AbstractSingletonAdapter
		implements IExecutionManagerAdapter
{
	@Override
	public ExecutionManager getExecutionManager(EObject target)
	{
		var current = target;
		while (!VulkanPackage.Literals.IENGINE_PART.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractEnginePartAdapter.adapt((IEnginePart) current).executionManager;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
}
