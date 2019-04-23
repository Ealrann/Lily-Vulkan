package org.sheepy.lily.vulkan.nuklear.pipeline.draw;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.joml.Math;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkRect2D;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.surface.Extent2D;

public class NuklearDrawer
{
	private final VkRect2D.Buffer scissorRect = VkRect2D.create(1);

	private final List<IVkDescriptorSet> descriptorSets;
	private final NuklearResources resources;
	private final long layoutId;

	private int previousDescriptorSet = -1;
	private int indexOffset = 0;

	private int bindPoint;
	private Extent2D extent;

	public NuklearDrawer(	List<IVkDescriptorSet> descriptorSets,
							NuklearResources resources,
							long layoutId)
	{
		this.descriptorSets = descriptorSets;
		this.resources = resources;
		this.layoutId = layoutId;
	}

	public void prepare(int bindPoint, Extent2D extent)
	{
		this.bindPoint = bindPoint;
		this.extent = extent;
		previousDescriptorSet = -1;
		indexOffset = 0;
	}

	public void draw(VkCommandBuffer graphicCommandBuffer, DrawCommandData commandData)
	{
		updateDescriptor(graphicCommandBuffer, commandData);
		drawIndexed(graphicCommandBuffer, commandData);
	}

	public void drawIndexed(VkCommandBuffer commandBuffer, DrawCommandData commandData)
	{
		scissorRect.offset().x(Math.max(commandData.xOffset, 0));
		scissorRect.offset().y(Math.max(commandData.yOffset, 0));
		scissorRect.extent().width(Math.min(commandData.xExtent, extent.getWidth()));
		scissorRect.extent().height(Math.min(commandData.yExtent, extent.getHeight()));

		vkCmdSetScissor(commandBuffer, 0, scissorRect);
		vkCmdDrawIndexed(commandBuffer, commandData.elemCount, 1, indexOffset, 0, 0);

		indexOffset += commandData.elemCount;
	}

	public void updateDescriptor(VkCommandBuffer commandBuffer, DrawCommandData commandData)
	{
		final int currentIndex = resources.getDescriptorSetIndex(commandData.descriptorSetId);
		if (previousDescriptorSet != currentIndex)
		{
			final var descriptorSet = descriptorSets.get(currentIndex);

			vkCmdBindDescriptorSets(commandBuffer, bindPoint, layoutId, 0, new long[] {
					descriptorSet.getId()
			}, null);

			previousDescriptorSet = currentIndex;
		}
	}

}
