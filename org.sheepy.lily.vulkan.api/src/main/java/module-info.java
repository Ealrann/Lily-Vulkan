import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.api.model.VulkanModelExtension;

module org.sheepy.lily.vulkan.api
{
	requires transitive org.sheepy.vulkan;
	requires transitive org.sheepy.lily.core.api;
	requires transitive org.lwjgl;

	exports org.sheepy.lily.vulkan.api.concurrent;
	exports org.sheepy.lily.vulkan.api.device;
	exports org.sheepy.lily.vulkan.api.engine;
	exports org.sheepy.lily.vulkan.api.execution;
	exports org.sheepy.lily.vulkan.api.input;
	exports org.sheepy.lily.vulkan.api.pipeline;
	exports org.sheepy.lily.vulkan.api.process;
	exports org.sheepy.lily.vulkan.api.resource.buffer;
	exports org.sheepy.lily.vulkan.api.util;
	exports org.sheepy.lily.vulkan.api.view;
	exports org.sheepy.lily.vulkan.api.window;

	exports org.sheepy.lily.vulkan.model;
	exports org.sheepy.lily.vulkan.model.impl;
	exports org.sheepy.lily.vulkan.model.util;
	exports org.sheepy.lily.vulkan.model.binding;
	exports org.sheepy.lily.vulkan.model.binding.impl;
	exports org.sheepy.lily.vulkan.model.binding.util;
	exports org.sheepy.lily.vulkan.model.process;
	exports org.sheepy.lily.vulkan.model.process.impl;
	exports org.sheepy.lily.vulkan.model.process.util;
	exports org.sheepy.lily.vulkan.model.process.compute;
	exports org.sheepy.lily.vulkan.model.process.compute.impl;
	exports org.sheepy.lily.vulkan.model.process.compute.util;
	exports org.sheepy.lily.vulkan.model.process.graphic;
	exports org.sheepy.lily.vulkan.model.process.graphic.impl;
	exports org.sheepy.lily.vulkan.model.process.graphic.util;
	exports org.sheepy.lily.vulkan.model.resource;
	exports org.sheepy.lily.vulkan.model.resource.impl;
	exports org.sheepy.lily.vulkan.model.resource.util;

	provides IModelExtension with VulkanModelExtension;
}
