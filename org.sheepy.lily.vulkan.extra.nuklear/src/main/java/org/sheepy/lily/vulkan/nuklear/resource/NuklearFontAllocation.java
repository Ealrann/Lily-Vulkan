package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.nuklear.font.IFontAllocator;
import org.sheepy.lily.vulkan.nuklear.font.NkFontLoader;
import org.sheepy.lily.vulkan.nuklear.font.util.FontAllocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ModelExtender(scope = NuklearFont.class)
@Allocation(context = ExecutionContext.class)
public final class NuklearFontAllocation implements IExtender
{
	public final Map<Font, NkUserFont> fontMap;
	private final List<NkFontLoader> fontLoaders;
	private final List<FontAllocator> fontAllocators;

	public NuklearFontAllocation(NuklearFont nulkearFont)
	{
		final var fonts = nulkearFont.adapt(NuklearFontAdapter.class).getFonts();
		fontAllocators = List.copyOf(buildAllocators(fonts));
		try (final var stack = MemoryStack.stackPush())
		{
			for (final var allocator : fontAllocators)
			{
				allocator.allocate(stack);
			}
		}

		final var builder = new Builder(fontAllocators);
		this.fontMap = Map.copyOf(builder.fontMap);
		this.fontLoaders = List.copyOf(builder.fontLoaders);

		for (final var loader : fontLoaders)
		{
			loader.allocate();
		}
	}

	@Free
	public void free()
	{
		for (final var loader : fontLoaders)
		{
			loader.free();
		}
		for (final var allocator : fontAllocators)
		{
			allocator.free();
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
}
