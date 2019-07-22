package org.sheepy.lily.vulkan.api.resource;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackedchar.Buffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.FontImage;

public interface IFontImageAdapter extends IImageAdapter
{
	int getBufferWidth();
	int getBufferHeight();

	float getDescent();
	float getScale();
	STBTTFontinfo getFontInfo();
	Buffer getCdata();

	public static IFontImageAdapter adapt(FontImage font)
	{
		return IAdapterFactoryService.INSTANCE.adapt(font, IFontImageAdapter.class);
	}
}
