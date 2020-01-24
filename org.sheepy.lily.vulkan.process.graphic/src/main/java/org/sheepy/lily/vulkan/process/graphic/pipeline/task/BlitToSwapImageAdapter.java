package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.vulkan.VkImageBlit;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.graphic.IImageViewManager;
import org.sheepy.lily.vulkan.common.resource.IImageAdapter;
import org.sheepy.lily.vulkan.common.resource.image.VkImage;
import org.sheepy.lily.vulkan.common.resource.image.VkImage.VkImageBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

@Statefull
@Adapter(scope = BlitToSwapImage.class)
public class BlitToSwapImageAdapter
		implements IPipelineTaskAdapter<BlitToSwapImage>, IAllocableAdapter<IGraphicContext>
{
	private static final int FORMAT = EFormat.R8G8B8A8_UNORM_VALUE;
	private static final VkImage.Builder clearTextureBuilder = new VkImageBuilder(	1,
																					1,
																					FORMAT).usage(VK_IMAGE_USAGE_TRANSFER_SRC_BIT | VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_STORAGE_BIT).tiling(VK_IMAGE_TILING_OPTIMAL).mipLevels(1).copyImmutable();

	private final BlitToSwapImage blitTask;

	private long imagePtr;
	private VkImageBlit.Buffer region;
	private IImageViewManager imageViewManager;
	private VkImage clearTexture;
	private VkImageBlit.Buffer clearRegions;
	private IAllocationConfigurator config;

	public BlitToSwapImageAdapter(BlitToSwapImage blitTask)
	{
		this.blitTask = blitTask;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		this.config = config;
		final var imageViewManager = context.getImageViewManager();

		config.addDependencies(List.of(imageViewManager));
	}

	@NotifyChanged(featureIds = GraphicPackage.BLIT_TO_SWAP_IMAGE__IMAGE)
	private void imageChanged()
	{
		config.setDirty();
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		imageViewManager = context.getImageViewManager();
		final var extent = context.getSurfaceManager().getExtent();

		final var image = blitTask.getImage();
		final var imageAdapter = image.adaptNotNull(IImageAdapter.class);
		final var imageInfo = imageAdapter.getVkImage();

		imagePtr = imageAdapter.getImagePtr();

		final int viewWidth = extent.getWidth();
		final int viewHeight = extent.getHeight();
		final float scale = Math.min(	(float) viewWidth / imageInfo.width,
										(float) viewHeight / imageInfo.height);

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
				fillRegion(	clearRegions.get(1),
							1,
							1,
							0,
							yOffset + dstHeight,
							viewWidth,
							viewHeight);
			}
			else
			{
				clearRegions = VkImageBlit.calloc(1);
				fillRegion(clearRegions.get(0), 1, 1, 0, 0, viewWidth, 1);
			}
		}

		region = VkImageBlit.calloc(1);
		fillRegion(	region.get(0),
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
	public void free(IGraphicContext context)
	{
		region.free();

		if (clearTexture != null) clearTexture.free(context);
		if (clearRegions != null) clearRegions.free();

		clearTexture = null;
		clearRegions = null;
	}

	@Override
	public void record(BlitToSwapImage task, IRecordContext context)
	{
		final var swapImage = imageViewManager.getImageViews().get(context.index()).getImagePtr();
		final var transfertSrc = EImageLayout.TRANSFER_SRC_OPTIMAL_VALUE;
		final var transfertDst = EImageLayout.TRANSFER_DST_OPTIMAL_VALUE;
		final int filter = task.getFilter().getValue();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdBlitImage(	commandBuffer,
						imagePtr,
						transfertSrc,
						swapImage,
						transfertDst,
						region,
						filter);

		if (clearRegions != null)
		{
			vkCmdBlitImage(	commandBuffer,
							clearTexture.getPtr(),
							transfertSrc,
							swapImage,
							transfertDst,
							clearRegions,
							EFilter.NEAREST_VALUE);
		}
	}

	private static void fillRegion(	VkImageBlit region,
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
