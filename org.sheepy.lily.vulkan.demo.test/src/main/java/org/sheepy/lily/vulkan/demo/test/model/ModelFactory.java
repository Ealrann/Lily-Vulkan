package org.sheepy.lily.vulkan.demo.test.model;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.test.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPartPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class ModelFactory
{
	private static final int BUFFER_COUNT = 10;
	public final Application application = ApplicationFactory.eINSTANCE.createApplication();
	public final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();
	public final ComputeProcess process;
	public final ResourceContainer resourceContainer;

	public ModelFactory()
	{
		application.setTitle("Vulkan - CompositeBuffer test");
		application.getEngines().add(engine);
		application.setHeadless(true);

		resourceContainer = TestResourceFactory.build(BUFFER_COUNT);
		process = createComputeProcessPool();

		engine.getProcesses().add(process);
	}

	private ComputeProcess createComputeProcessPool()
	{
		final ComputeProcess process = ComputeFactory.eINSTANCE.createComputeProcess();

		final var pipeline = createPipeline(resourceContainer);

		final ProcessPartPkg partPkg = ProcessFactory.eINSTANCE.createProcessPartPkg();
		process.setPartPkg(partPkg);
		partPkg.getParts().add(pipeline);

		final var resourcePkg = VulkanFactory.eINSTANCE.createResourcePkg();
		process.setResourcePkg(resourcePkg);
		final var resourceList = resourcePkg.getResources();
		resourceList.add(resourceContainer.transferBuffer);
		resourceList.add(resourceContainer.compositeBuffer);
		for (int i = 0; i < BUFFER_COUNT; i++)
		{
			resourceList.add(resourceContainer.targetBuffers.get(i));
		}

		process.setResetAllowed(true);

		return process;
	}

	private static ComputePipeline createPipeline(ResourceContainer resourceContainer)
	{
		final var flushTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
		flushTask.setTransferBuffer(resourceContainer.transferBuffer);

		final var res = ComputeFactory.eINSTANCE.createComputePipeline();
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		res.setTaskPkg(taskPkg);
		taskPkg.getTasks().add(flushTask);

		for (int i = 0; i < BUFFER_COUNT; i++)
		{
			final var copyTask = ProcessFactory.eINSTANCE.createCopyBufferTask();
			final var srcBuffer = ResourceFactory.eINSTANCE.createCompositeBufferReference();
			srcBuffer.setBuffer(resourceContainer.compositeBuffer);
			srcBuffer.setPart(i);

			final var dstBuffer = ResourceFactory.eINSTANCE.createBufferReference();
			dstBuffer.setBuffer(resourceContainer.targetBuffers.get(i));
			copyTask.setSrcBuffer(srcBuffer);
			copyTask.setDstBuffer(dstBuffer);

			taskPkg.getTasks().add(copyTask);
		}

		res.setStage(ECommandStage.TRANSFER);

		return res;
	}
}
