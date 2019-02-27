package org.sheepy.lily.vulkan.common.execution;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.model.IExecutionManager;

public class ExecutionManagerUtils
{
	public static ExecutionContext getExecutionContext(EObject target)
	{
		var current = target;
		while (current instanceof IExecutionManager == false)
		{
			current = current.eContainer();
		}

		return IExecutionManagerAdapter.adapt((IExecutionManager) current).getExecutionContext();
	}
}
