module org.sheepy.lily.vulkan.base
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.core.base;
	
	requires org.sheepy.lily.vulkan.common;
	requires org.sheepy.lily.vulkan.process;
	requires org.sheepy.lily.vulkan.process.compute;
	requires org.sheepy.lily.vulkan.process.graphic;
	requires org.sheepy.lily.vulkan.resource;
}
