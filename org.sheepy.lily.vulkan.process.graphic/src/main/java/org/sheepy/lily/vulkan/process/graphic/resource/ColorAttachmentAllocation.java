package org.sheepy.lily.vulkan.process.graphic.resource;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAllocation;
import org.sheepy.lily.vulkan.core.resource.image.ImageBackend;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ColorAttachment.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
public final class ColorAttachmentAllocation implements IExtraAttachmentAllocation
{
	private static final String PREFIX = "[ColorAttachment]";

	private final ColorAttachment colorAttachment;
	private final IAllocationState allocationState;
	private final int colorFormat;

	private final ImageBackend colorImageBackend;
	private final VkImageView colorImageView;

	public ColorAttachmentAllocation(ColorAttachment colorAttachment,
									 ProcessContext context,
									 IAllocationState allocationState,
									 @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation)
	{
		this.colorAttachment = colorAttachment;
		this.allocationState = allocationState;

		final var format = colorAttachment.getFormat().getValue();
		final int surfaceFormat = surfaceAllocation.getColorDomain().format;

		colorFormat = format == 0 ? surfaceFormat : format;

		colorImageBackend = createImage(context, surfaceAllocation);
		colorImageView = createAndAllocateImageView(context.getLogicalDevice(), colorAttachment.getName());
		layoutTransition(context);
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	private ImageBackend createImage(ProcessContext context, PhysicalSurfaceAllocation surfaceAllocation)
	{
		final var extent = surfaceAllocation.getExtent();
		final int width = extent.x();
		final int height = extent.y();
		final int usage = VulkanModelUtil.getEnumeratedFlag(colorAttachment.getUsages());
		final var imageBuilder = VkImage.newBuilder(PREFIX + colorAttachment.getName(), width, height, colorFormat);
		imageBuilder.usage(usage);
		imageBuilder.initialLayout(colorAttachment.getInitialLayout());

		return context.executeFunction(imageBuilder::build);
	}

	private VkImageView createAndAllocateImageView(LogicalDevice logicalDevice, String name)
	{
		final var device = logicalDevice.getVkDevice();
		final var colorImageView = new VkImageView(device,
												   name,
												   colorImageBackend.vkImage(),
												   VK_IMAGE_ASPECT_COLOR_BIT);

		return colorImageView;
	}

	private void layoutTransition(ProcessContext context)
	{
		final var srcStage = EPipelineStage.TOP_OF_PIPE_BIT;
		final var srcLayout = EImageLayout.UNDEFINED;
		context.executeCommand(recordContext -> colorImageBackend.transitionToInitialLayout(recordContext.stack(),
																							recordContext.vkCommandBuffer(),
																							srcStage,
																							srcLayout,
																							List.of()));
	}

	@Free
	private void free(ProcessContext context)
	{
		final var device = context.getVkDevice();
		colorImageView.free(device);
		colorImageBackend.free(context);
	}

	@Override
	public long getImagePtr()
	{
		return colorImageBackend.getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return colorImageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return colorImageBackend.vkImage();
	}

	@Override
	public ImageBackend getImageBackend()
	{
		return colorImageBackend;
	}

	@Override
	public ClearInfo getClearInfos()
	{
		return new ClearInfo(false, colorAttachment.getClearValue());
	}

	@Override
	public int getImageFormat()
	{
		return colorFormat;
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = colorImageBackend.vkImage();
		return new Vector2i(vkImage.width(), vkImage.height());
	}
}
