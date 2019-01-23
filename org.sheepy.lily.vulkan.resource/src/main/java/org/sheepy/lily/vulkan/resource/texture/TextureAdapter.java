package org.sheepy.lily.vulkan.resource.texture;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Texture;
import org.sheepy.lily.vulkan.resource.util.STBImageLoader;

public class TextureAdapter extends AbstractTextureAdapter
{
	private int width = 0;
	private int height = 0;

	private final STBImageLoader imageLoader = new STBImageLoader();

	@Override
	public void setTarget(Notifier target)
	{
		final Texture texture = (Texture) target;

		imageLoader.allocBuffer(texture.getFile());

		width = imageLoader.getWidth();
		height = imageLoader.getHeight();
		
		super.setTarget(target);
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
