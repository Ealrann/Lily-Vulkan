import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.extra.graphic.shape.Adapters;

module org.sheepy.lily.vulkan.extra.graphic.shape
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires org.lwjgl.par;
	requires org.lwjgl.par.natives;

	opens org.sheepy.lily.vulkan.extra.graphic.shape;

	provides IAdapterProvider with Adapters;
}
