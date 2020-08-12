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
import org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory;
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
		textWidgetAdapterDeployer.deploy(ui);

		update();
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
			final Map<Font, FontUsage> usageMap = new HashMap<>();
			for (final var textAdapter : textAdapters)
			{
				final var providedFont = textAdapter.getFont();
				final var font = providedFont != null ? providedFont : defaultFont;
				final var usage = usageMap.computeIfAbsent(font, NuklearFontAdapter::newFontUsage);
				usage.getStrings().add(textAdapter.getText());
			}

			nuklearFont.getFontImage().getFontUsages().clear();
			nuklearFont.getFontImage().getFontUsages().addAll(usageMap.values());
			dirty = false;
		}
	}

	private static FontUsage newFontUsage(Font font)
	{
		final var res = NuklearFactory.eINSTANCE.createFontUsage();
		res.setFont(font);
		return res;
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
