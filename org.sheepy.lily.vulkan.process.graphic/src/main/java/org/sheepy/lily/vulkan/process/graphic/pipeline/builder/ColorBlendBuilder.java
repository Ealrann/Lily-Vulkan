package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineColorBlendAttachmentState;
import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment;

public class ColorBlendBuilder
{
	private VkPipelineColorBlendStateCreateInfo colorBlending;
	private VkPipelineColorBlendAttachmentState.Buffer colorBlendAttachments;

	public VkPipelineColorBlendStateCreateInfo allocCreateInfo(ColorBlend colorBlend)
	{
		colorBlendAttachments = VkPipelineColorBlendAttachmentState
				.calloc(colorBlend.getAttachments().size());
		for (ColorBlendAttachment attachement : colorBlend.getAttachments())
		{
			int writeMask = 0;
			if (attachement.isRedComponentEnable()) writeMask |= VK_COLOR_COMPONENT_R_BIT;
			if (attachement.isGreenComponentEnable()) writeMask |= VK_COLOR_COMPONENT_G_BIT;
			if (attachement.isBlueComponentEnable()) writeMask |= VK_COLOR_COMPONENT_B_BIT;
			if (attachement.isAlphaComponentEnable()) writeMask |= VK_COLOR_COMPONENT_A_BIT;

			colorBlendAttachments.colorWriteMask(writeMask);
			colorBlendAttachments.blendEnable(attachement.isBlendEnable());
			
			colorBlendAttachments.srcColorBlendFactor(attachement.getSrcColor().getValue());
			colorBlendAttachments.dstColorBlendFactor(attachement.getDstColor().getValue());
			colorBlendAttachments.colorBlendOp(attachement.getColorBlendOp().getValue());
			colorBlendAttachments.srcAlphaBlendFactor(attachement.getSrcAlpha().getValue());
			colorBlendAttachments.dstAlphaBlendFactor(attachement.getDstAlpha().getValue());
			colorBlendAttachments.alphaBlendOp(attachement.getAlphaBlendOp().getValue());
		}

		colorBlending = VkPipelineColorBlendStateCreateInfo.calloc();
		colorBlending.sType(VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
		colorBlending.logicOpEnable(colorBlend.isLogicOpEnable());
		colorBlending.logicOp(colorBlend.getLogicOp().getValue());
		colorBlending.pAttachments(colorBlendAttachments);
		colorBlending.blendConstants(0, colorBlend.getBlendConstant0());
		colorBlending.blendConstants(1, colorBlend.getBlendConstant1());
		colorBlending.blendConstants(2, colorBlend.getBlendConstant2());
		colorBlending.blendConstants(3, colorBlend.getBlendConstant3());

		return colorBlending;
	}

	public void freeColorBlendStateCreateInfo()
	{
		colorBlending.free();
		colorBlendAttachments.free();
	}
}
