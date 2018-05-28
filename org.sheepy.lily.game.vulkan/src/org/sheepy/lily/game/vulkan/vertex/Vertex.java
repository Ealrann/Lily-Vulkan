package org.sheepy.lily.game.vulkan.vertex;

import static org.lwjgl.vulkan.VK10.*;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;

public class Vertex
{
	public static final int SIZE_OF = 5 * 4;
	public static final int POSITION_OFFSET = 0 * 4;
	public static final int COLOR_OFFSET = 2 * 4;
	
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
	
	public static VkVertexInputBindingDescription.Buffer allocBindingDescription()
	{
        VkVertexInputBindingDescription.Buffer bindingDescription = VkVertexInputBindingDescription.calloc(1);

        bindingDescription.binding(0);
        bindingDescription.stride(SIZE_OF);
        bindingDescription.inputRate(VK_VERTEX_INPUT_RATE_VERTEX);
        
        return bindingDescription;
    }
	
	public static VkVertexInputAttributeDescription.Buffer getgetAttributeDescriptions()
	{
		VkVertexInputAttributeDescription.Buffer attributeDescriptions = VkVertexInputAttributeDescription.calloc(2);
		
		VkVertexInputAttributeDescription attributeDescriptionPosition = attributeDescriptions.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32_SFLOAT);
		attributeDescriptionPosition.offset(POSITION_OFFSET);

		VkVertexInputAttributeDescription attributeDescriptionColor = attributeDescriptions.get(1);
		attributeDescriptionColor.binding(0);
		attributeDescriptionColor.location(1);
		attributeDescriptionColor.format(VK_FORMAT_R32G32B32_SFLOAT);
		attributeDescriptionColor.offset(COLOR_OFFSET);
		
		return attributeDescriptions;
	}
}
