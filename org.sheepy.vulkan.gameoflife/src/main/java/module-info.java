import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.vulkan.gameoflife.compute.BoardBufferAdapter;
import org.sheepy.vulkan.gameoflife.compute.BoardImageAdapter;

/**
 *
 */
module org.sheepy.vulkan.gameoflife {

	requires org.sheepy.vulkan.api;
	requires org.sheepy.vulkan.resource;
	requires org.sheepy.vulkan.process.compute;
	requires org.sheepy.vulkan.process.graphic;
	
	requires org.joml;
	
	provides ISingletonAdapter with BoardBufferAdapter, BoardImageAdapter;
}
