import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.demo.rotating.RotatingEngineProvider;
import org.sheepy.lily.vulkan.demo.texture.TextureEngineProvider;
import org.sheepy.lily.vulkan.demo.triangle.TriangleEngineProvider;

@Adapters(classifiers = {
		CameraConstantAdapter.class,
		TriangleEngineProvider.class,
		RotatingEngineProvider.class,
		TextureEngineProvider.class
})

module org.sheepy.lily.vulkan.demo.texture
{
	requires transitive org.sheepy.lily.vulkan.base;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.mesh;

	opens org.sheepy.lily.vulkan.demo.adapter;
	opens org.sheepy.lily.vulkan.demo.texture;
	opens org.sheepy.lily.vulkan.demo.rotating;
	opens org.sheepy.lily.vulkan.demo.triangle;
}
