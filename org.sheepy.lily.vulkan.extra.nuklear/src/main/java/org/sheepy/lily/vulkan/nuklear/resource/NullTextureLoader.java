package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.resource.StaticImage;

@ModelExtender(scope = StaticImage.class, name = NullTextureLoader.MODEL_OBJECT_NAME)
@Adapter(singleton = true, lazy = false)
public class NullTextureLoader implements IAdapter
{
	public static final String MODEL_OBJECT_NAME = "NullImage";

	@Load
	public static void load(StaticImage sampledImage)
	{
		final var buffer = BufferUtils.createByteBuffer(4);
		buffer.putInt(0xFFFFFFFF);
		buffer.flip();

		sampledImage.setFillWith(buffer);
	}
}
