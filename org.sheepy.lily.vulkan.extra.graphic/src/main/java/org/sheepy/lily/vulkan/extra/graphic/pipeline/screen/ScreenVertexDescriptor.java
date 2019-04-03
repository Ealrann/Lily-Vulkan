package org.sheepy.lily.vulkan.extra.graphic.pipeline.screen;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.joml.Vector2f;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.lily.vulkan.api.resource.IVertex;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.extra.graphic.pipeline.screen.ScreenVertexDescriptor.ScreenVertex;

public class ScreenVertexDescriptor implements IVertexBufferDescriptor<ScreenVertex>
{
	public static final int SIZE_OF = 2 * 4;
	public static final int POSITION_OFFSET = 0 * 4;

	@Override
	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		final var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack);
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		final var allocBindingDescription = allocBindingDescription(stack);
		final var attributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription);
		vertexInputInfo.pVertexAttributeDescriptions(attributeDescriptions);

		return vertexInputInfo;
	}

	private static VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescription = VkVertexInputBindingDescription.mallocStack(1, stack);

		bindingDescription.binding(0);
		bindingDescription.stride(SIZE_OF);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	private static VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final var attributeDescriptions = VkVertexInputAttributeDescription.mallocStack(1, stack);

		final var attributeDescriptionPosition = attributeDescriptions.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32_SFLOAT);
		attributeDescriptionPosition.offset(POSITION_OFFSET);
		return attributeDescriptions;
	}

	@Override
	public void free()
	{}

	@Override
	public int sizeOfVertex()
	{
		return SIZE_OF;
	}

	@Override
	public ByteBuffer toVertexBuffer(ScreenVertex[] vertices)
	{
		final ByteBuffer res = MemoryUtil.memAlloc(SIZE_OF * vertices.length);

		for (final ScreenVertex vertex : vertices)
		{
			res.putFloat(vertex.position.x);
			res.putFloat(vertex.position.y);
		}
		res.flip();

		return res;
	}

	public static class ScreenVertex implements IVertex
	{
		public final Vector2f position;

		public ScreenVertex(Vector2f position)
		{
			this.position = position;
		}
	}
}
