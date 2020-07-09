package org.sheepy.lily.vulkan.resource.font;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VK10;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.font.IFontImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunk;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.lily.vulkan.resource.font.util.CodepointMap;
import org.sheepy.lily.vulkan.resource.font.util.FontAllocator;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@ModelExtender(scope = FontImage.class)
@Allocation(context = ExecutionContext.class)
public final class FontImageAllocation implements IFontImageAllocation
{
	private static final int BASE_FONTIMAGE_WIDTH = 1024;
	private static final int BASE_FONTIMAGE_HEIGHT = 1024;
	private static final int H_OVERSAMPLING = 4;
	private static final int V_OVERSAMPLING = 4;

	private final List<Font> fonts;
	private final List<FontAllocator> fontAllocators;
	private final MemoryChunk memory;
	private final VkImage image;
	private final VkImageView view;

	private STBTTPackedchar.Buffer cdata;
	private CodepointMap codepointMap;

	public FontImageAllocation(FontImage fontImage, ExecutionContext context)
	{
		fonts = List.copyOf(fontImage.getFonts());
		fontAllocators = List.copyOf(buildAllocators(fonts));

		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		for (final var allocator : fontAllocators)
		{
			allocator.allocate(stack);
		}

		final var builder = new VkImageBuilder(fontImage, BASE_FONTIMAGE_WIDTH, BASE_FONTIMAGE_HEIGHT);
		final var memoryBuilder = new MemoryChunkBuilder(context, VK10.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		view = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
		image = builder.build(context, memoryBuilder);
		memory = memoryBuilder.build();
		memory.allocate(context);
		view.allocate(vkDevice, image);
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		image.free(context);
		view.free(vkDevice);
		memory.free(context);

		for (final var allocator : fontAllocators)
		{
			allocator.free();
		}

		if (cdata != null)
		{
			cdata.free();
			cdata = null;
		}
	}

	@Override
	public boolean push(Map<Font, List<String>> characterMap, TransferBuffer transferBuffer)
	{
		boolean res = false;
		if (cdata != null)
		{
			cdata.free();
			cdata = null;
		}

		addDefaultChars(characterMap, fonts.get(0));

		final var tmpCodePointMap = CodepointMap.fromCharacterMap(characterMap);
		if (codepointMap == null || codepointMap.isCompatible(tmpCodePointMap) == false)
		{
			codepointMap = tmpCodePointMap;
			try (final var stack = MemoryStack.stackPush())
			{
				cdata = STBTTPackedchar.calloc(codepointMap.codepointCount);

				final var transferBufferAdapter = transferBuffer.adapt(TransferBufferAllocation.class);
				final long memSize = BASE_FONTIMAGE_WIDTH * BASE_FONTIMAGE_HEIGHT;
				final var ticket = transferBufferAdapter.reserveMemory(memSize);

				if (ticket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS)
				{
					final var bitmap = ticket.toBuffer();

					final STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
					stbtt_PackBegin(pc, bitmap, BASE_FONTIMAGE_WIDTH, BASE_FONTIMAGE_HEIGHT, 0, 1, NULL);
					stbtt_PackSetOversampling(pc, H_OVERSAMPLING, V_OVERSAMPLING);

					int offset = 0;
					for (final var allocator : fontAllocators)
					{
						final var codepoints = codepointMap.get(allocator.font);
						allocator.clear();
						if (codepoints != null)
						{
							final var subCData = cdata.slice(offset, codepoints.length);
							allocator.fill(pc, subCData, codepoints);

							offset += codepoints.length;
						}
					}

					stbtt_PackEnd(pc);

					final var command = DataFlowCommandFactory.newPushImageCommand(ticket,
																				   image,
																				   EPipelineStage.TOP_OF_PIPE_BIT,
																				   List.of(EAccess.UNDEFINED),
																				   EPipelineStage.FRAGMENT_SHADER_BIT,
																				   List.of(EAccess.SHADER_READ_BIT),
																				   EImageLayout.GENERAL);

					transferBufferAdapter.addTransferCommand(command);
					res = true;
				}

			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			res = true;
		}

		return res;
	}

	private static void addDefaultChars(Map<Font, List<String>> characterMap, Font font)
	{
		final var list = characterMap.computeIfAbsent(font, k -> new ArrayList<>());
		list.add("!?,.+-*/123456789");
	}

	@Override
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

	@Override
	public VkImage getVkImage()
	{
		return image;
	}

	@Override
	public long getImagePtr()
	{
		return getVkImage().getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return view.getPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return getVkImage().getMemoryPtr();
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width, vkImage.height);
	}
}
