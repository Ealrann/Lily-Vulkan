package test.vulkan.mesh;

import static org.lwjgl.vulkan.KHRSwapchain.VK_IMAGE_LAYOUT_PRESENT_SRC_KHR;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkRenderPassCreateInfo;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.sheepy.vulkan.pipeline.graphic.GraphicContext;
import org.sheepy.vulkan.pipeline.graphic.IRenderPass;

public class MeshRenderPass implements IRenderPass
{
	private GraphicContext context;

	private long renderPass;

	@Override
	public void bindContext(GraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		VkAttachmentDescription colorAttachment = VkAttachmentDescription.callocStack(stack);
		colorAttachment.format(context.swapChainManager.getColorDomain().getColorFormat());
		colorAttachment.samples(VK_SAMPLE_COUNT_1_BIT);
		colorAttachment.loadOp(VK_ATTACHMENT_LOAD_OP_CLEAR);
		colorAttachment.storeOp(VK_ATTACHMENT_STORE_OP_STORE);
		colorAttachment.stencilLoadOp(VK_ATTACHMENT_LOAD_OP_DONT_CARE);
		colorAttachment.stencilStoreOp(VK_ATTACHMENT_STORE_OP_DONT_CARE);
		colorAttachment.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
		colorAttachment.finalLayout(VK_IMAGE_LAYOUT_PRESENT_SRC_KHR);

		VkAttachmentReference.Buffer colorAttachmentRef = VkAttachmentReference.callocStack(1,
				stack);
		colorAttachmentRef.attachment(0);
		colorAttachmentRef.layout(VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL);

		VkAttachmentDescription depthAttachment = null;
		VkAttachmentReference depthAttachmentRef = null;
		if (context.depthResource != null)
		{
			depthAttachment = VkAttachmentDescription.callocStack(stack);
			depthAttachment.format(context.depthResource.getDepthFormat());
			depthAttachment.samples(VK_SAMPLE_COUNT_1_BIT);
			depthAttachment.loadOp(VK_ATTACHMENT_LOAD_OP_CLEAR);
			depthAttachment.storeOp(VK_ATTACHMENT_STORE_OP_DONT_CARE);
			depthAttachment.stencilLoadOp(VK_ATTACHMENT_LOAD_OP_DONT_CARE);
			depthAttachment.stencilStoreOp(VK_ATTACHMENT_STORE_OP_DONT_CARE);
			depthAttachment.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
			depthAttachment.finalLayout(VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL);

			depthAttachmentRef = VkAttachmentReference.callocStack(stack);
			depthAttachmentRef.attachment(1);
			depthAttachmentRef.layout(VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
		}

		VkSubpassDescription.Buffer subpass = VkSubpassDescription.callocStack(1, stack);
		subpass.pipelineBindPoint(VK_PIPELINE_BIND_POINT_GRAPHICS);
		subpass.colorAttachmentCount(1);
		subpass.pColorAttachments(colorAttachmentRef);
		subpass.pDepthStencilAttachment(depthAttachmentRef);

		VkSubpassDependency.Buffer dependency = VkSubpassDependency.callocStack(1, stack);
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
				.callocStack(attachmentCount, stack);
		attachments.put(colorAttachment);
		if (depthAttachment != null)
		{
			attachments.put(depthAttachment);
		}
		attachments.flip();

		VkRenderPassCreateInfo renderPassInfo = VkRenderPassCreateInfo.callocStack(stack);
		renderPassInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO);
		renderPassInfo.pAttachments(attachments);
		renderPassInfo.pSubpasses(subpass);
		renderPassInfo.pDependencies(dependency);

		long[] aRenderPass = new long[1];
		if (vkCreateRenderPass(context.logicalDevice.getVkDevice(), renderPassInfo, null,
				aRenderPass) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create render pass!");
		}
		renderPass = aRenderPass[0];
	}

	@Override
	public long getId()
	{
		return renderPass;
	}

	@Override
	public void free()
	{
		vkDestroyRenderPass(context.logicalDevice.getVkDevice(), renderPass, null);
	}
}
