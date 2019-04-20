package org.sheepy.lily.vulkan.resource.texture;

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
import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.AbstractIntegerIndexDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVertex;
import org.sheepy.lily.vulkan.resource.texture.TextureVertexDescriptor.TextureVertex;

public class TextureVertexDescriptor extends AbstractIntegerIndexDescriptor<TextureVertex>
{
	public static final int SIZE_OF = 8 * 4;
	public static final int POSITION_OFFSET = 0 * 4;
	public static final int COLOR_OFFSET = 3 * 4;
	public static final int TEXTURE_OFFSET = 6 * 4;

	@Override
	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack);
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		var allocBindingDescription = allocBindingDescription(stack);
		var attributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription);
		vertexInputInfo.pVertexAttributeDescriptions(attributeDescriptions);

		return vertexInputInfo;
	}

	private static VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescription = VkVertexInputBindingDescription.callocStack(1, stack);

		bindingDescription.binding(0);
		bindingDescription.stride(SIZE_OF);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	private static VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final var attributeDescriptions = VkVertexInputAttributeDescription.callocStack(3, stack);

		final var attributeDescriptionPosition = attributeDescriptions.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32B32_SFLOAT);
		attributeDescriptionPosition.offset(POSITION_OFFSET);

		final var attributeDescriptionColor = attributeDescriptions.get(1);
		attributeDescriptionColor.binding(0);
		attributeDescriptionColor.location(1);
		attributeDescriptionColor.format(VK_FORMAT_R32G32B32_SFLOAT);
		attributeDescriptionColor.offset(COLOR_OFFSET);

		final var attributeDescriptionTexCoord = attributeDescriptions.get(2);
		attributeDescriptionTexCoord.binding(0);
		attributeDescriptionTexCoord.location(2);
		attributeDescriptionTexCoord.format(VK_FORMAT_R32G32_SFLOAT);
		attributeDescriptionTexCoord.offset(TEXTURE_OFFSET);

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
	public ByteBuffer toVertexBuffer(TextureVertex[] vertices)
	{
		final ByteBuffer res = MemoryUtil.memAlloc(SIZE_OF * vertices.length);
		final FloatBuffer fb = res.asFloatBuffer();

		for (final TextureVertex vertex : vertices)
		{
			fb.put(vertex.position.x);
			fb.put(vertex.position.y);
			fb.put(vertex.position.z);
			fb.put(vertex.color.x);
			fb.put(vertex.color.y);
			fb.put(vertex.color.z);
			fb.put(vertex.texCoord.x);
			fb.put(vertex.texCoord.y);
		}

		return res;
	}

	public static class TextureVertex implements IVertex
	{
		Vector3f position;
		Vector3f color;
		Vector2f texCoord;

		public TextureVertex(Vector3f position, Vector3f color, Vector2f texCoord)
		{
			this.position = position;
			this.color = color;
			this.texCoord = texCoord;
		}

		public TextureVertex(	float x,
								float y,
								float z,
								float r,
								float g,
								float b,
								float xTex,
								float yTex)
		{
			this(new Vector3f(x, y, z), new Vector3f(r, g, b), new Vector2f(xTex, yTex));
		}
	}
}
