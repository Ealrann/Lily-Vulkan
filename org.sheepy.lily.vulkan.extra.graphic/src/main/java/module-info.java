import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.extra.graphic.Extenders;

module org.sheepy.lily.vulkan.extra.graphic {
	requires transitive org.sheepy.lily.vulkan.extra.api;
	requires org.sheepy.lily.vulkan.core;

	opens org.sheepy.lily.vulkan.extra.graphic.rendering;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.buffer;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.resource;
	opens org.sheepy.lily.vulkan.extra.graphic.sprite;

	provides IExtenderProvider with Extenders;
}
