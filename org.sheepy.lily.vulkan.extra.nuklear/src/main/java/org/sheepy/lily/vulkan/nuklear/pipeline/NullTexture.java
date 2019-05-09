package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.resource.image.VkImage;

public class NullTexture implements IAllocable
{
	private static final int FORMAT = VK_FORMAT_R8G8B8A8_UNORM;
	private static final int USAGE = VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_SAMPLED_BIT;

	private static final Sampler sampler = new SamplerImpl();
	static
	{
		sampler.setMinFilter(EFilter.NEAREST);
		sampler.setMagFilter(EFilter.NEAREST);
	}

	private static final VkImage.Builder imageBuilder;
	static
	{
		final var builder = VkImage.newBuilder(1, 1, FORMAT);
		builder.usage(USAGE);
		builder.properties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		imageBuilder = builder.copyImmutable();
	}

	public final VkTexture texture = new VkTexture(imageBuilder, sampler);

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var executionContext = (IExecutionContext) context;
		final ByteBuffer buffer = MemoryUtil.memAlloc(4);
		buffer.putInt(0xFFFFFFFF);
		buffer.flip();

		texture.allocate(stack, context);
		texture.loadImage(stack, executionContext, buffer);

		MemoryUtil.memFree(buffer);
	}

	@Override
	public void free(IAllocationContext context)
	{
		texture.free(context);
	}

	public long getSamplerAddress()
	{
		return texture.getSamplerAddress();
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
