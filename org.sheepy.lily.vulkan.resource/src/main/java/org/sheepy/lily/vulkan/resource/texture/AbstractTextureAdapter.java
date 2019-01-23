package org.sheepy.lily.vulkan.resource.texture;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.AbstractTexture;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.Texture;
import org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl;
import org.sheepy.lily.vulkan.resource.image.AbstractSampledImageAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageInfo;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;

public abstract class AbstractTextureAdapter extends AbstractSampledImageAdapter
{
	private int mipLevels;

	protected VkTexture vkTexture;

	private ImageInfo info;
	
	@Override
	public void setTarget(Notifier target)
	{
		final AbstractTexture texture = (Texture) target;
		Sampler samplerInfos = texture.getSampler();
		if (samplerInfos == null)
		{
			samplerInfos = new SamplerImpl();
			texture.setSampler(samplerInfos);
		}

		int width = getWidth();
		int height = getHeight();
		mipLevels = 1;
		if (texture.isMipmapEnabled())
			mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);
		samplerInfos.setMaxLod(Math.max(mipLevels, samplerInfos.getMaxLod()));

		int format = VK_FORMAT_R8G8B8A8_UNORM;
		int usage = VK_IMAGE_USAGE_TRANSFER_SRC_BIT
				| VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT;

		info = new ImageInfo(width, height, format, usage, VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT,
				VK_IMAGE_TILING_OPTIMAL, mipLevels);
		
		super.setTarget(target);
	}

	@Override
	protected ImageInfo getImageInfo()
	{
		return info;
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
		return IServiceAdapterFactory.INSTANCE.adapt(texture, AbstractTextureAdapter.class);
	}
}
