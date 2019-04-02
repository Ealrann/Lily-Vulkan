import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.demo.adapter.UniformBufferAdapter;
import org.sheepy.lily.vulkan.demo.mesh.MeshPipelineAdapter;

@Adapters(classifiers = {
		MeshPipelineAdapter.class, UniformBufferAdapter.class
})

module org.sheepy.lily.vulkan.demo.texture
{
	requires transitive org.sheepy.lily.vulkan.process.graphic;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.mesh;

	opens org.sheepy.lily.vulkan.demo.adapter;
}
