package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = StaticImage.class)
@Allocation(context = ExecutionContext.class)
public class StaticImageAllocation extends Notifier<IMemoryChunkPartAllocation.Features> implements
																						 IMemoryChunkPartAllocation,
																						 IVkImageAllocation
{
	private final StaticImage image;
	private final VkImage imageBackend;
	private final VkImageView imageView;

	public StaticImageAllocation(StaticImage image, ExecutionContext context)
	{
		super(List.of(Features.PushRequest, Features.Attach));
		this.image = image;

		final var size = image.getSize();
		final var builder = new VkImageBuilder(image, size.x(), size.y());

		imageBackend = builder.buildNoFill(context);
		imageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageView.free(vkDevice);
		imageBackend.free(context);
	}

	@Override
	public void registerMemory(final MemoryBuilder memoryBuilder)
	{
		memoryBuilder.registerImage(imageBackend.getPtr(), this::bindMemory);
	}

	public void bindMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		imageBackend.bindMemory(vkDevice, memoryPtr, offset, size);
		imageView.allocate(vkDevice, imageBackend);
	}

	@Override
	public Stream<FillCommand> streamFillCommands(boolean force)
	{
		final var fillCommand = new FillCommand.FillImageCommand(this::fillData, imageBackend, 0);
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
	public long getMemoryPtr()
	{
		return imageBackend.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend;
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width, vkImage.height);
	}
}
