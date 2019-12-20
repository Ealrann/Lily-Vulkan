package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.vulkan.VkImageBlit;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IImageViewManager;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@Statefull
@Adapter(scope = BlitToSwapImage.class)
public class BlitToSwapImageAdapter
		implements IPipelineTaskAdapter<BlitToSwapImage>, IAllocableAdapter<IGraphicContext>
{
	private final BlitToSwapImage blitTask;

	private long imagePtr;
	private VkImageBlit.Buffer region;
	private IImageViewManager imageViewManager;

	public BlitToSwapImageAdapter(BlitToSwapImage blitTask)
	{
		this.blitTask = blitTask;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		final var imageViewManager = context.getImageViewManager();

		config.addDependencies(List.of(imageViewManager));
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

		region = VkImageBlit.calloc(1);
		region.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.srcSubresource().mipLevel(0);
		region.srcSubresource().baseArrayLayer(0);
		region.srcSubresource().layerCount(1);
		region.srcOffsets(0).x(0);
		region.srcOffsets(0).y(0);
		region.srcOffsets(0).z(0);
		region.srcOffsets(1).x(imageInfo.width);
		region.srcOffsets(1).y(imageInfo.height);
		region.srcOffsets(1).z(1);
		region.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.dstSubresource().mipLevel(0);
		region.dstSubresource().baseArrayLayer(0);
		region.dstSubresource().layerCount(1);
		region.dstOffsets(0).x(0);
		region.dstOffsets(0).y(0);
		region.dstOffsets(0).z(0);
		region.dstOffsets(1).x(extent.getWidth());
		region.dstOffsets(1).y(extent.getHeight());
		region.dstOffsets(1).z(1);
	}

	@Override
	public void free(IGraphicContext context)
	{
		region.free();
	}

	@Override
	public void record(BlitToSwapImage task, RecordContext context)
	{
		final var swapImage = imageViewManager.getImageViews().get(context.index).getImagePtr();
		final var transfertSrc = EImageLayout.TRANSFER_SRC_OPTIMAL_VALUE;
		final var transfertDst = EImageLayout.TRANSFER_DST_OPTIMAL_VALUE;
		final var commandBuffer = context.commandBuffer;
		final int filter = task.getFilter().getValue();

		vkCmdBlitImage(	commandBuffer,
						imagePtr,
						transfertSrc,
						swapImage,
						transfertDst,
						region,
						filter);
	}
}
