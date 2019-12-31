package org.sheepy.lily.vulkan.nuklear.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.nuklear.NkUserFont;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.ResourcePkg;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.nuklear.util.NkFontLoader;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

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
		final var fontArrayDescriptor = nuklearFont.getFontArrayDescriptor();
		final var resourcePkg = (ResourcePkg) nuklearFont.eContainer();
		final int index = resourcePkg.getResources().indexOf(nuklearFont);
		final var builder = new Builder((UI) subpass.getScenePart(), resourcePkg, index);

		fonts = List.copyOf(builder.fonts);
		fontLoaders = List.copyOf(builder.fontLoaders);
		fontMap = Map.copyOf(builder.fontMap);

		for (final var fontLoader : fontLoaders)
		{
			// Add the target fonts to fontTextureArray
			fontArrayDescriptor.getImages().add(fontLoader.fontImage);
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

		public Builder(UI ui, ResourcePkg resourcePkg, int index)
		{
			final var fontPkg = ui.getFontPkg();
			fonts = List.copyOf(gatherFonts(fontPkg));

			final List<NkFontLoader> fontLoaders = new ArrayList<>();
			final Map<Font, NkUserFont> fontMap = new HashMap<>();
			for (final var font : fonts)
			{
				final float height = font.getHeight();
				final var imageFont = buildImage(font);
				final var loader = new NkFontLoader(imageFont, height);
				fontLoaders.add(loader);
				fontMap.put(font, loader.getNkFont());

				resourcePkg.getResources().add(index, imageFont);
			}

			this.fontLoaders = fontLoaders;
			this.fontMap = Map.copyOf(fontMap);
		}

		private FontImage buildImage(Font font)
		{
			final FontImage res = ResourceFactory.eINSTANCE.createFontImage();

			final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
			initialLayout.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
			initialLayout.setStage(EPipelineStage.FRAGMENT_SHADER_BIT);
			initialLayout.getAccessMask().add(EAccess.SHADER_READ_BIT);

			res.setFont(font);
			res.setInitialLayout(initialLayout);
			res.getUsages().add(EImageUsage.SAMPLED);
			res.getUsages().add(EImageUsage.TRANSFER_DST);
			res.setFormat(EFormat.R8_UNORM);

			return res;
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
