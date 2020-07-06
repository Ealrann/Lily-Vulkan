package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceTestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;

public class InstanceEngineFactory
{
	public static int MAX_COUNT = 150;

	private static final int PART_COUNT = 10;

	public static IEngine build()
	{
		final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();

		final var resourceContainer = InstanceTestResourceFactory.build(PART_COUNT);
		final var process = createComputeProcessPool(resourceContainer);

		final var pipeline = createPipeline(resourceContainer);
		process.getPipelinePkg().getPipelines().add(pipeline);
		pipeline.getLayout().add(resourceContainer.dSets.get(0));

		final var taskManager = new InstanceTaskManager(resourceContainer);
		taskManager.install(pipeline.getTaskPkgs().get(0).getTasks());

		final var cadence = buildCadence(process, MAX_COUNT);

		engine.getProcesses().add(process);
		process.setCadence(cadence);

		return engine;
	}

	private static Cadence buildCadence(final ComputeProcess process, int frameCount)
	{
		final var runProcess = VulkanFactory.eINSTANCE.createRunProcess();
		runProcess.setProcess(process);

		final var waitIdle = VulkanFactory.eINSTANCE.createWaitProcessIdle();
		waitIdle.setProcess(process);

		final var cadence = CadenceFactory.eINSTANCE.createCadence();
		cadence.getTasks().add(runProcess);
		cadence.getTasks().add(waitIdle);

		if (frameCount > 0)
		{
			final var executeIf = CadenceFactory.eINSTANCE.createExecuteIf();
			final var countUntil = CadenceFactory.eINSTANCE.createCountUntil();
			final var closeApp = CadenceFactory.eINSTANCE.createCloseApplication();
			countUntil.setTotalCount(frameCount);
			executeIf.getConditions().add(countUntil);
			executeIf.getTasks().add(closeApp);
			cadence.getTasks().add(executeIf);
		}

		return cadence;
	}

	private static ComputeProcess createComputeProcessPool(ResourceContainer resourceContainer)
	{
		final var process = ComputeFactory.eINSTANCE.createComputeProcess();
		process.setExtensionPkg(ProcessFactory.eINSTANCE.createProcessExtensionPkg());
		final var computeExecutionManager = ComputeFactory.eINSTANCE.createComputeExecutionManager();
		computeExecutionManager.setIndexCount(PART_COUNT);
		process.setExecutionManager(computeExecutionManager);

		final var partPkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		process.setPipelinePkg(partPkg);

		final var resourcePkg = ResourceFactory.eINSTANCE.createResourcePkg();
		process.setResourcePkg(resourcePkg);
		final var resourceList = resourcePkg.getResources();
		resourceList.add(resourceContainer.transferBuffer);
		resourceList.add(resourceContainer.compositeBuffer);
		resourceList.add(resourceContainer.shader);

		final var descriptorPkg = VulkanFactory.eINSTANCE.createDescriptorPkg();
		process.setDescriptorPkg(descriptorPkg);
		final var descriptorList = descriptorPkg.getDescriptors();
		descriptorList.addAll(resourceContainer.descriptors);

		process.setResetAllowed(true);

		return process;
	}

	private static ComputePipeline createPipeline(ResourceContainer resourceContainer)
	{
		final var res = ComputeFactory.eINSTANCE.createComputePipeline();
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		res.getTaskPkgs().add(taskPkg);
		res.setShader(resourceContainer.shader);
		final var dsPkg = VulkanResourceFactory.eINSTANCE.createDescriptorPool();
		res.setDescriptorPool(dsPkg);
		dsPkg.getDescriptorSets().addAll(resourceContainer.dSets);
		return res;
	}
}
