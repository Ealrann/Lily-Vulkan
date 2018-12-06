package org.sheepy.vulkan.resource.texture;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.Texture;
import org.sheepy.vulkan.resource.util.STBImageLoader;

public class TextureAdapter extends AbstractTextureAdapter
{
	private int width = 0;
	private int height = 0;

	private final STBImageLoader imageLoader = new STBImageLoader();

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final Texture texture = (Texture) target;

		imageLoader.allocBuffer(texture.getFile());

		width = imageLoader.getWidth();
		height = imageLoader.getHeight();

		super.flatAllocate(stack);
	}

	@Override
	protected ByteBuffer allocDataBuffer()
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.TEXTURE == eClass;
	}

	public static TextureAdapter adapt(Texture texture)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(texture, TextureAdapter.class);
	}
}
