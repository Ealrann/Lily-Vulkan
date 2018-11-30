package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.model.resource.ImageLayout;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.resource.PipelineResourceAdapter;

public class ImageAdapter extends PipelineResourceAdapter
{
	private ImageBackend imageBackend;
	private Image image;
	private ImageView imageView;

	private IImageLoader loader = null;
	private ExecutionManager executionManager;

	@Override
	public void setTarget(Notifier target)
	{
		this.image = (Image) target;
		super.setTarget(target);
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		var logicalDevice = executionManager.logicalDevice;
		var info = new ImageInfo(image);

		imageBackend = new ImageBackend(logicalDevice, info);
		imageBackend.allocate(stack);

		if (image.getInitialLayout() != null)
		{
			initialTransition();
		}

		imageView = new ImageView(executionManager.logicalDevice.getVkDevice());
		imageView.load(imageBackend.getId(), 1, info.format, VK_IMAGE_ASPECT_COLOR_BIT);

		load();

		dirty = false;
	}

	private void initialTransition()
	{
		SingleTimeCommand stc = new SingleTimeCommand(executionManager)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				ImageLayout initialLayout = image.getInitialLayout();
				imageBackend.transitionImageLayout(commandBuffer, EPipelineStage.BOTTOM_OF_PIPE_BIT,
						initialLayout.getStage(), EImageLayout.UNDEFINED, initialLayout.getLayout(),
						0, initialLayout.getAccess());
			}
		};
		stc.execute();
	}

	public void load()
	{
		if (loader != null)
		{
			loader.load(executionManager, imageBackend);
		}
	}

	@Override
	public void free()
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
		imageInfo.imageView(imageView.getId());

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

	public long getId()
	{
		return imageBackend.getId();
	}

	public long getMemoryId()
	{
		return imageBackend.getMemoryId();
	}

	public static ImageAdapter adapt(Image image)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(image, ImageAdapter.class);
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.IMAGE == eClass;
	}

	public static interface IImageLoader
	{
		void load(ExecutionManager executionManager, ImageBackend backendBuffer);
	}
}