package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.vulkan.VkImageBlit;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.util.ModelDependencyInjector;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImage.VkImageBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.AbstractBlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.vulkan.model.enumeration.*;
import org.sheepy.vulkan.model.image.ImageFactory;

import static org.lwjgl.vulkan.VK10.*;

@Statefull
public abstract class AbstractBlitTaskAdapter implements IPipelineTaskAdapter<AbstractBlitTask>,
														 IAllocableAdapter<GraphicContext>
{
	private static final int FORMAT = EFormat.R8G8B8A8_UNORM_VALUE;
	private static final VkImage.Builder clearTextureBuilder = new VkImageBuilder(1, 1, FORMAT).usage(
			VK_IMAGE_USAGE_TRANSFER_SRC_BIT | VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_STORAGE_BIT)
																							   .tiling(VK_IMAGE_TILING_OPTIMAL)
																							   .mipLevels(1)
																							   .copyImmutable();

	private final AbstractBlitTask blitTask;
	private final ModelDependencyInjector dependencyInjector;

	private long srcImagePtr;
	private VkImageBlit.Buffer region;
	private VkImage clearTexture;
	private VkImageBlit.Buffer clearRegions;

	public AbstractBlitTaskAdapter(AbstractBlitTask blitTask)
	{
		this.blitTask = blitTask;
		dependencyInjector = new ModelDependencyInjector(blitTask,
														 GraphicPackage.Literals.ABSTRACT_BLIT_TASK__SRC_IMAGE);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		dependencyInjector.start(config);
	}

	@Dispose
	private void dispose()
	{
		dependencyInjector.stop();
	}

	@Override
	public void allocate(GraphicContext context)
	{
		final var dstSize = getDtImageSize(context);

		final var srcImage = blitTask.getSrcImage();
		final var imageAdapter = srcImage.adaptNotNull(IVkImageAdapter.class);
		final var imageInfo = imageAdapter.getVkImage();

		srcImagePtr = imageAdapter.getImagePtr();

		final int viewWidth = dstSize.x();
		final int viewHeight = dstSize.y();
		final float scale = Math.min((float) viewWidth / imageInfo.width, (float) viewHeight / imageInfo.height);

		final int dstWidth = (int) (scale * imageInfo.width);
		final int dstHeight = (int) (scale * imageInfo.height);

		int xOffset = 0;
		int yOffset = 0;
		if (dstWidth < viewWidth)
		{
			xOffset = (viewWidth - dstWidth) / 2;

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
		if (dstHeight < viewHeight)
		{
			yOffset = (viewHeight - dstHeight) / 2;

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

		region = VkImageBlit.calloc(1);
		fillRegion(region.get(0),
				   imageInfo.width,
				   imageInfo.height,
				   xOffset,
				   yOffset,
				   xOffset + dstWidth,
				   yOffset + dstHeight);

		if (clearRegions != null)
		{
			final var clearColor = blitTask.getClearColor();
			final int intColor = clearColor.x() + (clearColor.y() << 8) + (clearColor.z() << 16);
			final var buffer = BufferUtils.createByteBuffer(4);
			buffer.putInt(intColor);
			buffer.flip();

			final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
			initialLayout.setLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
			initialLayout.getAccessMask().add(EAccess.TRANSFER_READ_BIT);
			initialLayout.setStage(EPipelineStage.TRANSFER_BIT);

			final VkImageBuilder builder = new VkImageBuilder(clearTextureBuilder);
			builder.fillWith(buffer);
			builder.initialLayout(initialLayout);
			clearTexture = builder.build();
			clearTexture.allocate(context);
		}
	}

	@Override
	public void free(GraphicContext context)
	{
		region.free();

		if (clearTexture != null) clearTexture.free(context);
		if (clearRegions != null) clearRegions.free();

		clearTexture = null;
		clearRegions = null;
	}

	@Override
	public void record(AbstractBlitTask task, IRecordContext context)
	{
		final var dstImagePtr = getDstImagePtr(context);
		final var transfertSrc = EImageLayout.TRANSFER_SRC_OPTIMAL_VALUE;
		final var transfertDst = EImageLayout.TRANSFER_DST_OPTIMAL_VALUE;
		final int filter = task.getFilter().getValue();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

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
	}

	protected abstract long getDstImagePtr(IRecordContext context);
	protected abstract Vector2ic getDtImageSize(final IGraphicContext context);

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
