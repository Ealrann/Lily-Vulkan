package org.sheepy.lily.vulkan.resource.image;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.resource.PipelineResourceAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;

public abstract class AbstractSampledImageAdapter extends PipelineResourceAdapter
		implements IDescriptorAdapter
{
	protected VkTexture vkTexture;

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);

		final var resource = (SampledImage) target;
		final var samplerInfo = resource.getSampler();
		final var imageInfo = getImageInfo();

		vkTexture = new VkTexture(imageInfo, samplerInfo);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var executionContext = (ExecutionContext) context;
		final var logicalDevice = executionContext.getLogicalDevice();

		ByteBuffer allocDataBuffer = allocDataBuffer(stack);

		vkTexture.allocate(stack, logicalDevice);
		vkTexture.loadImage(stack, executionContext, allocDataBuffer);

		MemoryUtil.memFree(allocDataBuffer);
	}

	public long getImageId()
	{
		return vkTexture.getImageId();
	}

	public long getImageViewId()
	{
		return vkTexture.getImageViewId();
	}

	public long getSamplerId()
	{
		return vkTexture.getSamplerId();
	}

	@Override
	public void free(IAllocationContext context)
	{
		vkTexture.free();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		return vkTexture.allocLayoutBinding(stack);
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		return vkTexture.allocWriteDescriptor(stack);
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		return vkTexture.allocPoolSize(stack);
	}

	protected abstract ImageInfo getImageInfo();

	protected abstract ByteBuffer allocDataBuffer(MemoryStack stack);
}
