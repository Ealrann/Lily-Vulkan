import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.api.model.VulkanExtraModelExtension;

module org.sheepy.lily.vulkan.extra.api
{
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.extra.model.graphic;
	exports org.sheepy.lily.vulkan.extra.model.graphic.impl;
	exports org.sheepy.lily.vulkan.extra.model.graphic.util;
	
	provides IModelExtension with VulkanExtraModelExtension;
}
