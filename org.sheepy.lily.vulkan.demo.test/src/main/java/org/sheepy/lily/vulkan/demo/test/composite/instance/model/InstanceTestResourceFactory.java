package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.ApplicationFactory;
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
	public static ResourceContainer build(int partCount)
	{
		final var transferBuffer = buildTransferBuffer();
		final var compositeBuffer = buildCompositeBuffer(partCount);
		final var shader = ResourceFactory.eINSTANCE.createShader();
		final var moduleResource = ApplicationFactory.eINSTANCE.createModuleResource();
		moduleResource.setModule(InstanceTaskManager.class.getModule());
		moduleResource.setPath("increment.comp.spv");
		shader.setFile(moduleResource);
		shader.setStage(EShaderStage.COMPUTE_BIT);

		final var ds = ResourceFactory.eINSTANCE.createDescriptorSet();

		for (int i = 0; i < 2; i++)
		{
			final var descriptor = ResourceFactory.eINSTANCE.createBufferDescriptor();
			descriptor.setType(EDescriptorType.STORAGE_BUFFER);
			descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
			descriptor.setBuffer(compositeBuffer.getParts().get(i));

			ds.getDescriptors().add(descriptor);
		}

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
		res.setUsedToFetch(true);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(int partCount)
	{
		final var res = ResourceFactory.eINSTANCE.createCompositeBuffer();

		final var provider = ResourceFactory.eINSTANCE.createBufferDataProvider();
		provider.setName(InstanceDataProviderAdapter.NAME);
		provider.getUsages().add(EBufferUsage.STORAGE_BUFFER_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.COMPUTE_SHADER_BIT);
		provider.getAccessBeforeFetch().add(EAccess.SHADER_WRITE_BIT);
		provider.setUsedToFetch(true);

		final var parts = res.getParts();
		for (int i = 0; i < partCount; i++)
		{
			final var bufferPart = ResourceFactory.eINSTANCE.createBufferPart();
			bufferPart.setDataProvider(EcoreUtil.copy(provider));

			parts.add(bufferPart);
		}

		return res;
	}
}
