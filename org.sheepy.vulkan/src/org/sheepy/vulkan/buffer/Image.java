package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.sheepy.vulkan.device.LogicalDevice;

public class Image
{
	private LogicalDevice logicalDevice;

	private int width;
	private int height;
	private int format;
	private int mipLevels = 1;
	
	private long size;
	protected long imageId;
	protected long imageMemoryId;
	
	private int layout;
	private int access;

	public static Image alloc(LogicalDevice logicalDevice,
			int width,
			int height,
			int format,
			int tiling,
			int usage,
			int properties)
	{
		Image res = new Image(logicalDevice);
		res.createImage(width, height, 1, format, tiling, usage, properties);
		return res;
	}

	public Image(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void createImage(int width,
			int height,
			int mipLevels,
			int format,
			int tiling,
			int usage,
			int properties)
	{
		this.width = width;
		this.height = height;
		this.format = format;
		this.mipLevels = mipLevels;
		
		layout = VK_IMAGE_LAYOUT_UNDEFINED;
		access = 0;

		VkImageCreateInfo imageInfo = VkImageCreateInfo.calloc();
		imageInfo.sType(VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO);
		imageInfo.imageType(VK_IMAGE_TYPE_2D);
		imageInfo.extent().width(width);
		imageInfo.extent().height(height);
		imageInfo.extent().depth(1);
		imageInfo.mipLevels(mipLevels);
		imageInfo.arrayLayers(1);
		imageInfo.format(format);
		imageInfo.tiling(tiling);
		imageInfo.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
		imageInfo.usage(usage);
		imageInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);
		imageInfo.samples(VK_SAMPLE_COUNT_1_BIT);
		imageInfo.flags(0); // Optional

		long[] aImageId = new long[1];
		if (vkCreateImage(logicalDevice.getVkDevice(), imageInfo, null, aImageId) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create image!");
		}
		imageId = aImageId[0];

		VkMemoryRequirements memRequirements = VkMemoryRequirements.calloc();
		vkGetImageMemoryRequirements(logicalDevice.getVkDevice(), imageId, memRequirements);

		this.size = memRequirements.size();
		VkMemoryAllocateInfo allocInfo = VkMemoryAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);
		allocInfo.allocationSize(memRequirements.size());
		allocInfo.memoryTypeIndex(logicalDevice.getPhysicalDevice()
				.findMemoryType(memRequirements.memoryTypeBits(), properties));

		long[] aImageMemoryId = new long[1];
		if (vkAllocateMemory(logicalDevice.getVkDevice(), allocInfo, null,
				aImageMemoryId) != VK_SUCCESS)
		{
			throw new AssertionError("failed to allocate image memory!");
		}
		imageMemoryId = aImageMemoryId[0];

		vkBindImageMemory(logicalDevice.getVkDevice(), imageId, imageMemoryId, 0);

		imageInfo.free();
		allocInfo.free();
	}

	public void fillWithBuffer(VkCommandBuffer commandBuffer, Buffer buffer)
	{
		VkBufferImageCopy.Buffer region = VkBufferImageCopy.calloc(1);
		region.bufferOffset(0);
		region.bufferRowLength(0);
		region.bufferImageHeight(0);

		region.imageSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.imageSubresource().mipLevel(0);
		region.imageSubresource().baseArrayLayer(0);
		region.imageSubresource().layerCount(1);

		region.imageOffset().set(0, 0, 0);
		region.imageExtent().set(width, height, 1);

		vkCmdCopyBufferToImage(commandBuffer, buffer.getId(), imageId,
				VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, region);
	}

	public void transitionImageLayout(VkCommandBuffer commandBuffer,
			int srcStage,
			int dstStage,
			int newLayout,
			int dstAccessMask)
	{
		ImageBarrier.execute(commandBuffer, this, srcStage, dstStage, newLayout, dstAccessMask);
	}

	public static boolean hasStencilComponent(int imageFormat)
	{
		return imageFormat == VK_FORMAT_D32_SFLOAT_S8_UINT
				|| imageFormat == VK_FORMAT_D24_UNORM_S8_UINT;
	}

	public long getId()
	{
		return imageId;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public void free()
	{
		vkDestroyImage(logicalDevice.getVkDevice(), imageId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), imageMemoryId, null);
	}

	public long getSize()
	{
		return size;
	}
	
	public int getLayout()
	{
		return layout;
	}
	
	public void setLayout(int imageLayout) 
	{
		this.layout = imageLayout;
	}

	public int getAccess()
	{
		return access;
	}

	public void setAccess(int access)
	{
		this.access = access;
	}
	
	public int getMipLevels()
	{
		return mipLevels;
	}
	
	public int getFormat()
	{
		return format;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageId ^ (imageId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Image other = (Image) obj;
		if (imageId != other.imageId) return false;
		return true;
	}

	public long getMemoryId()
	{
		return imageMemoryId;
	}

}
