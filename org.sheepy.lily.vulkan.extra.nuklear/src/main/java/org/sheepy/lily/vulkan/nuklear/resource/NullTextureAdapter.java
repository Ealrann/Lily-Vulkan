package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.StaticImage;

@Statefull
@Adapter(scope = StaticImage.class, name = NullTextureAdapter.MODEL_OBJECT_NAME)
public class NullTextureAdapter implements IVulkanAdapter
{
	public static final String MODEL_OBJECT_NAME = "NullImage";

	@Autorun
	public NullTextureAdapter(StaticImage sampledImage)
	{
		final var buffer = BufferUtils.createByteBuffer(4);
		buffer.putInt(0xFFFFFFFF);
		buffer.flip();

		sampledImage.setFillWith(buffer);
	}
}
