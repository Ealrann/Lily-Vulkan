package org.sheepy.lily.vulkan.nuklear.resource;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.adapter.AdapterDeployer;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.font.util.CodepointMap;
import org.sheepy.lily.vulkan.nuklear.ui.ITextWidgetAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@ModelExtender(scope = NuklearFont.class)
@Adapter
@AutoLoad
public final class NuklearFontAdapter extends Notifier<NuklearFontAdapter.Features> implements IAdapter
{
	interface Features extends IFeatures<Features>
	{
		Feature<Runnable, Features> CodepointMap = Feature.newFeature();
	}

	private final List<ITextWidgetAdapter> textAdapters = new ArrayList<>();
	private final AdapterDeployer<ITextWidgetAdapter> textWidgetAdapterDeployer = new AdapterDeployer<>(
			ITextWidgetAdapter.class,
			this::newTextWidgetAdapter,
			this::oldTextWidgetAdapter);
	private final Consumer<String> textListener = this::textChanged;
	private final UI ui;
	public final Font defaultFont;
	private CodepointMap codepointMap = null;
	private final List<Font> fonts;

	private boolean dirty = true;

	public NuklearFontAdapter(NuklearFont nuklearFont)
	{
		super(List.of(Features.CodepointMap));

		final var subpass = ModelUtil.findParent(nuklearFont, Subpass.class);
		ui = (UI) subpass.getCompositor();

		fonts = gatherFonts(ui.getFontPkg());
		defaultFont = fonts.get(0);
		textWidgetAdapterDeployer.deploy(ui);

		update();
	}

	@Dispose
	private void dispose()
	{
		textWidgetAdapterDeployer.remove(ui);
	}

	@Tick(priority = -10)
	public void update()
	{
		if (dirty)
		{
			final Map<Font, List<String>> stringMap = new HashMap<>();
			for (final var textAdapter : textAdapters)
			{
				final var providedFont = textAdapter.getFont();
				final var font = providedFont != null ? providedFont : defaultFont;
				final var list = stringMap.computeIfAbsent(font, f -> new ArrayList<>());
				list.add(textAdapter.getText());
			}

			addDefaultChars(stringMap, fonts.get(0));
			updateCodepointMap(stringMap);
			dirty = false;
		}
	}

	private void updateCodepointMap(Map<Font, List<String>> stringMap)
	{
		final var tmpCodepointMap = CodepointMap.fromCharacterMap(stringMap);
		if (codepointMap == null || codepointMap.isCompatible(tmpCodepointMap) == false)
		{
			codepointMap = tmpCodepointMap;
			notify(Features.CodepointMap);
		}
	}

	private static void addDefaultChars(Map<Font, List<String>> characterMap, Font font)
	{
		final var list = characterMap.computeIfAbsent(font, k -> new ArrayList<>());
		list.add("!?,.+-*/123456789");
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

	public List<Font> getFonts()
	{
		return fonts;
	}

	public CodepointMap getCodepointMap()
	{
		return codepointMap;
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
