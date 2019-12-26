package org.sheepy.lily.vulkan.nuklear.ui;

import java.util.List;
import java.util.Map;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkImage;
import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.nuklear.Nuklear;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.vulkan.window.Window;

public interface IPanelAdapter extends IAdapter
{
	boolean layout(UIContext context);

	default void collectImages(List<FileResource> imageCollection)
	{};

	static final class UIContext
	{
		public final Window window;
		public final NkContext nkContext;
		public final Map<FileResource, NkImage> imageMap;

		private final Font defaultFont;
		private final Map<Font, NkUserFont> fontMap;

		private Font currentFont;

		public UIContext(	Window window,
							NkContext nkContext,
							Map<FileResource, NkImage> imageMap,
							Map<Font, NkUserFont> fontMap,
							Font defaultFont)
		{
			this.window = window;
			this.nkContext = nkContext;
			this.defaultFont = defaultFont;
			this.imageMap = Map.copyOf(imageMap);
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
