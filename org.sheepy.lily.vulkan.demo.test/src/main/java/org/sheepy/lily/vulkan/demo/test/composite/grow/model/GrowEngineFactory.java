package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class GrowEngineFactory
{
	public static int MAX_COUNT = 200;

	private static final int PART_COUNT = 10;

	public static IEngine build()
	{
		final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();
		final var resourceContainer = TestResourceFactory.build(PART_COUNT);
		final var process = createComputeProcessPool(resourceContainer);

		final var pipeline = createPipeline();
		process.getPipelinePkg().getPipelines().add(pipeline);

		final var taskManager = new TaskManager(resourceContainer, PART_COUNT);
		taskManager.install(pipeline.getTaskPkg().getTasks());
		process.getExtensionPkg().getExtensions().add(taskManager.indexConfiguration);

		final var cadence = buildCadence(process, MAX_COUNT);
		process.setCadence(cadence);

		engine.getProcesses().add(process);

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
		final ComputeProcess process = ComputeFactory.eINSTANCE.createComputeProcess();
		process.setExtensionPkg(ProcessFactory.eINSTANCE.createProcessExtensionPkg());

		final var pipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		process.setPipelinePkg(pipelinePkg);

		final var resourcePkg = ResourceFactory.eINSTANCE.createResourcePkg();
		process.setResourcePkg(resourcePkg);
		final var resourceList = resourcePkg.getResources();
		resourceList.add(resourceContainer.transferBuffer);
		resourceList.add(resourceContainer.compositeBuffer);

		process.setResetAllowed(true);

		return process;
	}

	private static Pipeline createPipeline()
	{
		final var res = ProcessFactory.eINSTANCE.createPipeline();
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		res.setTaskPkg(taskPkg);
		res.setStage(ECommandStage.TRANSFER);
		return res;
	}
}
