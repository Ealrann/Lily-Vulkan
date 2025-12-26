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
		final int size = colorBlend.attachments().size();
		final var colorBlendAttachments = VkPipelineColorBlendAttachmentState.calloc(size, stack);
		for (final ColorBlendAttachment attachement : colorBlend.attachments())
		{
			final var colorBlendAttachment = colorBlendAttachments.get();
			final boolean red = attachement.redComponentEnable();
			final boolean green = attachement.greenComponentEnable();
			final boolean blue = attachement.blueComponentEnable();
			final boolean alpha = attachement.alphaComponentEnable();

			final int writeMask = (red ? VK_COLOR_COMPONENT_R_BIT : 0) |
								  (green ? VK_COLOR_COMPONENT_G_BIT : 0) |
								  (blue ? VK_COLOR_COMPONENT_B_BIT : 0) |
								  (alpha ? VK_COLOR_COMPONENT_A_BIT : 0);

			colorBlendAttachment.colorWriteMask(writeMask);
			colorBlendAttachment.blendEnable(attachement.blendEnable());

			colorBlendAttachment.srcColorBlendFactor(attachement.srcColor().value());
			colorBlendAttachment.dstColorBlendFactor(attachement.dstColor().value());
			colorBlendAttachment.colorBlendOp(attachement.colorBlendOp().value());
			colorBlendAttachment.srcAlphaBlendFactor(attachement.srcAlpha().value());
			colorBlendAttachment.dstAlphaBlendFactor(attachement.dstAlpha().value());
			colorBlendAttachment.alphaBlendOp(attachement.alphaBlendOp().value());
		}
		colorBlendAttachments.flip();

		final var colorBlending = VkPipelineColorBlendStateCreateInfo.malloc(stack);
		colorBlending.sType(VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
		colorBlending.logicOpEnable(colorBlend.logicOpEnable());
		colorBlending.logicOp(colorBlend.logicOp().value());
		colorBlending.pAttachments(colorBlendAttachments);
		colorBlending.blendConstants(0, colorBlend.blendConstant0());
		colorBlending.blendConstants(1, colorBlend.blendConstant1());
		colorBlending.blendConstants(2, colorBlend.blendConstant2());
		colorBlending.blendConstants(3, colorBlend.blendConstant3());

		colorBlending.pNext(VK_NULL_HANDLE);
		colorBlending.flags(0);

		return colorBlending;
	}
}
