import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.extra.graphic.pipeline.image.ImagePipelineAdapter;
import org.sheepy.lily.vulkan.extra.graphic.pipeline.screen.ScreenRendererAdapter;
import org.sheepy.lily.vulkan.extra.graphic.pipeline.terrain.TerrainRendererAdapter;

@Adapters(classifiers = {
		ImagePipelineAdapter.class, ScreenRendererAdapter.class, TerrainRendererAdapter.class
})

module org.sheepy.lily.vulkan.extra.graphic
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires org.sheepy.lily.vulkan.process.graphic;

	opens org.sheepy.lily.vulkan.extra.graphic.pipeline.image;
	opens org.sheepy.lily.vulkan.extra.graphic.pipeline.screen;
	opens org.sheepy.lily.vulkan.extra.graphic.pipeline.terrain;
}
