package org.sheepy.lily.vulkan.resource.image;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;

@Statefull
public abstract class AbstractSampledImageAdapter implements IDescriptorAdapter, IResourceAdapter
{
	private final SampledImage sampledImage;

	protected VkTexture vkTexture;

	public AbstractSampledImageAdapter(SampledImage sampledImage)
	{
		this.sampledImage = sampledImage;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var samplerInfo = sampledImage.getSampler();
		final var imageInfo = getImageInfo();

		vkTexture = new VkTexture(imageInfo, samplerInfo);

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
