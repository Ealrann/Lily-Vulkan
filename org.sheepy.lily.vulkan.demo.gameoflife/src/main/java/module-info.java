import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.demo.gameoflife.view.GameOfLifeEngineProvider;

@Adapters(classifiers = {
		GameOfLifeEngineProvider.class
})

module org.sheepy.lily.vulkan.demo.gameoflife
{
	requires org.sheepy.lily.vulkan.base;

	requires org.joml;
	
	opens org.sheepy.lily.vulkan.demo.gameoflife.view;
}
