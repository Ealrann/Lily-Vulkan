import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.extra.graphic.Extenders;

module org.sheepy.lily.vulkan.extra.graphic {
	requires transitive org.sheepy.lily.vulkan.extra.api;
	requires org.sheepy.lily.vulkan.core;

	opens org.sheepy.lily.vulkan.extra.graphic.rendering;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.buffer;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.camera;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.resource;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick;
	opens org.sheepy.lily.vulkan.extra.graphic.sprite;

	provides IAdapterProvider with Extenders;
}
