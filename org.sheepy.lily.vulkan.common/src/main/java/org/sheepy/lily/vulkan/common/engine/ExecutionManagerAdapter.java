package org.sheepy.lily.vulkan.common.engine;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.lily.vulkan.model.IEnginePart;
import org.sheepy.lily.vulkan.model.VulkanPackage;

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
