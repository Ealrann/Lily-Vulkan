package org.sheepy.lily.vulkan.nuklear.font;

import org.lwjgl.system.Struct;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.core.model.ui.Font;

import java.util.List;

public interface IFontAllocator extends INotifier<IFontAllocator.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Runnable, Features> codepointsLoaded = Feature.newFeature();
	}

	Font getFont();

	void fillPackedQuad(Struct stbTTAlignedQuad, int index);

	int indexOf(int codepoint);
	int charCount();
	boolean contains(int codepoint);
	IFontTableInfo getTableInfo(int codepoint);

	List<? extends IFontTableInfo> getTableInfos();
}
