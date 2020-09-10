package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DrawTaskConfigurator
{
	private static final String ONLY_ONE_INDEX_PROVIDER_IS_ALLOWED = "Only one IndexProvider is allowed";
	private final ConstantBuffer constantBuffer;

	public DrawTaskConfigurator(ConstantBuffer constantBuffer)
	{
		this.constantBuffer = constantBuffer;
	}

	public RenderPipelineSetup install(PipelineBuildContext<?> context)
	{
		final var bufferContext = setupBindTask(context);
		install(bufferContext);
		return bufferContext.toRenderSetup();
	}

	private static BufferContext setupBindTask(PipelineBuildContext<?> context)
	{
		final var part = context.part();
		final int drawCall = part + context.drawCallOffset();
		final var bufferMemory = context.bufferMemories().get(part);
		final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		final var descriptorSets = bindDS.getDescriptorSets();

		descriptorSets.add(context.staticBindings());
		if (!context.dynamicBindings().isEmpty()) descriptorSets.add(context.dynamicBindings().get(part));

		context.pipeline().getTaskPkgs().get(0).getTasks().add(bindDS);

		return new BufferContext(context.pipeline(), context.structure(), bufferMemory, drawCall);
	}

	private void install(BufferContext context)
	{
		final var pipeline = context.pipeline();
		final var taskPkg = pipeline.getTaskPkgs().get(0);
		final var resourcePkg = pipeline.getResourcePkg();
		final var bufferParts = context.bufferMemory().getBuffers();
		final List<VertexProvider<?>> vertexProviders = new ArrayList<>();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		int indexIndex = -1;

		for (int i = 0; i < bufferParts.size(); i++)
		{
			final var part = bufferParts.get(i);
			final var provider = ((BufferViewer) part).getDataProvider();

			if (provider instanceof IndexProvider)
			{
				if (indexIndex != -1)
				{
					throw new IllegalStateException(ONLY_ONE_INDEX_PROVIDER_IS_ALLOWED);
				}

				indexIndex = i;
			}
			else if (provider instanceof VertexProvider<?> vertexProvider)
			{
				final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
				vertexBinding.setBuffer(part);
				vertexBufferRef.add(vertexBinding);
				vertexProviders.add(vertexProvider);
			}
		}

		final var proxyConstantBuffer = RenderingFactory.eINSTANCE.createRenderProxyConstantBuffer();
		proxyConstantBuffer.setConstantBuffer(constantBuffer);
		proxyConstantBuffer.setPartIndex(context.drawCall());
		resourcePkg.getResources().add(proxyConstantBuffer);

		final var pushConstant = ProcessFactory.eINSTANCE.createPushConstantBuffer();
		pushConstant.getStages().add(EShaderStage.VERTEX_BIT);
		pushConstant.getStages().add(EShaderStage.FRAGMENT_BIT);
		pushConstant.setBuffer(proxyConstantBuffer);
		taskPkg.getTasks().add(pushConstant);

		final var bindVertex = GraphicFactory.eINSTANCE.createBindVertexBuffer();
		bindVertex.getVertexBindings().addAll(vertexBufferRef);
		taskPkg.getTasks().add(bindVertex);

		final var structureAdapter = context.structure.adapt(IStructureAdapter.class);

		if (indexIndex != -1)
		{
			final var part = bufferParts.get(indexIndex);
			final var indexProvider = (IndexProvider<?>) ((BufferViewer) part).getDataProvider();
			final var indexedDraw = GraphicFactory.eINSTANCE.createDrawIndexed();
			final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();

			bindIndex.setBuffer(part);
			bindIndex.setIndexType(indexProvider.getIndexType());
			taskPkg.getTasks().add(bindIndex);
			taskPkg.getTasks().add(indexedDraw);

			final var indexProviderAdapter = indexProvider.adapt(IIndexProviderAdapter.class);
			structureAdapter.listen(indexedDraw::setInstanceCount, IStructureAdapter.Features.InstanceCount);
			indexProviderAdapter.listen(indexedDraw::setIndexCount, IIndexProviderAdapter.Features.IndexCount);

			indexedDraw.setInstanceCount(structureAdapter.getInstanceCount(context.structure));
			indexedDraw.setIndexCount(indexProviderAdapter.getIndexCount());
		}
		else
		{
			final var draw = GraphicFactory.eINSTANCE.createDraw();
			taskPkg.getTasks().add(draw);

			structureAdapter.listen(draw::setInstanceCount, IStructureAdapter.Features.InstanceCount);
			draw.setInstanceCount(structureAdapter.getInstanceCount(context.structure));

			for (final var vertexProvider : vertexProviders)
			{
				final var vertexProviderAdapter = vertexProvider.adapt(IVertexProviderAdapter.class);
				vertexProviderAdapter.listenNoParam(() -> updateVertexCount(vertexProviders, draw),
													IVertexProviderAdapter.Features.VertexCount);
			}

			updateVertexCount(vertexProviders, draw);
		}
	}

	private static void updateVertexCount(final List<VertexProvider<?>> vertexProviders, final Draw draw)
	{
		final int vertexCount = vertexProviders.stream()
											   .map(IVertexProviderAdapter::adapt)
											   .mapToInt(IVertexProviderAdapter::getVertexCount)
											   .sum();

		draw.setVertexCount(vertexCount);
	}

	private record BufferContext(GraphicsPipeline pipeline,
								 Structure structure,
								 BufferMemory bufferMemory,
								 int drawCall)
	{
		public RenderPipelineSetup toRenderSetup()
		{
			final var dataProviders = bufferMemory.getBuffers()
												  .stream()
												  .map(BufferViewer.class::cast)
												  .map(BufferViewer::getDataProvider)
												  .map(BufferDataProvider.class::cast)
												  .collect(Collectors.toUnmodifiableList());

			return new RenderPipelineSetup(pipeline, dataProviders, structure);
		}
	}
}
