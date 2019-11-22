import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.extra.rendering.CompositeResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.rendering.GenericRendererMaintainerAdapter;
import org.sheepy.lily.vulkan.extra.rendering.StaticResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.rendering.buffer.RenderProxyConstantBufferAdapter;
import org.sheepy.lily.vulkan.extra.rendering.task.RenderDrawTaskAdapter;
import org.sheepy.lily.vulkan.extra.rendering.task.RenderIndexedDrawTaskAdapter;
import org.sheepy.lily.vulkan.extra.sprite.SpriteCountSpecializationAdapter;
import org.sheepy.lily.vulkan.extra.sprite.SpriteMonoSamplerProviderAdapter;

@Adapters(classifiers = {
		GenericRendererMaintainerAdapter.class,
		StaticResourceProviderAdapter.class,
		CompositeResourceProviderAdapter.class,
		SpriteMonoSamplerProviderAdapter.class,
		RenderProxyConstantBufferAdapter.class,
		SpriteCountSpecializationAdapter.class,
		RenderDrawTaskAdapter.class,
		RenderIndexedDrawTaskAdapter.class
})

module org.sheepy.lily.vulkan.extra.graphic
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	opens org.sheepy.lily.vulkan.extra.rendering;
	opens org.sheepy.lily.vulkan.extra.rendering.buffer;
	opens org.sheepy.lily.vulkan.extra.rendering.task;
	opens org.sheepy.lily.vulkan.extra.sprite;
}
