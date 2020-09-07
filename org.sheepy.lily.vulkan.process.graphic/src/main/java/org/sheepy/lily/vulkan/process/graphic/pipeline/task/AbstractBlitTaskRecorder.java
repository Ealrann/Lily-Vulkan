package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkImageBlit;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.ImageBackend;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.AbstractBlitTask;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import static org.lwjgl.vulkan.VK10.*;

public abstract class AbstractBlitTaskRecorder implements IRecordableExtender
{
	private static final int FORMAT = EFormat.R8G8B8A8_UNORM_VALUE;
	private static final IVkImageBuilder clearTextureBuilder = new VkImageBuilder("BlitClearTexture",
																				  1,
																				  1,
																				  FORMAT).usage(
			VK_IMAGE_USAGE_TRANSFER_SRC_BIT | VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_STORAGE_BIT)
																						 .tiling(VK_IMAGE_TILING_OPTIMAL)
																						 .mipLevels(1)
																						 .copyImmutable();

	private final long srcImagePtr;
	private final VkImageBlit.Buffer clearRegions;
	private final VkImageBlit.Buffer region;
	private final ImageBackend clearTexture;
	private final AbstractBlitTask blitTask;
	private final IAllocationState allocationState;

	public AbstractBlitTaskRecorder(AbstractBlitTask blitTask,
									IAllocationState allocationState,
									ProcessContext context,
									IVkImageAllocation srcImage,
									Vector2ic dstSize)
	{
		this.blitTask = blitTask;
		this.allocationState = allocationState;
		final var imageInfo = srcImage.getVkImage();

		srcImagePtr = srcImage.getImagePtr();

		final int viewWidth = dstSize.x();
		final int viewHeight = dstSize.y();
		final float scale = Math.min((float) viewWidth / imageInfo.width(), (float) viewHeight / imageInfo.height());

		final int dstWidth = Math.round(scale * imageInfo.width());
		final int dstHeight = Math.round(scale * imageInfo.height());

		int xOffset = 0;
		int yOffset = 0;
		if (dstWidth < viewWidth)
		{
			xOffset = Math.round((viewWidth - dstWidth) / 2f);

			if (xOffset >= 2)
			{
				clearRegions = VkImageBlit.calloc(2);
				fillRegion(clearRegions.get(0), 1, 1, 0, 0, xOffset, viewHeight);
				fillRegion(clearRegions.get(1), 1, 1, xOffset + dstWidth, 0, viewWidth, viewHeight);
			}
			else
			{
				clearRegions = VkImageBlit.calloc(1);
				fillRegion(clearRegions.get(0), 1, 1, 0, 0, 1, viewHeight);
			}
		}
		else if (dstHeight < viewHeight)
		{
			yOffset = Math.round((viewHeight - dstHeight) / 2f);

			if (yOffset >= 2)
			{
				clearRegions = VkImageBlit.calloc(2);
				fillRegion(clearRegions.get(0), 1, 1, 0, 0, viewWidth, yOffset);
				fillRegion(clearRegions.get(1), 1, 1, 0, yOffset + dstHeight, viewWidth, viewHeight);
			}
			else
			{
				clearRegions = VkImageBlit.calloc(1);
				fillRegion(clearRegions.get(0), 1, 1, 0, 0, viewWidth, 1);
			}
		}
		else
		{
			clearRegions = null;
		}

		region = VkImageBlit.calloc(1);
		fillRegion(region.get(0),
				   imageInfo.width(),
				   imageInfo.height(),
				   xOffset,
				   yOffset,
				   xOffset + dstWidth,
				   yOffset + dstHeight);

		if (clearRegions != null)
		{
			final var stack = context.stack();
			final var clearColor = blitTask.getClearColor();
			final int intColor = clearColor.x() + (clearColor.y() << 8) + (clearColor.z() << 16);
			final var buffer = stack.malloc(4);
			buffer.putInt(intColor);
			buffer.flip();

			final var builder = clearTextureBuilder.copy();
			builder.fillWith(buffer);
			builder.initialLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);

			clearTexture = context.executeFunction(builder::build);
		}
		else
		{
			clearTexture = null;
		}
	}

	@Free
	public void free(ProcessContext context)
	{
		region.free();

		if (clearTexture != null) clearTexture.free(context);
		if (clearRegions != null) clearRegions.free();
	}

	@Override
	public void record(RecordContext context)
	{
		final var dstImagePtr = getDstImagePtr(context.index());
		final var transfertSrc = EImageLayout.TRANSFER_SRC_OPTIMAL_VALUE;
		final var transfertDst = EImageLayout.TRANSFER_DST_OPTIMAL_VALUE;
		final int filter = blitTask.getFilter().getValue();
		final var commandBuffer = context.commandBuffer;

		vkCmdBlitImage(commandBuffer, srcImagePtr, transfertSrc, dstImagePtr, transfertDst, region, filter);

		if (clearRegions != null)
		{
			vkCmdBlitImage(commandBuffer,
						   clearTexture.getPtr(),
						   transfertSrc,
						   dstImagePtr,
						   transfertDst,
						   clearRegions,
						   EFilter.NEAREST_VALUE);
		}

		context.lockAllocationDuringExecution(allocationState);
	}

	protected abstract long getDstImagePtr(int index);

	protected static void fillRegion(VkImageBlit region,
									 final int srcWidth,
									 final int srcHeight,
									 int dstX1,
									 int dstY1,
									 int dstX2,
									 int dstY2)
	{
		region.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.srcSubresource().mipLevel(0);
		region.srcSubresource().baseArrayLayer(0);
		region.srcSubresource().layerCount(1);
		region.srcOffsets(0).x(0);
		region.srcOffsets(0).y(0);
		region.srcOffsets(0).z(0);
		region.srcOffsets(1).x(srcWidth);
		region.srcOffsets(1).y(srcHeight);
		region.srcOffsets(1).z(1);
		region.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.dstSubresource().mipLevel(0);
		region.dstSubresource().baseArrayLayer(0);
		region.dstSubresource().layerCount(1);
		region.dstOffsets(0).x(dstX1);
		region.dstOffsets(0).y(dstY1);
		region.dstOffsets(0).z(0);
		region.dstOffsets(1).x(dstX2);
		region.dstOffsets(1).y(dstY2);
		region.dstOffsets(1).z(1);
	}
}
