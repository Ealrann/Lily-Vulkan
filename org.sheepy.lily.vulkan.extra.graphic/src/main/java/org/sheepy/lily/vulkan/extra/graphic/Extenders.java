package org.sheepy.lily.vulkan.extra.graphic;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.extra.graphic.rendering.GenericRendererMaintainerAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.buffer.RenderProxyConstantBufferAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DataDescriptorsProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.task.RenderDrawTaskAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.task.RenderIndexedDrawTaskAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteCountSpecializationAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteMonoSamplerProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.SpriteStructureAdapter;

import java.util.List;

public final class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(GenericRendererMaintainerAdapter.class,
					   DescriptorProviderAdapter.class,
					   SpriteMonoSamplerProviderAdapter.class,
					   RenderProxyConstantBufferAdapter.class,
					   SpriteCountSpecializationAdapter.class,
					   RenderDrawTaskAdapter.class,
					   RenderIndexedDrawTaskAdapter.class,
					   DataDescriptorsProviderAdapter.class,
					   SpriteStructureAdapter.class);
	}
}
