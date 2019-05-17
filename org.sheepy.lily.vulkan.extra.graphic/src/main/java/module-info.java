import org.sheepy.lily.core.api.adapter.annotation.Adapters;

@Adapters(classifiers = {
})

module org.sheepy.lily.vulkan.extra.graphic
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires org.sheepy.lily.vulkan.process.graphic;
}
