package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import org.sheepy.lily.vulkan.demo.test.composite.instance.adapter.InstanceDataProviderAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
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
		final var ds = ResourceFactory.eINSTANCE.createDescriptorSet();
		ds.getDescriptors().add(compositeBuffer);

		final var shader = ResourceFactory.eINSTANCE.createShader();
		final var moduleResource = ResourceFactory.eINSTANCE.createModuleResource();
		moduleResource.setModule(InstanceTaskManager.class.getModule());
		moduleResource.setPath("increment.comp.spv");
		shader.setFile(moduleResource);
		shader.setStage(EShaderStage.COMPUTE_BIT);

		return new ResourceContainer(transferBuffer, compositeBuffer, ds, shader);
	}

	public static final class ResourceContainer
	{
		public final TransferBuffer transferBuffer;
		public final CompositeBuffer compositeBuffer;
		public final DescriptorSet ds;
		public final Shader shader;

		public ResourceContainer(	TransferBuffer transferBuffer,
									CompositeBuffer compositeBuffer,
									DescriptorSet ds,
									Shader shader)
		{
			this.transferBuffer = transferBuffer;
			this.compositeBuffer = compositeBuffer;
			this.ds = ds;
			this.shader = shader;
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

		final var descriptor = ResourceFactory.eINSTANCE.createDescriptor();
		descriptor.setDescriptorType(EDescriptorType.STORAGE_BUFFER);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);

		final var providers = res.getDataProviders();
		final var provider = ResourceFactory.eINSTANCE.createDescribedDataProvider();
		provider.setName(InstanceDataProviderAdapter.NAME);
		provider.setUsage(EBufferUsage.STORAGE_BUFFER_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.COMPUTE_SHADER_BIT);
		provider.getAccessBeforeFetch().add(EAccess.SHADER_WRITE_BIT);
		provider.setUsedToFetch(true);
		provider.setInstanceCount(instanceCount);
		provider.setDescriptor(descriptor);

		providers.add(provider);

		return res;
	}
}
