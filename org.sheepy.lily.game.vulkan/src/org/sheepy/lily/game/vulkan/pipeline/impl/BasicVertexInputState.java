package org.sheepy.lily.game.vulkan.pipeline.impl;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO;

import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.lily.game.vulkan.pipeline.IVertexInputState;
import org.sheepy.lily.game.vulkan.vertex.Vertex;

public class BasicVertexInputState implements IVertexInputState
{
	private VkPipelineVertexInputStateCreateInfo vertexInputInfo;
	private VkVertexInputBindingDescription.Buffer allocBindingDescription;
	private VkVertexInputAttributeDescription.Buffer getgetAttributeDescriptions;

	@Override
	public VkPipelineVertexInputStateCreateInfo allocInputStateCreateInfo()
	{
		vertexInputInfo = VkPipelineVertexInputStateCreateInfo.calloc();
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		allocBindingDescription = Vertex.allocBindingDescription();
		getgetAttributeDescriptions = Vertex.getgetAttributeDescriptions();

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription); // Optional
		vertexInputInfo.pVertexAttributeDescriptions(getgetAttributeDescriptions); // Optional

		return vertexInputInfo;
	}

	@Override
	public void freeInputStateCreateInfo()
	{
		vertexInputInfo.free();
		allocBindingDescription.free();
		getgetAttributeDescriptions.free();
	}

	@Override
	public void free()
	{}

}
