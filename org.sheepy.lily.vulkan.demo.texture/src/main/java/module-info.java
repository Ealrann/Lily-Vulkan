import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;

@Adapters(classifiers = {
		CameraConstantAdapter.class
})

module org.sheepy.lily.vulkan.demo.texture
{
	requires transitive org.sheepy.lily.vulkan.base;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.mesh;

	opens org.sheepy.lily.vulkan.demo.adapter;
	opens org.sheepy.lily.vulkan.demo.texture;
	opens org.sheepy.lily.vulkan.demo.triangle;
}
