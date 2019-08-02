package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptedResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.lily.vulkan.resource.util.STBImageLoader;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImage.Builder;
import org.sheepy.vulkan.resource.image.VkImageArrayDescriptor;

@Statefull
@Adapter(scope = Texture2DArray.class)
public final class Texture2DArrayAdapter implements IDescriptedResourceAdapter
{
	private final Texture2DArray textureArray;
	private final STBImageLoader imageLoader = new STBImageLoader();
	private final List<FileTextureWrapper> textureWrappers;

	private List<IVkDescriptor> descriptors = null;

	public Texture2DArrayAdapter(Texture2DArray textureArray)
	{
		this.textureArray = textureArray;
		final var imageBuilder = createBuilder();

		textureWrappers = List.copyOf(createTextureList(imageBuilder));
	}

	private List<FileTextureWrapper> createTextureList(final Builder imageBuilder)
	{
		final List<FileTextureWrapper> res = new ArrayList<>();
		for (final var resource : textureArray.getFiles())
		{
			final var texture = new VkTexture(imageBuilder);
			res.add(new FileTextureWrapper(texture, resource));
		}

		return res;
	}

	private Builder createBuilder()
	{
		final int width = textureArray.getWidth();
		final int height = textureArray.getHeight();

		final int mipLevels = textureArray.isMipmapEnabled()
				? (int) Math.floor(log2nlz(Math.max(width, height))) + 1
				: 1;

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
		final var layout = textureArray.getInitialLayout();

		for (final var wrapper : textureWrappers)
		{
			imageLoader.allocBuffer(wrapper.resource);
			final var buffer = imageLoader.getBuffer();

			wrapper.texture.allocate(stack, context);
			wrapper.texture.loadImage(stack, executionContext, buffer, layout);

			imageLoader.free();
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		for (final var wrapper : textureWrappers)
		{
			wrapper.texture.free(context);
		}
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			final var descriptor = textureArray.getDescriptor();
			final var type = descriptor.getDescriptorType();
			final var stages = descriptor.getShaderStages();
			final var layout = textureArray.getInitialLayout().getLayout();
			final long[] viewPtrs = new long[textureArray.getFiles().size()];

			for (int i = 0; i < textureWrappers.size(); i++)
			{
				final var wrapper = textureWrappers.get(i);
				viewPtrs[i] = wrapper.texture.getViewPtr();
			}

			final var vkDescriptor = new VkImageArrayDescriptor(viewPtrs, layout, type, stages);
			descriptors = List.of(vkDescriptor);
		}

		return descriptors;
	}
	
	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0;
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	private static final class FileTextureWrapper
	{
		private final VkTexture texture;
		private final PathResource resource;

		public FileTextureWrapper(VkTexture texture, PathResource resource)
		{
			this.texture = texture;
			this.resource = resource;
		}
	}
}
