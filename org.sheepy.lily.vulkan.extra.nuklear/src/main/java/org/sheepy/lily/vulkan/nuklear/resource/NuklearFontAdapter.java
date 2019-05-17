package org.sheepy.lily.vulkan.nuklear.resource;

import java.util.Objects;

import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.resource.Font;
import org.sheepy.lily.vulkan.nuklear.util.NkFontLoader;
import org.sheepy.lily.vulkan.resource.texture.FontAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = Font.class, name = NuklearFontAdapter.MODEL_OBJECT_NAME)
public class NuklearFontAdapter extends FontAdapter
{
	public static final String MODEL_OBJECT_NAME = "NuklearFont";

	private final Font font;

	private NkFontLoader fontLoader = null;
	private NkUserFont defaultFont = null;

	public NuklearFontAdapter(Font font)
	{
		super(font);
		this.font = font;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		super.allocate(stack, context);

		fontLoader = new NkFontLoader(font);
		fontLoader.allocate();
		defaultFont = fontLoader.createNkFont(getSamplerAddress());
	}

	@Override
	public void free(IExecutionContext context)
	{
		fontLoader.free();

		Objects.requireNonNull(defaultFont.query()).free();
		Objects.requireNonNull(defaultFont.width()).free();

		super.free(context);
	}

	public NkUserFont getNkFont()
	{
		return defaultFont;
	}
}
