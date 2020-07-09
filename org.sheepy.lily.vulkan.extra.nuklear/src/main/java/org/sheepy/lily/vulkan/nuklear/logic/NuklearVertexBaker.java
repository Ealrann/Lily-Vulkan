package org.sheepy.lily.vulkan.nuklear.logic;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.nuklear.Nuklear.*;

public final class NuklearVertexBaker implements IExtender
{
	private static final String NK_CONVERT_FAILED = "nk_convert failed: ";

	private final List<Long> texturePtrs = new ArrayList<>();
	private final NuklearState state;

	private int previousDrawedIndexes = 0;

	public NuklearVertexBaker(GraphicsPipeline pipeline, NuklearState state)
	{
		this.state = state;

		final var descriptorSet = pipeline.getDescriptorPool().getDescriptorSets().get(0);
		reloadTexturePtrs(descriptorSet);
	}

	public List<DrawCommandData> buildDrawCommands()
	{
		final boolean vertexUpdated = fillVertexBuffer();

		if (vertexUpdated == true)
		{
			return prepareDrawCommands();
		}
		else
		{
			return List.of();
		}

		// Print vertex buffer
		//
		// final var backend = ((StagingBuffer) stagingBuffer).bufferBackend;
		// NuklearVertexDescriptor.dumpVertex(backend.getMemoryMap(),
		// NuklearVertexBuffer.VERTEX_BUFFER_SIZE);
		//
		// NuklearVertexDescriptor.dumpIndex(
		// backend.getMemoryMap() + NuklearVertexBuffer.VERTEX_BUFFER_SIZE - 24,
		// f NuklearVertexBuffer.INDEX_BUFFER_SIZE);
	}

	private boolean fillVertexBuffer()
	{
		boolean res = true;

		final var nkContext = state.nkContext();
		final var cmds = state.cmds();
		final var vbuf = state.vbuf();
		final var ebuf = state.ebuf();
		final var config = state.config();

		// load draw vertices & elements directly into vertex + element buffer
		final int result = nk_convert(nkContext, cmds, vbuf, ebuf, config);
		if (result != NK_CONVERT_SUCCESS)
		{
			final var messageBuilder = new StringBuilder();
			messageBuilder.append(NK_CONVERT_FAILED);
			if ((result & NK_CONVERT_INVALID_PARAM) != 0) messageBuilder.append("\nNK_CONVERT_INVALID_PARAM");
			if ((result & NK_CONVERT_COMMAND_BUFFER_FULL) != 0)
				messageBuilder.append("\nNK_CONVERT_COMMAND_BUFFER_FULL");
			if ((result & NK_CONVERT_VERTEX_BUFFER_FULL) != 0) messageBuilder.append("\nNK_CONVERT_VERTEX_BUFFER_FULL");
			if ((result & NK_CONVERT_ELEMENT_BUFFER_FULL) != 0)
				messageBuilder.append("\nNK_CONVERT_ELEMENT_BUFFER_FULL");

			res = false;
			System.err.println(messageBuilder);
		}
		return res;
	}

	public List<DrawCommandData> prepareDrawCommands()
	{
		final List<DrawCommandData> res = new ArrayList<>();
		int drawedIndexes = 0;

		final var nkContext = state.nkContext();
		final var cmds = state.cmds();

		var drawCommand = nk__draw_begin(nkContext, cmds);
		while (drawCommand != null)
		{
			final int elemCount = drawCommand.elem_count();
			if (elemCount > 0)
			{
				final var texturePtr = drawCommand.texture().ptr();
				final int descriptorIndex = texturePtr > 1 ? texturePtrs.indexOf(texturePtr) + 2 : (int) texturePtr;

				res.add(new DrawCommandData(drawCommand, descriptorIndex));
				drawedIndexes += elemCount;
			}

			drawCommand = nk__draw_next(drawCommand, cmds, nkContext);
		}

		if (DebugUtil.DEBUG_VERBOSE_ENABLED && previousDrawedIndexes != drawedIndexes)
		{
			System.out.println("Nuklear Index count:" + drawedIndexes);
			previousDrawedIndexes = drawedIndexes;
		}

		return res;
	}

	private void reloadTexturePtrs(DescriptorSet descriptorSet)
	{
//		mouais, on va trouver un meilleur moyen de chercher ces pointeurs quand meme
//
//		texturePtrs.clear();
//		for (final var descriptor : descriptorSet.getDescriptors())
//		{
//			final var allocation = descriptor.adapt(IDescriptorAllocation.class);
//			final var vkDescriptor = allocation.getVkDescriptor();
//			if (vkDescriptor instanceof VkImageArrayDescriptor)
//			{
//				final var viewPtrs = ((VkImageArrayDescriptor) vkDescriptor).getViewPtrs();
//				for (int i = 0; i < viewPtrs.length; i++)
//				{
//					final var ptr = viewPtrs[i];
//					texturePtrs.add(ptr);
//				}
//			}
//		}
	}
}
