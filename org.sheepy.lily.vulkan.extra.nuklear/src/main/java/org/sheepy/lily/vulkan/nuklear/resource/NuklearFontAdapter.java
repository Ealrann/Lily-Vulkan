package org.sheepy.lily.vulkan.nuklear.resource;

import java.util.Objects;

import org.lwjgl.nuklear.NkUserFont;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.nuklear.util.NkFontLoader;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = NuklearFont.class)
public class NuklearFontAdapter implements IResourceAdapter
{
	private final NuklearFont nuklearFont;
	private final ISampledImageAdapter samplerAdapter;

	private NkFontLoader fontLoader = null;
	private NkUserFont defaultFont = null;

	public NuklearFontAdapter(NuklearFont nuklearFont)
	{
		this.nuklearFont = nuklearFont;
		final var sampler = nuklearFont.getFontSampledImage();
		samplerAdapter = sampler.adaptNotNull(ISampledImageAdapter.class);
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var fontImage = nuklearFont.getFontSampledImage().getImage();

		samplerAdapter.allocate(context);

		final var samplerPtr = samplerAdapter.getVkSampler().getPtr();

		fontLoader = new NkFontLoader((FontImage) fontImage);
		fontLoader.allocate();
		defaultFont = fontLoader.createNkFont(samplerPtr);
	}

	@Override
	public void free(IExecutionContext context)
	{
		fontLoader.free();

		Objects.requireNonNull(defaultFont.query()).free();
		Objects.requireNonNull(defaultFont.width()).free();

		samplerAdapter.free(context);
	}

	public NkUserFont getNkFont()
	{
		return defaultFont;
	}
}
