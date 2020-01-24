module org.sheepy.vulkan
{
	requires transitive org.sheepy.lily.core.api;

	exports org.sheepy.vulkan.model.barrier;
	exports org.sheepy.vulkan.model.barrier.impl;
	exports org.sheepy.vulkan.model.barrier.util;
	exports org.sheepy.vulkan.model.enumeration;
	exports org.sheepy.vulkan.model.enumeration.impl;
	exports org.sheepy.vulkan.model.enumeration.util;
	exports org.sheepy.vulkan.model.graphicpipeline;
	exports org.sheepy.vulkan.model.graphicpipeline.impl;
	exports org.sheepy.vulkan.model.graphicpipeline.util;
	exports org.sheepy.vulkan.model.image;
	exports org.sheepy.vulkan.model.image.impl;
	exports org.sheepy.vulkan.model.image.util;
	exports org.sheepy.vulkan.model.pipeline;
	exports org.sheepy.vulkan.model.pipeline.impl;
	exports org.sheepy.vulkan.model.pipeline.util;
}
