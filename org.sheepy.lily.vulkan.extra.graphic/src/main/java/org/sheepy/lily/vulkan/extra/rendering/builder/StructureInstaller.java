package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

public final class StructureInstaller<T extends Structure<?>>
{
	public final boolean hasDynamicDescriptors;
	public final boolean hasIndexData;

	private final GenericRenderer<T> maintainer;

	private CompositeBuffer buffer;

	public StructureInstaller(GenericRenderer<T> maintainer)
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

	public StructureContext install(PipelineContext pipelineContext, T structure, int part)
	{
		final var taskPkg = pipelineContext.pipeline.getTaskPkg();

		createBuffer(pipelineContext, structure, part);
		setupDescriptorSet(pipelineContext, taskPkg);

		createDrawTasks(taskPkg, countInstances(structure));

		return new StructureContext(buffer, part);
	}

	private static final int countInstances(Structure<?> structure)
	{
		final var presentations = structure.getPresentations().stream();
		final var entities = presentations.flatMap(p -> p.getPresentedEntities().stream());

		return (int) entities.count();
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

	private void createDrawTasks(TaskPkg taskPkg, int instanceCount)
	{
		final var dataProviders = buffer.getDataProviders();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		int indexIndex = -1;

		for (int i = 0; i < dataProviders.size(); i++)
		{
			final var provider = dataProviders.get(i);
			if (provider instanceof IndexProvider)
			{
				if (indexIndex != -1)
				{
					throw new IllegalStateException("Only one IndexProvider is allowed");
				}
				indexIndex = i;
			}
			else if (provider instanceof VertexProvider)
			{
				final var vertexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
				vertexRef.setBuffer(buffer);
				vertexRef.setPart(i);

				final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
				vertexBinding.setBufferRef(vertexRef);

				vertexBufferRef.add(vertexBinding);
			}
		}

		final var bindVertex = GraphicFactory.eINSTANCE.createBindVertexBuffer();
		bindVertex.getVertexBindings().addAll(vertexBufferRef);
		taskPkg.getTasks().add(bindVertex);

		if (indexIndex != -1)
		{
			final var indexProvider = (IndexProvider<?>) dataProviders.get(indexIndex);
			final var indexProviderAdapter = IIndexProviderAdapter.adapt(indexProvider);

			final var indexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
			indexRef.setBuffer(buffer);
			indexRef.setPart(1);

			final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();
			bindIndex.setBufferRef(indexRef);
			bindIndex.setIndexType(indexProvider.getIndexType());

			final var drawIndexed = GraphicFactory.eINSTANCE.createDrawIndexed();
			drawIndexed.setIndexCount(indexProviderAdapter.getIndexCount());
			drawIndexed.setInstanceCount(instanceCount);

			taskPkg.getTasks().add(bindIndex);
			taskPkg.getTasks().add(drawIndexed);
		}
		else
		{
			final var draw = GraphicFactory.eINSTANCE.createDraw();

			taskPkg.getTasks().add(draw);
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
