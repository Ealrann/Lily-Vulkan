package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter.ResourceDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.*;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public final class ResourceInstaller<T extends Structure>
{
	private final GenericRenderer<T> maintainer;
	private final T structure;
	private final GraphicsPipeline pipeline;
	private final int drawCallOffset;
	private final int count;

	public ResourceInstaller(final GenericRenderer<T> maintainer,
							 final T structure,
							 final GraphicsPipeline pipeline,
							 final int drawCallOffset,
							 final int count)
	{
		this.maintainer = maintainer;
		this.structure = structure;
		this.pipeline = pipeline;
		this.drawCallOffset = drawCallOffset;
		this.count = count;
	}

	public PipelineBuildContext<T> prepare(final int part)
	{
		final List<BufferMemory> bufferMemories = new ArrayList<>();
		final List<DescriptorSet> dynamicBindings = new ArrayList<>();
		final var staticBindings = prepareResourceDescriptors((adapter, provider) -> adapter.buildForPipeline(provider,
																											  structure));

		final var memoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		pipeline.getResourcePkg().getResources().add(memoryChunk);
		memoryChunk.setTransferBuffer(maintainer.getTransferBuffer());

		for (int i = 0; i < count; i++)
		{
			final var buffer = prepareBufferMemory(memoryChunk, structure, i);
			bufferMemories.add(buffer);

			final var dynamicDescriptors = prepareResourceDescriptors((adapter, provider) -> adapter.buildForPart(
					provider,
					buffer));
			if (dynamicDescriptors != null)
			{
				dynamicBindings.add(dynamicDescriptors);
			}
		}

		return new PipelineBuildContext<>(structure,
										  pipeline,
										  part,
										  drawCallOffset,
										  bufferMemories,
										  dynamicBindings,
										  staticBindings);
	}

	private DescriptorSet prepareResourceDescriptors(BiFunction<IDescriptorProviderAdapter, ResourceDescriptorProvider, ResourceDescriptor> builder)
	{
		final List<IDescriptor> res = new ArrayList<>();
		final var descriptorProviderPkg = maintainer.getDescriptorProviderPkg();
		if (descriptorProviderPkg != null)
		{
			for (final var provider : descriptorProviderPkg.getResourceDescriptorProviders())
			{
				final var adapter = provider.adaptNotNull(IDescriptorProviderAdapter.class);
				final var resourceDescriptors = builder.apply(adapter, provider);

				if (resourceDescriptors != null)
				{
					pipeline.getResourcePkg().getResources().addAll(resourceDescriptors.resources);
					pipeline.getDescriptorPkg().getDescriptors().addAll(resourceDescriptors.descriptors);
					res.addAll(resourceDescriptors.descriptors);
				}
			}
		}

		if (res.isEmpty() == false)
		{
			final var dSet = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
			dSet.getDescriptors().addAll(res);
			pipeline.getDescriptorPool().getDescriptorSets().add(dSet);
			pipeline.getLayout().add(dSet);
			return dSet;
		}
		else
		{
			return null;
		}
	}

	private BufferMemory prepareBufferMemory(MemoryChunk memoryChunk, T structure, int part)
	{
		final var bufferMemory = VulkanResourceFactory.eINSTANCE.createBufferMemory();
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();
		bufferMemory.setName(maintainer.getName());

		for (int i = 0; i < dataProviders.size(); i++)
		{
			final var dataProvider = dataProviders.get(i);
			final var dataSource = RenderingFactory.eINSTANCE.<T>createRenderableDataSource();
			dataSource.setPart(part);
			dataSource.setStructure(structure);

			final var renderDataProvider = EcoreUtil.copy(dataProvider.getDataProvider());
			renderDataProvider.setDataSource(dataSource);

			final var bufferViewer = VulkanResourceFactory.eINSTANCE.createBufferViewer();
			final var usages = bufferViewer.getUsages();
			bufferViewer.setDataProvider(renderDataProvider);
			bufferViewer.setGrowFactor(dataProvider.getGrowFactor());
			bufferViewer.setSize(dataProvider.getMinSize());
			usages.addAll(dataProvider.getUsages());
			usages.add(renderDataProvider instanceof IndexProvider
							   ? EBufferUsage.INDEX_BUFFER_BIT
							   : EBufferUsage.VERTEX_BUFFER_BIT);
			usages.add(EBufferUsage.TRANSFER_DST_BIT);

			bufferMemory.getBuffers().add(bufferViewer);
			final var bufferReference = VulkanResourceFactory.eINSTANCE.createBufferReference();
			bufferReference.getBuffers().add(bufferViewer);
		}

		memoryChunk.getParts().add(bufferMemory);
		return bufferMemory;
	}
}
