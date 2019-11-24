package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import java.util.List;

import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceTestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EBindPoint;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public class InstanceTaskManager
{
	public final FlushTransferBufferTask pushTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final FlushTransferBufferTask fetchTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();

	public final PipelineBarrier barrier = ProcessFactory.eINSTANCE.createPipelineBarrier();
	public final CompositeBufferBarrier readBarrier = ResourceFactory.eINSTANCE.createCompositeBufferBarrier();
	public final CompositeBufferBarrier writeBarrier = ResourceFactory.eINSTANCE.createCompositeBufferBarrier();

	public final BindDescriptorSets bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();

	public final DispatchTask dispatch = ComputeFactory.eINSTANCE.createDispatchTask();
	public final PrepareCompositeTransfer preparePush = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final PrepareCompositeTransfer prepareFetch = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();

	private final BufferDataProvider<?> dataProvider;
	private final int instanceCount;

	private int instance = 0;

	public InstanceTaskManager(ResourceContainer resourceContainer, int instanceCount)
	{
		this.instanceCount = instanceCount;
		dataProvider = resourceContainer.compositeBuffer.getDataProviders().get(0);

		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.setStage(ECommandStage.TRANSFER);
		pushTask.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setStage(ECommandStage.TRANSFER);

		barrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		barrier.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		readBarrier.setDataProvider(dataProvider);
		writeBarrier.setDataProvider(dataProvider);

		bindDS.setBindPoint(EBindPoint.COMPUTE);
		bindDS.getDescriptorSets().add(resourceContainer.ds);

		dispatch.setWorkgroupCountX(31250);

		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.setStage(ECommandStage.COMPUTE);
		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setStage(ECommandStage.COMPUTE);
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.add(preparePush);
		tasks.add(pushTask);

		tasks.add(barrier);
		tasks.add(bindDS);
		tasks.add(dispatch);

		tasks.add(prepareFetch);
		tasks.add(fetchTask);
	}

	public void nextInstance()
	{
		instance = (instance + 1) % instanceCount;
	}

	public void configure()
	{
		final int nextInstance = (instance + 1) % instanceCount;

		dataProvider.setFirstDescriptor(instance);
		preparePush.setInstance(instance);
		prepareFetch.setInstance(nextInstance);

		readBarrier.setInstance(instance);
		writeBarrier.setInstance(nextInstance);
	}
}