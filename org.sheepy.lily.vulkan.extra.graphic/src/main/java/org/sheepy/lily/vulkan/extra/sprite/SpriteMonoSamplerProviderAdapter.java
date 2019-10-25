package org.sheepy.lily.vulkan.extra.sprite;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.image.ImagePackage;

@Adapter(scope = SpriteMonoSamplerProvider.class)
public class SpriteMonoSamplerProviderAdapter implements IResourceProviderAdapter
{
	private static final List<EStructuralFeature> featureToCopy = List.copyOf(ImagePackage.Literals.SAMPLER_INFO.getEAllStructuralFeatures());

	@Override
	public List<DescriptedResource> getResources(ResourceProvider provider)
	{
		final var spriteProvider = (SpriteMonoSamplerProvider) provider;
		final var resources = gatherResources(provider);
		final var samplerInfo = spriteProvider.getSamplerInfo();

		final var descriptorSampler = ResourceFactory.eINSTANCE.createDescriptor();
		descriptorSampler.setDescriptorType(EDescriptorType.SAMPLER);
		descriptorSampler.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

		final var sampler = ResourceFactory.eINSTANCE.createSampler();
		ModelUtil.copyFeatures(samplerInfo, sampler, featureToCopy);
		sampler.setDescriptor(descriptorSampler);

		final var descriptorTexture = ResourceFactory.eINSTANCE.createDescriptor();
		descriptorTexture.setDescriptorType(EDescriptorType.SAMPLED_IMAGE);
		descriptorTexture.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

		final var intialLayout = ImageFactory.eINSTANCE.createImageLayout();
		intialLayout.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		intialLayout.getAccessMask().add(EAccess.SHADER_READ_BIT);
		intialLayout.setStage(EPipelineStage.FRAGMENT_SHADER_BIT);

		final var texture2DArray = ResourceFactory.eINSTANCE.createTexture2DArray();
		texture2DArray.getFiles().addAll(resources);
		texture2DArray.setDescriptor(descriptorTexture);
		texture2DArray.setInitialLayout(intialLayout);

		final List<DescriptedResource> res = List.of(sampler, texture2DArray);
		spriteProvider.getTargetResourcePkg().getResources().addAll(res);
		return res;
	}

	public List<PathResource> gatherResources(ResourceProvider provider)
	{
		final var renderer = ModelUtil.findParent(provider, SpriteRenderer.class);
		final var structures = renderer.getRenderedStructures().stream();
		final var sprites = structures.flatMap(s -> s.getSprites().stream());
		final var spriteFiles = sprites.map(s -> EcoreUtil.copy(s.getFile()));
		final var resources = spriteFiles.collect(Collectors.toList());
		return resources;
	}
}
