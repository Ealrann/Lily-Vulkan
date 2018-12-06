package org.sheepy.vulkan.resource.texture;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.resource.Font;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferBackend;
import org.sheepy.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.vulkan.resource.image.AbstractSampledResourceAdapter;
import org.sheepy.vulkan.resource.image.ImageBackend;

public abstract class FontAdapter extends AbstractSampledResourceAdapter
{
	public static final int BUFFER_WIDTH = 1024;
	public static final int BUFFER_HEIGHT = 1024;

	private STBTTFontinfo fontInfo;
	private STBTTPackedchar.Buffer cdata;
	private float descent;
	private float scale;

	@Override
	protected void loadImage(MemoryStack stack, ImageBackend imageBackend)
	{
		final var context = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		final var logicalDevice = context.getLogicalDevice();
		final var font = (Font) target;

		final var file = font.getFile();
		final var fileAdapter = FileResourceAdapter.adapt(file);
		final ByteBuffer bufferedRessource = fileAdapter.toByteBuffer(file);

		ByteBuffer fontTexture = allocateFontTexture(stack, bufferedRessource, font.getHeight());
		memFree(bufferedRessource);

		int size = BUFFER_WIDTH * BUFFER_HEIGHT * 4;

		final int stagingUsage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final BufferBackend buffer = BufferAllocator.allocateCPUBufferAndFill(stack, logicalDevice,
				size, stagingUsage, fontTexture);

		final SingleTimeCommand stc = new SingleTimeCommand(context)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				imageBackend.transitionImageLayout(commandBuffer, EPipelineStage.TOP_OF_PIPE_BIT,
						EPipelineStage.TRANSFER_BIT, EImageLayout.UNDEFINED,
						EImageLayout.TRANSFER_DST_OPTIMAL, 0, VK_ACCESS_TRANSFER_WRITE_BIT);

				imageBackend.fillWithBuffer(commandBuffer, buffer.getId());
			}
		};
		stc.execute();

		MemoryUtil.memFree(fontTexture);
	}

	public ByteBuffer allocateFontTexture(MemoryStack stack, ByteBuffer ttf, int fontHeight)
	{
		ByteBuffer bitmap = null;
		ByteBuffer texture = null;
		try
		{
			fontInfo = STBTTFontinfo.create();
			cdata = STBTTPackedchar.create(95);
			stbtt_InitFont(fontInfo, ttf);
			scale = stbtt_ScaleForPixelHeight(fontInfo, fontHeight);

			IntBuffer d = stack.mallocInt(1);
			stbtt_GetFontVMetrics(fontInfo, null, d, null);
			descent = d.get(0) * scale;

			bitmap = memAlloc(BUFFER_WIDTH * BUFFER_HEIGHT);

			STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
			stbtt_PackBegin(pc, bitmap, BUFFER_WIDTH, BUFFER_HEIGHT, 0, 1, NULL);
			stbtt_PackSetOversampling(pc, 4, 4);
			stbtt_PackFontRange(pc, ttf, 0, fontHeight, 32, cdata);
			stbtt_PackEnd(pc);

			// Convert R8 to RGBA8
			texture = memAlloc(BUFFER_WIDTH * BUFFER_HEIGHT * 4);
			for (int i = 0; i < bitmap.capacity(); i++)
			{
				texture.putInt((bitmap.get(i) << 24) | 0x00FFFFFF);
			}
			texture.flip();
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
	protected int getWidth()
	{
		return BUFFER_WIDTH;
	}

	@Override
	protected int getHeight()
	{
		return BUFFER_HEIGHT;
	}

	@Override
	protected int getFormat()
	{
		return VK_FORMAT_R8G8B8A8_UNORM;
	}

	@Override
	protected int getUsage()
	{
		return VK_IMAGE_USAGE_TRANSFER_SRC_BIT
				| VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT;
	}

	@Override
	protected int getMipLevels()
	{
		return 1;
	}

	public static FontAdapter adapt(Font font)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(font, FontAdapter.class);
	}
}
