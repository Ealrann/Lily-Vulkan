package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;

public class VkVertexDescriptor
{
	private final int strideLength;
	private final List<VkAttributeDescription> attributes;

	public VkVertexDescriptor(int strideLength, List<VkAttributeDescription> attributes)
	{
		this.strideLength = strideLength;
		this.attributes = List.copyOf(attributes);
	}

	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		final var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack);
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		final var allocBindingDescription = allocBindingDescription(stack);
		final var getgetAttributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription); // Optional
		vertexInputInfo.pVertexAttributeDescriptions(getgetAttributeDescriptions); // Optional

		return vertexInputInfo;
	}

	public VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescription = VkVertexInputBindingDescription.callocStack(1, stack);

		bindingDescription.binding(0);
		bindingDescription.stride(strideLength);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	public VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final int size = attributes.size();
		final var attributeDescriptions = VkVertexInputAttributeDescription.callocStack(size,
				stack);

		for (int i = 0; i < size; i++)
		{
			final var attribute = attributes.get(i);
			final int offset = attribute.offset;
			final int format = attribute.format;

			final var attributeDescriptionPosition = attributeDescriptions.get();
			attributeDescriptionPosition.binding(0);
			attributeDescriptionPosition.location(i);
			attributeDescriptionPosition.format(format);
			attributeDescriptionPosition.offset(offset);
		}
		attributeDescriptions.flip();

		return attributeDescriptions;
	}

	public int sizeOfVertex()
	{
		return strideLength;
	}

	public static class VkAttributeDescription
	{
		public final int format;
		public final int offset;

		public VkAttributeDescription(int format, int offset)
		{
			this.format = format;
			this.offset = offset;
		}
	}
}
