package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.resource.ImageViewer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;

import java.util.List;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ImageViewer.class)
@Allocation(context = ExecutionContext.class)
public final class ImageViewerAllocation extends Notifier<IMemoryChunkPartAllocation.Features> implements
																							   IMemoryChunkPartAllocation,
																							   IVkImageAllocation
{
	private final VkImage imageBackend;
	private final VkImageView imageView;
	private final IImageDataProviderAdapter dataProviderAdapter;

	private boolean needPush = true;

	public ImageViewerAllocation(ImageViewer image,
								 ExecutionContext context,
								 IObservatoryBuilder observatory,
								 IAllocationState allocationState)
	{
		super(List.of(Features.PushRequest, Features.Attach));

		dataProviderAdapter = image.getDataProvider().adapt(IImageDataProviderAdapter.class);
		final var size = dataProviderAdapter.size();
		final var builder = new VkImageBuilder(image, size.x(), size.y());

		// TODO support mipMapping
		// if (image.isMipmapEnabled()) builder.computeMipLevels();

		imageBackend = builder.buildNoFill(context);
		imageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);

		final var dataProviderObservatory = observatory.explore(VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER)
													   .adaptNotifier(IImageDataProviderAdapter.class);
		dataProviderObservatory.listenNoParam(allocationState::setAllocationObsolete,
											  IImageDataProviderAdapter.Features.Size);
		dataProviderObservatory.listenNoParam(this::requestPush, IImageDataProviderAdapter.Features.Data);
	}

	private void requestPush()
	{
		needPush = true;
		notify(Features.PushRequest);
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageView.free(vkDevice);
		imageBackend.free(context);
	}

	@Override
	public void registerMemory(final MemoryBuilder memoryBuilder)
	{
		memoryBuilder.registerImage(imageBackend.getPtr(), this::bindMemory);
	}

	public void bindMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		imageBackend.bindMemory(vkDevice, memoryPtr, offset, size);
		imageView.allocate(vkDevice, imageBackend);
	}

	@Override
	public Stream<FillCommand> streamFillCommands(boolean force)
	{
		if (needPush || force)
		{
			needPush = false;
			final var fillCommand = new FillCommand.FillImageCommand(dataProviderAdapter::fill, imageBackend, 0);
			return Stream.of(fillCommand);
		}
		else
		{
			return Stream.empty();
		}
	}

//	private void generateMipmaps(VkCommandBuffer commandBuffer, ImageLayout targetLayout)
//	{
//		final long imageAddress = image.getPtr();
//
//		final VkImageMemoryBarrier.Buffer barrier = VkImageMemoryBarrier.calloc(1);
//		barrier.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
//		barrier.image(imageAddress);
//		barrier.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
//		barrier.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
//		barrier.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
//		barrier.subresourceRange().baseArrayLayer(0);
//		barrier.subresourceRange().layerCount(1);
//		barrier.subresourceRange().levelCount(1);
//
//		int mipWidth = image.width;
//		int mipHeight = image.height;
//
//		for (int i = 1; i < image.mipLevels; i++)
//		{
//			barrier.subresourceRange().baseMipLevel(i - 1);
//			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
//			barrier.newLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
//			barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
//			barrier.dstAccessMask(VK_ACCESS_TRANSFER_READ_BIT);
//
//			vkCmdPipelineBarrier(commandBuffer,
//								 VK_PIPELINE_STAGE_TRANSFER_BIT,
//								 VK_PIPELINE_STAGE_TRANSFER_BIT,
//								 0,
//								 null,
//								 null,
//								 barrier);
//
//			final VkOffset3D.Buffer srcOffsets = VkOffset3D.calloc(2);
//			srcOffsets.get(0).set(0, 0, 0);
//			srcOffsets.get(1).set(mipWidth, mipHeight, 1);
//
//			final VkOffset3D.Buffer dstOffsets = VkOffset3D.calloc(2);
//			dstOffsets.get(0).set(0, 0, 0);
//			dstOffsets.get(1).set(mipWidth / 2, mipHeight / 2, 1);
//
//			final VkImageBlit.Buffer blit = VkImageBlit.calloc(1);
//			blit.srcOffsets(srcOffsets);
//			blit.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
//			blit.srcSubresource().mipLevel(i - 1);
//			blit.srcSubresource().baseArrayLayer(0);
//			blit.srcSubresource().layerCount(1);
//			blit.dstOffsets(dstOffsets);
//			blit.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
//			blit.dstSubresource().mipLevel(i);
//			blit.dstSubresource().baseArrayLayer(0);
//			blit.dstSubresource().layerCount(1);
//
//			vkCmdBlitImage(commandBuffer,
//						   imageAddress,
//						   VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL,
//						   imageAddress,
//						   VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL,
//						   blit,
//						   VK_FILTER_LINEAR);
//
//			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
//			barrier.newLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
//			barrier.srcAccessMask(VK_ACCESS_TRANSFER_READ_BIT);
//			barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);
//
//			vkCmdPipelineBarrier(commandBuffer,
//								 VK_PIPELINE_STAGE_TRANSFER_BIT,
//								 VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT,
//								 0,
//								 null,
//								 null,
//								 barrier);
//
//			if (mipWidth > 1) mipWidth /= 2;
//			if (mipHeight > 1) mipHeight /= 2;
//
//			blit.free();
//		}
//
//		final int trgAccess;
//		final int trgStage;
//		final int trgLayout;
//		if (targetLayout != null)
//		{
//			trgAccess = VulkanModelUtil.getEnumeratedFlag(targetLayout.getAccessMask());
//			trgStage = targetLayout.getStage().getValue();
//			trgLayout = targetLayout.getLayout().getValue();
//		}
//		else
//		{
//			trgAccess = EAccess.SHADER_READ_BIT_VALUE;
//			trgStage = EPipelineStage.FRAGMENT_SHADER_BIT_VALUE;
//			trgLayout = EImageLayout.SHADER_READ_ONLY_OPTIMAL_VALUE;
//		}
//
//		barrier.subresourceRange().baseMipLevel(image.mipLevels - 1);
//		barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
//		barrier.newLayout(trgLayout);
//		barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
//		barrier.dstAccessMask(trgAccess);
//
//		vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT, trgStage, 0, null, null, barrier);
//
//		barrier.free();
//	}

	@Override
	public long getImagePtr()
	{
		return imageBackend.getPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return imageBackend.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend;
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width, vkImage.height);
	}
}
