import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.common.cadence.RunProcessAdapter;
import org.sheepy.lily.vulkan.common.cadence.WaitProcessIdleAdapter;
import org.sheepy.lily.vulkan.common.engine.VulkanEngineAdapter;

@Adapters(classifiers = {
		VulkanEngineAdapter.class, WaitProcessIdleAdapter.class, RunProcessAdapter.class
})

module org.sheepy.lily.vulkan.common
{
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;
	requires transitive org.lwjgl.stb;

	exports org.sheepy.lily.vulkan.common.allocation;
	exports org.sheepy.lily.vulkan.common.barrier;
	exports org.sheepy.lily.vulkan.common.execution;
	exports org.sheepy.lily.vulkan.common.graphic;
	exports org.sheepy.lily.vulkan.common.pipeline;
	exports org.sheepy.lily.vulkan.common.process;
	exports org.sheepy.lily.vulkan.common.resource;
	exports org.sheepy.lily.vulkan.common.resource.attachment;
	exports org.sheepy.lily.vulkan.common.resource.buffer;
	exports org.sheepy.lily.vulkan.common.resource.font;
	exports org.sheepy.lily.vulkan.common.util;

	opens org.sheepy.lily.vulkan.common.cadence;
	opens org.sheepy.lily.vulkan.common.engine;
}
