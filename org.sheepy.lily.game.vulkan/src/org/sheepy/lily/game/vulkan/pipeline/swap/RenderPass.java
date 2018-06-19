package org.sheepy.lily.game.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSwapchain.VK_IMAGE_LAYOUT_PRESENT_SRC_KHR;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkRenderPassCreateInfo;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.sheepy.lily.game.vulkan.buffer.DepthResource;
import org.sheepy.lily.game.vulkan.buffer.IndexBuffer;
import org.sheepy.lily.game.vulkan.buffer.Mesh;
import org.sheepy.lily.game.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.GraphicPipeline;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class RenderPass
{
	private LogicalDevice logicalDevice;
	private DepthResource depthResource;
	private Mesh mesh;
	private DescriptorPool descriptorPool;
	private GraphicPipeline graphicsPipeline;
	
	private long renderPass;

	public RenderPass(LogicalDevice logicalDevice, DepthResource depthResource,
			GraphicPipeline graphicsPipeline, Mesh mesh, DescriptorPool descriptorPool)
	{
		this.logicalDevice = logicalDevice;
		this.depthResource = depthResource;
		this.mesh = mesh;
		this.descriptorPool = descriptorPool;
		this.graphicsPipeline = graphicsPipeline;
	}

	public void rebuildRenderPass(List<RenderCommandBuffer> commandBuffers)
	{
		IndexBuffer indexBuffer = mesh.getIndexBuffer();
		long[] vertexBuffers = new long[] {
				indexBuffer.getBufferId()
		};
		long[] offsets = {
				0
		};

		for (RenderCommandBuffer commandBuffer : commandBuffers)
		{
			commandBuffer.start();

			vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_GRAPHICS,
					graphicsPipeline.getId());

			// TODO decoupler ce code
			vkCmdBindVertexBuffers(commandBuffer.getVkCommandBuffer(), 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(commandBuffer.getVkCommandBuffer(), indexBuffer.getIndexBufferId(),
					0, VK_INDEX_TYPE_UINT32);
			// endTODO

			if (descriptorPool != null)
			{
				LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(descriptorPool.size());
				for (DescriptorSet descriptorSet : descriptorPool)
				{
					bDescriptorSet.put(descriptorSet.getId());
				}
				bDescriptorSet.flip();
				vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
						VK_PIPELINE_BIND_POINT_GRAPHICS, graphicsPipeline.getLayoutId(), 0,
						bDescriptorSet, null);
			}

			// TODO decoupler ce code
			vkCmdDrawIndexed(commandBuffer.getVkCommandBuffer(), indexBuffer.indexCount(), 1, 0, 0,
					0);
			// endTODO

			commandBuffer.end();
		}
	}

	public void load(SwapChainManager swapChain)
	{
		VkAttachmentDescription colorAttachment = VkAttachmentDescription.calloc();
		colorAttachment.format(swapChain.getColorDomain().getColorFormat());
		colorAttachment.samples(VK_SAMPLE_COUNT_1_BIT);
		colorAttachment.loadOp(VK_ATTACHMENT_LOAD_OP_CLEAR);
		colorAttachment.storeOp(VK_ATTACHMENT_STORE_OP_STORE);
		colorAttachment.stencilLoadOp(VK_ATTACHMENT_LOAD_OP_DONT_CARE);
		colorAttachment.stencilStoreOp(VK_ATTACHMENT_STORE_OP_DONT_CARE);
		colorAttachment.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
		colorAttachment.finalLayout(VK_IMAGE_LAYOUT_PRESENT_SRC_KHR);

		VkAttachmentReference.Buffer colorAttachmentRef = VkAttachmentReference.calloc(1);
		colorAttachmentRef.attachment(0);
		colorAttachmentRef.layout(VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL);

		VkAttachmentDescription depthAttachment = null;
		VkAttachmentReference depthAttachmentRef = null;
		if (depthResource != null)
		{
			depthAttachment = VkAttachmentDescription.calloc();
			depthAttachment.format(depthResource.getDepthFormat());
			depthAttachment.samples(VK_SAMPLE_COUNT_1_BIT);
			depthAttachment.loadOp(VK_ATTACHMENT_LOAD_OP_CLEAR);
			depthAttachment.storeOp(VK_ATTACHMENT_STORE_OP_DONT_CARE);
			depthAttachment.stencilLoadOp(VK_ATTACHMENT_LOAD_OP_DONT_CARE);
			depthAttachment.stencilStoreOp(VK_ATTACHMENT_STORE_OP_DONT_CARE);
			depthAttachment.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
			depthAttachment.finalLayout(VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL);

			depthAttachmentRef = VkAttachmentReference.calloc();
			depthAttachmentRef.attachment(1);
			depthAttachmentRef.layout(VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
		}

		VkSubpassDescription.Buffer subpass = VkSubpassDescription.calloc(1);
		subpass.pipelineBindPoint(VK_PIPELINE_BIND_POINT_GRAPHICS);
		subpass.colorAttachmentCount(1);
		subpass.pColorAttachments(colorAttachmentRef);
		subpass.pDepthStencilAttachment(depthAttachmentRef);

		VkSubpassDependency.Buffer dependency = VkSubpassDependency.calloc(1);
		dependency.srcSubpass(VK_SUBPASS_EXTERNAL);
		dependency.dstSubpass(0);
		dependency.srcStageMask(VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT);
		dependency.srcAccessMask(0);
		dependency.dstStageMask(VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT);
		dependency.dstAccessMask(
				VK_ACCESS_COLOR_ATTACHMENT_READ_BIT | VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT);

		int attachmentCount = 1;
		attachmentCount += depthAttachment != null ? 1 : 0;
		VkAttachmentDescription.Buffer attachments = VkAttachmentDescription
				.calloc(attachmentCount);
		attachments.put(colorAttachment);
		if (depthAttachment != null)
		{
			attachments.put(depthAttachment);
		}
		attachments.flip();

		VkRenderPassCreateInfo renderPassInfo = VkRenderPassCreateInfo.calloc();
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO);
		renderPassInfo.pAttachments(attachments);
		renderPassInfo.pSubpasses(subpass);
		renderPassInfo.pDependencies(dependency);

		long[] aRenderPass = new long[1];
		if (vkCreateRenderPass(logicalDevice.getVkDevice(), renderPassInfo, null,
				aRenderPass) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create render pass!");
		}
		renderPass = aRenderPass[0];

		if (depthAttachment != null) depthAttachment.free();
		if (depthAttachmentRef != null) depthAttachmentRef.free();
		attachments.free();
		dependency.free();
		renderPassInfo.free();
		subpass.free();
		colorAttachmentRef.free();
		colorAttachment.free();
	}

	public long getID()
	{
		return renderPass;
	}

	public void free()
	{
		vkDestroyRenderPass(logicalDevice.getVkDevice(), renderPass, null);
	}
}
