package org.sheepy.vulkan.process.graphic.pipeline.render.impl;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineColorBlendAttachmentState;
import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;
import org.sheepy.vulkan.process.graphic.pipeline.render.IColorBlendState;

public class BasicColorBlendState implements IColorBlendState
{

	private VkPipelineColorBlendStateCreateInfo colorBlending;
	private VkPipelineColorBlendAttachmentState.Buffer colorBlendAttachment;

	@Override
	public VkPipelineColorBlendStateCreateInfo allocCreateInfo()
	{
		colorBlendAttachment = VkPipelineColorBlendAttachmentState.calloc(1);
		colorBlendAttachment.colorWriteMask(VK_COLOR_COMPONENT_R_BIT
				| VK_COLOR_COMPONENT_G_BIT
				| VK_COLOR_COMPONENT_B_BIT
				| VK_COLOR_COMPONENT_A_BIT);
		colorBlendAttachment.blendEnable(false);
		colorBlendAttachment.srcColorBlendFactor(VK_BLEND_FACTOR_ONE); // Optional
		colorBlendAttachment.dstColorBlendFactor(VK_BLEND_FACTOR_ZERO); // Optional
		colorBlendAttachment.colorBlendOp(VK_BLEND_OP_ADD); // Optional
		colorBlendAttachment.srcAlphaBlendFactor(VK_BLEND_FACTOR_ONE); // Optional
		colorBlendAttachment.dstAlphaBlendFactor(VK_BLEND_FACTOR_ZERO); // Optional
		colorBlendAttachment.alphaBlendOp(VK_BLEND_OP_ADD); // Optional

		colorBlending = VkPipelineColorBlendStateCreateInfo.calloc();
		colorBlending.sType(VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
		colorBlending.logicOpEnable(false);
		colorBlending.logicOp(VK_LOGIC_OP_COPY); // Optional
		colorBlending.pAttachments(colorBlendAttachment);
		colorBlending.blendConstants(0, 0f);
		colorBlending.blendConstants(1, 0f);
		colorBlending.blendConstants(2, 0f);
		colorBlending.blendConstants(3, 1f);

		return colorBlending;
	}

	@Override
	public void freeColorBlendStateCreateInfo()
	{
		colorBlending.free();
		colorBlendAttachment.free();
	}

	@Override
	public void free()
	{}

}
