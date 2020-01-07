package org.sheepy.lily.vulkan.resource.font;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.LongNotification;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.font.IFontImageAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.font.util.CodepointMap;
import org.sheepy.lily.vulkan.resource.font.util.FontAllocator;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageView;
import org.sheepy.vulkan.resource.memory.MemoryChunk;
import org.sheepy.vulkan.resource.memory.MemoryChunkBuilder;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket.EReservationStatus;

@Statefull
@Adapter(scope = FontImage.class)
public final class FontImageAdapter extends Notifier implements IFontImageAdapter
{
	private static final int BASE_FONTIMAGE_WIDTH = 1024;
	private static final int BASE_FONTIMAGE_HEIGHT = 1024;
	private static final int H_OVERSAMPLING = 4;
	private static final int V_OVERSAMPLING = 4;

	private final FontImage fontImage;
	private final List<Font> fonts;
	private final List<FontAllocator> fontAllocators;

	private boolean first = true;
	private int instance = 0;
	private int instanceCount = 0;
	private STBTTPackedchar.Buffer cdata;
	private CodepointMap codepointMap;

	private VkImage[] images;
	private VkImageView[] views;
	private MemoryChunk memory;

	public FontImageAdapter(FontImage fontImage)
	{
		super(Features.values().length);

		this.fontImage = fontImage;
		fonts = List.copyOf(fontImage.getFonts());
		fontAllocators = List.copyOf(buildAllocators(fonts));
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		for (final var allocator : fontAllocators)
		{
			allocator.allocate(stack);
		}

		instanceCount = VulkanModelUtil.getInstanceCount(context, fontImage.getInstanceCount());

		first = true;
		images = new VkImage[instanceCount];
		views = new VkImageView[instanceCount];

		final var builder = new VkImage.VkImageBuilder(	fontImage,
														BASE_FONTIMAGE_WIDTH,
														BASE_FONTIMAGE_HEIGHT);

		int properties = 0;
		for (int i = 0; i < instanceCount; i++)
		{
			final var image = builder.build();
			final var view = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
			images[i] = image;
			views[i] = view;
			properties |= image.properties;
		}
		final var memoryBuilder = new MemoryChunkBuilder(context, properties);
		for (int i = 0; i < instanceCount; i++)
		{
			images[i].allocate(context, memoryBuilder);
		}
		memory = memoryBuilder.build();
		memory.allocate(context);
		for (int i = 0; i < instanceCount; i++)
		{
			views[i].allocate(vkDevice, images[i]);
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		for (int i = 0; i < instanceCount; i++)
		{
			images[i].free(context);
			views[i].free(vkDevice);
		}
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

		images = null;
		views = null;
		instanceCount = 0;
		instance = 0;
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

		ByteBuffer bitmap = null;
		addDefaultChars(characterMap, fonts.get(0));

		final var tmpCodePointMap = CodepointMap.fromCharacterMap(characterMap);
		if (codepointMap == null || codepointMap.isCompatible(tmpCodePointMap) == false)
		{
			codepointMap = tmpCodePointMap;
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				cdata = STBTTPackedchar.calloc(codepointMap.codepointCount);

				final var transferBufferAdapter = transferBuffer.adapt(ITransferBufferAdapter.class);
				final var bb = transferBufferAdapter.getTransferBufferBackend();
				final long memSize = BASE_FONTIMAGE_WIDTH * BASE_FONTIMAGE_HEIGHT;
				final var ticket = bb.reserveMemory(memSize);

				if (ticket.getReservationStatus() == EReservationStatus.SUCCESS)
				{
					bitmap = ticket.toBuffer();

					final STBTTPackContext pc = STBTTPackContext.mallocStack(stack);
					stbtt_PackBegin(pc,
									bitmap,
									BASE_FONTIMAGE_WIDTH,
									BASE_FONTIMAGE_HEIGHT,
									0,
									1,
									NULL);
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

					if (first == true)
					{
						first = false;
					}
					else
					{
						nextInstance();
					}
					final var image = images[instance];
					final var command = IDataFlowCommand.newPushImageCommand(	ticket,
																				image,
																				EPipelineStage.TOP_OF_PIPE_BIT,
																				List.of(EAccess.UNDEFINED),
																				EPipelineStage.FRAGMENT_SHADER_BIT,
																				List.of(EAccess.SHADER_READ_BIT),
																				EImageLayout.GENERAL);

					bb.addTransferCommand(command);
					res = true;
				}

			} catch (final Exception e)
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
		var list = characterMap.get(font);
		if (list == null)
		{
			list = new ArrayList<>();
			characterMap.put(font, list);
		}
		list.add("!?,.+-*/123456789");
	}

	private void nextInstance()
	{
		final var oldImage = images[instance];
		final var oldView = views[instance];

		instance = (instance + 1) % instanceCount;

		final var newImage = images[instance];
		final var newView = views[instance];

		final var imageNotification = new LongNotification(	this,
															Features.Image,
															oldImage.getPtr(),
															newImage.getPtr());
		final var viewNotification = new LongNotification(	this,
															Features.View,
															oldView.getPtr(),
															newView.getPtr());

		fireNotification(imageNotification);
		fireNotification(viewNotification);
	}

	@Override
	public List<FontAllocator> getAllocators()
	{
		return fontAllocators;
	}

	public Font getDefaultFont()
	{
		return fonts.get(0);
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
		return images[instance];
	}

	@Override
	public long getImagePtr()
	{
		return getVkImage().getPtr();
	}

	@Override
	public long getViewPtr()
	{
		return views[instance].getPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return getVkImage().getMemoryPtr();
	}
}
