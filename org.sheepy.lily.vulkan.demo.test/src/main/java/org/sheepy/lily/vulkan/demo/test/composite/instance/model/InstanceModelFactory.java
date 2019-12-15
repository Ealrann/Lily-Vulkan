package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceTestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPartPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class InstanceModelFactory
{
	public static final String CADENCE_NAME = "TestInstance_Cadence";
	private static final int INSTANCE_COUNT = 10;
	public final Application application = ApplicationFactory.eINSTANCE.createApplication();
	public final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();
	public final ComputeProcess process;
	public final ResourceContainer resourceContainer;
	public final InstanceTaskManager taskManager;

	public InstanceModelFactory()
	{
		application.setTitle("Vulkan - CompositeBuffer test");
		application.getEngines().add(engine);
		application.setHeadless(true);

		resourceContainer = InstanceTestResourceFactory.build(INSTANCE_COUNT);
		process = createComputeProcessPool();

		final var pipeline = createPipeline(resourceContainer);
		process.getPartPkg().getParts().add(pipeline);

		taskManager = new InstanceTaskManager(resourceContainer, INSTANCE_COUNT);
		taskManager.install(pipeline.getTaskPkg().getTasks());

		final var cadence = CadenceFactory.eINSTANCE.createGenericCadence();
		cadence.setName(CADENCE_NAME);

		engine.getProcesses().add(process);
		engine.setCadence(cadence);
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
		resourceList.add(resourceContainer.shader);

		final var descriptorPkg = VulkanFactory.eINSTANCE.createDescriptorPkg();
		process.setDescriptorPkg(descriptorPkg);
		final var descriptorList = descriptorPkg.getDescriptors();
		descriptorList.addAll(resourceContainer.ds.getDescriptors());

		process.setResetAllowed(true);

		return process;
	}

	private static ComputePipeline createPipeline(ResourceContainer resourceContainer)
	{
		final var res = ComputeFactory.eINSTANCE.createComputePipeline();
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		res.setTaskPkg(taskPkg);
		res.setShader(resourceContainer.shader);
		res.setStage(ECommandStage.COMPUTE);
		final DescriptorSetPkg dsPkg = ResourceFactory.eINSTANCE.createDescriptorSetPkg();
		res.setDescriptorSetPkg(dsPkg);
		dsPkg.getDescriptorSets().add(resourceContainer.ds);
		return res;
	}
}
