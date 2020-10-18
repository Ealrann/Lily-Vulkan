package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.ImageBackend;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;

import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ImageViewer.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = MemoryChunk.class, type = MemoryChunkAllocation.class)
public final class ImageViewerAllocation implements IMemoryChunkPartAllocation, IVkImageAllocation
{
	private final ImageViewer image;
	private final MemoryChunkAllocation chunkAllocation;
	private final ImageBackend imageBackend;
	private final VkImageView imageView;

	private boolean needPush = true;

	public ImageViewerAllocation(final ImageViewer image,
								 final ExecutionContext context,
								 final IObservatoryBuilder observatory,
								 final IAllocationState allocationState,
								 final @InjectDependency(index = 0) MemoryChunkAllocation chunkAllocation)
	{
		this.chunkAllocation = chunkAllocation;
		this.image = image;
		final var vkImage = image.adapt(ImageViewerAdapter.class).getImageBackend();
		final var boundImage = chunkAllocation.getBoundResource(image);
		this.imageBackend = new ImageBackend(vkImage, boundImage.size());
		this.imageView = new VkImageView(context.getVkDevice(), image.getName(), vkImage, VK_IMAGE_ASPECT_COLOR_BIT);

		final var dataProviderObservatory = observatory.explore(VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER)
													   .adaptNotifier(IImageDataProviderAdapter.class);
		dataProviderObservatory.listenNoParam(() -> {
			allocationState.setAllocationObsolete();
			chunkAllocation.markObsolete();
		}, IImageDataProviderAdapter.Features.Size);
		dataProviderObservatory.listenNoParam(this::requestPush, IImageDataProviderAdapter.Features.Data);
	}

	private void requestPush()
	{
		needPush = true;
		chunkAllocation.requestUpdate();
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		chunkAllocation.attach(recordContext);
	}

	@Free
	private void free(final ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageView.free(vkDevice);
		imageBackend.free(context);
	}

	@Override
	public Stream<FillCommand> streamFillCommands(boolean force)
	{
		if (needPush || force)
		{
			needPush = false;
			final var dataProviderAdapter = image.getDataProvider().adapt(IImageDataProviderAdapter.class);
			final var fillCommand = new FillCommand.FillImageCommand(dataProviderAdapter::fill,
																	 imageBackend,
																	 image.isMipmapEnabled());
			return Stream.of(fillCommand);
		}
		else
		{
			return Stream.empty();
		}
	}

	@Override
	public long getImagePtr()
	{
		return imageBackend.getPtr();
	}

	@Override
	public ImageBackend getImageBackend()
	{
		return imageBackend;
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
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width(), vkImage.height());
	}
}
