package org.sheepy.lily.vulkan.process.graphic.frame;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.allocation.up.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.graphic.IImageViewManager;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ImageViews.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicConfiguration.class, features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, type = SwapChainAllocation.class)
public final class ImageViewAllocation implements IImageViewManager, IAllocation
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private final List<VkImageView> vkImageViews;

	private ImageViewAllocation(ProcessContext context,
								@InjectDependency(type = PhysicalSurfaceAllocation.class) PhysicalSurfaceAllocation surfaceAllocation,
								@InjectDependency(type = SwapChainAllocation.class) SwapChainAllocation swapChainAllocation)
	{
		final var device = context.getVkDevice();
		final var colorFormat = surfaceAllocation.getColorDomain().format;
		final var swapImages = swapChainAllocation.getSwapChainImages();

		final List<VkImageView> vkImageViewsTmp = new ArrayList<>(swapImages.size());
		for (final long imageId : swapImages)
		{
			final var imageView = new VkImageView(IMAGE_ASPECT);
			imageView.allocate(device, imageId, 1, colorFormat);
			vkImageViewsTmp.add(imageView);
		}

		vkImageViews = List.copyOf(vkImageViewsTmp);
	}

	@Override
	public List<VkImageView> getImageViews()
	{
		return vkImageViews;
	}

	public VkImageView getImageView(int index)
	{
		return vkImageViews.get(index);
	}

	@Free
	private void free(ProcessContext context)
	{
		final var device = context.getVkDevice();
		for (final var view : vkImageViews)
		{
			view.free(device);
		}
	}
}
