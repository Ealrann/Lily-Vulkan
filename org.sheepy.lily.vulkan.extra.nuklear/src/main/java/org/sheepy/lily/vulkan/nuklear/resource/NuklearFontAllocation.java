package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.nuklear.NkUserFont;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.nuklear.font.IFontAllocator;
import org.sheepy.lily.vulkan.nuklear.font.NkFontLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ModelExtender(scope = NuklearFont.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(features = NuklearPackage.NUKLEAR_FONT__FONT_IMAGE, type = FontImageProviderAdapter.class)
public final class NuklearFontAllocation implements IExtender
{
	public final Map<Font, NkUserFont> fontMap;
	private final List<NkFontLoader> fontLoaders;

	public NuklearFontAllocation(@InjectDependency(index = 0) FontImageProviderAdapter fontImageAllocation)
	{
		final var allocators = fontImageAllocation.getAllocators();
		final var builder = new Builder(allocators);
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
}
