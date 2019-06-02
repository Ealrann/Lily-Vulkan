package org.sheepy.lily.vulkan.nuklear.resource;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.resource.image.AbstractSampledImageAdapter;
import org.sheepy.vulkan.resource.image.VkImage;

@Statefull
@Adapter(scope = SampledImage.class, name = NullTextureAdapter.MODEL_OBJECT_NAME)
public class NullTextureAdapter extends AbstractSampledImageAdapter
{
	public static final String MODEL_OBJECT_NAME = "NullTexture";

	private static final int FORMAT = VK_FORMAT_R8G8B8A8_UNORM;
	private static final int USAGE = VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_SAMPLED_BIT;

	private static final VkImage.Builder imageBuilder;
	static
	{
		final var builder = VkImage.newBuilder(1, 1, FORMAT);
		builder.usage(USAGE);
		builder.properties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		imageBuilder = builder.copyImmutable();
	}

	public NullTextureAdapter(SampledImage sampledImage)
	{
		super(sampledImage, imageBuilder);
	}

	@Override
	protected ByteBuffer allocDataBuffer(MemoryStack stack)
	{
		final var buffer = MemoryUtil.memAlloc(4);
		buffer.putInt(0xFFFFFFFF);
		buffer.flip();

		return buffer;
	}
}
