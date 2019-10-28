package org.sheepy.lily.vulkan.api.resource;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackedchar.Buffer;

public interface IFontImageAdapter extends IImageAdapter
{
	int getBufferWidth();
	int getBufferHeight();

	float getDescent();
	float getScale();
	STBTTFontinfo getFontInfo();
	Buffer getCdata();
}
