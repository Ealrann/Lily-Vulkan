import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.extra.graphic.shape.IcoSphereAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.IcosahedronAdapter;
import org.sheepy.lily.vulkan.extra.graphic.shape.SphereAdapter;

@Adapters(classifiers = {
		IcosahedronAdapter.class,
		IcoSphereAdapter.class,
		SphereAdapter.class
})

module org.sheepy.lily.vulkan.extra.graphic.shape
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires org.lwjgl.par;
	requires org.lwjgl.par.natives;

	opens org.sheepy.lily.vulkan.extra.graphic.shape;
}
