package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearVertexDescriptor.GuiVertex;
import org.sheepy.vulkan.resource.indexed.IIndexedBufferDescriptor;
import org.sheepy.vulkan.resource.indexed.IVertex;

public class NuklearVertexDescriptor implements IIndexedBufferDescriptor<GuiVertex>
{
	public static final int SIZE_OF = 5 * 4;
	public static final int POSITION_OFFSET = 0;
	public static final int TEX_COORD_OFFSET = 2 * 4;
	public static final int COLOR_OFFSET = 4 * 4;

	@Override
	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		final var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack);
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		final var bindingDescription = allocBindingDescription(stack);
		final var attributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.pVertexBindingDescriptions(bindingDescription); // Optional
		vertexInputInfo.pVertexAttributeDescriptions(attributeDescriptions); // Optional

		return vertexInputInfo;
	}

	public static VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescription = VkVertexInputBindingDescription.mallocStack(1, stack);

		bindingDescription.binding(0);
		bindingDescription.stride(SIZE_OF);
		bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);

		return bindingDescription;
	}

	public static VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final var attributeDescriptions = VkVertexInputAttributeDescription.mallocStack(3, stack);

		final var positionAttribute = attributeDescriptions.get(0);
		positionAttribute.binding(0);
		positionAttribute.location(0);
		positionAttribute.format(VK_FORMAT_R32G32_SFLOAT);
		positionAttribute.offset(POSITION_OFFSET);

		final var texCoordAttribute = attributeDescriptions.get(1);
		texCoordAttribute.binding(0);
		texCoordAttribute.location(1);
		texCoordAttribute.format(VK_FORMAT_R32G32_SFLOAT);
		texCoordAttribute.offset(TEX_COORD_OFFSET);

		final var colorAttribute = attributeDescriptions.get(2);
		colorAttribute.binding(0);
		colorAttribute.location(2);
		colorAttribute.format(VK_FORMAT_R8G8B8A8_UNORM);
		colorAttribute.offset(COLOR_OFFSET);

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
	public ByteBuffer toVertexBuffer(GuiVertex[] vertices)
	{
		final ByteBuffer res = MemoryUtil.memAlloc(SIZE_OF * vertices.length);

		for (final GuiVertex vertex : vertices)
		{
			res.putFloat(vertex.posX);
			res.putFloat(vertex.posY);
			res.putFloat(vertex.uvX);
			res.putFloat(vertex.uvY);
			res.putInt(vertex.tex);
		}

		return res;
	}

	public class GuiVertex implements IVertex
	{
		float posX;
		float posY;
		float uvX;
		float uvY;
		int tex;
	}

	@Override
	public int sizeOfIndex()
	{
		return Short.BYTES;
	}

	@Override
	@Deprecated
	public ByteBuffer toIndexBuffer(int[] indices)
	{
		final ByteBuffer res = MemoryUtil.memAlloc(indices.length * Short.BYTES);

		for (final Integer index : indices)
		{
			res.putShort(index.shortValue());
		}
		res.flip();

		return res;
	}

	public static void dumpVertex(long memoryAddress, long size)
	{
		final int elemSize = (int) (size / 4);
		final ByteBuffer buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) size);
		for (int i = 0; i < elemSize - 5; i += 5)
		{
			final float x = buffer.getFloat();
			final float y = buffer.getFloat();
			final float u = buffer.getFloat();
			final float v = buffer.getFloat();
			final int color = buffer.getInt();
			final int r = color & 255;
			final int g = (color >> 8) & 255;
			final int b = (color >> 16) & 255;
			final int a = (color >> 24) & 255;
			final int index = i / 5;

			if (x != 0 || y != 0) System.out.print(
					String.format("%d| p:{%.0f, %.0f}, uv:{%.2f, %.2f}, rgb:{%d, %d, %d, %d}\n",
							index, x, y, u, v, r, g, b, a));
		}
	}

	public static void dumpIndex(long memoryAddress, long size)
	{
		final int elemSize = (int) (size / 2);
		final ByteBuffer buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) size);
		for (int i = 0; i < elemSize - 3; i += 3)
		{
			final int i1 = buffer.getShort();
			final int i2 = buffer.getShort();
			final int i3 = buffer.getShort();

			if (i1 != 0 || i2 != 0 || i3 != 0)
				System.out.print(String.format("i:{%d, %d, %d}\n", i1, i2, i3));
		}
	}
}