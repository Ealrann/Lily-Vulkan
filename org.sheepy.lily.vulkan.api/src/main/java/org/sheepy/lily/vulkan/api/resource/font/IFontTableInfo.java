package org.sheepy.lily.vulkan.api.resource.font;

import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;

public interface IFontTableInfo
{
	int getCharCount();
	int indexOf(int codepoint);
	boolean contains(int codepoint);

	void pack(STBTTPackContext pc, STBTTPackedchar.Buffer subData);
	float getCodepointHMetric(int codePoint);
	float getVMetric();
	float getCodepointKernAdvance(int codePoint, int nextCodePoint);
}
