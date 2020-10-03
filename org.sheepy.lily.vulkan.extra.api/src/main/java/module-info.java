import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.api.model.VulkanExtraModelExtension;

module org.sheepy.lily.vulkan.extra.api
{
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.extra.api.mesh;
	exports org.sheepy.lily.vulkan.extra.api.mesh.data;
	exports org.sheepy.lily.vulkan.extra.api.nuklear;
	exports org.sheepy.lily.vulkan.extra.api.rendering;
	exports org.sheepy.lily.vulkan.extra.api.sprite;

	exports org.sheepy.lily.vulkan.extra.model.nuklear;
	exports org.sheepy.lily.vulkan.extra.model.nuklear.impl;
	exports org.sheepy.lily.vulkan.extra.model.nuklear.util;

	exports org.sheepy.lily.vulkan.extra.model.mesh;
	exports org.sheepy.lily.vulkan.extra.model.mesh.impl;
	exports org.sheepy.lily.vulkan.extra.model.mesh.util;

	exports org.sheepy.lily.vulkan.extra.model.rendering;
	exports org.sheepy.lily.vulkan.extra.model.rendering.impl;
	exports org.sheepy.lily.vulkan.extra.model.rendering.util;

	exports org.sheepy.lily.vulkan.extra.model.sprite;
	exports org.sheepy.lily.vulkan.extra.model.sprite.impl;
	exports org.sheepy.lily.vulkan.extra.model.sprite.util;

	provides IModelExtension with VulkanExtraModelExtension;
}
