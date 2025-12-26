module org.sheepy.lily.vulkan.extra.api
{
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.extra.api.mesh;
	exports org.sheepy.lily.vulkan.extra.api.mesh.data;
	exports org.sheepy.lily.vulkan.extra.api.nuklear;
	exports org.sheepy.lily.vulkan.extra.api.rendering;
	exports org.sheepy.lily.vulkan.extra.api.sprite;

	exports org.sheepy.lily.vulkan.extra.model.mesh;
	exports org.sheepy.lily.vulkan.extra.model.nuklear;
	exports org.sheepy.lily.vulkan.extra.model.rendering;
	exports org.sheepy.lily.vulkan.extra.model.shape;
	exports org.sheepy.lily.vulkan.extra.model.sprite;

	provides org.sheepy.lily.core.api.resource.IModelExtension with org.sheepy.lily.vulkan.extra.api.model.VulkanExtraModelExtension;
}
