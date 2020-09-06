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
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = ImageViewer.class)
@Allocation(context = ExecutionContext.class)
public final class ImageViewerAllocation extends Notifier<IMemoryChunkPartAllocation.Features> implements
																							   IMemoryChunkPartAllocation,
																							   IVkImageAllocation
{
	private final VkImage imageBackend;
	private final ImageViewer image;
	private final boolean mipmapEnabled;

	private VkImageView imageView;
	private boolean needPush = true;

	public ImageViewerAllocation(ImageViewer image,
								 ExecutionContext context,
								 IObservatoryBuilder observatory,
								 IAllocationState allocationState)
	{
		super(Features.Values);

		final var dataProviderAdapter = image.getDataProvider().adapt(IImageDataProviderAdapter.class);
		this.image = image;
		final var size = dataProviderAdapter.size();
		final var builder = new VkImageBuilder(image.getName(), image, size.x(), size.y());

		mipmapEnabled = image.isMipmapEnabled();
		if (mipmapEnabled)
		{
			builder.computeMipLevels();
			builder.addUsage(EImageUsage.TRANSFER_SRC_VALUE); // needed to generate the mipmap
			builder.addUsage(EImageUsage.TRANSFER_DST_VALUE); // needed to generate the mipmap
		}

		imageBackend = builder.buildNoFill(context);

		final var dataProviderObservatory = observatory.explore(VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER)
													   .adaptNotifier(IImageDataProviderAdapter.class);
		dataProviderObservatory.listenNoParam(() -> {
												  allocationState.setAllocationObsolete();
												  notify(Features.Obsolete);
											  },
											  IImageDataProviderAdapter.Features.Size);
		dataProviderObservatory.listenNoParam(this::requestPush, IImageDataProviderAdapter.Features.Data);
	}

	private void requestPush()
	{
		needPush = true;
		notify(Features.PushRequest);
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		notify(Features.Attach, recordContext);
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
		imageView = new VkImageView(vkDevice, image.getName(), imageBackend, VK_IMAGE_ASPECT_COLOR_BIT);
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
																	 mipmapEnabled);
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
