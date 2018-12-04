package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.resource.SampledResource;
import org.sheepy.vulkan.model.resource.Sampler;
import org.sheepy.vulkan.model.resource.impl.SamplerImpl;
import org.sheepy.vulkan.resource.PipelineResourceAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.vulkan.resource.nativehelper.VkSampler;

public abstract class AbstractSampledResourceAdapter extends PipelineResourceAdapter
		implements IDescriptorAdapter
{
	private ImageBackend imageBackend;
	private ImageView imageView;
	private VkSampler sampler;

	private int width;
	private int height;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var context = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		final var logicalDevice = context.getLogicalDevice();
		final SampledResource resource = (SampledResource) target;
		Sampler samplerInfos = resource.getSampler();

		if (samplerInfos == null)
		{
			samplerInfos = new SamplerImpl();
		}

		width = getWidth();
		height = getHeight();

		int format = getFormat();
		int usage = getUsage() | VK_IMAGE_USAGE_SAMPLED_BIT;
		int mipLevels = getMipLevels();

		final ImageInfo imageInfo = new ImageInfo(width, height, format, usage,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT, VK_IMAGE_TILING_OPTIMAL, mipLevels);

		imageBackend = new ImageBackend(logicalDevice, imageInfo);
		imageBackend.allocate(stack);
		final var imageId = imageBackend.getId();

		imageView = new ImageView(logicalDevice.getVkDevice());
		sampler = new VkSampler(logicalDevice, samplerInfos);

		imageView.load(imageId, mipLevels, format, VK_IMAGE_ASPECT_COLOR_BIT);
		sampler.load();

		loadImage(stack, imageBackend);
	}

	public long getImageId()
	{
		return imageBackend.getId();
	}

	public long getImageViewId()
	{
		return imageView.getId();
	}

	public long getSamplerId()
	{
		return sampler.getId();
	}
	
	@Override
	public void free()
	{
		sampler.free();
		imageView.free();
		imageBackend.free();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		res.descriptorCount(1);
		res.stageFlags(VK_SHADER_STAGE_FRAGMENT_BIT);
		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final VkDescriptorImageInfo.Buffer imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.imageLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
		imageInfo.imageView(getImageViewId());
		imageInfo.sampler(sampler.getId());

		final VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		descriptorWrite.pBufferInfo(null);
		descriptorWrite.pImageInfo(imageInfo);
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		final VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		poolSize.descriptorCount(1);
		return poolSize;
	}

	protected abstract int getMipLevels();

	protected abstract int getFormat();

	protected abstract int getUsage();

	protected abstract void loadImage(MemoryStack stack, ImageBackend imageBackend);

	protected abstract int getWidth();

	protected abstract int getHeight();
}
