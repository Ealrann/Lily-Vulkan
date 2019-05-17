package org.sheepy.lily.vulkan.resource.image;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;

@Statefull
public abstract class AbstractSampledImageAdapter
		implements IDescriptorAdapter, ISampledImageAdapter
{
	private final SampledImage sampledImage;

	protected VkTexture vkTexture;

	public AbstractSampledImageAdapter(SampledImage sampledImage)
	{
		this.sampledImage = sampledImage;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		final var samplerInfo = sampledImage.getSampler();
		final var imageBuilder = getImageBuilder().copyImmutable();

		vkTexture = new VkTexture(imageBuilder, samplerInfo);

		final var executionContext = (ExecutionContext) context;

		final ByteBuffer allocDataBuffer = allocDataBuffer(stack);

		vkTexture.allocate(stack, context);
		vkTexture.loadImage(stack, executionContext, allocDataBuffer);

		MemoryUtil.memFree(allocDataBuffer);
	}

	@Override
	public long getImageAddress()
	{
		return vkTexture.getImageAddress();
	}

	@Override
	public long getViewAddress()
	{
		return vkTexture.getViewAddress();
	}

	@Override
	public long getSamplerAddress()
	{
		return vkTexture.getSamplerAddress();
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkTexture.free(context);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		return vkTexture.allocLayoutBinding(stack);
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		vkTexture.fillWriteDescriptor(stack, writeDescriptor);
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		vkTexture.fillPoolSize(poolSize);
	}

	protected abstract VkImage.Builder getImageBuilder();

	protected abstract ByteBuffer allocDataBuffer(MemoryStack stack);
}
