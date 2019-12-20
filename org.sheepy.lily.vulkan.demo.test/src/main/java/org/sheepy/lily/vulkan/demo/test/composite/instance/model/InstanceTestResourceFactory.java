package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.test.composite.instance.adapter.InstanceDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

class InstanceTestResourceFactory
{
	public static ResourceContainer build(int instanceCount)
	{
		final var transferBuffer = buildTransferBuffer();
		final var compositeBuffer = buildCompositeBuffer(transferBuffer, instanceCount);
		final var shader = ResourceFactory.eINSTANCE.createShader();
		final var moduleResource = ApplicationFactory.eINSTANCE.createModuleResource();
		moduleResource.setModule(InstanceTaskManager.class.getModule());
		moduleResource.setPath("increment.comp.spv");
		shader.setFile(moduleResource);
		shader.setStage(EShaderStage.COMPUTE_BIT);

		final var ds = ResourceFactory.eINSTANCE.createDescriptorSet();

		final List<CompositeBufferReference> refs = new ArrayList<>();
		for (int i = 0; i < 2; i++)
		{
			final var reference = ResourceFactory.eINSTANCE.createCompositeBufferReference();
			reference.setBuffer(compositeBuffer);
			reference.setPart(0);
			reference.setInstance(i);
			refs.add(reference);

			final var descriptor = ResourceFactory.eINSTANCE.createBufferDescriptor();
			descriptor.setType(EDescriptorType.STORAGE_BUFFER);
			descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
			descriptor.setBufferReference(reference);

			ds.getDescriptors().add(descriptor);
		}

		return new ResourceContainer(transferBuffer, compositeBuffer, ds, refs, shader);
	}

	public static final class ResourceContainer
	{
		public final TransferBuffer transferBuffer;
		public final CompositeBuffer compositeBuffer;
		public final DescriptorSet ds;
		public final Shader shader;
		public final List<CompositeBufferReference> refs;

		public ResourceContainer(	TransferBuffer transferBuffer,
									CompositeBuffer compositeBuffer,
									DescriptorSet ds,
									List<CompositeBufferReference> refs,
									Shader shader)
		{
			this.transferBuffer = transferBuffer;
			this.compositeBuffer = compositeBuffer;
			this.ds = ds;
			this.refs = List.copyOf(refs);
			this.shader = shader;
		}

		public void setupDescriptor(int first, int second)
		{
			refs.get(0).setInstance(first);
			refs.get(1).setInstance(second);
		}
	}

	private static TransferBuffer buildTransferBuffer()
	{
		final var res = ResourceFactory.eINSTANCE.createTransferBuffer();
		res.setSize(InstanceDataProviderAdapter.SIZE);
		res.setInstanceCount(1);
		res.setUsedToFetch(true);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(TransferBuffer transferBuffer,
														int instanceCount)
	{
		final var res = ResourceFactory.eINSTANCE.createCompositeBuffer();

		res.setTransferBuffer(transferBuffer);

		final var provider = ResourceFactory.eINSTANCE.createBufferDataProvider();
		provider.setName(InstanceDataProviderAdapter.NAME);
		provider.setUsage(EBufferUsage.STORAGE_BUFFER_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.COMPUTE_SHADER_BIT);
		provider.getAccessBeforeFetch().add(EAccess.SHADER_WRITE_BIT);
		provider.setUsedToFetch(true);
		provider.setInstanceCount(instanceCount);

		final var providers = res.getDataProviders();
		providers.add(provider);

		return res;
	}
}
