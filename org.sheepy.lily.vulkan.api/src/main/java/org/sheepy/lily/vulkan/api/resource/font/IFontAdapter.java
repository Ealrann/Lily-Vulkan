package org.sheepy.lily.vulkan.api.resource.font;

import org.lwjgl.stb.STBTTAlignedQuad;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.resource.image.VkTexture;

public interface IFontAdapter extends IAdapter
{
	void allocate(IExecutionContext context, ImageInfo info);
	void free(IExecutionContext context);

	void fillPackedQuad(STBTTAlignedQuad quad, int codePoint);
	VkTexture getTexture();

	int indexOf(int codepoint);
	int charCount();
	boolean contains(int codepoint);
	IFontTableAdapter getTableAdapter(int codepoint);
}
