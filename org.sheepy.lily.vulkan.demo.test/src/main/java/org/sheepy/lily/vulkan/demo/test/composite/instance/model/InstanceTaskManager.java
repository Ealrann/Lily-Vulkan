package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import java.util.List;

import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceTestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EInstance;
import org.sheepy.lily.vulkan.model.binding.IndexConfiguration;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;
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
import org.sheepy.lily.vulkan.model.resource.CompositePartReference;
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
	public final CompositePartReference pushReference = ResourceFactory.eINSTANCE.createCompositePartReference();
	public final CompositePartReference fetchReference = ResourceFactory.eINSTANCE.createCompositePartReference();

	public final IndexConfiguration indexConfiguration = BindingFactory.eINSTANCE.createIndexConfiguration();
	public final ConfigurePrepareComposite configurePush = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final ConfigurePrepareComposite configureFetch = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final ConfigureCompositeBufferBarrier configureRead = BindingFactory.eINSTANCE.createConfigureCompositeBufferBarrier();
	public final ConfigureCompositeBufferBarrier configureWrite = BindingFactory.eINSTANCE.createConfigureCompositeBufferBarrier();
	public final RotateConfiguration rotateConfig = BindingFactory.eINSTANCE.createRotateConfiguration();

	private final BufferDataProvider<?> dataProvider;

	public InstanceTaskManager(ResourceContainer resourceContainer, int instanceCount)
	{
		dataProvider = resourceContainer.compositeBuffer.getDataProviders().get(0);

		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.getParts().add(pushReference);
		pushTask.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setStage(ECommandStage.TRANSFER);

		barrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		barrier.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		barrier.getBarriers().add(readBarrier);
		barrier.getBarriers().add(writeBarrier);
		readBarrier.setDataProvider(dataProvider);
		writeBarrier.setDataProvider(dataProvider);

		bindDS.setBindPoint(EBindPoint.COMPUTE);
		bindDS.getDescriptorSets().add(resourceContainer.ds);

		dispatch.setWorkgroupCountX(31250);

		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.getParts().add(fetchReference);
		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setStage(ECommandStage.COMPUTE);

		configurePush.getReferences().add(pushReference);
		configurePush.getReferences().add(resourceContainer.refs.get(0));
		configurePush.setTargetInstance(EInstance.CONTEXT_INSTANCE);
		configureFetch.getReferences().add(fetchReference);
		configureFetch.getReferences().add(resourceContainer.refs.get(1));
		configureFetch.setTargetInstance(EInstance.CONTEXT_INSTANCE_PLUS_ONE);
		configureRead.getBarriers().add(readBarrier);
		configureRead.setTargetInstance(EInstance.CONTEXT_INSTANCE);
		configureWrite.getBarriers().add(writeBarrier);
		configureWrite.setTargetInstance(EInstance.CONTEXT_INSTANCE_PLUS_ONE);

		indexConfiguration.getTasks().add(configurePush);
		indexConfiguration.getTasks().add(configureFetch);
		indexConfiguration.getTasks().add(configureRead);
		indexConfiguration.getTasks().add(configureWrite);
		indexConfiguration.setIndexCount(instanceCount);
		rotateConfig.setForceRecord(true);
		rotateConfig.getConfigurations().add(indexConfiguration);
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
		tasks.add(rotateConfig);
	}
}