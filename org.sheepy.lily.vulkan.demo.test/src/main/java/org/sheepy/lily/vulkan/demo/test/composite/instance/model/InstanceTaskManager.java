package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import java.util.List;

import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceTestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EContextIndex;
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
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
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
	public final BufferBarrier readBarrier = ResourceFactory.eINSTANCE.createBufferBarrier();
	public final BufferBarrier writeBarrier = ResourceFactory.eINSTANCE.createBufferBarrier();

	public final BindDescriptorSets bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();

	public final DispatchTask dispatch = ComputeFactory.eINSTANCE.createDispatchTask();
	public final PrepareCompositeTransfer preparePush = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final PrepareCompositeTransfer prepareFetch = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();

	public final IndexConfiguration indexConfiguration = BindingFactory.eINSTANCE.createIndexConfiguration();
	public final ConfigurePrepareComposite configurePush = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final ConfigurePrepareComposite configureFetch = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final ConfigureCompositeBufferBarrier configureRead = BindingFactory.eINSTANCE.createConfigureCompositeBufferBarrier();
	public final ConfigureCompositeBufferBarrier configureWrite = BindingFactory.eINSTANCE.createConfigureCompositeBufferBarrier();
	public final RotateConfiguration rotateConfig = BindingFactory.eINSTANCE.createRotateConfiguration();
	public final ConfigureBufferDescriptor configureReadDescriptor = BindingFactory.eINSTANCE.createConfigureBufferDescriptor();
	public final ConfigureBufferDescriptor configureWriteDescriptor = BindingFactory.eINSTANCE.createConfigureBufferDescriptor();

	public InstanceTaskManager(ResourceContainer resourceContainer, int partCount)
	{
		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setStage(ECommandStage.TRANSFER);

		barrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		barrier.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		barrier.getBarriers().add(readBarrier);
		barrier.getBarriers().add(writeBarrier);

		bindDS.setBindPoint(EBindPoint.COMPUTE);
		bindDS.getDescriptorSets().add(resourceContainer.ds);

		dispatch.setWorkgroupCountX(31250);

		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setStage(ECommandStage.COMPUTE);

		configurePush.setPrepareTask(preparePush);
		configurePush.getPartIndices().add(EContextIndex.CONTEXT_INSTANCE);
		configurePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		configureFetch.setPrepareTask(prepareFetch);
		configureFetch.getPartIndices().add(EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);
		configureFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		configureRead.getBarriers().add(readBarrier);
		configureRead.setPartIndex(EContextIndex.CONTEXT_INSTANCE);
		configureRead.setCompositeBuffer(resourceContainer.compositeBuffer);
		configureWrite.getBarriers().add(writeBarrier);
		configureWrite.setPartIndex(EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);
		configureWrite.setCompositeBuffer(resourceContainer.compositeBuffer);

		configureReadDescriptor.setCompositeBuffer(resourceContainer.compositeBuffer);
		configureReadDescriptor.setPartIndex(EContextIndex.CONTEXT_INSTANCE);
		configureReadDescriptor.setDescriptor((BufferDescriptor) resourceContainer.ds	.getDescriptors()
																						.get(0));

		configureWriteDescriptor.setCompositeBuffer(resourceContainer.compositeBuffer);
		configureWriteDescriptor.setPartIndex(EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);
		configureWriteDescriptor.setDescriptor((BufferDescriptor) resourceContainer.ds	.getDescriptors()
																						.get(1));

		indexConfiguration.getTasks().add(configurePush);
		indexConfiguration.getTasks().add(configureFetch);
		indexConfiguration.getTasks().add(configureRead);
		indexConfiguration.getTasks().add(configureWrite);
		indexConfiguration.getTasks().add(configureReadDescriptor);
		indexConfiguration.getTasks().add(configureWriteDescriptor);
		indexConfiguration.setIndexCount(partCount);
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