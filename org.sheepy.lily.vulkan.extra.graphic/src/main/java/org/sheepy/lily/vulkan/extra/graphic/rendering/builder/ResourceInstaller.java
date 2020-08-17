package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter.ResourceDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public final class ResourceInstaller<T extends Structure>
{
	private final GenericRenderer<T> maintainer;
	private final List<BufferMemory> bufferMemories = new ArrayList<>();
	private final List<DescriptorSet> dynamicBindings = new ArrayList<>();
	private DescriptorSet staticBindings = null;

	public ResourceInstaller(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
	}

	public void prepare(GraphicsPipeline pipeline, T structure, int count)
	{
		staticBindings = prepareResourceDescriptors(pipeline,
													(adapter, provider) -> adapter.buildForPipeline(provider,
																									structure));

		final var memoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		pipeline.getResourcePkg().getResources().add(memoryChunk);

		for (int i = 0; i < count; i++)
		{
			final var buffer = prepareBufferMemory(memoryChunk, structure, i);
			bufferMemories.add(buffer);

			final var dynamicDescriptors = prepareResourceDescriptors(pipeline,
																	  (adapter, provider) -> adapter.buildForPart(
																			  provider,
																			  buffer));
			if (dynamicDescriptors != null)
			{
				dynamicBindings.add(dynamicDescriptors);
			}
		}
	}

	private DescriptorSet prepareResourceDescriptors(GraphicsPipeline pipeline,
													 BiFunction<IDescriptorProviderAdapter, ResourceDescriptorProvider, ResourceDescriptor> builder)
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

	public BufferContext setupBindTask(GraphicsPipeline pipeline, int part, int drawCall)
	{
		final var bufferMemory = bufferMemories.get(part);

		final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		bindDS.getDescriptorSets().add(staticBindings);
		if (dynamicBindings.isEmpty() == false)
		{
			bindDS.getDescriptorSets().add(dynamicBindings.get(part));
		}

		pipeline.getTaskPkgs().get(0).getTasks().add(bindDS);

		return new BufferContext(pipeline, bufferMemory, drawCall);
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

			final var copy = EcoreUtil.copy(dataProvider);
			copy.setDataSource(dataSource);

			final var bufferViewer = VulkanResourceFactory.eINSTANCE.createBufferViewer();
			bufferViewer.setDataProvider(copy);

			bufferMemory.getBuffers().add(bufferViewer);
			final var bufferReference = VulkanResourceFactory.eINSTANCE.createBufferReference();
			bufferReference.getBuffers().add(bufferViewer);
		}

		memoryChunk.getParts().add(bufferMemory);
		return bufferMemory;
	}
}
