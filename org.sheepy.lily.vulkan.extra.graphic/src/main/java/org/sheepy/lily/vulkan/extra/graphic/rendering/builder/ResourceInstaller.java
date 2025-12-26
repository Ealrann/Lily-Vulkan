package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter.ResourceDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
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
	}

	public PipelineBuildContext<T> prepare(final int part)
	{
		final List<DescriptorSet> dynamicBindings = new ArrayList<>();
		final var staticBindings = prepareResourceDescriptors((adapter, provider) -> adapter.buildForPipeline(provider,
																											  structure));

		final var memoryChunk = MemoryChunk.builder().build();
		pipeline.resourcePkg().resources().add(memoryChunk);
		memoryChunk.transferBuffer(maintainer.transferBuffer());

//		for (int i = 0; i < count; i++)
//		{
		final BufferGroupSetup bufferSetup = prepareBufferMemory(memoryChunk, structure, part);

		final var dynamicDescriptors = prepareResourceDescriptors((adapter, provider) -> adapter.buildForPart(provider,
																											  bufferSetup
																													  .bufferSetups()
																													  .stream()
																													  .map(BufferSetup::bufferViewer)));
		if (dynamicDescriptors != null)
		{
			dynamicBindings.add(dynamicDescriptors);
		}
//		}

		if (part == 0)
		{
			if (staticBindings != null) pipeline.layout().add(staticBindings);
			if (dynamicBindings.isEmpty() == false) pipeline.layout().add(dynamicBindings.get(0));
		}

		return new PipelineBuildContext<>(structure,
										  pipeline,
										  part,
										  drawCallOffset,
										  bufferSetup,
										  dynamicBindings,
										  staticBindings);
	}

	private DescriptorSet prepareResourceDescriptors(BiFunction<IDescriptorProviderAdapter, ResourceDescriptorProvider, ResourceDescriptor> builder)
	{
		final List<IDescriptor> res = new ArrayList<>();
		final var descriptorProviderPkg = maintainer.descriptorProviderPkg();
		if (descriptorProviderPkg != null)
		{
			for (final var provider : descriptorProviderPkg.resourceDescriptorProviders())
			{
				final var adapter = provider.adaptNotNull(IDescriptorProviderAdapter.class);
				final var resourceDescriptors = builder.apply(adapter, provider);

				if (resourceDescriptors != null)
				{
					pipeline.resourcePkg().resources().addAll(resourceDescriptors.resources);
					pipeline.descriptorPkg().descriptors().addAll(resourceDescriptors.descriptors);
					res.addAll(resourceDescriptors.descriptors);
				}
			}
		}

		if (res.isEmpty() == false)
		{
			final var dSet = DescriptorSet.builder().build();
			dSet.descriptors().addAll(res);
			pipeline.descriptorPool().descriptorSets().add(dSet);
			return dSet;
		}
		else
		{
			return null;
		}
	}

	private BufferGroupSetup prepareBufferMemory(final MemoryChunk memoryChunk, final T structure, final int part)
	{
		final var bufferMemory = BufferMemory.builder()
											 .name(maintainer.name())
											 .build();
		final var dataProviders = maintainer.dataProviderPkg().dataProviders();
		final var resourcePkg = (VulkanResourcePkg) memoryChunk.lmContainer();

		final List<BufferSetup> res = new ArrayList<>();
		for (int i = 0; i < dataProviders.size(); i++)
		{
			final var dataProvider = dataProviders.get(i);
			final var dataSource = RenderableDataSource.<T>builder()
													   .part(part)
													   .structure(() -> structure)
													   .dataSource(() -> dataProvider.dataSource())
													   .name(dataProvider.dataSourceName())
													   .build();
			resourcePkg.resources().add(dataSource);

			final var bufferViewer = BufferViewer.builder()
												 .growFactor(dataProvider.growFactor())
												 .size(dataProvider.minSize())
												 .dataSource(() -> dataSource)
												 .addUsages(dataProvider.usages())
												 .addUsage(EBufferUsage.TRANSFER_DST_BIT)
												 .build();

			bufferMemory.buffers().add(bufferViewer);

			res.add(new BufferSetup(bufferViewer, dataProvider));
		}

		memoryChunk.parts().add(bufferMemory);
		return new BufferGroupSetup(List.copyOf(res));
	}
}
