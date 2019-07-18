package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IPresentationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.IndexProvider;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.VertexProvider;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

@Statefull
@Adapter(scope = GenericRendererMaintainer.class, scopeInheritance = true)
public final class GenericRendererMaintainerAdapter<T extends Presentation>
{
	public static final int PUSH_BUFFER_SIZE = 2097152;

	private final GenericRendererMaintainer<T> maintainer;
	private final GraphicProcess graphicProcess;

	private final List<PresentationContext<T>> contexts = new ArrayList<>();

	public GenericRendererMaintainerAdapter(GenericRendererMaintainer<T> maintainer)
	{
		this.maintainer = maintainer;
		graphicProcess = ModelUtil.findParent(maintainer, GraphicProcess.class);
	}

	@Autorun
	public void load()
	{
		buildPipelines();
	}

	private void buildPipelines()
	{
		final var presentationPkg = maintainer.getPresentationPkg();
		final var builder = new PresentationContext.Builder<T>(maintainer);
		final var presentationStream = presentationPkg.getPresentations().stream();
		final var pipelineIndex = new AtomicInteger(0);

		final Class<T> presentedClass = resolveGenericType();

		presentationStream.filter(presentedClass::isInstance).map(presentedClass::cast).forEach(presentation -> {
			final var meshAdapter = IPresentationAdapter.adapt(presentation);
			for (int i = 0; i < meshAdapter.getPartCount(); i++)
			{
				final var pipelineContext = newPipelineContext(pipelineIndex.getAndIncrement());
				final var meshContext = builder.setup(pipelineContext, presentation, i);
				contexts.add(meshContext);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private Class<T> resolveGenericType()
	{
		Class<T> filter = null;

		for (final var gType : maintainer.eClass().getEGenericSuperTypes())
		{
			if (gType.getEClassifier() == RenderingPackage.Literals.GENERIC_RENDERER_MAINTAINER)
			{
				filter = (Class<T>) gType.getERawType().getInstanceClass();
			}
		}

		return filter;
	}

	private PipelineContext newPipelineContext(int index)
	{
		// @Todo T MaintainerUtil.instanciate(Maintainer<T> maintainer);
		final GraphicsPipeline pipeline = GraphicFactory.eINSTANCE.createGraphicsPipeline();
		pipeline.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());
		pipeline.setResourcePkg(VulkanFactory.eINSTANCE.createResourcePkg());
		pipeline.setTaskPkg(ProcessFactory.eINSTANCE.createTaskPkg());
		maintainer.getMaintained().add(pipeline);

		for (final var constantRange : maintainer.getPushConstantRanges())
		{
			pipeline.getPushConstantRanges().add(EcoreUtil.copy(constantRange));
		}
		pipeline.getShaders().addAll(maintainer.getShaders());
		pipeline.setViewportState(EcoreUtil.copy(maintainer.getViewportState()));
		pipeline.setInputAssembly(EcoreUtil.copy(maintainer.getInputAssembly()));
		pipeline.setRasterizer(EcoreUtil.copy(maintainer.getRasterizer()));
		pipeline.setColorBlend(EcoreUtil.copy(maintainer.getColorBlend()));
		pipeline.setDynamicState(EcoreUtil.copy(maintainer.getDynamicState()));
		pipeline.setVertexInputState(EcoreUtil.copy(maintainer.getVertexInputState()));

		final var constantsData = BufferUtils.createByteBuffer(4);
		constantsData.putInt(0, index);
		pipeline.setSpecializationData(constantsData);

		pipeline.setSubpass(maintainer.getSubpass());

		final var constantBuffer = maintainer.getConstantBuffer();
		if (constantBuffer != null)
		{
			final var pushConstant = ProcessFactory.eINSTANCE.createPushConstantBuffer();
			pushConstant.getStages().add(EShaderStage.VERTEX_BIT);
			pushConstant.getStages().add(EShaderStage.FRAGMENT_BIT);
			pushConstant.setBuffer(constantBuffer);
			pipeline.getTaskPkg().getTasks().add(pushConstant);
		}

		graphicProcess.getPartPkg().getParts().add(pipeline);

		return new PipelineContext(pipeline, maintainer.getPushBuffer());
	}

	private static final class PresentationContext<T extends Presentation>
	{
		public final DescriptorSet descriptorSet;
		public final CompositeBuffer<RenderableDataSource<T>> buffer;
		public final int part;

		private PresentationContext(DescriptorSet descriptorSet,
									CompositeBuffer<RenderableDataSource<T>> buffer,
									int part)
		{
			this.descriptorSet = descriptorSet;
			this.buffer = buffer;
			this.part = part;
		}

		private static class Builder<T extends Presentation>
		{
			private final GenericRendererMaintainer<T> maintainer;

			private CompositeBuffer<RenderableDataSource<T>> buffer;
			private int part;

			private Builder(GenericRendererMaintainer<T> maintainer)
			{
				this.maintainer = maintainer;
			}

			public PresentationContext<T> setup(PipelineContext pipelineContext, T presentation, int part)
			{
				this.part = part;
				buffer = createBuffer(pipelineContext, presentation, part);

				pipelineContext.pipeline.getResourcePkg().getResources().add(buffer);

				final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
				descriptorSet.getDescriptors().addAll(maintainer.getBasicResources());
				descriptorSet.getDescriptors().add(buffer);

				pipelineContext.pipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);

				final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
				bindDS.getDescriptorSets().add(descriptorSet);

				final TaskPkg taskPkg = pipelineContext.pipeline.getTaskPkg();
				taskPkg.getTasks().add(bindDS);

				createDrawTasks(presentation, taskPkg);

				return new PresentationContext<>(descriptorSet, buffer, part);
			}

			private void createDrawTasks(T presentation, TaskPkg taskPkg)
			{
				final var dataProviders = maintainer.getDataProviders();

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
					@SuppressWarnings("unchecked")
					final var indexProvider = (IndexProvider<RenderableDataSource<T>>) dataProviders.get(indexIndex);
					final var indexProviderAdapter = IIndexProviderAdapter.adapt(indexProvider);

					final var indexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
					indexRef.setBuffer(buffer);
					indexRef.setPart(1);

					final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();
					bindIndex.setBufferRef(indexRef);
					bindIndex.setIndexType(indexProvider.getIndexType());

					final RenderableDataSource<T> dataSource = RenderingFactory.eINSTANCE.createRenderableDataSource();
					dataSource.setPart(part);
					dataSource.setPresentation(presentation);

					final var drawIndexed = GraphicFactory.eINSTANCE.createDrawIndexed();
					drawIndexed.setIndexCount(indexProviderAdapter.getIndexCount(dataSource));
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

			private CompositeBuffer<RenderableDataSource<T>> createBuffer(	PipelineContext pipelineContext,
																			T presentation,
																			int part)
			{
				final CompositeBuffer<RenderableDataSource<T>> res = ResourceFactory.eINSTANCE.createCompositeBuffer();
				final var dataProviders = maintainer.getDataProviders();

				final RenderableDataSource<T> dataSource = RenderingFactory.eINSTANCE.createRenderableDataSource();
				dataSource.setPart(part);
				dataSource.setPresentation(presentation);

				res.getDataProviders().addAll(dataProviders);
				res.setDataSource(dataSource);

				res.setPushBuffer(pipelineContext.pushBuffer);

				return res;
			}
		}
	}

	private final static class PipelineContext
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