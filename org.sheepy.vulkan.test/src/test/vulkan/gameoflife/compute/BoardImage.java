package test.vulkan.gameoflife.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.view.ImageView;

public class BoardImage implements IDescriptor, IAllocable
{
	private CommandPool commandPool;
	private VkQueue queue;
	private int width;
	private int height;
	private int imageFormat;

	private Image image;
	private ImageView imageView;

	public BoardImage(LogicalDevice logicalDevice, CommandPool commandPool, VkQueue queue,
			int width, int height, int imageFormat)
	{
		this.commandPool = commandPool;
		this.queue = queue;
		this.width = width;
		this.height = height;
		this.imageFormat = imageFormat;

		image = new Image(logicalDevice);
		imageView = new ImageView(logicalDevice);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		image.createImage(width, height, 1, imageFormat, VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_TRANSFER_SRC_BIT | VK_IMAGE_USAGE_STORAGE_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		SingleTimeCommand stc = new SingleTimeCommand(commandPool, queue)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				image.transitionImageLayout(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
						VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT, VK_IMAGE_LAYOUT_GENERAL,
						VK_ACCESS_SHADER_WRITE_BIT);
			}
		};
		stc.execute();

		imageView.load(image.getId(), 1, imageFormat, VK_IMAGE_ASPECT_COLOR_BIT);
	}

	public Image getImage()
	{
		return image;
	}

	@Override
	public void free()
	{
		imageView.free();
		image.free();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(VK_DESCRIPTOR_TYPE_STORAGE_IMAGE);
		res.descriptorCount(1);
		res.stageFlags(VK_SHADER_STAGE_COMPUTE_BIT);
		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{

		VkDescriptorImageInfo.Buffer imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.imageLayout(VK_IMAGE_LAYOUT_GENERAL);
		imageInfo.imageView(imageView.getId());

		VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_STORAGE_IMAGE);
		descriptorWrite.pBufferInfo(null);
		descriptorWrite.pImageInfo(imageInfo);
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(VK_DESCRIPTOR_TYPE_STORAGE_IMAGE);
		poolSize.descriptorCount(1);
		return poolSize;
	}
}