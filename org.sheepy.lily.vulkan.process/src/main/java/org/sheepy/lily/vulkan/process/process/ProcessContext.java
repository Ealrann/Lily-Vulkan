package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;

public class ProcessContext extends LogicalDeviceContext
{
	public final ExecutionManager executionManager;
	public final DescriptorPool descriptorPool;
	public final Application application;
	
	
	public ProcessContext(ExecutionManager executionManager, DescriptorPool descriptorPool, AbstractProcess process)
	{
		super(executionManager.logicalDevice);

		this.executionManager = executionManager;
		this.descriptorPool = descriptorPool;
		this.application = (Application) EcoreUtil.getRootContainer(process);
	}
}
