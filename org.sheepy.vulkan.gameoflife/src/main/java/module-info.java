import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.vulkan.gameoflife.MainLoop;

module org.sheepy.vulkan.gameoflife
{
	requires org.sheepy.vulkan.api;
	requires org.sheepy.vulkan.resource;
	requires org.sheepy.vulkan.process.compute;
	requires org.sheepy.vulkan.process.graphic;

	requires org.joml;
	
	provides IMainLoop with MainLoop;
}
