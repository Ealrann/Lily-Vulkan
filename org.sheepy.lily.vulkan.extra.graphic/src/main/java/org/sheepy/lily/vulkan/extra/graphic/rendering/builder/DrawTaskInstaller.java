package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.graphic.rendering.data.IStructurePartDrawSetup;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.util.ArrayList;
import java.util.List;

public final class DrawTaskInstaller
{
	private static final String ONLY_ONE_INDEX_PROVIDER_IS_ALLOWED = "Only one IndexProvider is allowed";
	private final Structure structure;
	private final ConstantBuffer constantBuffer;

	public DrawTaskInstaller(Structure structure, ConstantBuffer constantBuffer)
	{
		this.structure = structure;
		this.constantBuffer = constantBuffer;
	}

	public IStructurePartDrawSetup install(BufferContext context)
	{
		final var pipeline = context.pipeline;
		final var taskPkg = pipeline.getTaskPkg();
		final var resourcePkg = pipeline.getResourcePkg();
		final var buffer = context.buffer;
		final var bufferParts = buffer.getParts();
		final List<VertexProvider<?>> vertexProviders = new ArrayList<>();
		final List<BufferDataProvider> dataProviders = new ArrayList<>();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		int indexIndex = -1;

		for (int i = 0; i < bufferParts.size(); i++)
		{
			final var part = bufferParts.get(i);
			final var provider = part.getDataProvider();
			dataProviders.add(provider);

			if (provider instanceof IndexProvider)
			{
				if (indexIndex != -1)
				{
					throw new IllegalStateException(ONLY_ONE_INDEX_PROVIDER_IS_ALLOWED);
				}
				indexIndex = i;
			}
			else if (provider instanceof VertexProvider)
			{
				final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
				vertexBinding.setBuffer(part);
				vertexBufferRef.add(vertexBinding);
				vertexProviders.add((VertexProvider<?>) provider);
			}
		}

		final var proxyConstantBuffer = RenderingFactory.eINSTANCE.createRenderProxyConstantBuffer();
		proxyConstantBuffer.setConstantBuffer(constantBuffer);
		proxyConstantBuffer.setPartIndex(context.drawCall);
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
			final var part = bufferParts.get(indexIndex);
			final var indexProvider = (IndexProvider<?>) part.getDataProvider();

			final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();
			bindIndex.setBuffer(part);
			bindIndex.setIndexType(indexProvider.getIndexType());

			final var indexedDraw = RenderingFactory.eINSTANCE.createRenderIndexedDrawTask();
			indexedDraw.setStructure(structure);
			indexedDraw.setIndexProvider(indexProvider);

			taskPkg.getTasks().add(bindIndex);
			taskPkg.getTasks().add(indexedDraw);

			return new IndexedDrawSetup(dataProviders, structure);
		}
		else
		{
			final var draw = RenderingFactory.eINSTANCE.createRenderDrawTask();
			draw.getVertexProviders().addAll(vertexProviders);

			taskPkg.getTasks().add(draw);

			return new DrawSetup(dataProviders, structure);
		}
	}

	private static final class IndexedDrawSetup implements IStructurePartDrawSetup
	{
		private final List<BufferDataProvider> dataProviders;
		private final Structure structure;

		private IndexedDrawSetup(List<BufferDataProvider> dataProviders, Structure structure)
		{
			this.structure = structure;
			this.dataProviders = List.copyOf(dataProviders);
		}

		@Override
		public Structure getStructure()
		{
			return structure;
		}

		@Override
		public List<BufferDataProvider> getDataProviders()
		{
			return dataProviders;
		}
	}

	private static final class DrawSetup implements IStructurePartDrawSetup
	{
		private final List<BufferDataProvider> dataProviders;
		private final Structure structure;

		private DrawSetup(List<BufferDataProvider> dataProviders, Structure structure)
		{
			this.structure = structure;
			this.dataProviders = List.copyOf(dataProviders);
		}

		@Override
		public Structure getStructure()
		{
			return structure;
		}

		@Override
		public List<BufferDataProvider> getDataProviders()
		{
			return dataProviders;
		}
	}
}
