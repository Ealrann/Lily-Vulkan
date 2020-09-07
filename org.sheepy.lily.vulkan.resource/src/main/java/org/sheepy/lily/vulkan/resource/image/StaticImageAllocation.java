package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.ImageBackend;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;

import java.nio.ByteBuffer;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = StaticImage.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = MemoryChunk.class, type = MemoryChunkAllocation.class)
public final class StaticImageAllocation implements IMemoryChunkPartAllocation, IVkImageAllocation
{
	private final StaticImage image;
	private final MemoryChunkAllocation chunkAllocation;
	private final ImageBackend imageBackend;
	private final VkImageView imageView;

	public StaticImageAllocation(final StaticImage image,
								 final ExecutionContext context,
								 @InjectDependency(index = 0) final MemoryChunkAllocation chunkAllocation)
	{
		this.image = image;
		this.chunkAllocation = chunkAllocation;
		final var vkImage = image.adapt(StaticImageAdapter.class).getImageBackend();
		final var boundImage = chunkAllocation.getBoundResource(image);
		this.imageBackend = new ImageBackend(vkImage, boundImage.size());
		imageView = new VkImageView(context.getVkDevice(), image.getName(), vkImage, VK_IMAGE_ASPECT_COLOR_BIT);
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageView.free(vkDevice);
		imageBackend.free(context);
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		chunkAllocation.attach(recordContext);
	}

	@Override
	public Stream<FillCommand> streamFillCommands(boolean force)
	{
		final var fillCommand = new FillCommand.FillImageCommand(this::fillData, imageBackend, false);
		return Stream.of(fillCommand);
	}

	private void fillData(ByteBuffer trgBuffer)
	{
		if (image.isFillWithZero())
		{
			MemoryUtil.memSet(trgBuffer, 0);
		}
		else if (image.getFillWith() != null)
		{
			MemoryUtil.memCopy(image.getFillWith(), trgBuffer);
		}
	}

	@Override
	public long getImagePtr()
	{
		return imageBackend.getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend.vkImage();
	}

	@Override
	public ImageBackend getImageBackend()
	{
		return imageBackend;
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width(), vkImage.height());
	}
}
