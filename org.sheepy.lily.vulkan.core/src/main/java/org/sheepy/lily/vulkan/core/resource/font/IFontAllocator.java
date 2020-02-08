package org.sheepy.lily.vulkan.core.resource.font;

import java.util.List;

import org.lwjgl.system.Struct;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.ui.Font;

public interface IFontAllocator extends INotifier
{
	enum Features
	{
		loadedCodepoints
	}

	Font getFont();

	void fillPackedQuad(Struct stbTTAlignedQuad, int index);

	int indexOf(int codepoint);
	int charCount();
	boolean contains(int codepoint);
	IFontTableInfo getTableInfo(int codepoint);

	List<? extends IFontTableInfo> getTableInfos();
}
