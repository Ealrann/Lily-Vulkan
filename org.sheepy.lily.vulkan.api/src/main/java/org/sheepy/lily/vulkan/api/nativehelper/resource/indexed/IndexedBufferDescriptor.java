package org.sheepy.lily.vulkan.api.nativehelper.resource.indexed;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBufferDescriptor.Vertex;
import org.sheepy.lily.vulkan.api.resource.IVertex;

public class IndexedBufferDescriptor extends AbstractIntegerIndexDescriptor<Vertex>
{
	public static final int SIZE_OF = 5 * 4;
	public static final int POSITION_OFFSET = 0 * 4;
	public static final int COLOR_OFFSET = 2 * 4;

	@Override
	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack);
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		var allocBindingDescription = allocBindingDescription(stack);
		var getgetAttributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription); // Optional
		vertexInputInfo.pVertexAttributeDescriptions(getgetAttributeDescriptions); // Optional

		return vertexInputInfo;
	}

	public static VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		var bindingDescription = VkVertexInputBindingDescription.callocStack(1, stack);

		bindingDescription.binding(0);
		bindingDescription.stride(SIZE_OF);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	public static VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		var attributeDescriptions = VkVertexInputAttributeDescription.callocStack(2, stack);

		var attributeDescriptionPosition = attributeDescriptions.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32_SFLOAT);
		attributeDescriptionPosition.offset(POSITION_OFFSET);

		var attributeDescriptionColor = attributeDescriptions.get(1);
		attributeDescriptionColor.binding(0);
		attributeDescriptionColor.location(1);
		attributeDescriptionColor.format(VK_FORMAT_R32G32B32_SFLOAT);
		attributeDescriptionColor.offset(COLOR_OFFSET);

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
	public ByteBuffer toVertexBuffer(Vertex[] vertices)
	{
		ByteBuffer res = MemoryUtil.memAlloc(SIZE_OF * vertices.length);
		FloatBuffer fb = res.asFloatBuffer();

		for (Vertex vertex : vertices)
		{
			fb.put(vertex.position.x);
			fb.put(vertex.position.y);
			fb.put(vertex.color.x);
			fb.put(vertex.color.y);
			fb.put(vertex.color.z);
		}

		return res;
	}

	public static class Vertex implements IVertex
	{
		Vector2f position;
		Vector3f color;

		public Vertex(Vector2f position, Vector3f color)
		{
			this.position = position;
			this.color = color;
		}

		public Vertex(float x, float y, float r, float g, float b)
		{
			this(new Vector2f(x, y), new Vector3f(r, g, b));
		}
	}
}
