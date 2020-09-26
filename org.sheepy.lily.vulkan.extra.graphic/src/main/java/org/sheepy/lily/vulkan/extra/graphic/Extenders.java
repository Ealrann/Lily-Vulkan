package org.sheepy.lily.vulkan.extra.graphic;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.extra.graphic.rendering.GenericRendererMaintainerAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.RenderPipelineAllocator;
import org.sheepy.lily.vulkan.extra.graphic.rendering.buffer.RenderProxyConstantBufferAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DataDescriptorsProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteCountSpecializationAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteMonoSamplerProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteRendererDeactivator;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteStructureAdapter;

import java.lang.invoke.MethodHandles;
import java.util.List;

public final class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(SpriteRendererDeactivator.class,
					   GenericRendererMaintainerAdapter.class,
					   DescriptorProviderAdapter.class,
					   RenderProxyConstantBufferAdapter.class,
					   SpriteCountSpecializationAdapter.class,
					   SpriteStructureAdapter.class,
					   SpriteMonoSamplerProviderAdapter.class,
					   DataDescriptorsProviderAdapter.class,
					   RenderPipelineAllocator.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
