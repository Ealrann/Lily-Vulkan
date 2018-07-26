package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkFormatProperties;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.view.ImageView;

public class DepthResource implements IAllocable
{
	private LogicalDevice logicalDevice;
	private CommandPool commandPool;
	private int width;
	private int height;

	private Image depthImage;
	private ImageView depthImageView;

	private int depthFormat;

	public DepthResource(LogicalDevice logicalDevice, CommandPool commandPool)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;

		depthImage = new Image(logicalDevice);
		depthImageView = new ImageView(logicalDevice);
	}

	public void configure(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		depthFormat = findDepthFormat();
		depthImage.createImage(width, height, 1, depthFormat, VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT, VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		depthImageView.load(depthImage.getId(), 1, depthFormat, VK_IMAGE_ASPECT_DEPTH_BIT);

		SingleTimeCommand stc = new SingleTimeCommand(commandPool,
				logicalDevice.getQueueManager().getGraphicQueue())
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				ImageBarrier.execute(commandBuffer, depthImage, VK_PIPELINE_STAGE_TOP_OF_PIPE_BIT,
						VK_PIPELINE_STAGE_EARLY_FRAGMENT_TESTS_BIT, VK_IMAGE_LAYOUT_UNDEFINED,
						VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL, 0,
						VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT
								| VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT);
			}
		};
		stc.execute();
	}

	private int findSupportedFormat(int[] candidates, int tiling, int features)
	{
		for (int format : candidates)
		{
			VkFormatProperties props = VkFormatProperties.calloc();
			vkGetPhysicalDeviceFormatProperties(
					logicalDevice.getPhysicalDevice().getVkPhysicalDevice(), format, props);

			if (tiling == VK_IMAGE_TILING_LINEAR
					&& (props.linearTilingFeatures() & features) == features)
			{
				return format;
			}
			else if (tiling == VK_IMAGE_TILING_OPTIMAL
					&& (props.optimalTilingFeatures() & features) == features)
			{
				return format;
			}
		}

		throw new AssertionError("failed to find supported format!");
	}

	private int findDepthFormat()
	{
		return findSupportedFormat(new int[] {
				VK_FORMAT_D32_SFLOAT, VK_FORMAT_D32_SFLOAT_S8_UINT, VK_FORMAT_D24_UNORM_S8_UINT
		}, VK_IMAGE_TILING_OPTIMAL, VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT);
	}

	public int getDepthFormat()
	{
		return depthFormat;
	}

	public long getDepthImageId()
	{
		return depthImage.getId();
	}

	public long getDepthImageViewId()
	{
		return depthImageView.getId();
	}

	@Override
	public void free()
	{
		depthImageView.free();
		depthImage.free();
	}
}
