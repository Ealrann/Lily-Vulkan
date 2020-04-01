package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineColorBlendAttachmentState;
import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;

import static org.lwjgl.vulkan.VK10.*;

public class ColorBlendBuilder
{
	public VkPipelineColorBlendStateCreateInfo allocCreateInfo(MemoryStack stack, ColorBlend colorBlend)
	{
		final int size = colorBlend.getAttachments().size();
		final var colorBlendAttachments = VkPipelineColorBlendAttachmentState.callocStack(size, stack);
		for (final ColorBlendAttachment attachement : colorBlend.getAttachments())
		{
			final var colorBlendAttachment = colorBlendAttachments.get();
			final boolean red = attachement.isRedComponentEnable();
			final boolean green = attachement.isGreenComponentEnable();
			final boolean blue = attachement.isBlueComponentEnable();
			final boolean alpha = attachement.isAlphaComponentEnable();

			final int writeMask = (red ? VK_COLOR_COMPONENT_R_BIT : 0) |
								  (green ? VK_COLOR_COMPONENT_G_BIT : 0) |
								  (blue ? VK_COLOR_COMPONENT_B_BIT : 0) |
								  (alpha ? VK_COLOR_COMPONENT_A_BIT : 0);

			colorBlendAttachment.colorWriteMask(writeMask);
			colorBlendAttachment.blendEnable(attachement.isBlendEnable());

			colorBlendAttachment.srcColorBlendFactor(attachement.getSrcColor().getValue());
			colorBlendAttachment.dstColorBlendFactor(attachement.getDstColor().getValue());
			colorBlendAttachment.colorBlendOp(attachement.getColorBlendOp().getValue());
			colorBlendAttachment.srcAlphaBlendFactor(attachement.getSrcAlpha().getValue());
			colorBlendAttachment.dstAlphaBlendFactor(attachement.getDstAlpha().getValue());
			colorBlendAttachment.alphaBlendOp(attachement.getAlphaBlendOp().getValue());
		}
		colorBlendAttachments.flip();

		final var colorBlending = VkPipelineColorBlendStateCreateInfo.mallocStack(stack);
		colorBlending.sType(VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
		colorBlending.logicOpEnable(colorBlend.isLogicOpEnable());
		colorBlending.logicOp(colorBlend.getLogicOp().getValue());
		colorBlending.pAttachments(colorBlendAttachments);
		colorBlending.blendConstants(0, colorBlend.getBlendConstant0());
		colorBlending.blendConstants(1, colorBlend.getBlendConstant1());
		colorBlending.blendConstants(2, colorBlend.getBlendConstant2());
		colorBlending.blendConstants(3, colorBlend.getBlendConstant3());

		colorBlending.pNext(VK_NULL_HANDLE);
		colorBlending.flags(0);

		return colorBlending;
	}
}
