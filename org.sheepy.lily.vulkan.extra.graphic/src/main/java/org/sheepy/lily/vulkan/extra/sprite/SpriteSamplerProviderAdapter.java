package org.sheepy.lily.vulkan.extra.sprite;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.image.ImagePackage;

@Adapter(scope = SpriteMonoSamplerProvider.class)
public class SpriteSamplerProviderAdapter implements IResourceProviderAdapter
{
	private final List<EStructuralFeature> featureToCopy = List
			.copyOf(ImagePackage.Literals.SAMPLER_INFO.getEAllStructuralFeatures());

	@Override
	public List<DescriptedResource> getResources(ResourceProvider provider)
	{
		final var spriteProvider = (SpriteMonoSamplerProvider) provider;
		final var renderer = ModelUtil.findParent(provider, SpriteRenderer.class);
		final var spritePkg = renderer.getPresentationPkg();
		final var sprites = spritePkg.getPresentations();
		final var samplerInfo = spriteProvider.getSamplerInfo();

		final var sampler = ResourceFactory.eINSTANCE.createSampler();
		ModelUtil.copyFeatures(samplerInfo, sampler, featureToCopy);

		final var texture2DArray = ResourceFactory.eINSTANCE.createTexture2DArray();
		texture2DArray.setWidth(spriteProvider.getWidth());
		texture2DArray.setHeight(spriteProvider.getHeight());

		for (final var sprite : sprites)
		{
			texture2DArray.getFiles().add(EcoreUtil.copy(sprite.getFile()));
		}

		return List.of(sampler, texture2DArray);
	}
}
