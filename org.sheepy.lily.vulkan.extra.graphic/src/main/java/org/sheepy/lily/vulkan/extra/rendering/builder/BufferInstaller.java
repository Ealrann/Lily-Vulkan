package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

public final class BufferInstaller<T extends Structure<?>>
{
	public final boolean hasDynamicDescriptors;
	public final boolean hasIndexData;

	private final GenericRenderer<T> maintainer;

	private CompositeBuffer buffer;

	public BufferInstaller(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;

		hasDynamicDescriptors = isContainingDynamicDescriptors();
		hasIndexData = isContainingIndexData();
	}

	private boolean isContainingDynamicDescriptors()
	{
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();
		return dataProviders.stream().anyMatch(DescribedDataProvider.class::isInstance);
	}

	private boolean isContainingIndexData()
	{
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();
		return dataProviders.stream().anyMatch(IndexProvider.class::isInstance);
	}

	public BufferContext install(PipelineContext pipelineContext, T structure, int part)
	{
		final var taskPkg = pipelineContext.pipeline.getTaskPkg();

		createBuffer(pipelineContext, structure, part);
		setupDescriptorSet(pipelineContext, taskPkg);

		return new BufferContext(pipelineContext, buffer, part);
	}

	private void setupDescriptorSet(PipelineContext pipelineContext, final TaskPkg taskPkg)
	{
		if (hasDynamicDescriptors)
		{
			final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
			descriptorSet.getDescriptors().add(buffer);

			pipelineContext.pipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
		}

		final var dSets = pipelineContext.pipeline.getDescriptorSetPkg().getDescriptorSets();

		if (dSets.isEmpty() == false)
		{
			final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
			bindDS.getDescriptorSets().addAll(dSets);

			taskPkg.getTasks().add(bindDS);
		}
	}

	private void createBuffer(PipelineContext pipelineContext, T structure, int part)
	{
		buffer = ResourceFactory.eINSTANCE.createCompositeBuffer();
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();

		for (final var dataProvider : dataProviders)
		{
			final var dataSource = RenderingFactory.eINSTANCE.<T> createRenderableDataSource();
			dataSource.setPart(part);
			dataSource.setStructure(structure);

			final var copy = EcoreUtil.copy(dataProvider);
			copy.setDataSource(dataSource);
			buffer.getDataProviders().add(copy);
		}

		buffer.setPushBuffer(pipelineContext.pushBuffer);

		pipelineContext.pipeline.getResourcePkg().getResources().add(buffer);
	}
}
