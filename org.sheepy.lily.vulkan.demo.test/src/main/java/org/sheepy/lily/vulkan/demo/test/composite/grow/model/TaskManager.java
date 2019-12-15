package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import java.util.List;

import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EInstance;
import org.sheepy.lily.vulkan.model.binding.IndexConfiguration;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.resource.CompositePartReference;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class TaskManager
{
	public final FlushTransferBufferTask pushTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final FlushTransferBufferTask fetchTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final PrepareCompositeTransfer preparePush = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final PrepareCompositeTransfer prepareFetch = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final CompositePartReference pushReference = ResourceFactory.eINSTANCE.createCompositePartReference();
	public final CompositePartReference fetchReference = ResourceFactory.eINSTANCE.createCompositePartReference();

	public final IndexConfiguration indexConfiguration = BindingFactory.eINSTANCE.createIndexConfiguration();
	public final ConfigurePrepareComposite configurePrepareComposite = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final RotateConfiguration rotateConfig = BindingFactory.eINSTANCE.createRotateConfiguration();

	public TaskManager(ResourceContainer resourceContainer, int instanceCount)
	{
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

		configurePrepareComposite.getReferences().add(pushReference);
		configurePrepareComposite.getReferences().add(fetchReference);
		configurePrepareComposite.setTargetInstance(EInstance.CONTEXT_INSTANCE);
		indexConfiguration.getTasks().add(configurePrepareComposite);
		indexConfiguration.setIndexCount(instanceCount);
		rotateConfig.setForceRecord(true);
		rotateConfig.getConfigurations().add(indexConfiguration);
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.add(preparePush);
		tasks.add(pushTask);
		tasks.add(prepareFetch);
		tasks.add(fetchTask);
		tasks.add(rotateConfig);
	}
}