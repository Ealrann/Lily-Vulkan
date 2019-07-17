import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.api.model.VulkanExtraModelExtension;

module org.sheepy.lily.vulkan.extra.api
{
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.extra.api.mesh;
	exports org.sheepy.lily.vulkan.extra.api.mesh.data;

	exports org.sheepy.lily.vulkan.extra.model.nuklear;
	exports org.sheepy.lily.vulkan.extra.model.nuklear.impl;
	exports org.sheepy.lily.vulkan.extra.model.nuklear.util;

	provides IModelExtension with VulkanExtraModelExtension;
}
