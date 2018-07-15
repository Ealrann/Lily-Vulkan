package org.sheepy.vulkan.imgui;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

import org.joml.Math;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferImageCopy;
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
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkSamplerCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.lwjgl.vulkan.VkViewport;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.buffer.Buffer;
import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.vulkan.shader.Shader;
import org.sheepy.vulkan.view.ImageView;

import glm_.vec2.Vec2;
import glm_.vec2.Vec2i;
import imgui.DrawCmd;
import imgui.DrawData;
import imgui.DrawList;
import imgui.DrawVert;
import imgui.IO;
import imgui.ImGui;
import imgui.Style;
import kotlin.Triple;

public class MyImGui implements IAllocable
{
	private final static String IMGUI_VERT_SHADER = "org/sheepy/vulkan/imgui/ui.vert.spv";
	private final static String IMGUI_FRAG_SHADER = "org/sheepy/vulkan/imgui/ui.frag.spv";

	// ----------------------------------------------------------------------------
	// ImGUI class
	// ----------------------------------------------------------------------------
	// Vulkan resources for rendering the UI
	private long sampler;
	private Buffer vertexBuffer;
	private Buffer indexBuffer;
	private Image fontImage;
	private ImageView fontImageView;
	private long pipelineCache;
	private long pipelineLayout;
	private long pipeline;
	private long descriptorPool;
	private long descriptorSetLayout;
	private long descriptorSet;
	private VkDevice device;

	private ImGui imgui;
	private IO io;

	private static final int SIZEOF_ImDrawVert = 20;
	private static final int SIZEOF_ImDrawIdx = 2;

	// UI params are set via push constants
	private class PushConstBlock
	{
		Vec2 scale;
		Vec2 translate;

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
	private CommandPool commandPool;
	private VkQueue queue;
	private UIDescriptor uiConfiguration;
	private SwapConfiguration configuration;

	public MyImGui(CommandPool commandPool, SwapConfiguration configuration,
			UIDescriptor uiConfiguration)
	{
		this.logicalDevice = configuration.logicalDevice;
		this.device = logicalDevice.getVkDevice();
		this.commandPool = commandPool;
		this.queue = logicalDevice.getQueueManager().getGraphicQueue();
		this.configuration = configuration;
		this.uiConfiguration = uiConfiguration;

		imgui = ImGui.INSTANCE;

		int vertexBufferSize = MAX_VERTEX_COUNT * SIZEOF_ImDrawVert;
		int indexBufferSize = MAX_INDEX_COUNT * SIZEOF_ImDrawIdx;

		vertexBuffer = new Buffer(logicalDevice, vertexBufferSize,
				VK_BUFFER_USAGE_VERTEX_BUFFER_BIT, VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT);
		indexBuffer = new Buffer(logicalDevice, indexBufferSize, VK_BUFFER_USAGE_INDEX_BUFFER_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT);

	}

	@Override
	public void allocate(MemoryStack stack)
	{
		vertexBuffer.allocate();
		indexBuffer.allocate();

		int vertexBufferSize = MAX_VERTEX_COUNT * SIZEOF_ImDrawVert;
		stagingBuffer = MemoryUtil.memAlloc(vertexBufferSize);

		init();
		initResources();
	}

	@Override
	public void free()
	{
		// Release all Vulkan resources required for rendering imGui
		vertexBuffer.free();
		indexBuffer.free();

		fontImageView.free();
		fontImage.free();
		vkDestroySampler(device, sampler, null);
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

		uiConfiguration.configureStyle(style);

		int[] size = uiConfiguration.getSize();
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
	public void initResources()
	{
		// Create font texture
		Triple<ByteBuffer, Vec2i, Integer> texData = io.getFonts().getTexDataAsRGBA32();
		ByteBuffer fontData = texData.component1();
		int texWidth = texData.component2().getX();
		int texHeight = texData.component2().getY();

		int uploadSize = texWidth * texHeight * 4;

		fontImage = new Image(logicalDevice);
		fontImage.createImage(texWidth, texHeight, 1, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_SAMPLED_BIT | VK_IMAGE_USAGE_TRANSFER_DST_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		fontImageView = new ImageView(logicalDevice);
		fontImageView.load(fontImage.getId(), 1, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_ASPECT_COLOR_BIT);

		// Staging buffers for font data upload
		Buffer stagingBuffer = new Buffer(logicalDevice, uploadSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		stagingBuffer.allocate();
		stagingBuffer.fillWithBuffer(fontData);

		SingleTimeCommand stc = new SingleTimeCommand(commandPool, queue)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				fontImage.transitionImageLayout(commandBuffer, VK_IMAGE_LAYOUT_UNDEFINED,
						VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, 1, VK_PIPELINE_STAGE_HOST_BIT,
						VK_PIPELINE_STAGE_TRANSFER_BIT, 0, VK_ACCESS_TRANSFER_WRITE_BIT);

				// Copy
				VkBufferImageCopy.Buffer bufferCopyRegion = VkBufferImageCopy.calloc(1);
				bufferCopyRegion.imageSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
				bufferCopyRegion.imageSubresource().layerCount(1);
				bufferCopyRegion.imageExtent().width(texWidth);
				bufferCopyRegion.imageExtent().height(texHeight);
				bufferCopyRegion.imageExtent().depth(1);

				vkCmdCopyBufferToImage(commandBuffer, stagingBuffer.getId(), fontImage.getId(),
						VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, bufferCopyRegion);

				fontImage.transitionImageLayout(commandBuffer, VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL,
						VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL, 1, VK_PIPELINE_STAGE_TRANSFER_BIT,
						VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT, VK_ACCESS_TRANSFER_WRITE_BIT,
						VK_ACCESS_INPUT_ATTACHMENT_READ_BIT);
			}
		};
		stc.execute();

		stagingBuffer.free();

		// Font texture Sampler
		VkSamplerCreateInfo samplerInfo = VkSamplerCreateInfo.calloc();
		samplerInfo.sType(VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO);
		samplerInfo.magFilter(VK_FILTER_LINEAR);
		samplerInfo.minFilter(VK_FILTER_LINEAR);
		samplerInfo.mipmapMode(VK_SAMPLER_MIPMAP_MODE_LINEAR);
		samplerInfo.addressModeU(VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE);
		samplerInfo.addressModeV(VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE);
		samplerInfo.addressModeW(VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE);
		samplerInfo.borderColor(VK_BORDER_COLOR_FLOAT_OPAQUE_WHITE);
		long[] lArray = new long[1];
		VK_CHECK_RESULT(vkCreateSampler(device, samplerInfo, null, lArray));

		sampler = lArray[0];

		// Descriptor pool
		VkDescriptorPoolSize.Buffer poolSizes = VkDescriptorPoolSize.calloc(1);
		poolSizes.type(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		poolSizes.descriptorCount(1);

		VkDescriptorPoolCreateInfo descriptorPoolInfo = VkDescriptorPoolCreateInfo.calloc();
		descriptorPoolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
		descriptorPoolInfo.pPoolSizes(poolSizes);
		descriptorPoolInfo.maxSets(2);
		VK_CHECK_RESULT(vkCreateDescriptorPool(device, descriptorPoolInfo, null, lArray));
		descriptorPool = lArray[0];

		// Descriptor set layout
		VkDescriptorSetLayoutBinding.Buffer setLayoutBindings = VkDescriptorSetLayoutBinding
				.calloc(1);
		setLayoutBindings.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		setLayoutBindings.stageFlags(VK_SHADER_STAGE_FRAGMENT_BIT);
		setLayoutBindings.descriptorCount(1);

		VkDescriptorSetLayoutCreateInfo descriptorLayout = VkDescriptorSetLayoutCreateInfo.calloc();
		descriptorLayout.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		descriptorLayout.pBindings(setLayoutBindings);
		VK_CHECK_RESULT(vkCreateDescriptorSetLayout(device, descriptorLayout, null, lArray));
		descriptorSetLayout = lArray[0];

		LongBuffer lBuffer = MemoryUtil.memAllocLong(1);
		lBuffer.put(descriptorSetLayout);
		lBuffer.flip();

		// Descriptor set
		VkDescriptorSetAllocateInfo allocInfo = VkDescriptorSetAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(descriptorPool);
		allocInfo.pSetLayouts(lBuffer);
		VK_CHECK_RESULT(vkAllocateDescriptorSets(device, allocInfo, lArray));
		MemoryUtil.memFree(lBuffer);

		descriptorSet = lArray[0];

		VkDescriptorImageInfo.Buffer fontDescriptor = VkDescriptorImageInfo.calloc(1);
		fontDescriptor.get(0).set(sampler, fontImageView.getId(),
				VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);

		VkWriteDescriptorSet.Buffer writeDescriptorSets = VkWriteDescriptorSet.calloc(1);
		writeDescriptorSets.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptorSets.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		writeDescriptorSets.pImageInfo(fontDescriptor);
		writeDescriptorSets.dstSet(descriptorSet);
		writeDescriptorSets.dstBinding(0);

		vkUpdateDescriptorSets(device, writeDescriptorSets, null);

		// Pipeline cache
		VkPipelineCacheCreateInfo pipelineCacheCreateInfo = VkPipelineCacheCreateInfo.calloc();
		pipelineCacheCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_CACHE_CREATE_INFO);
		VK_CHECK_RESULT(vkCreatePipelineCache(device, pipelineCacheCreateInfo, null, lArray));
		pipelineCache = lArray[0];

		// Pipeline layout
		// Push constants for UI rendering parameters
		VkPushConstantRange.Buffer pushConstantRange = VkPushConstantRange.calloc(1);
		// 16 should be for sizeof(PushConstBlock)
		pushConstantRange.get(0).set(VK_SHADER_STAGE_VERTEX_BIT, 0, 16);

		LongBuffer layoutBuffer = MemoryUtil.memAllocLong(1);
		layoutBuffer.put(descriptorSetLayout);
		layoutBuffer.flip();

		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.calloc();
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(layoutBuffer);
		pipelineLayoutCreateInfo.pPushConstantRanges(pushConstantRange);
		VK_CHECK_RESULT(vkCreatePipelineLayout(device, pipelineLayoutCreateInfo, null, lArray));
		pipelineLayout = lArray[0];

		// Setup graphics pipeline for UI rendering
		VkPipelineInputAssemblyStateCreateInfo inputAssemblyState = VkPipelineInputAssemblyStateCreateInfo
				.calloc();
		inputAssemblyState.sType(VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
		inputAssemblyState.topology(VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST);
		inputAssemblyState.primitiveRestartEnable(false);

		VkPipelineRasterizationStateCreateInfo rasterizationState = VkPipelineRasterizationStateCreateInfo
				.calloc();
		rasterizationState.lineWidth(1.0f);
		rasterizationState.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizationState.cullMode(VK_CULL_MODE_NONE);
		rasterizationState.polygonMode(VK_POLYGON_MODE_FILL);
		rasterizationState.frontFace(VK_FRONT_FACE_COUNTER_CLOCKWISE);

		// Enable blending
		VkPipelineColorBlendAttachmentState.Buffer blendAttachmentState = VkPipelineColorBlendAttachmentState
				.calloc(1);
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
				.calloc();
		colorBlendState.sType(VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
		colorBlendState.pAttachments(blendAttachmentState);

		VkPipelineDepthStencilStateCreateInfo depthStencilState = VkPipelineDepthStencilStateCreateInfo
				.calloc();
		depthStencilState.depthTestEnable(false);
		depthStencilState.depthWriteEnable(false);
		depthStencilState.depthCompareOp(VK_COMPARE_OP_LESS_OR_EQUAL);

		VkPipelineViewportStateCreateInfo viewportState = VkPipelineViewportStateCreateInfo
				.calloc();
		viewportState.scissorCount(1);
		viewportState.viewportCount(1);
		viewportState.sType(VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO);

		VkPipelineMultisampleStateCreateInfo multisampleState = VkPipelineMultisampleStateCreateInfo
				.calloc();
		multisampleState.sType(VK_STRUCTURE_TYPE_PIPELINE_MULTISAMPLE_STATE_CREATE_INFO);
		multisampleState.rasterizationSamples(VK_SAMPLE_COUNT_1_BIT);

		IntBuffer dynamicStates = MemoryUtil.memAllocInt(2);
		dynamicStates.put(VK_DYNAMIC_STATE_VIEWPORT);
		dynamicStates.put(VK_DYNAMIC_STATE_SCISSOR);
		dynamicStates.flip();

		VkPipelineDynamicStateCreateInfo dynamicState = VkPipelineDynamicStateCreateInfo.malloc();
		dynamicState.sType(VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO);
		dynamicState.pDynamicStates(dynamicStates);

		VkPipelineShaderStageCreateInfo.Buffer shaderStages = VkPipelineShaderStageCreateInfo
				.calloc(2);

		VkGraphicsPipelineCreateInfo.Buffer pipelineCreateInfo = VkGraphicsPipelineCreateInfo
				.calloc(1);
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
		VkVertexInputBindingDescription.Buffer vertexInputBindings = VkVertexInputBindingDescription
				.calloc(1);
		vertexInputBindings.get(0).set(0, 20, VK_VERTEX_INPUT_RATE_VERTEX);

		VkVertexInputAttributeDescription.Buffer vertexInputAttributes = VkVertexInputAttributeDescription
				.calloc(3);

		VkVertexInputAttributeDescription attributeDescriptionPosition = vertexInputAttributes
				.get(0);
		attributeDescriptionPosition.binding(0);
		attributeDescriptionPosition.location(0);
		attributeDescriptionPosition.format(VK_FORMAT_R32G32B32_SFLOAT);
		attributeDescriptionPosition.offset(0);

		VkVertexInputAttributeDescription attributeDescriptionColor = vertexInputAttributes.get(1);
		attributeDescriptionColor.binding(0);
		attributeDescriptionColor.location(1);
		attributeDescriptionColor.format(VK_FORMAT_R32G32B32_SFLOAT);
		attributeDescriptionColor.offset(8);

		VkVertexInputAttributeDescription attributeDescriptionTexCoord = vertexInputAttributes
				.get(2);
		attributeDescriptionTexCoord.binding(0);
		attributeDescriptionTexCoord.location(2);
		attributeDescriptionTexCoord.format(VK_FORMAT_R8G8B8A8_UNORM);
		attributeDescriptionTexCoord.offset(16);

		VkPipelineVertexInputStateCreateInfo vertexInputState = VkPipelineVertexInputStateCreateInfo
				.calloc();
		vertexInputState.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);
		vertexInputState.pVertexBindingDescriptions(vertexInputBindings);
		vertexInputState.pVertexAttributeDescriptions(vertexInputAttributes);
		pipelineCreateInfo.pVertexInputState(vertexInputState);

		Shader vertShader = new Shader(logicalDevice, IMGUI_VERT_SHADER,
				VK_SHADER_STAGE_VERTEX_BIT);
		Shader fragShader = new Shader(logicalDevice, IMGUI_FRAG_SHADER,
				VK_SHADER_STAGE_FRAGMENT_BIT);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			vertShader.allocate(stack);
			fragShader.allocate(stack);
		}

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

		// Init imGui windows and elements

		// imgui.textUnformatted(infos.title, 0);
		// imgui.textUnformatted(device.getPhysicalDevice().toString(), 0);
		//
		// // Update frame time display
		// if (updateFrameGraph)
		// {
		// // std::rotate(infos.frameTimes.begin(), infos.frameTimes.begin() +
		// // 1, infos.frameTimes.end());
		// //
		// // float frameTime = 1000.0f / (infos.frameTimer * 1000.0f);
		// // infos.frameTimes.back() = frameTime;
		// // if (frameTime < infos.frameTimeMin) {
		// // infos.frameTimeMin = frameTime;
		// // }
		// // if (frameTime > infos.frameTimeMax) {
		// // infos.frameTimeMax = frameTime;
		// // }
		// }
		//
		// imgui.plotLines("Frame Times", infos.frameTimes, 0, "",
		// infos.frameTimeMin,
		// infos.frameTimeMax, new Vec2(0, 80), 0);
		//
		// imgui.text("Camera");
		// imgui.inputFloat3("pos", infos.cameraPosition, "%f", 0);
		// imgui.inputFloat3("rot", infos.cameraRotation, "oh?", 0);

		imgui.newFrame();

		uiConfiguration.newFrame(imgui);

		imgui.endFrame();
		// imgui.showDemoWindow(new boolean[1]);

		// Render to generate draw buffers
		imgui.render();
	}

	private static final int MAX_VERTEX_COUNT = 2000;
	private static final int MAX_INDEX_COUNT = 4500;
	private ByteBuffer stagingBuffer;

	// Update vertex and index buffer containing the imGui elements when
	// required
	public void updateBuffers()
	{
		DrawData imDrawData = imgui.getDrawData();

		int vertexCount = imDrawData.getTotalVtxCount();
		int indexCount = imDrawData.getTotalIdxCount();

		if (vertexCount > MAX_VERTEX_COUNT || indexCount > MAX_INDEX_COUNT)
		{
			throw new AssertionError("UI Buffers too small");
		}

		for (int n = 0; n < imDrawData.getCmdListsCount(); n++)
		{
			DrawList cmd_list = imDrawData.getCmdLists().get(n);

			for (DrawVert vert : cmd_list.getVtxBuffer())
			{
				stagingBuffer.putFloat(vert.getPos().component1());
				stagingBuffer.putFloat(vert.getPos().component2());
				stagingBuffer.putFloat(vert.getUv().component1());
				stagingBuffer.putFloat(vert.getUv().component2());
				stagingBuffer.putInt(vert.getCol());
			}
		}

		stagingBuffer.flip();
		vertexBuffer.fillWithBuffer(stagingBuffer);
		stagingBuffer.clear();

		for (int n = 0; n < imDrawData.getCmdListsCount(); n++)
		{
			DrawList cmd_list = imDrawData.getCmdLists().get(n);

			for (Integer index : cmd_list.getIdxBuffer())
			{
				stagingBuffer.putShort(index.shortValue());
			}
		}
		stagingBuffer.flip();
		indexBuffer.fillWithBuffer(stagingBuffer);
		stagingBuffer.clear();

		// Flush to make writes visible to GPU
		vertexBuffer.flush();
		indexBuffer.flush();
	}

	// Draw current imGui frame into a command buffer
	public void drawFrame(VkCommandBuffer commandBuffer)
	{
		long[] lArray = new long[1];
		lArray[0] = descriptorSet;
		vkCmdBindDescriptorSets(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, pipelineLayout, 0,
				lArray, null);
		vkCmdBindPipeline(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, pipeline);

		// Bind vertex and index buffer
		long[] pBuffer = {
				vertexBuffer.getId()
		};
		long[] offsets = {
				0
		};
		vkCmdBindVertexBuffers(commandBuffer, 0, pBuffer, offsets);

		vkCmdBindIndexBuffer(commandBuffer, indexBuffer.getId(), 0, VK_INDEX_TYPE_UINT16);

		VkViewport.Buffer viewport = VkViewport.calloc(1);
		viewport.get(0).set(0, 0, io.getDisplaySize().getX(), io.getDisplaySize().getY(), 0, 1);
		vkCmdSetViewport(commandBuffer, 0, viewport);

		// UI scale and translate via push constants
		PushConstBlock pushConstBlock = new PushConstBlock();
		pushConstBlock.scale = new Vec2(2.0f / io.getDisplaySize().getX(),
				2.0f / io.getDisplaySize().getY());
		pushConstBlock.translate = new Vec2(-1.0f);
		vkCmdPushConstants(commandBuffer, pipelineLayout, VK_SHADER_STAGE_VERTEX_BIT, 0,
				pushConstBlock.toArray());

		// Render commands
		DrawData imDrawData = imgui.getDrawData();
		int vertexOffset = 0;
		int indexOffset = 0;
		for (int i = 0; i < imDrawData.getCmdListsCount(); i++)
		{
			DrawList cmd_list = imDrawData.getCmdLists().get(i);
			for (int j = 0; j < cmd_list.getCmdBuffer().size(); j++)
			{
				DrawCmd pcmd = cmd_list.getCmdBuffer().get(j);
				VkRect2D.Buffer scissorRect = VkRect2D.calloc(1);
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
