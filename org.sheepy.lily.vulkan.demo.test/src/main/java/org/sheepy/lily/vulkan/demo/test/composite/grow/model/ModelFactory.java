package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPartPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class ModelFactory
{
	private static final int INSTANCE_COUNT = 10;
	public final Application application = ApplicationFactory.eINSTANCE.createApplication();
	public final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();
	public final ComputeProcess process;
	public final ResourceContainer resourceContainer;
	public final TaskManager taskManager;

	public ModelFactory()
	{
		application.setTitle("Vulkan - CompositeBuffer test");
		application.getEngines().add(engine);
		application.setHeadless(true);

		resourceContainer = TestResourceFactory.build(INSTANCE_COUNT);
		process = createComputeProcessPool();

		final var pipeline = createPipeline();
		process.getPartPkg().getParts().add(pipeline);

		taskManager = new TaskManager(resourceContainer, INSTANCE_COUNT);
		taskManager.install(pipeline.getTaskPkg().getTasks());

		engine.getProcesses().add(process);
	}

	private ComputeProcess createComputeProcessPool()
	{
		final ComputeProcess process = ComputeFactory.eINSTANCE.createComputeProcess();

		final ProcessPartPkg partPkg = ProcessFactory.eINSTANCE.createProcessPartPkg();
		process.setPartPkg(partPkg);

		final var resourcePkg = VulkanFactory.eINSTANCE.createResourcePkg();
		process.setResourcePkg(resourcePkg);
		final var resourceList = resourcePkg.getResources();
		resourceList.add(resourceContainer.transferBuffer);
		resourceList.add(resourceContainer.compositeBuffer);

		process.setResetAllowed(true);

		return process;
	}

	private static ComputePipeline createPipeline()
	{
		final var res = ComputeFactory.eINSTANCE.createComputePipeline();
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		res.setTaskPkg(taskPkg);
		res.setStage(ECommandStage.TRANSFER);
		return res;
	}
}
