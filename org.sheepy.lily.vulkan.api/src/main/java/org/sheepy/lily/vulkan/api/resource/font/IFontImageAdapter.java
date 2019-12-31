package org.sheepy.lily.vulkan.api.resource.font;

import org.lwjgl.stb.STBTTAlignedQuad;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.vulkan.resource.image.VkTexture;

public interface IFontImageAdapter extends IImageAdapter
{
	void fillPackedQuad(STBTTAlignedQuad quad, int codePoint);
	VkTexture getTexture();

	int indexOf(int codepoint);
	int charCount();
	boolean contains(int codepoint);
	IFontTableInfo getTableInfo(int codepoint);
}
