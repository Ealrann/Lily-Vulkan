package org.sheepy.lily.vulkan.extra.graphic;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.extra.graphic.rendering.GenericRendererMaintainerAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.RenderPipelineAllocator;
import org.sheepy.lily.vulkan.extra.graphic.rendering.buffer.RenderProxyConstantBufferAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DataDescriptorsProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public final class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(GenericRendererMaintainerAdapter.class,
					   DescriptorProviderAdapter.class,
					   RenderProxyConstantBufferAdapter.class,
					   DataDescriptorsProviderAdapter.class,
					   RenderPipelineAllocator.class,
					   SpriteIndexConfigurator.class,
					   SpriteSpecializationFiller.class,
					   SpriteResourceInstaller.class,
					   SpriteDataSourceConfigurator.class,
					   SpritePipelineActivator.class,
					   SpriteIndexSupplier.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
