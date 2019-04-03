package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;

public interface IVertexBufferDescriptor<T extends IVertex>
{
	VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack);

	void free();

	int sizeOfVertex();

	ByteBuffer toVertexBuffer(T[] vertices);
}
