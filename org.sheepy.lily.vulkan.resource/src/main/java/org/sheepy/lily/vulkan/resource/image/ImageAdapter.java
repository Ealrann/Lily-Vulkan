package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageLayout;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImage;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.ISingleTimeCommand;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.resource.image.ImageInfo;
import org.sheepy.vulkan.resource.image.VkImageView;
import org.sheepy.vulkan.util.VkModelUtil;

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
		final var logicalDevice = executionContext.getLogicalDevice();
		final var info = createInfo(image);

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
				final ImageLayout initialLayout = image.getInitialLayout();
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
		for (final EShaderStage stage : image.getShaderStages())
		{
			stages |= stage.getValue();
		}

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(image.getDescriptorType().getValue());
		res.descriptorCount(1);
		res.stageFlags(stages);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.imageLayout(VK_IMAGE_LAYOUT_GENERAL);
		imageInfo.imageView(imageView.getAddress());

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(image.getDescriptorType().getValue());
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfo);
		writeDescriptor.pTexelBufferView(null);
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(image.getDescriptorType().getValue());
		poolSize.descriptorCount(1);
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
		void load(IExecutionContext executionManager, VkImage backendBuffer);
	}

	public static ImageAdapter adapt(Image image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, ImageAdapter.class);
	}

	private static ImageInfo createInfo(Image image)
	{
		final int usages = VkModelUtil.getEnumeratedFlag(image.getUsages());
		final int format = image.getFormat().getValue();
		final int mipLevels = image.getMipLevels();
		final int height = image.getHeight();
		final int tiling = image.getTiling();
		final int width = image.getWidth();
		final int properties = image.getProperties();

		return new ImageInfo(width, height, format, usages, properties, tiling, mipLevels);
	}
}
