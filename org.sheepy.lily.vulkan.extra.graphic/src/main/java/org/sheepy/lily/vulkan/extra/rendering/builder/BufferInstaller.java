package org.sheepy.lily.vulkan.extra.rendering.builder;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

public final class BufferInstaller<T extends Structure>
{
	private static final int BUFFER_MIN_SIZE = 1 << 16;
	private static final float BUFFER_GROW_FACTOR = 1.5f;

	public final boolean hasDynamicDescriptors;
	public final boolean hasIndexData;

	private final GenericRenderer<T> maintainer;

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

	public BufferContext install(GraphicsPipeline pipeline, T structure, int part)
	{
		final var taskPkg = pipeline.getTaskPkg();
		final var buffer = createBuffer(structure, part);

		installBuffer(pipeline, buffer);
		installDescriptorSet(pipeline, taskPkg, buffer);

		return new BufferContext(pipeline, buffer, part);
	}

	private static void installBuffer(GraphicsPipeline pipeline, final CompositeBuffer buffer)
	{
		pipeline.getResourcePkg().getResources().add(buffer);
	}

	private void installDescriptorSet(	GraphicsPipeline pipeline,
										final TaskPkg taskPkg,
										CompositeBuffer buffer)
	{
		if (hasDynamicDescriptors)
		{
			final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
			descriptorSet.getDescriptors().add(buffer);
			pipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
		}

		final var dSets = pipeline.getDescriptorSetPkg().getDescriptorSets();

		if (dSets.isEmpty() == false)
		{
			final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
			bindDS.getDescriptorSets().addAll(dSets);
			taskPkg.getTasks().add(bindDS);
		}
	}

	private CompositeBuffer createBuffer(T structure, int part)
	{
		final CompositeBuffer buffer = ResourceFactory.eINSTANCE.createCompositeBuffer();
		buffer.setGrowFactor(BUFFER_GROW_FACTOR);
		buffer.setMinSize(BUFFER_MIN_SIZE);
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();

		for (int i = 0; i < dataProviders.size(); i++)
		{
			final var dataProvider = dataProviders.get(i);
			final var dataSource = RenderingFactory.eINSTANCE.<T> createRenderableDataSource();
			dataSource.setPart(part);
			dataSource.setStructure(structure);

			final var copy = EcoreUtil.copy(dataProvider);
			copy.setDataSource(dataSource);
			buffer.getDataProviders().add(copy);
		}

		buffer.setTransferBuffer(maintainer.getTransferBuffer());

		return buffer;
	}
}
