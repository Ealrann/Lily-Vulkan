package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.FeatureCopier;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.*;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.image.ImagePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = SpriteMonoSamplerProvider.class)
@Adapter(singleton = true)
public class SpriteMonoSamplerProviderAdapter implements IDescriptorProviderAdapter
{
	private static final List<EStructuralFeature> featureToCopy = List.copyOf(ImagePackage.Literals.SAMPLER_INFO.getEAllStructuralFeatures());

	@Override
	public ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, Stream<BufferViewer> bufferViewers)
	{
		return null;
	}

	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure)
	{
		final List<IVulkanResource> resources = new ArrayList<>();
		final List<IDescriptor> descriptors = new ArrayList<>();
		final var structureResourceAdapter = structure.adapt(SpriteStructureAdapter.class);
		final var images = structureResourceAdapter.getImages();

		// Resources
		final var spriteProvider = (SpriteMonoSamplerProvider) provider;
		final var samplerInfo = spriteProvider.getSamplerInfo();

		final var sampler = VulkanResourceFactory.eINSTANCE.createSampler();
		final var featureCopier = new FeatureCopier(false);
		featureCopier.copyFeatures(samplerInfo, sampler, featureToCopy);

		final var intialLayout = ImageFactory.eINSTANCE.createImageLayout();
		intialLayout.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		intialLayout.getAccessMask().add(EAccess.SHADER_READ_BIT);
		intialLayout.setStage(EPipelineStage.FRAGMENT_SHADER_BIT);

		resources.add(sampler);
		resources.addAll(structureResourceAdapter.getResources());

		// Descriptors
		final var samplerDescriptor = VulkanResourceFactory.eINSTANCE.createImageDescriptor();
		samplerDescriptor.setSampler(sampler);
		samplerDescriptor.setType(EDescriptorType.SAMPLER);
		samplerDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

		final var imageArrayDescriptor = VulkanResourceFactory.eINSTANCE.createImageDescriptor();
		imageArrayDescriptor.setType(EDescriptorType.SAMPLED_IMAGE);
		imageArrayDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);
		imageArrayDescriptor.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		imageArrayDescriptor.getImages().addAll(images);

		descriptors.add(samplerDescriptor);
		descriptors.add(imageArrayDescriptor);

		return new ResourceDescriptor(resources, descriptors);
	}
}
