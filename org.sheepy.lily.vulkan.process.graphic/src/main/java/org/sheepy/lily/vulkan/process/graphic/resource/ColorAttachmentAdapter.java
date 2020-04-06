package org.sheepy.lily.vulkan.process.graphic.resource;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@Statefull
@Adapter(scope = ColorAttachment.class)
public final class ColorAttachmentAdapter extends Notifier<IVkImageAdapter.Features> implements IExtraAttachmentAdapter,
																								IAllocableAdapter<GraphicContext>
{
	private final ColorAttachment colorAttachment;

	private VkImage colorImageBackend;
	private VkImageView colorImageView;
	private int colorFormat;

	public ColorAttachmentAdapter(ColorAttachment colorAttachment)
	{
		super(Features.values().length);
		this.colorAttachment = colorAttachment;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();
		config.addDependencies(List.of(surfaceManager));
	}

	@Override
	public void allocate(GraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();
		final var format = colorAttachment.getFormat().getValue();
		final int surfaceFormat = surfaceManager.getColorDomain().getFormat().getValue();

		colorFormat = format == 0 ? surfaceFormat : format;

		createImage(context);
		allocateImage(context);
		createAndAllocateImageView(context.getLogicalDevice());
		layoutTransition(context);

		notify(Features.View, colorImageView.getPtr());
		notify(Features.Image, colorImageBackend.getPtr());
	}

	private void createImage(GraphicContext context)
	{
		final var surfaceManager = context.getSurfaceManager();
		final var extent = surfaceManager.getExtent();
		final int width = extent.x();
		final int height = extent.y();
		final int usage = VulkanModelUtil.getEnumeratedFlag(colorAttachment.getUsages());
		final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
		initialLayout.setLayout(colorAttachment.getInitialLayout());
		initialLayout.setStage(EPipelineStage.EARLY_FRAGMENT_TESTS_BIT);
		final var imageBuilder = VkImage.newBuilder(width, height, colorFormat);
		imageBuilder.usage(usage);
		imageBuilder.initialLayout(initialLayout);

		colorImageBackend = imageBuilder.build();
	}

	private void allocateImage(GraphicContext context)
	{
		colorImageBackend.allocate(context);
	}

	private void createAndAllocateImageView(LogicalDevice logicalDevice)
	{
		final var device = logicalDevice.getVkDevice();
		colorImageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
		colorImageView.allocate(device, colorImageBackend);
	}

	private void layoutTransition(GraphicContext context)
	{
		final var stack = context.stack();
		final var srcStage = EPipelineStage.TOP_OF_PIPE_BIT;
		final var srcLayout = EImageLayout.UNDEFINED;
		context.execute((context2, commandBuffer) -> colorImageBackend.transitionToInitialLayout(stack,
																								 commandBuffer.getVkCommandBuffer(),
																								 srcStage,
																								 srcLayout,
																								 List.of()));
	}

	@Override
	public void free(GraphicContext context)
	{
		final var device = context.getVkDevice();
		colorImageView.free(device);
		colorImageBackend.free(context);

		colorImageView = null;
		colorImageBackend = null;
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
