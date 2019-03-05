package org.sheepy.lily.vulkan.resource.texture;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.resource.Texture;
import org.sheepy.lily.vulkan.resource.util.STBImageLoader;

@Statefull
@Adapter(scope = Texture.class)
public class TextureAdapter extends AbstractTextureAdapter
{
	private final STBImageLoader imageLoader = new STBImageLoader();

	private int width = 0;
	private int height = 0;

	public TextureAdapter(Texture texture)
	{
		super(texture);
		imageLoader.allocBuffer(texture.getFile());

		width = imageLoader.getWidth();
		height = imageLoader.getHeight();
	}

	@Override
	protected ByteBuffer allocDataBuffer(MemoryStack stack)
	{
		return imageLoader.getBuffer();
	}

	@Override
	protected int getWidth()
	{
		return width;
	}

	@Override
	protected int getHeight()
	{
		return height;
	}

	public static TextureAdapter adapt(Texture texture)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(texture, TextureAdapter.class);
	}
}
