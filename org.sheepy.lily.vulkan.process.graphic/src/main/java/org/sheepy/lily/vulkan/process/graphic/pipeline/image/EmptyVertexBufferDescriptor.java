package org.sheepy.lily.vulkan.process.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.lily.vulkan.resource.indexed.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBufferDescriptor.Vertex;

public class EmptyVertexBufferDescriptor implements IVertexBufferDescriptor<Vertex>
{
	private VkPipelineVertexInputStateCreateInfo vertexInputInfo;
	private VkVertexInputBindingDescription.Buffer allocBindingDescription;
	private VkVertexInputAttributeDescription.Buffer getgetAttributeDescriptions;

	@Override
	public VkPipelineVertexInputStateCreateInfo allocCreateInfo()
	{
		vertexInputInfo = VkPipelineVertexInputStateCreateInfo.calloc();
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		allocBindingDescription = allocBindingDescription();
		getgetAttributeDescriptions = allocAttributeDescriptions();

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription); // Optional
		vertexInputInfo.pVertexAttributeDescriptions(getgetAttributeDescriptions); // Optional

		return vertexInputInfo;
	}

	public static VkVertexInputBindingDescription.Buffer allocBindingDescription()
	{
		var bindingDescription = VkVertexInputBindingDescription.calloc(1);

		bindingDescription.binding(0);
		bindingDescription.stride(0);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	public static VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions()
	{
		var attributeDescriptions = VkVertexInputAttributeDescription.calloc(1);

		var attributeDescriptionPosition = attributeDescriptions.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32_SFLOAT);
		attributeDescriptionPosition.offset(0);

		return attributeDescriptions;
	}

	@Override
	public void freeInputStateCreateInfo()
	{
		vertexInputInfo.free();
		allocBindingDescription.free();
		getgetAttributeDescriptions.free();
		
		vertexInputInfo = null;
		allocBindingDescription = null;
		getgetAttributeDescriptions = null;
	}

	@Override
	public void free()
	{}

	@Override
	public int sizeOfVertex()
	{
		return 0;
	}

	@Override
	public ByteBuffer toVertexBuffer(Vertex[] vertices)
	{
		return null;
	}
}
