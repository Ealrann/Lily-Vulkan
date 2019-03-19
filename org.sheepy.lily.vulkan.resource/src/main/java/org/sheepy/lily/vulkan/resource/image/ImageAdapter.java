package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.common.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EImageLayout;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageLayout;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImage;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

@Statefull
@Adapter(scope = Image.class)
public class ImageAdapter implements IDescriptorAdapter, IResourceAdapter
{
	private VkImage imageBackend;
	private final Image image;
	private VkImageView imageView;

	private IImageLoader loader = null;
	private ExecutionContext executionContext;

	public ImageAdapter(Image image)
	{
		this.image = image;
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		this.executionContext = (ExecutionContext) context;
		var logicalDevice = executionContext.getLogicalDevice();
		var info = new ImageInfo(image);

		imageBackend = new VkImage(logicalDevice, info);
		imageBackend.allocate(stack);

		if (image.getInitialLayout() != null)
		{
			initialTransition(stack);
		}

		imageView = new VkImageView(logicalDevice.getVkDevice());
		imageView.allocate(imageBackend.getAddress(), 1, info.format, VK_IMAGE_ASPECT_COLOR_BIT);

		load();
	}

	private void initialTransition(MemoryStack stack)
	{
		executionContext.execute(stack, new ISingleTimeCommand()
		{
			@Override
			public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				ImageLayout initialLayout = image.getInitialLayout();
				imageBackend.transitionImageLayout(commandBuffer, EPipelineStage.BOTTOM_OF_PIPE_BIT,
						initialLayout.getStage(), EImageLayout.UNDEFINED, initialLayout.getLayout(),
						Collections.emptyList(), initialLayout.getAccessMask());
			}
		});
	}

	public void load()
	{
		if (loader != null)
		{
			loader.load(executionContext, imageBackend);
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		imageView.free();
		imageView = null;

		imageBackend.free();
		imageBackend = null;
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		int stages = 0;
		for (EShaderStage stage : image.getShaderStages())
		{
			stages |= stage.getValue();
		}

		VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(image.getDescriptorType().getValue());
		res.descriptorCount(1);
		res.stageFlags(stages);
		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		VkDescriptorImageInfo.Buffer imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.imageLayout(VK_IMAGE_LAYOUT_GENERAL);
		imageInfo.imageView(imageView.getAddress());

		VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(image.getDescriptorType().getValue());
		descriptorWrite.pBufferInfo(null);
		descriptorWrite.pImageInfo(imageInfo);
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(image.getDescriptorType().getValue());
		poolSize.descriptorCount(1);
		return poolSize;
	}

	public long getAddress()
	{
		return imageBackend.getAddress();
	}

	public long getMemoryAddress()
	{
		return imageBackend.getMemoryAddress();
	}

	public long getViewAddress()
	{
		return imageView.getAddress();
	}

	public static interface IImageLoader
	{
		void load(ExecutionContext executionManager, VkImage backendBuffer);
	}

	public static ImageAdapter adapt(Image image)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(image, ImageAdapter.class);
	}
}
