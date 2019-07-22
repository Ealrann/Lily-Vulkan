package org.sheepy.lily.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageBlit;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkOffset3D;
import org.sheepy.lily.vulkan.model.resource.ImageLayout;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageView;
import org.sheepy.vulkan.util.VkModelUtil;

public class VkTexture implements IAllocable<IExecutionContext>
{
	private final VkImage image;

	private VkImageView imageView;

	public VkTexture(VkImage.Builder imageBuilder)
	{
		final var builder = new VkImage.VkImageBuilder(imageBuilder.copyImmutable());
		builder.addUsage(VK_IMAGE_USAGE_SAMPLED_BIT);
		image = builder.build();
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		image.allocate(stack, context);
		final var imageAddress = image.getPtr();

		imageView = new VkImageView(logicalDevice.getVkDevice());

		imageView.allocate(imageAddress, image.mipLevels, image.format, VK_IMAGE_ASPECT_COLOR_BIT);
	}

	public void loadImage(	MemoryStack stack,
							IExecutionContext executionContext,
							ByteBuffer data,
							ImageLayout targetLayout)
	{
		final int stagingUsage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final List<EAccess> srcAccessMask = List.of();
		final List<EAccess> dstAccessMask = List.of(EAccess.TRANSFER_WRITE_BIT);
		final int size = image.width * image.height * 4;

		final var buffer = BufferAllocator.allocateCPUBufferAndFill(stack, executionContext, size, stagingUsage, false,
				data);

		executionContext.execute(stack, (MemoryStack stack2, VkCommandBuffer commandBuffer) ->
		{
			image.transitionImageLayout(stack2, commandBuffer, EPipelineStage.TOP_OF_PIPE_BIT,
					EPipelineStage.TRANSFER_BIT, EImageLayout.UNDEFINED, EImageLayout.TRANSFER_DST_OPTIMAL,
					srcAccessMask, dstAccessMask);
			image.fillWithBuffer(commandBuffer, buffer.getAddress());
			generateMipmaps(commandBuffer, targetLayout);
		});

		buffer.free(executionContext);
	}

	private void generateMipmaps(VkCommandBuffer commandBuffer, ImageLayout targetLayout)
	{
		final long imageAddress = image.getPtr();

		final VkImageMemoryBarrier.Buffer barrier = VkImageMemoryBarrier.calloc(1);
		barrier.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrier.image(imageAddress);
		barrier.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		barrier.subresourceRange().baseArrayLayer(0);
		barrier.subresourceRange().layerCount(1);
		barrier.subresourceRange().levelCount(1);

		int mipWidth = image.width;
		int mipHeight = image.height;

		for (int i = 1; i < image.mipLevels; i++)
		{
			barrier.subresourceRange().baseMipLevel(i - 1);
			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
			barrier.newLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
			barrier.dstAccessMask(VK_ACCESS_TRANSFER_READ_BIT);

			vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT, VK_PIPELINE_STAGE_TRANSFER_BIT, 0, null,
					null, barrier);

			final VkOffset3D.Buffer srcOffsets = VkOffset3D.calloc(2);
			srcOffsets.get(0).set(0, 0, 0);
			srcOffsets.get(1).set(mipWidth, mipHeight, 1);

			final VkOffset3D.Buffer dstOffsets = VkOffset3D.calloc(2);
			dstOffsets.get(0).set(0, 0, 0);
			dstOffsets.get(1).set(mipWidth / 2, mipHeight / 2, 1);

			final VkImageBlit.Buffer blit = VkImageBlit.calloc(1);
			blit.srcOffsets(srcOffsets);
			blit.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
			blit.srcSubresource().mipLevel(i - 1);
			blit.srcSubresource().baseArrayLayer(0);
			blit.srcSubresource().layerCount(1);
			blit.dstOffsets(dstOffsets);
			blit.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
			blit.dstSubresource().mipLevel(i);
			blit.dstSubresource().baseArrayLayer(0);
			blit.dstSubresource().layerCount(1);

			vkCmdBlitImage(commandBuffer, imageAddress, VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL, imageAddress,
					VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, blit, VK_FILTER_LINEAR);

			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
			barrier.newLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_READ_BIT);
			barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);

			vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT, VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT,
					0, null, null, barrier);

			if (mipWidth > 1) mipWidth /= 2;
			if (mipHeight > 1) mipHeight /= 2;

			blit.free();
		}

		int trgAccess;
		int trgStage;
		int trgLayout;

		if (targetLayout != null)
		{
			trgAccess = VkModelUtil.getEnumeratedFlag(targetLayout.getAccessMask());
			trgStage = targetLayout.getStage().getValue();
			trgLayout = targetLayout.getLayout().getValue();
		}
		else
		{
			trgAccess = EAccess.SHADER_READ_BIT_VALUE;
			trgStage = EPipelineStage.FRAGMENT_SHADER_BIT_VALUE;
			trgLayout = EImageLayout.SHADER_READ_ONLY_OPTIMAL_VALUE;
		}

		barrier.subresourceRange().baseMipLevel(image.mipLevels - 1);
		barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
		barrier.newLayout(trgLayout);
		barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
		barrier.dstAccessMask(trgAccess);

		vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT, trgStage, 0, null, null, barrier);

		barrier.free();
	}

	public long getImagePtr()
	{
		return image.getPtr();
	}

	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	public long getMemoryPtr()
	{
		return image.getMemoryPtr();
	}

	public VkImage getImage()
	{
		return image;
	}

	@Override
	public void free(IExecutionContext context)
	{
		imageView.free();
		image.free(context);

		imageView = null;
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}
}
