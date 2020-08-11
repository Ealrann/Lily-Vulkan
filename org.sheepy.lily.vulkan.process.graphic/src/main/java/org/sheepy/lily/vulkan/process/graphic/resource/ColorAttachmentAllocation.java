package org.sheepy.lily.vulkan.process.graphic.resource;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ColorAttachment.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
public final class ColorAttachmentAllocation implements IExtraAttachmentAllocation
{
	private final ColorAttachment colorAttachment;
	private final int colorFormat;

	private final VkImage colorImageBackend;
	private final VkImageView colorImageView;

	public ColorAttachmentAllocation(ColorAttachment colorAttachment,
									 ProcessContext context,
									 @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation)
	{
		this.colorAttachment = colorAttachment;

		final var format = colorAttachment.getFormat().getValue();
		final int surfaceFormat = surfaceAllocation.getColorDomain().format;

		colorFormat = format == 0 ? surfaceFormat : format;

		colorImageBackend = createImage(context, surfaceAllocation);
		colorImageView = createAndAllocateImageView(context.getLogicalDevice());
		layoutTransition(context);
	}

	private VkImage createImage(ProcessContext context, PhysicalSurfaceAllocation surfaceAllocation)
	{
		final var extent = surfaceAllocation.getExtent();
		final int width = extent.x();
		final int height = extent.y();
		final int usage = VulkanModelUtil.getEnumeratedFlag(colorAttachment.getUsages());
		final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
		initialLayout.setLayout(colorAttachment.getInitialLayout());
		initialLayout.setStage(EPipelineStage.EARLY_FRAGMENT_TESTS_BIT);
		final var imageBuilder = VkImage.newBuilder(width, height, colorFormat);
		imageBuilder.usage(usage);
		imageBuilder.initialLayout(initialLayout);

		return imageBuilder.buildNoFill(context);
	}

	private VkImageView createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		final var device = logicalDevice.getVkDevice();
		final var colorImageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
		colorImageView.allocate(device, colorImageBackend);

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
	public long getMemoryPtr()
	{
		return colorImageBackend.getMemoryPtr();
	}

	@Override
	public VkImage getVkImage()
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
		return new Vector2i(colorImageBackend.width, colorImageBackend.height);
	}
}
