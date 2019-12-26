package org.sheepy.lily.vulkan.api.resource.font;

import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.image.ImageInfo;

public interface IFontTableAdapter extends IAdapter
{
	void allocate(IExecutionContext context, ImageInfo info);
	void free(IExecutionContext context);

	int getCharCount();
	int indexOf(int codepoint);
	boolean contains(int codepoint);

	void pack(STBTTPackContext pc, STBTTPackedchar.Buffer subData);
	float getCodepointHMetric(int codePoint);
	float getVMetric();
	float getCodepointKernAdvance(int codePoint, int nextCodePoint);
}
