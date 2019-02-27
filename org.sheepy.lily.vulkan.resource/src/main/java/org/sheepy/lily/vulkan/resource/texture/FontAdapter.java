package org.sheepy.lily.vulkan.resource.texture;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.Font;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.lily.vulkan.resource.image.AbstractSampledImageAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageInfo;

public class FontAdapter extends AbstractSampledImageAdapter
{
	public static final int BUFFER_WIDTH = 1024;
	public static final int BUFFER_HEIGHT = 1024;

	private STBTTFontinfo fontInfo;
	private STBTTPackedchar.Buffer cdata;
	private float descent;
	private float scale;
	private ByteBuffer bufferedRessource;

	@Override
	public void allocate(MemoryStack stack, ExecutionContext executionManager)
	{
		final var font = (Font) target;

		final var file = font.getFile();
		final var fileAdapter = FileResourceAdapter.adapt(file);
		bufferedRessource = fileAdapter.toByteBuffer(file);

		super.allocate(stack, executionManager);
	}

	@Override
	public void free()
	{
		super.free();

		fontInfo.free();
		cdata.free();
		MemoryUtil.memFree(bufferedRessource);
	}

	@Override
	protected ByteBuffer allocDataBuffer(MemoryStack stack)
	{
		final var font = (Font) target;

		return allocateFontTexture(stack, bufferedRessource, font.getHeight());
	}

	public ByteBuffer allocateFontTexture(MemoryStack stack, ByteBuffer ttf, int fontHeight)
	{
		ByteBuffer bitmap = null;
		ByteBuffer texture = null;
		try
		{
			fontInfo = STBTTFontinfo.calloc();
			cdata = STBTTPackedchar.malloc(95);
			stbtt_InitFont(fontInfo, ttf);
			scale = stbtt_ScaleForPixelHeight(fontInfo, fontHeight);

			IntBuffer d = stack.mallocInt(1);
			stbtt_GetFontVMetrics(fontInfo, null, d, null);
			descent = d.get(0) * scale;

			bitmap = memAlloc(BUFFER_WIDTH * BUFFER_HEIGHT);

			STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
			stbtt_PackBegin(pc, bitmap, BUFFER_WIDTH, BUFFER_HEIGHT, 0, 1, NULL);
			stbtt_PackSetOversampling(pc, 4, 4);
			if (stbtt_PackFontRange(pc, ttf, 0, fontHeight, 32, cdata) == false)
			{
				Logger.log("Fail to pack the font");
			}
			stbtt_PackEnd(pc);

			// Convert R8 to RGBA8
			texture = memAlloc(BUFFER_WIDTH * BUFFER_HEIGHT * 4);
			for (int i = 0; i < bitmap.capacity(); i++)
			{
				texture.putInt((bitmap.get(i) << 24) | 0x00FFFFFF);
			}
			texture.flip();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (bitmap != null)
			{
				memFree(bitmap);
			}
		}
		return texture;
	}

	public float getDescent()
	{
		return descent;
	}

	public STBTTFontinfo getFontInfo()
	{
		return fontInfo;
	}

	public STBTTPackedchar.Buffer getCdata()
	{
		return cdata;
	}

	public float getScale()
	{
		return scale;
	}

	@Override
	protected ImageInfo getImageInfo()
	{
		return new ImageInfo(BUFFER_WIDTH, BUFFER_HEIGHT, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_SAMPLED_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT, VK_IMAGE_TILING_OPTIMAL, 1);
	}

	public static FontAdapter adapt(Font font)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(font, FontAdapter.class);
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.FONT == eClass;
	}
}
