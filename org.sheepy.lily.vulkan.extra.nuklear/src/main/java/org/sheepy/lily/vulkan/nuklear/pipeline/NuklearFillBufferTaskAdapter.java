package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.nuklear.Nuklear.*;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.common.resource.image.VkImageArrayDescriptor;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.nuklear.draw.DrawCommandData;
import org.sheepy.lily.vulkan.nuklear.draw.DrawTaskMaintainer;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;

@Statefull
@Adapter(scope = NuklearFillBufferTask.class)
public final class NuklearFillBufferTaskAdapter
		implements IPipelineTaskAdapter<NuklearFillBufferTask>, IAllocableAdapter<IGraphicContext>
{
	private static final String NK_CONVERT_FAILED = "nk_convert failed: ";

	private final DrawTaskMaintainer drawTaskMaintainer;
	private final NuklearFillBufferTask task;
	private final List<Long> texturePtrs = new ArrayList<>();

	private NuklearLayoutTaskAdapter layoutAdapter;
	private NuklearContextAdapter nuklearContextAdapter;

	public NuklearFillBufferTaskAdapter(NuklearFillBufferTask task)
	{
		this.task = task;

		final var drawTask = task.getDrawTask();
		final var vertexBuffer = task.getVertexBuffer();

		drawTaskMaintainer = new DrawTaskMaintainer(drawTask, vertexBuffer);
	}

	@Load
	public void load()
	{
		layoutAdapter = task.getLayoutTask().adapt(NuklearLayoutTaskAdapter.class);
		nuklearContextAdapter = task.getContext().adaptNotNull(NuklearContextAdapter.class);
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var pipeline = ModelUtil.findParent(task, GraphicsPipeline.class);
		final var descriptorSet = pipeline.getDescriptorSetPkg().getDescriptorSets().get(0);
		reloadTexturePtrs(descriptorSet);
	}

	@Override
	public void free(IGraphicContext context)
	{}

	@Override
	public void update(NuklearFillBufferTask task, int index)
	{
		if (layoutAdapter.isDirty())
		{
			final boolean vertexUpdated = fillVertexBuffer();

			if (vertexUpdated == true)
			{
				final var commands = prepareDrawCommands();
				drawTaskMaintainer.reloadTasks(commands, layoutAdapter.getExtent());
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

		if (layoutAdapter.isFrameStarted())
		{
			layoutAdapter.clearFrame();
		}
	}

	public boolean fillVertexBuffer()
	{
		boolean res = true;

		final var nkContext = nuklearContextAdapter.getNkContext();
		final var cmds = nuklearContextAdapter.getCmds();
		final var vbuf = nuklearContextAdapter.getVBuf();
		final var ebuf = nuklearContextAdapter.getEBuf();
		final var config = nuklearContextAdapter.getConfig();

		// load draw vertices & elements directly into vertex + element buffer
		final int result = nk_convert(nkContext, cmds, vbuf, ebuf, config);
		if (result != 0)
		{
			res = false;
			System.err.println(NK_CONVERT_FAILED + result);
		}

		return res;
	}

	public List<DrawCommandData> prepareDrawCommands()
	{
		final List<DrawCommandData> res = new ArrayList<>();
		int drawedIndexes = 0;
		int previousDrawedIndexes = 0;

		final var nkContext = nuklearContextAdapter.getNkContext();
		final var cmds = nuklearContextAdapter.getCmds();

		var drawCommand = nk__draw_begin(nkContext, cmds);
		while (drawCommand != null)
		{
			final int elemCount = drawCommand.elem_count();
			if (elemCount > 0)
			{
				final var texturePtr = drawCommand.texture().ptr();
				final int descriptorIndex = texturePtr > 1
						? texturePtrs.indexOf(texturePtr) + 2
						: (int) texturePtr;

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

	@Override
	public void record(NuklearFillBufferTask task, IRecordContext context)
	{}

	private void reloadTexturePtrs(DescriptorSet descriptorSet)
	{
		texturePtrs.clear();
		for (final var descriptor : descriptorSet.getDescriptors())
		{
			final var adapter = descriptor.adaptNotNull(IDescriptorAdapter.class);
			final var vkDescriptor = adapter.getVkDescriptor();
			if (vkDescriptor instanceof VkImageArrayDescriptor)
			{
				final var viewPtrs = ((VkImageArrayDescriptor) vkDescriptor).getViewPtrs();
				for (int i = 0; i < viewPtrs.length; i++)
				{
					final var ptr = viewPtrs[i];
					texturePtrs.add(ptr);
				}
			}
		}
	}
}
