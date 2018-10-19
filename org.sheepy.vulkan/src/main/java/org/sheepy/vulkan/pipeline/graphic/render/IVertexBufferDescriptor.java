package org.sheepy.vulkan.pipeline.graphic.render;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.sheepy.vulkan.resource.indexed.IVertex;

public interface IVertexBufferDescriptor<T extends IVertex>
{
	VkPipelineVertexInputStateCreateInfo allocCreateInfo();
	void freeInputStateCreateInfo();
	void free();
	
	int sizeOfVertex();
	ByteBuffer toVertexBuffer(T[] vertices);
}
