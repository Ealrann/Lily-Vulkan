package org.sheepy.lily.vulkan.nuklear.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.nuklear.NkUserFont;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.adapter.util.AdapterDeployer;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.common.resource.font.IFontAllocator;
import org.sheepy.lily.vulkan.common.resource.font.IFontImageAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.font.NkFontLoader;
import org.sheepy.lily.vulkan.nuklear.ui.ITextWidgetAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = NuklearFont.class, lazy = false)
public class NuklearFontAdapter implements IVulkanResourceAdapter
{
	public final Font defaultFont;
	public Map<Font, NkUserFont> fontMap;

	private final NuklearFont nuklearFont;
	private final UI ui;

	private final AdapterDeployer<ITextWidgetAdapter> textWidgetAdapterDeployer = new AdapterDeployer<>(ITextWidgetAdapter.class,
																										this::newTextWidgetAdapter,
																										this::oldTextWidgetAdapter);
	private final INotificationListener textListener = this::textChanged;
	private final List<ITextWidgetAdapter> textAdapters = new ArrayList<>();

	private List<NkFontLoader> fontLoaders;
	private boolean dirty = true;

	public NuklearFontAdapter(NuklearFont nuklearFont)
	{
		this.nuklearFont = nuklearFont;
		final var subpass = ModelUtil.findParent(nuklearFont, Subpass.class);
		ui = (UI) subpass.getScenePart();

		final var fontImage = nuklearFont.getFontImage();
		final List<Font> fonts = Builder.gatherFonts(ui.getFontPkg());
		fontImage.getFonts().addAll(fonts);
		defaultFont = fonts.get(0);
	}

	private void newTextWidgetAdapter(ITextWidgetAdapter newAdapter)
	{
		newAdapter.addListener(textListener, ITextWidgetAdapter.Features.Text.ordinal());
		textAdapters.add(newAdapter);
		dirty = true;
	}

	private void oldTextWidgetAdapter(ITextWidgetAdapter oldAdapter)
	{
		oldAdapter.removeListener(textListener, ITextWidgetAdapter.Features.Text.ordinal());
		textAdapters.remove(oldAdapter);
	}

	private void textChanged(Notification notification)
	{
		dirty = true;
	}

	@Load
	private void load()
	{
		final var fontImage = nuklearFont.getFontImage();
		final var fontImageAdapter = fontImage.adapt(IFontImageAdapter.class);
		final var allocators = fontImageAdapter.getAllocators();
		final var builder = new Builder(allocators);

		this.fontMap = Map.copyOf(builder.fontMap);
		this.fontLoaders = List.copyOf(builder.fontLoaders);
		textWidgetAdapterDeployer.deploy(ui);
	}

	@Dispose
	private void dispose()
	{
		textWidgetAdapterDeployer.remove(ui);
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

	@Tick
	public void update()
	{
		if (dirty)
		{
			final var fontImage = nuklearFont.getFontImage();
			final var fontImageAdapter = fontImage.adapt(IFontImageAdapter.class);

			final Map<Font, List<String>> characterMap = new HashMap<>();
			for (final var textAdapter : textAdapters)
			{
				final var providedFont = textAdapter.getFont();
				final var font = providedFont != null ? providedFont : defaultFont;
				List<String> list = characterMap.get(font);
				if (list == null)
				{
					list = new ArrayList<>();
					characterMap.put(font, list);
				}
				list.add(textAdapter.getText());
			}

			if (fontImageAdapter.push(characterMap, nuklearFont.getTransferBuffer()))
			{
				dirty = false;
			}
		}
	}

	private final static class Builder
	{
		public final List<NkFontLoader> fontLoaders;
		public final Map<Font, NkUserFont> fontMap;

		public Builder(List<? extends IFontAllocator> allocators)
		{
			final List<NkFontLoader> fontLoaders = new ArrayList<>();
			final Map<Font, NkUserFont> fontMap = new HashMap<>();
			for (final var allocator : allocators)
			{
				final var font = allocator.getFont();
				final float height = font.getHeight();
				final var loader = new NkFontLoader(allocator, height);
				fontLoaders.add(loader);
				fontMap.put(font, loader.getNkFont());
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
