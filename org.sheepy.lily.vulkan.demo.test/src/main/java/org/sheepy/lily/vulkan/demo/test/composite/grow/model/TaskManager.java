package org.sheepy.lily.vulkan.demo.test.composite.grow.model;

import java.util.List;

import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EContextIndex;
import org.sheepy.lily.vulkan.model.binding.IndexConfiguration;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;
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

	public final IndexConfiguration indexConfiguration = BindingFactory.eINSTANCE.createIndexConfiguration();
	public final ConfigurePrepareComposite configurePreparePush = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final ConfigurePrepareComposite configurePrepareFetch = BindingFactory.eINSTANCE.createConfigurePrepareComposite();
	public final RotateConfiguration rotateConfig = BindingFactory.eINSTANCE.createRotateConfiguration();

	public TaskManager(ResourceContainer resourceContainer, int partCount)
	{
		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setTransferBuffer(resourceContainer.transferBuffer);
		pushTask.setStage(ECommandStage.TRANSFER);
		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
		fetchTask.setStage(ECommandStage.TRANSFER);

		configurePreparePush.setPrepareTask(preparePush);
		configurePreparePush.getPartIndices().add(EContextIndex.CONTEXT_INSTANCE);
		configurePrepareFetch.setPrepareTask(prepareFetch);
		configurePrepareFetch.getPartIndices().add(EContextIndex.CONTEXT_INSTANCE);

		indexConfiguration.getTasks().add(configurePreparePush);
		indexConfiguration.getTasks().add(configurePrepareFetch);
		indexConfiguration.setIndexCount(partCount);
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