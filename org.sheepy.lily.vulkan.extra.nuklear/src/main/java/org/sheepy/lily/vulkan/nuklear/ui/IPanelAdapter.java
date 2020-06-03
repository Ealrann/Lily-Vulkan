package org.sheepy.lily.vulkan.nuklear.ui;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.nuklear.Nuklear;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.game.api.window.IWindow;

import java.util.Map;

public interface IPanelAdapter extends IExtender
{
	boolean layout(UIContext context);
	boolean isHovered();
	boolean needLayout();
	IPanel getPanel();

	final class UIContext
	{
		public final IWindow window;
		public final NkContext nkContext;
		public final MemoryStack stack;

		private final Font defaultFont;
		private final Map<Font, NkUserFont> fontMap;

		private Font currentFont;

		public UIContext(IWindow window,
						 NkContext nkContext,
						 Map<Font, NkUserFont> fontMap,
						 Font defaultFont,
						 MemoryStack stack)
		{
			this.window = window;
			this.nkContext = nkContext;
			this.defaultFont = defaultFont;
			this.stack = stack;
			this.fontMap = Map.copyOf(fontMap);

			currentFont = defaultFont;
		}

		public void setFont(Font font)
		{
			if (font == null) font = defaultFont;
			if (currentFont != font)
			{
				Nuklear.nk_style_set_font(nkContext, fontMap.get(font));
				currentFont = font;
			}
		}
	}
}
