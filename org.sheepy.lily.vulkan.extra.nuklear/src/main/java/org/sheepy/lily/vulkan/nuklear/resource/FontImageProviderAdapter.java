package org.sheepy.lily.vulkan.nuklear.resource;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.font.util.CodepointMap;
import org.sheepy.lily.vulkan.nuklear.font.util.FontAllocator;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.NULL;

@ModelExtender(scope = FontImageProvider.class)
@Adapter
public final class FontImageProviderAdapter extends Notifier<IImageDataProviderAdapter.Features> implements
																								 IImageDataProviderAdapter
{
	private static final int BASE_FONTIMAGE_WIDTH = 1024;
	private static final int BASE_FONTIMAGE_HEIGHT = 1024;
	private static final int H_OVERSAMPLING = 4;
	private static final int V_OVERSAMPLING = 4;

	private final List<Font> fonts;
	private final FontImageProvider fontImageProvider;
	private final List<FontAllocator> fontAllocators;

	private STBTTPackedchar.Buffer cdata;
	private CodepointMap codepointMap = null;
	private CodepointMap nextCodepointMap = null;

	private FontImageProviderAdapter(FontImageProvider fontImageProvider, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size, Features.Data));

		final var subpass = ModelUtil.findParent(fontImageProvider, Subpass.class);
		final var ui = (UI) subpass.getCompositor();
		fonts = gatherFonts(ui.getFontPkg());

		this.fontImageProvider = fontImageProvider;
		fontAllocators = List.copyOf(buildAllocators(fonts));

		try (final var stack = MemoryStack.stackPush())
		{
			for (final var allocator : fontAllocators)
			{
				allocator.allocate(stack);
			}
		}

		observatory.listenNoParam(this::requestPush, NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES)
				   .explore(NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES)
				   .listenNoParam(this::requestPush, NuklearPackage.FONT_USAGE__STRINGS);

		updateCodepointMap();
	}

	private void requestPush()
	{
		if (updateCodepointMap())
		{
			notify(Features.Data);
		}
	}

	private boolean updateCodepointMap()
	{
		final var characterMap = computeCharacterMap();
		final var tmpCodePointMap = CodepointMap.fromCharacterMap(characterMap);
		if (codepointMap == null || codepointMap.isCompatible(tmpCodePointMap) == false)
		{
			nextCodepointMap = tmpCodePointMap;
			return true;
		}
		else
		{
			nextCodepointMap = null;
			return false;
		}
	}

	@Dispose
	private void dispose()
	{
		for (final var allocator : fontAllocators)
		{
			allocator.free();
		}
		freeCData();
	}

	@Override
	public void fill(final ByteBuffer bitmap)
	{
		if (nextCodepointMap != null)
		{
			codepointMap = nextCodepointMap;
			nextCodepointMap = null;
		}

		freeCData();
		try (final var stack = MemoryStack.stackPush())
		{
			cdata = STBTTPackedchar.calloc(codepointMap.codepointCount);

			final STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
			stbtt_PackBegin(pc, bitmap, BASE_FONTIMAGE_WIDTH, BASE_FONTIMAGE_HEIGHT, 0, 1, NULL);
			stbtt_PackSetOversampling(pc, H_OVERSAMPLING, V_OVERSAMPLING);

			int offset = 0;
			for (final var allocator : fontAllocators)
			{
				final var codepoints = codepointMap.get(allocator.font);
				allocator.clear();
				if (codepoints != null)
				{
					final var subCData = cdata.slice(offset, codepoints.length);
					allocator.fill(pc, subCData, codepoints);

					offset += codepoints.length;
				}
			}

			stbtt_PackEnd(pc);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	private Map<Font, List<String>> computeCharacterMap()
	{
		final Map<Font, List<String>> characterMap = new HashMap<>();
		for (final var fontUsage : fontImageProvider.getFontUsages())
		{
			final var list = characterMap.computeIfAbsent(fontUsage.getFont(), f -> new ArrayList<>());
			list.addAll(fontUsage.getStrings());
		}
		addDefaultChars(characterMap, fonts.get(0));
		return characterMap;
	}

	private void freeCData()
	{
		if (cdata != null)
		{
			cdata.free();
			cdata = null;
		}
	}

	private static void addDefaultChars(Map<Font, List<String>> characterMap, Font font)
	{
		final var list = characterMap.computeIfAbsent(font, k -> new ArrayList<>());
		list.add("!?,.+-*/123456789");
	}

	public List<FontAllocator> getAllocators()
	{
		return fontAllocators;
	}

	private static List<FontAllocator> buildAllocators(List<Font> fonts)
	{
		final List<FontAllocator> res = new ArrayList<>();
		for (final var font : fonts)
		{
			res.add(new FontAllocator(font));
		}
		return res;
	}

	@Override
	public Vector2ic size()
	{
		return new Vector2i(BASE_FONTIMAGE_WIDTH, BASE_FONTIMAGE_HEIGHT);
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
