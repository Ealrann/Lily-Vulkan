package org.sheepy.lily.game.vulkan.pipeline;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.sheepy.lily.game.vulkan.buffer.IVertex;

public interface IVertexDescriptor<T extends IVertex>
{
	VkPipelineVertexInputStateCreateInfo allocInputStateCreateInfo();
	void freeInputStateCreateInfo();
	void free();
	
	int sizeOfVertex();
	ByteBuffer toBuffer(T[] vertices);
}
