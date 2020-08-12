package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.resource.ImageViewer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;

import java.util.List;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ImageViewer.class)
@Allocation(context = ExecutionContext.class)
public class ImageViewerAllocation extends Notifier<IMemoryChunkPartAllocation.Features> implements
																						 IMemoryChunkPartAllocation,
																						 IVkImageAllocation
{
	private final VkImage imageBackend;
	private final VkImageView imageView;
	private final IImageDataProviderAdapter dataProviderAdapter;

	private boolean needPush = true;

	public ImageViewerAllocation(ImageViewer image,
								 ExecutionContext context,
								 IObservatoryBuilder observatory,
								 IAllocationState allocationState)
	{
		super(List.of(Features.PushRequest, Features.Attach));

		dataProviderAdapter = image.getDataProvider().adapt(IImageDataProviderAdapter.class);
		final var size = dataProviderAdapter.size();
		final var builder = new VkImageBuilder(image, size.x(), size.y());

		imageBackend = builder.buildNoFill(context);
		imageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);

		final var dataProviderObservatory = observatory.explore(VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER)
													   .adaptNotifier(IImageDataProviderAdapter.class);
		dataProviderObservatory.listenNoParam(allocationState::setAllocationObsolete,
											  IImageDataProviderAdapter.Features.Size);
		dataProviderObservatory.listenNoParam(this::requestPush, IImageDataProviderAdapter.Features.Data);
	}

	private void requestPush()
	{
		needPush = true;
		notify(Features.PushRequest);
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
	public PushData gatherPushData(boolean force, boolean computeSize)
	{
		if (needPush || force)
		{
			needPush = false;
			final var fillCommand = new FillCommand.FillImageCommand(dataProviderAdapter::fill, imageBackend);
			return new PushData(Stream.of(fillCommand), imageBackend.getSize());
		}
		else
		{
			return PushData.EMPTY;
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
