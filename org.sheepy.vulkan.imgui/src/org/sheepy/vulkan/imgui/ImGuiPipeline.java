package org.sheepy.vulkan.imgui;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

import org.joml.Math;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineCacheCreateInfo;
import org.lwjgl.vulkan.VkPipelineColorBlendAttachmentState;
import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.lwjgl.vulkan.VkViewport;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.vulkan.shader.Shader;

import glm_.vec2.Vec2;
import glm_.vec2.Vec2i;
import imgui.DrawCmd;
import imgui.DrawData;
import imgui.DrawList;
import imgui.IO;
import imgui.ImGui;
import imgui.Style;

public class ImGuiPipeline implements IAllocable
{
	private final static String IMGUI_VERT_SHADER = "org/sheepy/vulkan/imgui/ui.vert.spv";
	private final static String IMGUI_FRAG_SHADER = "org/sheepy/vulkan/imgui/ui.frag.spv";

	// ----------------------------------------------------------------------------
	// ImGUI class
	// ----------------------------------------------------------------------------
	// Vulkan resources for rendering the UI
	private ImGuiFontTexture font;
	private long pipelineCache;
	private long pipelineLayout;
	private long pipeline;
	private long descriptorPool;
	private long descriptorSetLayout;
	private long descriptorSet;
	private VkDevice device;

	private ImGui imgui;
	private IO io;

	// UI params are set via push constants
	private class PushConstBlock
	{
		Vec2 scale = new Vec2();
		Vec2 translate = new Vec2(-1.0f);

		public float[] toArray()
		{
			float[] res = new float[4];
			res[0] = scale.getX();
			res[1] = scale.getY();
			res[2] = translate.getX();
			res[3] = translate.getY();

			return res;
		}
	}

	private LogicalDevice logicalDevice;
	private UIDescriptor uiDescriptor;
	private SwapConfiguration configuration;
	private ImGuiVertexBuffer texture;

	public ImGuiPipeline(CommandPool commandPool, SwapConfiguration configuration,
			UIDescriptor uiConfiguration)
	{
		this.logicalDevice = configuration.logicalDevice;
		this.device = logicalDevice.getVkDevice();
		this.configuration = configuration;
		this.uiDescriptor = uiConfiguration;

		imgui = ImGui.INSTANCE;

		texture = new ImGuiVertexBuffer(logicalDevice, commandPool);
		font = new ImGuiFontTexture(logicalDevice, commandPool);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		viewport = VkViewport.calloc(1);
		pushConstBlock = new PushConstBlock();
		scissorRect = VkRect2D.calloc(1);

		init();

		texture.allocate(stack);
		font.allocate(stack);

		buildPipeline(stack);
	}

	private long[] lArray = new long[1];
	private VkViewport.Buffer viewport;
	private VkRect2D.Buffer scissorRect;
	private PushConstBlock pushConstBlock;

	@Override
	public void free()
	{
		// Release all Vulkan resources required for rendering imGui
		texture.free();
		font.free();

		viewport.free();
		pushConstBlock = null;
		scissorRect.free();;

		vkDestroyPipelineCache(device, pipelineCache, null);
		vkDestroyPipeline(device, pipeline, null);
		vkDestroyPipelineLayout(device, pipelineLayout, null);
		vkDestroyDescriptorPool(device, descriptorPool, null);
		vkDestroyDescriptorSetLayout(device, descriptorSetLayout, null);
	}

	// Initialize styles, keys, etc.
	public void init()
	{
		// Color scheme
		Style style = imgui.getStyle();

		uiDescriptor.configureStyle(style);

		int[] size = uiDescriptor.getSize();
		io = imgui.getIo();
		io.setDisplaySize(new Vec2i(size[0], size[1]));
		io.setDisplayFramebufferScale(new Vec2(1.0f, 1.0f));
	}

	private void VK_CHECK_RESULT(int res)
	{
		if (res != VK_SUCCESS)
		{
			throw new AssertionError("Error creating UI");
		}
	}

	// Initialize all Vulkan resources used by the ui
	public void buildPipeline(MemoryStack stack)
	{
		// Descriptor pool
		VkDescriptorPoolSize.Buffer poolSizes = VkDescriptorPoolSize.callocStack(1, stack);
		poolSizes.type(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		poolSizes.descriptorCount(1);

		VkDescriptorPoolCreateInfo descriptorPoolInfo = VkDescriptorPoolCreateInfo
				.callocStack(stack);
		descriptorPoolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
		descriptorPoolInfo.pPoolSizes(poolSizes);
		descriptorPoolInfo.maxSets(2);
		VK_CHECK_RESULT(vkCreateDescriptorPool(device, descriptorPoolInfo, null, lArray));
		descriptorPool = lArray[0];

		// Descriptor set layout
		VkDescriptorSetLayoutBinding.Buffer setLayoutBindings = VkDescriptorSetLayoutBinding
				.callocStack(1, stack);
		setLayoutBindings.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		setLayoutBindings.stageFlags(VK_SHADER_STAGE_FRAGMENT_BIT);
		setLayoutBindings.descriptorCount(1);

		VkDescriptorSetLayoutCreateInfo descriptorLayout = VkDescriptorSetLayoutCreateInfo
				.callocStack(stack);
		descriptorLayout.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		descriptorLayout.pBindings(setLayoutBindings);
		VK_CHECK_RESULT(vkCreateDescriptorSetLayout(device, descriptorLayout, null, lArray));
		descriptorSetLayout = lArray[0];

		LongBuffer lBuffer = MemoryUtil.memAllocLong(1);
		lBuffer.put(descriptorSetLayout);
		lBuffer.flip();

		// Descriptor set
		VkDescriptorSetAllocateInfo allocInfo = VkDescriptorSetAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(descriptorPool);
		allocInfo.pSetLayouts(lBuffer);
		VK_CHECK_RESULT(vkAllocateDescriptorSets(device, allocInfo, lArray));
		MemoryUtil.memFree(lBuffer);

		descriptorSet = lArray[0];

		VkDescriptorImageInfo.Buffer fontDescriptor = VkDescriptorImageInfo.callocStack(1, stack);
		fontDescriptor.get(0).set(font.getSampler(), font.getImageView().getId(),
				VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);

		VkWriteDescriptorSet.Buffer writeDescriptorSets = VkWriteDescriptorSet.callocStack(1,
				stack);
		writeDescriptorSets.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptorSets.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		writeDescriptorSets.pImageInfo(fontDescriptor);
		writeDescriptorSets.dstSet(descriptorSet);
		writeDescriptorSets.dstBinding(0);

		vkUpdateDescriptorSets(device, writeDescriptorSets, null);

		// Pipeline cache
		VkPipelineCacheCreateInfo pipelineCacheCreateInfo = VkPipelineCacheCreateInfo
				.callocStack(stack);
		pipelineCacheCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_CACHE_CREATE_INFO);
		VK_CHECK_RESULT(vkCreatePipelineCache(device, pipelineCacheCreateInfo, null, lArray));
		pipelineCache = lArray[0];

		// Pipeline layout
		// Push constants for UI rendering parameters
		VkPushConstantRange.Buffer pushConstantRange = VkPushConstantRange.callocStack(1, stack);
		// 16 should be for sizeof(PushConstBlock)
		pushConstantRange.get(0).set(VK_SHADER_STAGE_VERTEX_BIT, 0, 16);

		LongBuffer layoutBuffer = MemoryUtil.memAllocLong(1);
		layoutBuffer.put(descriptorSetLayout);
		layoutBuffer.flip();

		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo
				.callocStack(stack);
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(layoutBuffer);
		pipelineLayoutCreateInfo.pPushConstantRanges(pushConstantRange);
		VK_CHECK_RESULT(vkCreatePipelineLayout(device, pipelineLayoutCreateInfo, null, lArray));
		pipelineLayout = lArray[0];

		// Setup graphics pipeline for UI rendering
		VkPipelineInputAssemblyStateCreateInfo inputAssemblyState = VkPipelineInputAssemblyStateCreateInfo
				.callocStack(stack);
		inputAssemblyState.sType(VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
		inputAssemblyState.topology(VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST);
		inputAssemblyState.primitiveRestartEnable(false);

		VkPipelineRasterizationStateCreateInfo rasterizationState = VkPipelineRasterizationStateCreateInfo
				.callocStack(stack);
		rasterizationState.lineWidth(1.0f);
		rasterizationState.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizationState.cullMode(VK_CULL_MODE_NONE);
		rasterizationState.polygonMode(VK_POLYGON_MODE_FILL);
		rasterizationState.frontFace(VK_FRONT_FACE_COUNTER_CLOCKWISE);

		// Enable blending
		VkPipelineColorBlendAttachmentState.Buffer blendAttachmentState = VkPipelineColorBlendAttachmentState
				.callocStack(1, stack);
		blendAttachmentState.blendEnable(true);
		blendAttachmentState.colorWriteMask(VK_COLOR_COMPONENT_R_BIT
				| VK_COLOR_COMPONENT_G_BIT
				| VK_COLOR_COMPONENT_B_BIT
				| VK_COLOR_COMPONENT_A_BIT);
		blendAttachmentState.srcColorBlendFactor(VK_BLEND_FACTOR_SRC_ALPHA);
		blendAttachmentState.dstColorBlendFactor(VK_BLEND_FACTOR_ONE_MINUS_SRC_ALPHA);
		blendAttachmentState.colorBlendOp(VK_BLEND_OP_ADD);
		blendAttachmentState.srcAlphaBlendFactor(VK_BLEND_FACTOR_ONE_MINUS_SRC_ALPHA);
		blendAttachmentState.dstAlphaBlendFactor(VK_BLEND_FACTOR_ZERO);
		blendAttachmentState.alphaBlendOp(VK_BLEND_OP_ADD);

		VkPipelineColorBlendStateCreateInfo colorBlendState = VkPipelineColorBlendStateCreateInfo
				.callocStack(stack);
		colorBlendState.sType(VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
		colorBlendState.pAttachments(blendAttachmentState);

		VkPipelineDepthStencilStateCreateInfo depthStencilState = VkPipelineDepthStencilStateCreateInfo
				.callocStack(stack);
		depthStencilState.depthTestEnable(false);
		depthStencilState.depthWriteEnable(false);
		depthStencilState.depthCompareOp(VK_COMPARE_OP_LESS_OR_EQUAL);

		VkPipelineViewportStateCreateInfo viewportState = VkPipelineViewportStateCreateInfo
				.callocStack(stack);
		viewportState.scissorCount(1);
		viewportState.viewportCount(1);
		viewportState.sType(VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO);

		VkPipelineMultisampleStateCreateInfo multisampleState = VkPipelineMultisampleStateCreateInfo
				.callocStack(stack);
		multisampleState.sType(VK_STRUCTURE_TYPE_PIPELINE_MULTISAMPLE_STATE_CREATE_INFO);
		multisampleState.rasterizationSamples(VK_SAMPLE_COUNT_1_BIT);

		IntBuffer dynamicStates = MemoryUtil.memAllocInt(2);
		dynamicStates.put(VK_DYNAMIC_STATE_VIEWPORT);
		dynamicStates.put(VK_DYNAMIC_STATE_SCISSOR);
		dynamicStates.flip();

		VkPipelineDynamicStateCreateInfo dynamicState = VkPipelineDynamicStateCreateInfo.malloc();
		dynamicState.sType(VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO);
		dynamicState.pDynamicStates(dynamicStates);
		dynamicState.flags(0);

		VkPipelineShaderStageCreateInfo.Buffer shaderStages = VkPipelineShaderStageCreateInfo
				.callocStack(2, stack);

		VkGraphicsPipelineCreateInfo.Buffer pipelineCreateInfo = VkGraphicsPipelineCreateInfo
				.callocStack(1, stack);
		pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineCreateInfo.layout(pipelineLayout);
		pipelineCreateInfo.renderPass(configuration.renderPass.getId());

		pipelineCreateInfo.pInputAssemblyState(inputAssemblyState);
		pipelineCreateInfo.pRasterizationState(rasterizationState);
		pipelineCreateInfo.pColorBlendState(colorBlendState);
		pipelineCreateInfo.pMultisampleState(multisampleState);
		pipelineCreateInfo.pViewportState(viewportState);
		pipelineCreateInfo.pDepthStencilState(depthStencilState);
		pipelineCreateInfo.pDynamicState(dynamicState);
		pipelineCreateInfo.pStages(shaderStages);

		// Vertex bindings an attributes based on ImGui vertex definition
		VkVertexInputBindingDescription.Buffer vertexInputBindings = ImGuiVertexBuffer.VERTEX_DESCRIPTOR
				.allocBindingDescription();

		VkVertexInputAttributeDescription.Buffer vertexInputAttributes = ImGuiVertexBuffer.VERTEX_DESCRIPTOR
				.allocAttributeDescriptions();

		VkPipelineVertexInputStateCreateInfo vertexInputState = VkPipelineVertexInputStateCreateInfo
				.callocStack(stack);
		vertexInputState.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);
		vertexInputState.pVertexBindingDescriptions(vertexInputBindings);
		vertexInputState.pVertexAttributeDescriptions(vertexInputAttributes);
		pipelineCreateInfo.pVertexInputState(vertexInputState);

		Shader vertShader = new Shader(logicalDevice, IMGUI_VERT_SHADER,
				VK_SHADER_STAGE_VERTEX_BIT);
		Shader fragShader = new Shader(logicalDevice, IMGUI_FRAG_SHADER,
				VK_SHADER_STAGE_FRAGMENT_BIT);

		vertShader.allocate(stack);
		fragShader.allocate(stack);

		shaderStages.put(vertShader.allocInfo());
		shaderStages.put(fragShader.allocInfo());
		shaderStages.flip();

		VK_CHECK_RESULT(
				vkCreateGraphicsPipelines(device, pipelineCache, pipelineCreateInfo, null, lArray));
		pipeline = lArray[0];
	}

	// Starts a new imGui frame and sets up windows and ui elements
	public void newFrame(boolean updateFrameGraph)
	{
		imgui.newFrame();

		uiDescriptor.newFrame(imgui);

		// Render to generate draw buffers
		imgui.render();
	}

	// Update vertex and index buffer containing the imGui elements when
	// required
	public void updateBuffers()
	{
		DrawData imDrawData = imgui.getDrawData();

		texture.update(imDrawData);
	}

	// Draw current imGui frame into a command buffer
	public void drawFrame(VkCommandBuffer commandBuffer)
	{
		lArray[0] = descriptorSet;
		vkCmdBindDescriptorSets(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, pipelineLayout, 0,
				lArray, null);
		vkCmdBindPipeline(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, pipeline);

		texture.bind(commandBuffer);

		viewport.get(0).set(0, 0, io.getDisplaySize().getX(), io.getDisplaySize().getY(), 0, 1);
		vkCmdSetViewport(commandBuffer, 0, viewport);

		pushConstBlock.scale.setX(2.0f / io.getDisplaySize().getX());
		pushConstBlock.scale.setY(2.0f / io.getDisplaySize().getY());
		vkCmdPushConstants(commandBuffer, pipelineLayout, VK_SHADER_STAGE_VERTEX_BIT, 0,
				pushConstBlock.toArray());

		// Render commands
		int vertexOffset = 0;
		int indexOffset = 0;
		DrawData imDrawData = imgui.getDrawData();
		for (int i = 0; i < imDrawData.getCmdListsCount(); i++)
		{
			DrawList cmd_list = imDrawData.getCmdLists().get(i);
			for (int j = 0; j < cmd_list.getCmdBuffer().size(); j++)
			{
				DrawCmd pcmd = cmd_list.getCmdBuffer().get(j);
				scissorRect.offset().set((int) Math.max(pcmd.getClipRect().getX(), 0),
						(int) Math.max(pcmd.getClipRect().getY(), 0));
				scissorRect.extent()
						.width((int) (pcmd.getClipRect().getZ() - pcmd.getClipRect().getX()));
				scissorRect.extent()
						.height((int) (pcmd.getClipRect().getW() - pcmd.getClipRect().getY()));
				vkCmdSetScissor(commandBuffer, 0, scissorRect);
				vkCmdDrawIndexed(commandBuffer, pcmd.getElemCount(), 1, indexOffset, vertexOffset,
						0);
				indexOffset += pcmd.getElemCount();
			}
			vertexOffset += cmd_list.getVtxBuffer().size();
		}
	}
}
