package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;

public class GrowEngineFactory
{
	public static int MAX_COUNT = 200;

	public static final int PART_COUNT = 10;

	public static IEngine build()
	{
		final var engine = VulkanFactory.eINSTANCE.createVulkanEngine();
		final var resourceContainer = TestResourceFactory.build(PART_COUNT);
		final var process = createComputeProcessPool(resourceContainer);
		final var pipeline = createPipeline();
		final var taskManager = new TaskManager(resourceContainer);
		final var cadence = buildCadence(process, MAX_COUNT);

		process.getPipelinePkg().getPipelines().add(pipeline);
		taskManager.install(pipeline.getTaskPkgs().get(0).getTasks());
		process.setCadence(cadence);
		engine.getProcesses().add(process);

		return engine;
	}

	private static Cadence buildCadence(final ComputeProcess process, int frameCount)
	{
		final var runProcess = VulkanFactory.eINSTANCE.createRunProcess();
		runProcess.setProcess(process);

		final var cadence = CadenceFactory.eINSTANCE.createCadence();
		cadence.getTasks().add(runProcess);

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

	private static ComputeProcess createComputeProcessPool(MemoryChunk memoryChunk)
	{
		final ComputeProcess process = ComputeFactory.eINSTANCE.createComputeProcess();
		final ComputeExecutionManager computeExecutionManager = ComputeFactory.eINSTANCE.createComputeExecutionManager();
		computeExecutionManager.setIndexCount(PART_COUNT);
		process.setExecutionManager(computeExecutionManager);

		final var pipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		process.setPipelinePkg(pipelinePkg);

		final var resourcePkg = VulkanFactory.eINSTANCE.createVulkanResourcePkg();
		process.setVulkanResourcePkg(resourcePkg);
		final var resourceList = resourcePkg.getResources();
		resourceList.add(memoryChunk);

		process.setResetAllowed(true);

		return process;
	}

	private static Pipeline createPipeline()
	{
		final var res = ProcessFactory.eINSTANCE.createPipeline();
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		res.getTaskPkgs().add(taskPkg);
		return res;
	}
}
