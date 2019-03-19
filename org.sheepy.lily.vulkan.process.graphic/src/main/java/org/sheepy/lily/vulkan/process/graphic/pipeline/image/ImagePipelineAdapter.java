package org.sheepy.lily.vulkan.process.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkImageBlit;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewManager;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.resource.image.ImageAdapter;

@Statefull
@Adapter(scope = ImagePipeline.class)
public class ImagePipelineAdapter extends AbstractPipelineAdapter<GraphicCommandBuffer>
{
	private final ImagePipeline imagePipeline;

	private VkImageBlit.Buffer region;

	private InitialImagePipelineBarrier[] initialBarriers;
	private FinalImagePipelineBarrier[] finalBarriers;

	private ImageViewManager imageViewManager;

	public ImagePipelineAdapter(ImagePipeline imagePipeline)
	{
		super(imagePipeline);
		this.imagePipeline = imagePipeline;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		var graphicContext = (GraphicContext) context;
		var extent = graphicContext.surfaceManager.getExtent();
		var srcImage = imagePipeline.getImage();
		var swapChainManager = graphicContext.swapChainManager;

		imageViewManager = graphicContext.imageViewManager;
		allocationDependencies.add(swapChainManager);

		region = VkImageBlit.calloc(1);
		region.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.srcSubresource().mipLevel(0);
		region.srcSubresource().baseArrayLayer(0);
		region.srcSubresource().layerCount(1);
		region.srcOffsets(0).x(0);
		region.srcOffsets(0).y(0);
		region.srcOffsets(0).z(0);
		region.srcOffsets(1).x(srcImage.getWidth());
		region.srcOffsets(1).y(srcImage.getHeight());
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

		int size = graphicContext.commandBuffers.size();
		initialBarriers = new InitialImagePipelineBarrier[size];
		for (int i = 0; i < size; i++)
		{
			var view = imageViewManager.getImageView(i);
			initialBarriers[i] = new InitialImagePipelineBarrier(imagePipeline, view);
			initialBarriers[i].allocate(stack, context);
		}
		finalBarriers = new FinalImagePipelineBarrier[size];
		for (int i = 0; i < size; i++)
		{
			finalBarriers[i] = new FinalImagePipelineBarrier(imagePipeline);
			finalBarriers[i].allocate(stack, context);
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		for (int i = 0; i < initialBarriers.length; i++)
		{
			initialBarriers[i].free(context);
			finalBarriers[i].free(context);
		}

		initialBarriers = null;
		finalBarriers = null;

		region.free();
		region = null;

		super.free(context);
	}

	@Override
	public void record(GraphicCommandBuffer commandBuffer, int bindPoint)
	{
		var srcImage = imagePipeline.getImage();
		var srcImageId = ImageAdapter.adapt(srcImage).getAddress();
		var dstImageView = imageViewManager.getImageView(commandBuffer.index);
		var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

		initialBarriers[commandBuffer.index].execute(vkCommandBuffer);

		long bltSrcImage = srcImageId;
		long bltDstImage = dstImageView.getImageAddress();

		vkCmdBlitImage(vkCommandBuffer, bltSrcImage, VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL,
				bltDstImage, VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, region, VK_FILTER_NEAREST);

		finalBarriers[commandBuffer.index].execute(vkCommandBuffer);
	}

	@Override
	public AbstractConstants getConstants()
	{
		return imagePipeline.getConstants();
	}

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		return List.of();
	}

	@Override
	public boolean isRecordNeeded()
	{
		return false;
	}

	public static ImagePipelineAdapter adapt(ImagePipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ImagePipelineAdapter.class);
	}
}
