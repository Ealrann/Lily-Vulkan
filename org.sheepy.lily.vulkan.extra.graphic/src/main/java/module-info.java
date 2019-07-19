import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.extra.rendering.GenericRendererMaintainerAdapter;
import org.sheepy.lily.vulkan.extra.rendering.StaticResourceProviderAdapter;

@Adapters(classifiers = {
		GenericRendererMaintainerAdapter.class, StaticResourceProviderAdapter.class
})

module org.sheepy.lily.vulkan.extra.graphic
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires org.sheepy.lily.vulkan.process.graphic;

	opens org.sheepy.lily.vulkan.extra.rendering;
}
