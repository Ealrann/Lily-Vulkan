package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.core.resource.buffer.IBufferViewerAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexSupplier;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.util.ArrayList;
import java.util.List;

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
		final var bufferSetup = context.bufferSetup();
		final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		final var descriptorSets = bindDS.getDescriptorSets();

		descriptorSets.add(context.staticBindings());
		if (!context.dynamicBindings().isEmpty()) descriptorSets.add(context.dynamicBindings().get(part));

		context.pipeline().getTaskPkgs().get(0).getTasks().add(bindDS);

		return new BufferContext(context.pipeline(), context.structure(), bufferSetup, drawCall);
	}

	private void install(BufferContext context)
	{
		final var pipeline = context.pipeline();
		final var taskPkg = pipeline.getTaskPkgs().get(0);
		final var resourcePkg = pipeline.getResourcePkg();
		final var bufferSetups = context.bufferGroup().bufferSetups();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		final List<BufferSetup> vertexBuffers = new ArrayList<>();
		int indexIndex = -1;

		for (int i = 0; i < bufferSetups.size(); i++)
		{
			final var bufferSetup = bufferSetups.get(i);
			final var bufferViewer = bufferSetup.bufferViewer();
			final var isIndexBuffer = bufferViewer.getUsages().contains(EBufferUsage.INDEX_BUFFER_BIT);
			final var isVertexBuffer = bufferViewer.getUsages().contains(EBufferUsage.VERTEX_BUFFER_BIT);

			if (isIndexBuffer)
			{
				if (indexIndex != -1)
				{
					throw new IllegalStateException(ONLY_ONE_INDEX_PROVIDER_IS_ALLOWED);
				}

				indexIndex = i;
			}
			else if (isVertexBuffer)
			{
				final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
				vertexBinding.setBuffer(bufferViewer);
				vertexBufferRef.add(vertexBinding);

				vertexBuffers.add(bufferSetup);
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
			final var bufferSetup = bufferSetups.get(indexIndex);
			final var indexedDraw = GraphicFactory.eINSTANCE.createDrawIndexed();
			final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();
			final var dataProvider = (IndexedDataDescription<?>) bufferSetup.dataProvider();
			final var bufferViewer = bufferSetup.bufferViewer();

			bindIndex.setBuffer(bufferViewer);
			bindIndex.setIndexType(dataProvider.getIndexType());
			taskPkg.getTasks().add(bindIndex);
			taskPkg.getTasks().add(indexedDraw);

			final var indexProvider = bufferSetup.bufferViewer().adapt(IIndexSupplier.class);
			structureAdapter.listen(indexedDraw::setInstanceCount, IStructureAdapter.Features.InstanceCount);
			indexProvider.listen(indexedDraw::setIndexCount, IIndexSupplier.Features.IndexCount);

			indexedDraw.setInstanceCount(structureAdapter.getInstanceCount(context.structure));
			indexedDraw.setIndexCount(indexProvider.getIndexCount());
		}
		else
		{
			final var draw = GraphicFactory.eINSTANCE.createDraw();
			final Runnable listener = () -> updateVertexCount(vertexBuffers, draw);

			taskPkg.getTasks().add(draw);

			structureAdapter.listen(draw::setInstanceCount, IStructureAdapter.Features.InstanceCount);
			draw.setInstanceCount(structureAdapter.getInstanceCount(context.structure));

			vertexBuffers.stream()
						 .map(BufferSetup::bufferViewer)
						 .map(bufferViewer -> bufferViewer.adapt(IBufferViewerAdapter.class))
						 .map(bva -> bva.adaptDataSource(IVertexSupplier.class))
						 .forEach(vertexSupplier -> vertexSupplier.listenNoParam(listener,
																				 IVertexSupplier.Features.VertexCount));

			updateVertexCount(vertexBuffers, draw);
		}
	}

	private static void updateVertexCount(final List<BufferSetup> vertexBuffers, final Draw draw)
	{
		final int vertexCount = vertexBuffers.stream()
											 .map(BufferSetup::bufferViewer)
											 .map(bv -> bv.adapt(IBufferViewerAdapter.class))
											 .map(bva -> bva.adaptDataSource(IVertexSupplier.class))
											 .mapToInt(IVertexSupplier::getVertexCount)
											 .sum();

		draw.setVertexCount(vertexCount);
	}

	private record BufferContext(GraphicsPipeline pipeline,
								 Structure structure,
								 BufferGroupSetup bufferGroup,
								 int drawCall)
	{
		public RenderPipelineSetup toRenderSetup()
		{
			final var dataProviders = bufferGroup.bufferSetups()
												 .stream()
												 .map(BufferSetup::bufferViewer)
												 .toList();

			return new RenderPipelineSetup(pipeline, dataProviders, structure);
		}
	}
}
