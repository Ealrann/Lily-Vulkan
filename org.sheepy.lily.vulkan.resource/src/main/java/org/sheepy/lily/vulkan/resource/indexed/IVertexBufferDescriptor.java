package org.sheepy.vulkan.resource.indexed;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;

public interface IVertexBufferDescriptor<T extends IVertex>
{
	VkPipelineVertexInputStateCreateInfo allocCreateInfo();
	void freeInputStateCreateInfo();
	void free();
	
	int sizeOfVertex();
	ByteBuffer toVertexBuffer(T[] vertices);
}
