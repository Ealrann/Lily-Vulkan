import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.resource.Adapters;

module org.sheepy.lily.vulkan.resource
{
	requires transitive org.sheepy.lily.vulkan.core;

	requires transitive org.lwjgl.stb;
	requires org.lwjgl.stb.natives;

	exports org.sheepy.lily.vulkan.resource.semaphore;

	opens org.sheepy.lily.vulkan.resource.buffer;
	opens org.sheepy.lily.vulkan.resource.buffer.transfer;
	opens org.sheepy.lily.vulkan.resource.file;
	opens org.sheepy.lily.vulkan.resource.font;
	opens org.sheepy.lily.vulkan.resource.image;
	opens org.sheepy.lily.vulkan.resource.semaphore;
	opens org.sheepy.lily.vulkan.resource.shader;

	provides IAdapterProvider with Adapters;
}
