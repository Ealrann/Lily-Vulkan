package org.sheepy.lily.vulkan.process.graphic.frame;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
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
public final class ImageViewAllocation implements IImageViewManager, IAdapter
{
	private static final String BASE_NAME = "SwapImageView_";
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private final List<VkImageView> vkImageViews;

	private ImageViewAllocation(ProcessContext context,
								@InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
								@InjectDependency(index = 1) SwapChainAllocation swapChainAllocation)
	{
		final var device = context.getVkDevice();
		final var colorFormat = surfaceAllocation.getColorDomain().format;
		final int imageCount = swapChainAllocation.getImageCount();

		final List<VkImageView> vkImageViewsTmp = new ArrayList<>(imageCount);
		for (int i = 0; i < imageCount; i++)
		{
			final var name = BASE_NAME + i;
			final long imagePtr = swapChainAllocation.getImagePtr(i);
			final var imageView = new VkImageView(device, name, imagePtr, 1, colorFormat, IMAGE_ASPECT);
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
