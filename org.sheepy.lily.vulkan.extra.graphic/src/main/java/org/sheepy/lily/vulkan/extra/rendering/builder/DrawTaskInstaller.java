package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class DrawTaskInstaller
{
	private final int instanceCount;

	public DrawTaskInstaller(Structure<?> structure)
	{
		instanceCount = countInstances(structure);
	}

	private static final int countInstances(Structure<?> structure)
	{
		final var presentations = structure.getPresentations().stream();
		final var entities = presentations.flatMap(p -> p.getPresentedEntities().stream());

		return (int) entities.count();
	}

	public void install(BufferContext context)
	{
		final var pipeline = context.pipelineContext.pipeline;
		final var taskPkg = pipeline.getTaskPkg();
		final var resourcePkg = pipeline.getResourcePkg();
		final var buffer = context.buffer;

		final var dataProviders = buffer.getDataProviders();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		int indexIndex = -1;
		int vertexCount = 0;

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
				final var adapter = IVertexProviderAdapter.adapt((VertexProvider<?>) provider);
				vertexCount += adapter.getVertexCount();

				final var vertexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
				vertexRef.setBuffer(buffer);
				vertexRef.setPart(i);

				final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
				vertexBinding.setBufferRef(vertexRef);

				vertexBufferRef.add(vertexBinding);
			}
		}

		final var constantBuffer = context.pipelineContext.constantBuffer;
		final var proxyConstantBuffer = RenderingFactory.eINSTANCE
				.createRenderProxyConstantBuffer();
		proxyConstantBuffer.setConstantBuffer(constantBuffer);
		proxyConstantBuffer.setPartIndex(context.part);
		resourcePkg.getResources().add(proxyConstantBuffer);

		final var pushConstant = ProcessFactory.eINSTANCE.createPushConstantBuffer();
		pushConstant.getStages().add(EShaderStage.VERTEX_BIT);
		pushConstant.getStages().add(EShaderStage.FRAGMENT_BIT);
		pushConstant.setBuffer(proxyConstantBuffer);
		taskPkg.getTasks().add(pushConstant);

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
			draw.setVertexCount(vertexCount);

			taskPkg.getTasks().add(draw);
		}
	}
}
