module org.sheepy.vulkan
{
	requires transitive org.sheepy.lily.core.api;

	exports org.sheepy.vulkan.model.barrier;
	exports org.sheepy.vulkan.model.enumeration;
	exports org.sheepy.vulkan.model.graphicpipeline;
	exports org.sheepy.vulkan.model.image;
	exports org.sheepy.vulkan.model.pipeline;

	provides org.sheepy.lily.core.api.resource.IModelExtension with org.sheepy.vulkan.VulkanModelExtension;
}
