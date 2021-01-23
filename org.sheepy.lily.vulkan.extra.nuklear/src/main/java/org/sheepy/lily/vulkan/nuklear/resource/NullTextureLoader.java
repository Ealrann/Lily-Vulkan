package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.BufferUtils;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;

@ModelExtender(scope = StaticImage.class, name = NullTextureLoader.MODEL_OBJECT_NAME)
@Adapter(singleton = true)
@AutoLoad
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
