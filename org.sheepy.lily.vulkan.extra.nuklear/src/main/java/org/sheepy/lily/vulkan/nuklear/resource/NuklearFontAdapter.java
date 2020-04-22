package org.sheepy.lily.vulkan.nuklear.resource;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.util.AdapterDeployer;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.core.resource.font.IFontImageAllocation;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.ui.ITextWidgetAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@ModelExtender(scope = NuklearFont.class)
@Adapter(lazy = false)
public final class NuklearFontAdapter implements IExtender
{
	private final NuklearFont nuklearFont;
	private final List<ITextWidgetAdapter> textAdapters = new ArrayList<>();
	private final AdapterDeployer<ITextWidgetAdapter> textWidgetAdapterDeployer = new AdapterDeployer<>(
			ITextWidgetAdapter.class,
			this::newTextWidgetAdapter,
			this::oldTextWidgetAdapter);
	private final Consumer<String> textListener = this::textChanged;
	private final UI ui;
	public final Font defaultFont;

	private boolean dirty = true;

	public NuklearFontAdapter(NuklearFont nuklearFont)
	{
		this.nuklearFont = nuklearFont;
		final var subpass = ModelUtil.findParent(nuklearFont, Subpass.class);
		ui = (UI) subpass.getCompositor();

		final List<Font> fonts = gatherFonts(ui.getFontPkg());
		defaultFont = fonts.get(0);

		final var fontImage = nuklearFont.getFontImage();
		fontImage.getFonts().addAll(fonts);

		textWidgetAdapterDeployer.deploy(ui);
	}

	@Dispose
	private void dispose()
	{
		textWidgetAdapterDeployer.remove(ui);
	}

	@Tick
	public void update()
	{
		if (dirty)
		{
			final Map<Font, List<String>> characterMap = new HashMap<>();
			for (final var textAdapter : textAdapters)
			{
				final var providedFont = textAdapter.getFont();
				final var font = providedFont != null ? providedFont : defaultFont;
				final var list = characterMap.computeIfAbsent(font, k -> new ArrayList<>());
				list.add(textAdapter.getText());
			}

			final var fontImageAllocation = nuklearFont.getFontImage().adapt(IFontImageAllocation.class);
			if (fontImageAllocation.push(characterMap, nuklearFont.getTransferBuffer()))
			{
				dirty = false;
			}
		}
	}

	private void newTextWidgetAdapter(ITextWidgetAdapter newAdapter)
	{
		newAdapter.listen(textListener, ITextWidgetAdapter.Features.Text);
		textAdapters.add(newAdapter);
		dirty = true;
	}

	private void oldTextWidgetAdapter(ITextWidgetAdapter oldAdapter)
	{
		oldAdapter.sulk(textListener, ITextWidgetAdapter.Features.Text);
		textAdapters.remove(oldAdapter);
	}

	private void textChanged(String text)
	{
		dirty = true;
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
