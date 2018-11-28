package org.sheepy.vulkan.gameoflife.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.common.util.ModelUtil;
import org.sheepy.vulkan.gameoflife.model.GameOfLifePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.PipelineResourceAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.vulkan.resource.image.IImageAdapter;
import org.sheepy.vulkan.resource.image.ImageInfo;
import org.sheepy.vulkan.resource.image.ImageView;
import org.sheepy.vulkan.resource.image.StandaloneImage;

public class BoardImageAdapter extends PipelineResourceAdapter implements IImageAdapter, IDescriptorAdapter
{
	private StandaloneImage image;
	private ImageView imageView;
	private ImageInfo imageInfo;
	private final int imageFormat = VK_FORMAT_R8G8B8A8_UNORM;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		var executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		var application = ModelUtil.getVulkanApplication(target);
		var size = application.getSize();

		imageInfo = new ImageInfo();
		imageInfo.setWidth(size.getX());
		imageInfo.setHeight(size.getY());
		imageInfo.setFormat(imageFormat );
		imageInfo.setMipLevels(1);
		imageInfo.setTiling(VK_IMAGE_TILING_OPTIMAL);
		imageInfo.setUsage(VK_IMAGE_USAGE_TRANSFER_SRC_BIT | VK_IMAGE_USAGE_STORAGE_BIT);
		imageInfo.setProperties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		image = new StandaloneImage(executionManager.logicalDevice, imageInfo);
		image.allocate(stack);

		SingleTimeCommand stc = new SingleTimeCommand(executionManager)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				image.transitionImageLayout(commandBuffer, EPipelineStage.TRANSFER_BIT,
						EPipelineStage.COMPUTE_SHADER_BIT, EImageLayout.UNDEFINED,
						EImageLayout.GENERAL, 0, VK_ACCESS_SHADER_WRITE_BIT);
			}
		};
		stc.execute();

		imageView = new ImageView(executionManager.logicalDevice.getVkDevice());
		imageView.load(image.getId(), 1, imageFormat , VK_IMAGE_ASPECT_COLOR_BIT);
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

	@Override
	public long getId()
	{
		return image.getId();
	}

	@Override
	public int getWidth()
	{
		return imageInfo.getWidth();
	}

	@Override
	public int getHeight()
	{
		return imageInfo.getHeight();
	}

	@Override
	public int getDepth()
	{
		return 0;
	}

	@Override
	public long getSize()
	{
		return image.getSize();
	}

	@Override
	public long getMemoryId()
	{
		return image.getMemoryId();
	}

	@Override
	public int getFormat()
	{
		return imageFormat;
	}

	@Override
	public int getMipLevels()
	{
		return 1;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return GameOfLifePackage.Literals.BOARD_IMAGE == eClass;
	}
}
