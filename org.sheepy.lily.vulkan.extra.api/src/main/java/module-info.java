import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.api.model.VulkanExtraModelExtension;

module org.sheepy.lily.vulkan.extra.api
{
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.extra.graphic.model;
	exports org.sheepy.lily.vulkan.extra.graphic.model.impl;
	exports org.sheepy.lily.vulkan.extra.graphic.model.util;
	exports org.sheepy.lily.vulkan.extra.nuklear.model;
	exports org.sheepy.lily.vulkan.extra.nuklear.model.impl;
	exports org.sheepy.lily.vulkan.extra.nuklear.model.util;

	provides IModelExtension with VulkanExtraModelExtension;
}
