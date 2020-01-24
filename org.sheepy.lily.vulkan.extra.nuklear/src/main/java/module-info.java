import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.nuklear.Adapters;

module org.sheepy.lily.vulkan.extra.nuklear
{
	requires transitive org.sheepy.lily.vulkan.extra.api;
	requires org.sheepy.lily.vulkan.common;

	requires transitive org.lwjgl.stb;
	requires transitive org.lwjgl.nuklear;
	requires org.lwjgl.stb.natives;
	requires org.lwjgl.nuklear.natives;

	exports org.sheepy.lily.vulkan.nuklear.ui;

	opens org.sheepy.lily.vulkan.nuklear.dataprovider;
	opens org.sheepy.lily.vulkan.nuklear.pipeline;
	opens org.sheepy.lily.vulkan.nuklear.resource;
	opens org.sheepy.lily.vulkan.nuklear.scene;
	opens org.sheepy.lily.vulkan.nuklear.ui;

	provides IAdapterProvider with Adapters;
}
