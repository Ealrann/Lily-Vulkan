package org.sheepy.lily.vulkan.resource.image;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptedResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;

@Statefull
public abstract class AbstractSampledImageAdapter
		implements IDescriptedResourceAdapter, ISampledImageAdapter
{
	private List<IVkDescriptor> descriptors = null;
	protected VkTexture vkTexture;

	public AbstractSampledImageAdapter(SampledImage sampledImage, VkImage.Builder imageBuilder)
	{
		final var samplerInfo = sampledImage.getSampler();

		vkTexture = new VkTexture(imageBuilder, samplerInfo);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
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
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			descriptors = List.of(vkTexture.getDescriptor());
		}

		return descriptors;
	}

	protected abstract ByteBuffer allocDataBuffer(MemoryStack stack);
}
