package org.sheepy.lily.vulkan.nuklear.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.lwjgl.nuklear.NkUserFont;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.util.NkFontLoader;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = NuklearFont.class, lazy = false)
public class NuklearFontAdapter implements IVulkanResourceAdapter
{
	public final Map<Font, NkUserFont> fontMap;

	private final List<Font> fonts;
	private final List<NkFontLoader> fontLoaders;

	public NuklearFontAdapter(NuklearFont nuklearFont)
	{
		final var subpass = ModelUtil.findParent(nuklearFont, Subpass.class);
		final var fontTextureArray = nuklearFont.getFontTextureArray();
		final var builder = new Builder((UI) subpass.getScenePart());

		fonts = List.copyOf(builder.fonts);
		fontLoaders = List.copyOf(builder.fontLoaders);
		fontMap = Map.copyOf(builder.fontMap);

		for (final var fontLoader : fontLoaders)
		{
			// Add the target fonts to fontTextureArray
			fontTextureArray.getFonts().add(fontLoader.font);
		}
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		for (final var loader : fontLoaders)
		{
			loader.allocate();
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		for (final var loader : fontLoaders)
		{
			loader.free();
		}
	}

	public Font getDefaultFont()
	{
		return fonts.get(0);
	}

	public int getfontCount()
	{
		return fontLoaders.size();
	}

	private final static class Builder
	{
		public final List<Font> fonts;
		public final List<NkFontLoader> fontLoaders;
		public final Map<Font, NkUserFont> fontMap;

		public Builder(UI ui)
		{
			final var fontPkg = ui.getFontPkg();
			fonts = List.copyOf(gatherFonts(fontPkg));

			final List<NkFontLoader> fontLoaders = new ArrayList<>();
			final Map<Font, NkUserFont> fontMap = new HashMap<>();
			for (final var srcFont : fonts)
			{
				final var targetFont = EcoreUtil.copy(srcFont);
				final var loader = new NkFontLoader(targetFont);
				fontLoaders.add(loader);
				fontMap.put(srcFont, loader.getNkFont());
			}

			this.fontLoaders = fontLoaders;
			this.fontMap = Map.copyOf(fontMap);
		}

		private static List<Font> gatherFonts(FontPkg fontPkg)
		{
			if (fontPkg != null)
			{
				return fontPkg.getFonts();
			}
			else
			{
				return List.of();
			}
		}
	}
}
