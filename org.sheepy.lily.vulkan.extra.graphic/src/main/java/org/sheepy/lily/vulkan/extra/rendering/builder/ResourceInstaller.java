package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter.ResourceDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

public final class ResourceInstaller<T extends Structure>
{
	private static final int BUFFER_MIN_SIZE = 1 << 16;

	private final GenericRenderer<T> maintainer;
	private final List<CompositeBuffer> buffers = new ArrayList<>();
	private final List<DescriptorSet> dynamicBindings = new ArrayList<>();
	private DescriptorSet staticBindings = null;

	public ResourceInstaller(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
	}

	public void prepare(GraphicsPipeline pipeline, T structure, int count)
	{
		staticBindings = prepareResourceDescriptors(pipeline,
													IDescriptorProviderAdapter::buildForPipeline);

		for (int i = 0; i < count; i++)
		{
			final var buffer = prepareBuffer(pipeline, structure, i);
			buffers.add(buffer);

			final var dynamicDescriptors = prepareResourceDescriptors(	pipeline,
																		(	adapter,
																			provider) -> adapter.buildForPart(	provider,
																												buffer));
			if (dynamicDescriptors != null)
			{
				dynamicBindings.add(dynamicDescriptors);
			}
		}
	}

	private DescriptorSet prepareResourceDescriptors(	GraphicsPipeline pipeline,
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
					pipeline.getDescriptorPkg()
							.getDescriptors()
							.addAll(resourceDescriptors.descriptors);
					res.addAll(resourceDescriptors.descriptors);
				}
			}
		}

		if (res.isEmpty() == false)
		{
			final var dSet = ResourceFactory.eINSTANCE.createDescriptorSet();
			dSet.getDescriptors().addAll(res);
			pipeline.getDescriptorSetPkg().getDescriptorSets().add(dSet);
			return dSet;
		}
		else
		{
			return null;
		}
	}

	public BufferContext setupBindTask(GraphicsPipeline pipeline, int part)
	{
		final var buffer = buffers.get(part);

		final var bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		bindDS.getDescriptorSets().add(staticBindings);
		if (dynamicBindings.isEmpty() == false)
		{
			bindDS.getDescriptorSets().add(dynamicBindings.get(part));
		}

		pipeline.getTaskPkg().getTasks().add(bindDS);

		return new BufferContext(pipeline, buffer, part);
	}

	private CompositeBuffer prepareBuffer(GraphicsPipeline pipeline, T structure, int part)
	{
		final var buffer = ResourceFactory.eINSTANCE.createCompositeBuffer();
		final var dataProviders = maintainer.getDataProviderPkg().getDataProviders();
		final var flushTransferTask = maintainer.getFlushTransferBufferTask();
		final var prepareTranferTask = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
		prepareTranferTask.setCompositeBuffer(buffer);
		prepareTranferTask.setMode(EFlushMode.PUSH);

		for (int i = 0; i < dataProviders.size(); i++)
		{
			final var transferReference = ResourceFactory.eINSTANCE.createCompositePartReference();
			final var dataProvider = dataProviders.get(i);
			final var dataSource = RenderingFactory.eINSTANCE.<T> createRenderableDataSource();
			dataSource.setPart(part);
			dataSource.setStructure(structure);

			final var copy = EcoreUtil.copy(dataProvider);
			copy.setDataSource(dataSource);
			buffer.getDataProviders().add(copy);
			
			transferReference.setPart(i);
			prepareTranferTask.getParts().add(transferReference);
		}

		buffer.setMinSize(BUFFER_MIN_SIZE);
		buffer.setTransferBuffer(maintainer.getTransferBuffer());

		@SuppressWarnings("unchecked")
		final var containingList = (List<IPipelineTask>) flushTransferTask	.eContainer()
																			.eGet(flushTransferTask.eContainingFeature());
		final int index = containingList.indexOf(flushTransferTask);
		containingList.add(index, prepareTranferTask);

		pipeline.getResourcePkg().getResources().add(buffer);
		return buffer;
	}
}
