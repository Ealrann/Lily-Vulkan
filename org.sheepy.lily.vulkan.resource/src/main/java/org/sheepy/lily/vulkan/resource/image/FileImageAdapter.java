package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.lily.vulkan.resource.util.STBImageLoader;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImage.Builder;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;

@Statefull
@Adapter(scope = FileImage.class)
public class FileImageAdapter implements IImageAdapter
{
	private final STBImageLoader imageLoader = new STBImageLoader();
	private final VkTexture vkTexture;
	private final FileImage image;

	private List<IVkDescriptor> descriptors = null;

	public FileImageAdapter(FileImage image)
	{
		this.image = image;
		final var imageBuilder = createBuilder(image);

		vkTexture = new VkTexture(imageBuilder);
	}

	private static Builder createBuilder(FileImage image)
	{
		final var size = STBImageLoader.getSize(image.getFile());
		final int width = size.x();
		final int height = size.y();

		final int mipLevels = image.isMipmapEnabled() ? (int) Math.floor(log2nlz(Math.max(width, height))) + 1 : 1;

		final int format = VK_FORMAT_R8G8B8A8_UNORM;
		final int usage = VK_IMAGE_USAGE_TRANSFER_SRC_BIT
				| VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT;

		final var imageBuilder = VkImage.newBuilder(width, height, format);
		imageBuilder.usage(usage);
		imageBuilder.properties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		imageBuilder.tiling(VK_IMAGE_TILING_OPTIMAL);
		imageBuilder.mipLevels(mipLevels);

		return imageBuilder.copyImmutable();
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		final var executionContext = (ExecutionContext) context;
		final var layout = image.getInitialLayout();

		imageLoader.allocBuffer(image.getFile());
		vkTexture.allocate(stack, context);
		vkTexture.loadImage(stack, executionContext, imageLoader.getBuffer(), layout);

		imageLoader.free();
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkTexture.free(context);
	}

	@Override
	public VkImage getVkImage()
	{
		return vkTexture.getImage();
	}

	@Override
	public long getImagePtr()
	{
		return vkTexture.getImagePtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return vkTexture.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return vkTexture.getViewPtr();
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			final var descriptor = image.getDescriptor();
			final var type = descriptor.getDescriptorType();
			final var stages = descriptor.getShaderStages();
			final var layout = EImageLayout.GENERAL;
			final long viewPtr = getViewPtr();

			final var vkImageDescriptor = new VkImageDescriptor(viewPtr, 0, layout, type, stages);
			descriptors = List.of(vkImageDescriptor);
		}

		return descriptors;
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0;
		return 31 - Integer.numberOfLeadingZeros(bits);
	}
}