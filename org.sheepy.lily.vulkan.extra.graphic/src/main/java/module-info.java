import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.extra.graphic.Adapters;

module org.sheepy.lily.vulkan.extra.graphic
{
	requires transitive org.sheepy.lily.vulkan.extra.api;
	requires org.sheepy.lily.vulkan.common;

	opens org.sheepy.lily.vulkan.extra.graphic.rendering;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.buffer;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.resource;
	opens org.sheepy.lily.vulkan.extra.graphic.rendering.task;
	opens org.sheepy.lily.vulkan.extra.graphic.sprite;

	provides IAdapterProvider with Adapters;
}
