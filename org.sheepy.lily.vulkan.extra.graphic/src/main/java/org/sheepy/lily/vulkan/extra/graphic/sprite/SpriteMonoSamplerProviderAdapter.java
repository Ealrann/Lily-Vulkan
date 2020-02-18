package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.IResource;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.*;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.image.ImagePackage;

import java.util.ArrayList;
import java.util.List;

@Adapter(scope = SpriteMonoSamplerProvider.class)
public class SpriteMonoSamplerProviderAdapter implements IDescriptorProviderAdapter
{
	private static final List<EStructuralFeature> featureToCopy = List.copyOf(ImagePackage.Literals.SAMPLER_INFO.getEAllStructuralFeatures());

	@Override
	public ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, CompositeBuffer compositeBuffer)
	{
		return null;
	}

	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure)
	{
		final List<IResource> resources = new ArrayList<>();
		final List<IDescriptor> descriptors = new ArrayList<>();
		final var structureResourceAdapter = structure.adapt(SpriteStructureAdapter.class);
		final var images = structureResourceAdapter.getResources();

		// Resources
		final var spriteProvider = (SpriteMonoSamplerProvider) provider;
		final var samplerInfo = spriteProvider.getSamplerInfo();

		final var sampler = VulkanResourceFactory.eINSTANCE.createSampler();
		ModelUtil.copyFeatures(samplerInfo, sampler, featureToCopy);

		final var intialLayout = ImageFactory.eINSTANCE.createImageLayout();
		intialLayout.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		intialLayout.getAccessMask().add(EAccess.SHADER_READ_BIT);
		intialLayout.setStage(EPipelineStage.FRAGMENT_SHADER_BIT);

		resources.add(sampler);
		resources.addAll(images);

		// Descriptors
		final var samplerDescriptor = VulkanResourceFactory.eINSTANCE.createSamplerDescriptor();
		samplerDescriptor.setSampler(sampler);
		samplerDescriptor.setType(EDescriptorType.SAMPLER);
		samplerDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

		final var imageArrayDescriptor = VulkanResourceFactory.eINSTANCE.createImageArrayDescriptor();
		imageArrayDescriptor.setType(EDescriptorType.SAMPLED_IMAGE);
		imageArrayDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);
		imageArrayDescriptor.setInitialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		imageArrayDescriptor.getImages().addAll(images);

		descriptors.add(samplerDescriptor);
		descriptors.add(imageArrayDescriptor);

		return new ResourceDescriptor(resources, descriptors);
	}
}
