package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericIndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericVertexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

public final class PresentationContext<T extends Presentation>
{
	public final CompositeBuffer buffer;
	public final int part;

	private PresentationContext(CompositeBuffer buffer, int part)
	{
		this.buffer = buffer;
		this.part = part;
	}

	public static class Builder<T extends Presentation>
	{
		public final boolean hasDynamicDescriptors;
		public final boolean hasIndexData;

		private final GenericRenderer<T> maintainer;

		private CompositeBuffer buffer;

		public Builder(GenericRenderer<T> maintainer)
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
			return dataProviders.stream().anyMatch(GenericIndexProvider.class::isInstance);
		}

		public PresentationContext<T> setup(PipelineContext pipelineContext, T presentation, int part)
		{
			createBuffer(pipelineContext, presentation, part);

			final var taskPkg = pipelineContext.pipeline.getTaskPkg();
			setupDescriptorSet(pipelineContext, taskPkg);

			pipelineContext.pipeline.getResourcePkg().getResources().add(buffer);

			createDrawTasks(presentation, taskPkg);

			return new PresentationContext<>(buffer, part);
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

		private void createDrawTasks(T presentation, TaskPkg taskPkg)
		{
			final var dataProviders = buffer.getDataProviders();

			final List<VertexBinding> vertexBufferRef = new ArrayList<>();
			int indexIndex = -1;

			for (int i = 0; i < dataProviders.size(); i++)
			{
				final var provider = dataProviders.get(i);
				if (provider instanceof GenericIndexProvider)
				{
					if (indexIndex != -1)
					{
						throw new IllegalStateException("Only one IndexProvider is allowed");
					}
					indexIndex = i;
				}
				else if (provider instanceof GenericVertexProvider)
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
				final var indexProvider = (GenericIndexProvider<?>) dataProviders.get(indexIndex);
				final var indexProviderAdapter = IIndexProviderAdapter.adapt(indexProvider);

				final var indexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
				indexRef.setBuffer(buffer);
				indexRef.setPart(1);

				final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();
				bindIndex.setBufferRef(indexRef);
				bindIndex.setIndexType(indexProvider.getIndexType());

				final var drawIndexed = GraphicFactory.eINSTANCE.createDrawIndexed();
				drawIndexed.setIndexCount(indexProviderAdapter.getIndexCount());
				drawIndexed.setInstanceCount(presentation.getPresentedEntities().size());

				taskPkg.getTasks().add(bindIndex);
				taskPkg.getTasks().add(drawIndexed);
			}
			else
			{
				final var draw = GraphicFactory.eINSTANCE.createDraw();

				taskPkg.getTasks().add(draw);
			}
		}

		private void createBuffer(PipelineContext pipelineContext, T presentation, int part)
		{
			buffer = ResourceFactory.eINSTANCE.createCompositeBuffer();
			final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();

			for (final var dataProvider : dataProviders)
			{
				final RenderableDataSource<T> dataSource = RenderingFactory.eINSTANCE.createRenderableDataSource();
				dataSource.setPart(part);
				dataSource.setPresentation(presentation);

				final var copy = EcoreUtil.copy(dataProvider);
				copy.setDataSource(dataSource);
				buffer.getDataProviders().add(copy);
			}

			buffer.setPushBuffer(pipelineContext.pushBuffer);
		}
	}

	public final static class PipelineContext
	{
		private final GraphicsPipeline pipeline;
		private final PushBuffer pushBuffer;

		public PipelineContext(GraphicsPipeline pipeline, PushBuffer pushBuffer)
		{
			this.pipeline = pipeline;
			this.pushBuffer = pushBuffer;
		}
	}
}