package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import java.util.List;

import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.process.CompositePartReference;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class TaskManager
{
	public final FlushTransferBufferTask pushTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final FlushTransferBufferTask fetchTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final PrepareCompositeTransfer preparePush = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final PrepareCompositeTransfer prepareFetch = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final CompositePartReference pushReference = ProcessFactory.eINSTANCE.createCompositePartReference();
	public final CompositePartReference fetchReference = ProcessFactory.eINSTANCE.createCompositePartReference();

	private final int instanceCount;

	private int instance = 0;

	public TaskManager(ResourceContainer resourceContainer, int instanceCount)
	{
		this.instanceCount = instanceCount;
		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.getParts().add(pushReference);
		pushTask.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setStage(ECommandStage.TRANSFER);
		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.getParts().add(fetchReference);
		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setStage(ECommandStage.TRANSFER);
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.add(preparePush);
		tasks.add(pushTask);
		tasks.add(prepareFetch);
		tasks.add(fetchTask);
	}

	public void nextInstance()
	{
		instance = (instance + 1) % instanceCount;
	}

	public void configure()
	{
		pushReference.setInstance(instance);
		fetchReference.setInstance(instance);
	}
}