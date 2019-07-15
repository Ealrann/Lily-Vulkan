package org.sheepy.lily.vulkan.resource.texture;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.resource.AbstractTexture;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.Texture;
import org.sheepy.lily.vulkan.resource.image.AbstractSampledImageAdapter;
import org.sheepy.lily.vulkan.resource.util.STBImageLoader;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImage.Builder;

@Statefull
@Adapter(scope = Texture.class)
public final class TextureAdapter extends AbstractSampledImageAdapter
{
	private final STBImageLoader imageLoader = new STBImageLoader();
	private final Texture texture;

	public TextureAdapter(Texture texture)
	{
		super(texture, createBuilder(texture));
		this.texture = texture;
	}

	private static Builder createBuilder(Texture texture)
	{
		final var size = STBImageLoader.getSize(texture.getFile());
		final int width = size.x();
		final int height = size.y();

		int mipLevels;
		if (texture.isMipmapEnabled())
			mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);
		else mipLevels = 1;

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
		imageLoader.allocBuffer(texture.getFile());
		final int width = imageLoader.getWidth();
		final int height = imageLoader.getHeight();

		Sampler samplerInfos = texture.getSampler();
		if (samplerInfos == null)
		{
			samplerInfos = ResourceFactory.eINSTANCE.createSampler();
			texture.setSampler(samplerInfos);
		}

		int mipLevels = 0;
		if (texture.isMipmapEnabled())
			mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);
		else mipLevels = 1;
		samplerInfos.setMaxLod(Math.max(mipLevels, samplerInfos.getMaxLod()));

		super.allocate(stack, context);
	}

	@Override
	protected ByteBuffer allocDataBuffer(MemoryStack stack)
	{
		return imageLoader.getBuffer();
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0; // or throw exception
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	public static TextureAdapter adapt(AbstractTexture texture)
	{
		return IAdapterFactoryService.INSTANCE.adapt(texture, TextureAdapter.class);
	}
}
