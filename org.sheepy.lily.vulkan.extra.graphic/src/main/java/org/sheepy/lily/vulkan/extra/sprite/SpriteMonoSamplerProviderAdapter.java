package org.sheepy.lily.vulkan.extra.sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.vulkan.extra.api.rendering.IDescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.image.ImagePackage;

@Adapter(scope = SpriteMonoSamplerProvider.class)
public class SpriteMonoSamplerProviderAdapter implements IDescriptorProviderAdapter
{
	private static final List<EStructuralFeature> featureToCopy = List.copyOf(ImagePackage.Literals.SAMPLER_INFO.getEAllStructuralFeatures());

	@Override
	public ResourceDescriptor buildForPart(	ResourceDescriptorProvider provider,
											CompositeBuffer compositeBuffer)
	{
		return null;
	}

	@Override
	public ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider)
	{
		final List<IResource> resources = new ArrayList<>();
		final List<IDescriptor> descriptors = new ArrayList<>();

		// Resources
		final var spriteProvider = (SpriteMonoSamplerProvider) provider;
		final var srcResources = gatherResources(provider);
		final var samplerInfo = spriteProvider.getSamplerInfo();

		final var sampler = ResourceFactory.eINSTANCE.createSampler();
		ModelUtil.copyFeatures(samplerInfo, sampler, featureToCopy);

		final var intialLayout = ImageFactory.eINSTANCE.createImageLayout();
		intialLayout.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		intialLayout.getAccessMask().add(EAccess.SHADER_READ_BIT);
		intialLayout.setStage(EPipelineStage.FRAGMENT_SHADER_BIT);

		final var texture2DArray = ResourceFactory.eINSTANCE.createTexture2DArray();
		texture2DArray.getFiles().addAll(srcResources);
		texture2DArray.setInitialLayout(intialLayout);
		texture2DArray.getUsages().add(EImageUsage.SAMPLED);
		texture2DArray.getUsages().add(EImageUsage.TRANSFER_DST);

		resources.add(sampler);
		resources.add(texture2DArray);

		// Descriptors
		final var samplerDescriptor = ResourceFactory.eINSTANCE.createSamplerDescriptor();
		samplerDescriptor.setSampler(sampler);
		samplerDescriptor.setType(EDescriptorType.SAMPLER);
		samplerDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

		final var textureArrayDescriptor = ResourceFactory.eINSTANCE.createTexture2DArrayDescriptor();
		textureArrayDescriptor.setTextureArray(texture2DArray);
		textureArrayDescriptor.setType(EDescriptorType.SAMPLED_IMAGE);
		textureArrayDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

		descriptors.add(samplerDescriptor);
		descriptors.add(textureArrayDescriptor);

		return new ResourceDescriptor(resources, descriptors);
	}

	public static List<FileResource> gatherResources(ResourceDescriptorProvider provider)
	{
		final var renderer = ModelUtil.findParent(provider, SpriteRenderer.class);
		final var structures = renderer.getRenderedStructures().stream();
		final var sprites = structures.flatMap(s -> s.getSprites().stream());
		final var spriteFiles = sprites.map(s -> EcoreUtil.copy(s.getFile()));
		final var resources = spriteFiles.collect(Collectors.toList());
		return resources;
	}
}
