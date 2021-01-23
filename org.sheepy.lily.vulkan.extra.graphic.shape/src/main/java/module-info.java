import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.extra.graphic.shape.Extenders;

module org.sheepy.lily.vulkan.extra.graphic.shape {
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires org.lwjgl.par;
	requires org.lwjgl.par.natives;

	opens org.sheepy.lily.vulkan.extra.graphic.shape.adapter;

	provides IAdapterProvider with Extenders;
}
