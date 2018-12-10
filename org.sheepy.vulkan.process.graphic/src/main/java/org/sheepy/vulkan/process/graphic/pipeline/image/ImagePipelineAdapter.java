package org.sheepy.vulkan.process.graphic.pipeline.image;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkImageBlit;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.vulkan.process.graphic.process.IGraphicContextAdapter;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager;
import org.sheepy.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.vulkan.resource.image.ImageAdapter;

public class ImagePipelineAdapter extends IPipelineAdapter<GraphicCommandBuffer>
{
	private VkImageBlit.Buffer region;

	private InitialImagePipelineBarrier[] initialBarriers;
	private FinalImagePipelineBarrier finalBarrier;
	private SwapChainManager swapChainManager;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		super.deepAllocate(stack);

		var context = IGraphicContextAdapter.adapt(target).getGraphicContext(target);
		var extent = context.swapChainManager.getExtent();
		var pipeline = (ImagePipeline) target;
		var srcImage = pipeline.getImage();

		swapChainManager = context.swapChainManager;
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

		int size = context.commandBuffers.size();
		initialBarriers = new InitialImagePipelineBarrier[size];
		for (int i = 0; i < size; i++)
		{
			var dstImageView = context.imageViewManager.getImageView(i);
			initialBarriers[i] = new InitialImagePipelineBarrier(pipeline, dstImageView);
			initialBarriers[i].allocate(stack);
		}

		finalBarrier = new FinalImagePipelineBarrier(pipeline);
		finalBarrier.allocate(stack);
	}

	@Override
	public void free()
	{
		for (int i = 0; i < initialBarriers.length; i++)
		{
			initialBarriers[i].free();
		}

		finalBarrier.free();
		region.free();
		super.free();
	}

	@Override
	public void record(GraphicCommandBuffer commandBuffer, int bindPoint)
	{
		var context = IGraphicContextAdapter.adapt(target).getGraphicContext(target);
		var pipeline = (ImagePipeline) target;
		var srcImage = pipeline.getImage();
		var srcImageId = ImageAdapter.adapt(srcImage).getId();
		var dstImageView = context.imageViewManager.getImageView(commandBuffer.index);
		var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

		initialBarriers[commandBuffer.index].execute(vkCommandBuffer);

		long bltSrcImage = srcImageId;
		long bltDstImage = dstImageView.getImageId();

		vkCmdBlitImage(vkCommandBuffer, bltSrcImage, VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL,
				bltDstImage, VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, region, VK_FILTER_NEAREST);

		finalBarrier.execute(vkCommandBuffer);
	}

	@Override
	protected AbstractConstants getConstants()
	{
		return ((ImagePipeline) target).getConstants();
	}

	@Override
	protected DescriptorSet getDescriptorSet()
	{
		return ((ImagePipeline) target).getDescriptorSet();
	}

	@Override
	public boolean isRecordNeeded()
	{
		return false;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return GraphicPackage.Literals.IMAGE_PIPELINE == eClass;
	}

	public static ImagePipelineAdapter adapt(ImagePipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ImagePipelineAdapter.class);
	}
}
