package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CloseApplication;
import org.sheepy.lily.core.model.cadence.CountUntil;
import org.sheepy.lily.core.model.cadence.ExecuteIf;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;

public class GrowEngineFactory
{
	public static int MAX_COUNT = 200;

	public static final int PART_COUNT = 10;

	public static IEngine build()
	{
		final var resourceContainer = TestResourceFactory.build(PART_COUNT);
		final var process = createComputeProcessPool(resourceContainer);
		final var pipeline = createPipeline();
		final var taskManager = new TaskManager(resourceContainer);
		final var cadence = buildCadence(process, MAX_COUNT);

		process.pipelinePkg().pipelines().add(pipeline);
		taskManager.install(pipeline.taskPkgs().get(0).tasks());
		process.cadence(cadence);

		return VulkanEngine.builder()
						  .addProcesse(() -> process)
						  .build();
	}

	private static Cadence buildCadence(final ComputeProcess process, int frameCount)
	{
		final var runProcess = RunProcess.builder()
										 .process(() -> process)
										 .build();

		final var cadence = Cadence.builder()
								  .addTask(() -> runProcess)
								  .build();

		if (frameCount > 0)
		{
			final var executeIf = ExecuteIf.builder()
										   .addCondition(() -> CountUntil.builder().totalCount(frameCount).build())
										   .addTask(() -> CloseApplication.builder().build())
										   .build();
			cadence.tasks().add(executeIf);
		}

		return cadence;
	}

	private static ComputeProcess createComputeProcessPool(final MemoryChunk memoryChunk)
	{
		final var computeExecutionManager = ComputeExecutionManager.builder()
																 .indexCount(PART_COUNT)
																 .build();

		return ComputeProcess.builder()
							 .configuration(() -> ComputeConfiguration.builder().build())
							 .executionManager(() -> computeExecutionManager)
							 .pipelinePkg(() -> PipelinePkg.builder().build())
							 .resourcePkg(() -> VulkanResourcePkg.builder().addResource(() -> memoryChunk).build())
							 .resetAllowed(true)
							 .build();
	}

	private static Pipeline createPipeline()
	{
		return Pipeline.builder()
					   .addTaskPkg(() -> TaskPkg.builder().build())
					   .build();
	}
}

