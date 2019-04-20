package org.sheepy.lily.vulkan.extra.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferDescriptor.Vertex;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;

public class EmptyVertexBufferDescriptor implements IVertexBufferDescriptor<Vertex>
{
	@Override
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

	public static VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescription = VkVertexInputBindingDescription.callocStack(1, stack);

		bindingDescription.binding(0);
		bindingDescription.stride(0);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	public static VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final var attributeDescriptions = VkVertexInputAttributeDescription.callocStack(1, stack);

		final var attributeDescriptionPosition = attributeDescriptions.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32_SFLOAT);
		attributeDescriptionPosition.offset(0);

		return attributeDescriptions;
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
