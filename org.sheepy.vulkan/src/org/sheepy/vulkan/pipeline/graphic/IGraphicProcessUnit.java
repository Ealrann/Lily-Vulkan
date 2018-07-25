package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.vulkan.descriptor.DescriptorPool;

public interface IGraphicProcessUnit
{
	void bindContext(DescriptorPool descriptorPool, GraphicContext context);
}
