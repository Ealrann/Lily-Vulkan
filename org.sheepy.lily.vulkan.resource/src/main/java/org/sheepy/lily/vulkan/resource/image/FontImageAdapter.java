package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IFontImageAdapter;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.lily.vulkan.resource.nativehelper.VkTexture;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.resource.image.VkImage;

@Statefull
@Adapter(scope = FontImage.class)
public class FontImageAdapter implements IFontImageAdapter
{
	public static final int BUFFER_WIDTH = 1024;
	public static final int BUFFER_HEIGHT = 1024;

	public static final VkImage.Builder imageBuilder;
	static
	{
		final var builder = VkImage.newBuilder(BUFFER_WIDTH, BUFFER_HEIGHT,
				VK_FORMAT_R8G8B8A8_UNORM);
		builder.usage(VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT);
		builder.properties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		builder.tiling(VK_IMAGE_TILING_OPTIMAL);
		builder.mipLevels(1);
		imageBuilder = builder.copyImmutable();
	}

	private final FontImage font;
	private final VkTexture vkTexture;

	private STBTTFontinfo fontInfo;
	private STBTTPackedchar.Buffer cdata;
	private float descent;
	private float scale;
	private ByteBuffer bufferedRessource;

	public FontImageAdapter(FontImage font)
	{
		this.font = font;

		vkTexture = new VkTexture(imageBuilder);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		final var executionContext = (ExecutionContext) context;

		final var file = font.getFile();
		final var fileAdapter = FileResourceAdapter.adapt(file);
		final var targetLayout = font.getInitialLayout();

		bufferedRessource = fileAdapter.toByteBuffer(file);

		vkTexture.allocate(stack, context);
		final var texture = allocDataBuffer(stack);
		vkTexture.loadImage(stack, executionContext, texture, targetLayout);

		memFree(texture);
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkTexture.free(context);

		fontInfo.free();
		cdata.free();
		MemoryUtil.memFree(bufferedRessource);

		fontInfo = null;
		cdata = null;
		bufferedRessource = null;
	}

	private ByteBuffer allocDataBuffer(MemoryStack stack)
	{
		final var fontHeight = font.getHeight();
		final var ttf = bufferedRessource;
		ByteBuffer bitmap = null;
		ByteBuffer texture = null;
		try
		{
			fontInfo = STBTTFontinfo.calloc();
			cdata = STBTTPackedchar.malloc(95);
			stbtt_InitFont(fontInfo, ttf);
			scale = stbtt_ScaleForPixelHeight(fontInfo, fontHeight);

			final IntBuffer d = stack.mallocInt(1);
			stbtt_GetFontVMetrics(fontInfo, null, d, null);
			descent = d.get(0) * scale;

			bitmap = memAlloc(BUFFER_WIDTH * BUFFER_HEIGHT);

			final STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
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
		} catch (final Exception e)
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

	@Override
	public VkImage getVkImage()
	{
		return vkTexture.getImage();
	}

	@Override
	public long getImagePtr()
	{
		return vkTexture.getImagePtr();
	}

	@Override
	public long getViewPtr()
	{
		return vkTexture.getViewPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return vkTexture.getMemoryPtr();
	}

	@Override
	public float getDescent()
	{
		return descent;
	}

	@Override
	public STBTTFontinfo getFontInfo()
	{
		return fontInfo;
	}

	@Override
	public STBTTPackedchar.Buffer getCdata()
	{
		return cdata;
	}

	@Override
	public float getScale()
	{
		return scale;
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		return List.of();
	}

	@Override
	public int getBufferWidth()
	{
		return BUFFER_WIDTH;
	}

	@Override
	public int getBufferHeight()
	{
		return BUFFER_HEIGHT;
	}
}