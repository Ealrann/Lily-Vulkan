package org.sheepy.lily.vulkan.nuklear.font;

import org.lwjgl.system.Struct;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.core.model.ui.Font;

import java.util.List;

public interface IFontAllocator extends INotifier<IFontAllocator.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Runnable, Features> codepointsLoaded = IFeature.newFeature();
	}

	Font getFont();

	void fillPackedQuad(Struct stbTTAlignedQuad, int index);

	int indexOf(int codepoint);
	int charCount();
	boolean contains(int codepoint);
	IFontTableInfo getTableInfo(int codepoint);

	List<? extends IFontTableInfo> getTableInfos();
}
