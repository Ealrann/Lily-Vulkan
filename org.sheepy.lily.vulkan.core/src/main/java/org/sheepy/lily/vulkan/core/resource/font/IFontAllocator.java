package org.sheepy.lily.vulkan.core.resource.font;

import org.lwjgl.system.Struct;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.ui.Font;

import java.util.List;

public interface IFontAllocator extends INotifier<IFontAllocator.Features>
{
	enum Features implements IFeature<Runnable, Features>
	{
		codepointsLoaded
	}

	Font getFont();

	void fillPackedQuad(Struct stbTTAlignedQuad, int index);

	int indexOf(int codepoint);
	int charCount();
	boolean contains(int codepoint);
	IFontTableInfo getTableInfo(int codepoint);

	List<? extends IFontTableInfo> getTableInfos();
}
