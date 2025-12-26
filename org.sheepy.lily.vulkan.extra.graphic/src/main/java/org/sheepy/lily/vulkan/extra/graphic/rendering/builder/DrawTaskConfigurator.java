package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.core.resource.buffer.IBufferViewerAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexSupplier;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.data.RenderPipelineSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EBindPoint;
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
		final var bindDS = BindDescriptorSets.builder()
											 .bindPoint(EBindPoint.GRAPHICS)
											 .build();
		final var descriptorSets = bindDS.descriptorSets();

		descriptorSets.add(context.staticBindings());
		if (!context.dynamicBindings().isEmpty()) descriptorSets.add(context.dynamicBindings().get(part));

		context.pipeline().taskPkgs().get(0).tasks().add(bindDS);

		return new BufferContext(context.pipeline(), context.structure(), bufferSetup, drawCall);
	}

	private void install(BufferContext context)
	{
		final var pipeline = context.pipeline();
		final var taskPkg = pipeline.taskPkgs().get(0);
		final var resourcePkg = pipeline.resourcePkg();
		final var bufferSetups = context.bufferGroup().bufferSetups();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		final List<BufferSetup> vertexBuffers = new ArrayList<>();
		int indexIndex = -1;

		for (int i = 0; i < bufferSetups.size(); i++)
		{
			final var bufferSetup = bufferSetups.get(i);
			final var bufferViewer = bufferSetup.bufferViewer();
			final var isIndexBuffer = bufferViewer.usages().contains(EBufferUsage.INDEX_BUFFER_BIT);
			final var isVertexBuffer = bufferViewer.usages().contains(EBufferUsage.VERTEX_BUFFER_BIT);

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
				final var vertexBinding = VertexBinding.builder()
													   .buffer(() -> bufferViewer)
													   .build();
				vertexBufferRef.add(vertexBinding);

				vertexBuffers.add(bufferSetup);
			}
		}

		final var proxyConstantBuffer = RenderProxyConstantBuffer.builder()
																 .constantBuffer(() -> constantBuffer)
																 .partIndex(context.drawCall())
																 .build();
		resourcePkg.resources().add(proxyConstantBuffer);

		final var pushConstant = PushConstantBuffer.builder()
												   .addStage(EShaderStage.VERTEX_BIT)
												   .addStage(EShaderStage.FRAGMENT_BIT)
												   .buffer(() -> proxyConstantBuffer)
												   .build();
		taskPkg.tasks().add(pushConstant);

		final var bindVertex = BindVertexBuffer.builder()
											   .addVertexBindings(vertexBufferRef)
											   .build();
		taskPkg.tasks().add(bindVertex);

		final var structureAdapter = context.structure.adapt(IStructureAdapter.class);

		if (indexIndex != -1)
		{
			final var bufferSetup = bufferSetups.get(indexIndex);
			final var indexedDraw = DrawIndexed.builder().build();
			final var bindIndex = BindIndexBuffer.builder().build();
			final var dataProvider = (IndexedDataDescription<?>) bufferSetup.dataProvider();
			final var bufferViewer = bufferSetup.bufferViewer();

			bindIndex.buffer(bufferViewer);
			bindIndex.indexType(dataProvider.indexType());
			taskPkg.tasks().add(bindIndex);
			taskPkg.tasks().add(indexedDraw);

			final var indexProvider = bufferSetup.bufferViewer().adapt(IIndexSupplier.class);
			structureAdapter.listen(indexedDraw::instanceCount, IStructureAdapter.Features.InstanceCount);
			indexProvider.listen(indexedDraw::indexCount, IIndexSupplier.Features.IndexCount);

			indexedDraw.instanceCount(structureAdapter.getInstanceCount(context.structure));
			indexedDraw.indexCount(indexProvider.getIndexCount());
		}
		else
		{
			final var draw = Draw.builder().build();
			final Runnable listener = () -> updateVertexCount(vertexBuffers, draw);

			taskPkg.tasks().add(draw);

			structureAdapter.listen(draw::instanceCount, IStructureAdapter.Features.InstanceCount);
			draw.instanceCount(structureAdapter.getInstanceCount(context.structure));

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

		draw.vertexCount(vertexCount);
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
