package org.sheepy.vulkan.resource.texture;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageBlit;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkOffset3D;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.resource.AbstractTexture;
import org.sheepy.vulkan.model.resource.Sampler;
import org.sheepy.vulkan.model.resource.Texture;
import org.sheepy.vulkan.model.resource.impl.SamplerImpl;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferBackend;
import org.sheepy.vulkan.resource.image.AbstractSampledResourceAdapter;
import org.sheepy.vulkan.resource.image.ImageBackend;

public abstract class AbstractTextureAdapter extends AbstractSampledResourceAdapter
{
	private int mipLevels;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final AbstractTexture texture = (Texture) target;
		Sampler samplerInfos = texture.getSampler();
		if (samplerInfos == null)
		{
			samplerInfos = new SamplerImpl();
			texture.setSampler(samplerInfos);
		}

		int width = getWidth();
		int height = getHeight();
		mipLevels = 1;
		if (texture.isMipmapEnabled())
			mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);
		samplerInfos.setMaxLod(Math.max(mipLevels, samplerInfos.getMaxLod()));

		super.flatAllocate(stack);
	}

	@Override
	protected void loadImage(MemoryStack stack, ImageBackend imageBackend)
	{
		final var context = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		final var logicalDevice = context.getLogicalDevice();
		final int stagingUsage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		int width = getWidth();
		int height = getHeight();

		var data = allocDataBuffer();
		int size = width * height * 4;

		final BufferBackend buffer = BufferAllocator.allocateCPUBufferAndFill(stack, logicalDevice,
				size, stagingUsage, data);

		final SingleTimeCommand stc = new SingleTimeCommand(context)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				imageBackend.transitionImageLayout(commandBuffer, EPipelineStage.TOP_OF_PIPE_BIT,
						EPipelineStage.TRANSFER_BIT, EImageLayout.UNDEFINED,
						EImageLayout.TRANSFER_DST_OPTIMAL, 0, VK_ACCESS_TRANSFER_WRITE_BIT);

				imageBackend.fillWithBuffer(commandBuffer, buffer.getId());

				generateMipmaps(commandBuffer, imageBackend.getId());
			}
		};
		stc.execute();

		MemoryUtil.memFree(data);
	}

	@Override
	protected int getFormat()
	{
		return VK_FORMAT_R8G8B8A8_UNORM;
	}

	@Override
	protected int getUsage()
	{
		return VK_IMAGE_USAGE_TRANSFER_SRC_BIT
				| VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT;
	}

	@Override
	protected int getMipLevels()
	{
		return mipLevels;
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0; // or throw exception
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	private void generateMipmaps(VkCommandBuffer commandBuffer, long image)
	{
		final VkImageMemoryBarrier.Buffer barrier = VkImageMemoryBarrier.calloc(1);
		barrier.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrier.image(image);
		barrier.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		barrier.subresourceRange().baseArrayLayer(0);
		barrier.subresourceRange().layerCount(1);
		barrier.subresourceRange().levelCount(1);

		int mipWidth = getWidth();
		int mipHeight = getHeight();

		for (int i = 1; i < mipLevels; i++)
		{
			barrier.subresourceRange().baseMipLevel(i - 1);
			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
			barrier.newLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
			barrier.dstAccessMask(VK_ACCESS_TRANSFER_READ_BIT);

			vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
					VK_PIPELINE_STAGE_TRANSFER_BIT, 0, null, null, barrier);

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

			vkCmdBlitImage(commandBuffer, image, VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL, image,
					VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, blit, VK_FILTER_LINEAR);

			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
			barrier.newLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_READ_BIT);
			barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);

			vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
					VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT, 0, null, null, barrier);

			if (mipWidth > 1) mipWidth /= 2;
			if (mipHeight > 1) mipHeight /= 2;

			blit.free();
		}

		barrier.subresourceRange().baseMipLevel(mipLevels - 1);
		barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
		barrier.newLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
		barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
		barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);

		vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
				VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT, 0, null, null, barrier);

		barrier.free();
	}

	public static AbstractTextureAdapter adapt(AbstractTexture texture)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(texture, AbstractTextureAdapter.class);
	}

	protected abstract ByteBuffer allocDataBuffer();
}
