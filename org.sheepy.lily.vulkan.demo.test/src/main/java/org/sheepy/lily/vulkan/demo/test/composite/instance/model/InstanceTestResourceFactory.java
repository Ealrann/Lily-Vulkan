package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.demo.test.composite.instance.adapter.InstanceDataProviderAdapter;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.*;
import org.sheepy.vulkan.model.enumeration.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class InstanceTestResourceFactory
{
	public static ResourceContainer build(int partCount)
	{
		final var transferBuffer = buildTransferBuffer();
		final var compositeBuffer = buildCompositeBuffer(partCount);
		final var shader = VulkanResourceFactory.eINSTANCE.createShader();
		final var moduleResource = ResourceFactory.eINSTANCE.createModuleResource();
		moduleResource.setModule(InstanceTaskManager.class.getModule());
		moduleResource.setPath("increment.comp.spv");
		shader.setFile(moduleResource);
		shader.setStage(EShaderStage.COMPUTE_BIT);

		final var descriptors = compositeBuffer.getParts()
											   .stream()
											   .map(InstanceTestResourceFactory::newBufferDescriptor)
											   .collect(Collectors.toUnmodifiableList());

		return new ResourceContainer(transferBuffer, compositeBuffer, descriptors, shader);
	}

	private static BufferDescriptor newBufferDescriptor(final BufferPart bufferPart)
	{
		final var descriptor = VulkanResourceFactory.eINSTANCE.createBufferDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_BUFFER);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setBuffer(bufferPart);
		return descriptor;
	}

	public static final class ResourceContainer
	{
		public final TransferBuffer transferBuffer;
		public final CompositeBuffer compositeBuffer;
		public final List<IDescriptor> descriptors;
		public final List<DescriptorSet> dSets;
		public final Shader shader;

		public ResourceContainer(TransferBuffer transferBuffer,
								 CompositeBuffer compositeBuffer,
								 List<? extends IDescriptor> descriptors,
								 Shader shader)
		{
			this.transferBuffer = transferBuffer;
			this.compositeBuffer = compositeBuffer;
			this.descriptors = List.copyOf(descriptors);
			this.shader = shader;

			this.dSets = List.copyOf(buildDescriptorSets(descriptors));
		}

		private static List<DescriptorSet> buildDescriptorSets(final List<? extends IDescriptor> descriptors)
		{
			final List<DescriptorSet> dSets = new ArrayList<>();
			final int size = descriptors.size();
			for (int i = 0; i < size; i++)
			{
				final var i2 = (i + 1) % size;

				final var descriptor1 = descriptors.get(i);
				final var descriptor2 = descriptors.get(i2);

				final var dSet = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
				dSet.getDescriptors().add(descriptor1);
				dSet.getDescriptors().add(descriptor2);
				dSets.add(dSet);
			}
			return dSets;
		}
	}

	private static TransferBuffer buildTransferBuffer()
	{
		final var res = VulkanResourceFactory.eINSTANCE.createTransferBuffer();
		res.setSize(InstanceDataProviderAdapter.SIZE);
		res.setUsedToFetch(true);
		return res;
	}

	private static CompositeBuffer buildCompositeBuffer(int partCount)
	{
		final var res = VulkanResourceFactory.eINSTANCE.createCompositeBuffer();

		final var provider = VulkanResourceFactory.eINSTANCE.createBufferDataProvider();
		provider.setName(InstanceDataProviderAdapter.NAME);
		provider.getUsages().add(EBufferUsage.STORAGE_BUFFER_BIT);
		provider.setStageBeforePush(EPipelineStage.TRANSFER_BIT);
		provider.setStageBeforeFetch(EPipelineStage.COMPUTE_SHADER_BIT);
		provider.getAccessBeforeFetch().add(EAccess.SHADER_WRITE_BIT);
		provider.setUsedToFetch(true);

		final var parts = res.getParts();
		for (int i = 0; i < partCount; i++)
		{
			final var bufferPart = VulkanResourceFactory.eINSTANCE.createBufferPart();
			bufferPart.setDataProvider(EcoreUtil.copy(provider));
			parts.add(bufferPart);
		}

		return res;
	}
}
