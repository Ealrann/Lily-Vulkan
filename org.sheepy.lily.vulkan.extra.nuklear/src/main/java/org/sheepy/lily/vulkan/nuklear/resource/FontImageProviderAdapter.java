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
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

import java.nio.ByteBuffer;
import java.util.List;

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

	private final FontImageProvider fontImageProvider;

	private STBTTPackedchar.Buffer cdata;

	private FontImageProviderAdapter(FontImageProvider fontImageProvider, IObservatoryBuilder observatory)
	{
		super(List.of(Features.Size, Features.Data));

		this.fontImageProvider = fontImageProvider;

		observatory.explore(NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT)
				   .adaptNotifier(NuklearFontAdapter.class)
				   .listenNoParam(() -> notify(Features.Data), NuklearFontAdapter.Features.CodepointMap);
	}

	@Dispose
	private void dispose()
	{
		freeCData();
	}

	@Override
	public void fill(final ByteBuffer bitmap)
	{
		final var nuklearFont = fontImageProvider.getNuklearFont();
		final var codepointMap = nuklearFont.adapt(NuklearFontAdapter.class).getCodepointMap();
		freeCData();
		try (final var stack = MemoryStack.stackPush())
		{
			final var nuklearFontAllocation = nuklearFont.adapt(NuklearFontAllocation.class);
			final var allocators = nuklearFontAllocation.getAllocators();

			cdata = STBTTPackedchar.calloc(codepointMap.codepointCount);

			final STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
			stbtt_PackBegin(pc, bitmap, BASE_FONTIMAGE_WIDTH, BASE_FONTIMAGE_HEIGHT, 0, 1, NULL);
			stbtt_PackSetOversampling(pc, H_OVERSAMPLING, V_OVERSAMPLING);

			int offset = 0;
			for (final var allocator : allocators)
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

	private void freeCData()
	{
		if (cdata != null)
		{
			cdata.free();
			cdata = null;
		}
	}

	@Override
	public Vector2ic size()
	{
		return new Vector2i(BASE_FONTIMAGE_WIDTH, BASE_FONTIMAGE_HEIGHT);
	}
}
