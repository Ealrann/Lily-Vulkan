package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IRenderDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
import org.sheepy.lily.vulkan.extra.rendering.data.IStructurePartDrawSetup;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

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

		final var dataProviders = buffer.getDataProviders();

		final List<VertexBinding> vertexBufferRef = new ArrayList<>();
		final List<IRenderDataProviderAdapter> adaptedDataProviders = new ArrayList<>();
		int indexIndex = -1;

		for (int i = 0; i < dataProviders.size(); i++)
		{
			final var provider = dataProviders.get(i);
			final var adapter = provider.adaptNotNull(IRenderDataProviderAdapter.class);
			adaptedDataProviders.add(adapter);

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
				final var vertexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
				vertexRef.setBuffer(buffer);
				vertexRef.setPart(i);

				final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
				vertexBinding.setBufferRef(vertexRef);

				vertexBufferRef.add(vertexBinding);
			}
		}

		final var proxyConstantBuffer = RenderingFactory.eINSTANCE.createRenderProxyConstantBuffer();
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
			final var indexProviderAdapter = indexProvider.adaptNotNull(IIndexProviderAdapter.class);

			final var indexRef = ResourceFactory.eINSTANCE.createCompositeBufferReference();
			indexRef.setBuffer(buffer);
			indexRef.setPart(1);

			final var bindIndex = GraphicFactory.eINSTANCE.createBindIndexBuffer();
			bindIndex.setBufferRef(indexRef);
			bindIndex.setIndexType(indexProvider.getIndexType());

			final var drawIndexed = GraphicFactory.eINSTANCE.createDrawIndexed();

			taskPkg.getTasks().add(bindIndex);
			taskPkg.getTasks().add(drawIndexed);

			return new IndexedDrawSetup(bindVertex,
										bindIndex,
										drawIndexed,
										indexProviderAdapter,
										adaptedDataProviders,
										structure);
		}
		else
		{
			final var draw = GraphicFactory.eINSTANCE.createDraw();
			taskPkg.getTasks().add(draw);

			return new DrawSetup(bindVertex, draw, adaptedDataProviders, structure);
		}
	}
	
	private static final class IndexedDrawSetup implements IStructurePartDrawSetup
	{
		@SuppressWarnings("unused")
		private final BindVertexBuffer vertexBindTask;
		@SuppressWarnings("unused")
		private final BindIndexBuffer indexBindTask;
		private final DrawIndexed drawTask;
		private final IIndexProviderAdapter indexProvider;
		private final List<IRenderDataProviderAdapter> dataProviders;
		private final Structure structure;

		private boolean dirty = true;

		private IndexedDrawSetup(	BindVertexBuffer vertexBindTask,
									BindIndexBuffer indexBindTask,
									DrawIndexed drawTask,
									IIndexProviderAdapter indexProvider,
									List<IRenderDataProviderAdapter> dataProviders,
									Structure structure)
		{
			this.vertexBindTask = vertexBindTask;
			this.indexBindTask = indexBindTask;
			this.drawTask = drawTask;
			this.indexProvider = indexProvider;
			this.structure = structure;
			this.dataProviders = List.copyOf(dataProviders);
		}

		@Override
		public void update()
		{
			if (dirty)
			{
				final var structureAdapter = structure.adaptNotNull(IStructureAdapter.class);
				final int instanceCount = structureAdapter.getInstanceCount(structure);
				drawTask.setIndexCount(indexProvider.getIndexCount());
				drawTask.setInstanceCount(instanceCount);
				dirty = false;
			}
		}

		@Override
		public Structure getStructure()
		{
			return structure;
		}

		@Override
		public List<? extends IRenderDataProviderAdapter> getDataProviders()
		{
			return dataProviders;
		}
	}

	private static final class DrawSetup implements IStructurePartDrawSetup
	{
		@SuppressWarnings("unused")
		private final BindVertexBuffer bindTask;
		private final Draw drawTask;
		private final List<IRenderDataProviderAdapter> dataProviders;
		private final Structure structure;

		private boolean dirty = true;

		private DrawSetup(	BindVertexBuffer bindTask,
							Draw drawTask,
							List<IRenderDataProviderAdapter> dataProviders,
							Structure structure)
		{
			this.bindTask = bindTask;
			this.drawTask = drawTask;
			this.structure = structure;
			this.dataProviders = List.copyOf(dataProviders);
		}

		@Override
		public void update()
		{
			if (dirty)
			{
				int vertexCount = 0;
				for (final var vertexProvider : dataProviders)
				{
					if (vertexProvider instanceof IVertexProviderAdapter)
					{
						vertexCount += ((IVertexProviderAdapter) vertexProvider).getVertexCount();
					}
				}

				drawTask.setVertexCount(vertexCount);

				dirty = false;
			}
		}

		@Override
		public Structure getStructure()
		{
			return structure;
		}

		@Override
		public List<? extends IRenderDataProviderAdapter> getDataProviders()
		{
			return dataProviders;
		}
	}
}
