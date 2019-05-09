package org.sheepy.lily.vulkan.resource.texture;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.AbstractTexture;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.Texture;
import org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl;
import org.sheepy.lily.vulkan.resource.image.AbstractSampledImageAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.resource.image.VkImage;

public abstract class AbstractTextureAdapter extends AbstractSampledImageAdapter
{
	private final Texture texture;

	private VkImage.Builder imageBuilder;
	private int mipLevels;

	protected VkTexture vkTexture;

	public AbstractTextureAdapter(Texture texture)
	{
		super(texture);
		this.texture = texture;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		Sampler samplerInfos = texture.getSampler();
		if (samplerInfos == null)
		{
			samplerInfos = new SamplerImpl();
			texture.setSampler(samplerInfos);
		}

		final int width = getWidth();
		final int height = getHeight();
		if (texture.isMipmapEnabled())
			mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);
		else mipLevels = 1;
		samplerInfos.setMaxLod(Math.max(mipLevels, samplerInfos.getMaxLod()));

		final int format = VK_FORMAT_R8G8B8A8_UNORM;
		final int usage = VK_IMAGE_USAGE_TRANSFER_SRC_BIT
				| VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT;

		final var imageBuilder = VkImage.newBuilder(width, height, format);
		imageBuilder.usage(usage);
		imageBuilder.properties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		imageBuilder.tiling(VK_IMAGE_TILING_OPTIMAL);
		imageBuilder.mipLevels(mipLevels);
		this.imageBuilder = imageBuilder.copyImmutable();

		super.allocate(stack, context);
	}

	@Override
	protected VkImage.Builder getImageBuilder()
	{
		return imageBuilder;
	}

	protected abstract int getWidth();

	protected abstract int getHeight();

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0; // or throw exception
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	public static AbstractTextureAdapter adapt(AbstractTexture texture)
	{
		return IAdapterFactoryService.INSTANCE.adapt(texture, AbstractTextureAdapter.class);
	}
}
