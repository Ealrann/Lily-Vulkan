package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

public class TaskManager
{
	public final FlushTransferBufferTask fetchTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final PrepareCompositeTransfer preparePush = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final PrepareCompositeTransfer prepareFetch = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();

	TaskManager(ResourceContainer resourceContainer)
	{
		final var pushbufferReference = VulkanResourceFactory.eINSTANCE.createCircularBufferReference();
		pushbufferReference.getBuffers().addAll(resourceContainer.compositeBuffer.getParts());
		pushbufferReference.setStride(1);
		final var fetchbufferReference = VulkanResourceFactory.eINSTANCE.createCircularBufferReference();
		fetchbufferReference.getBuffers().addAll(resourceContainer.compositeBuffer.getParts());
		fetchbufferReference.setStride(1);

		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.setTransferBuffer(resourceContainer.transferBuffer);
		preparePush.setBufferReference(pushbufferReference);
		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.setTransferBuffer(resourceContainer.transferBuffer);
		prepareFetch.setBufferReference(fetchbufferReference);
		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setStage(ECommandStage.TRANSFER);
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.add(preparePush);
		tasks.add(prepareFetch);
		tasks.add(fetchTask);
	}
}
