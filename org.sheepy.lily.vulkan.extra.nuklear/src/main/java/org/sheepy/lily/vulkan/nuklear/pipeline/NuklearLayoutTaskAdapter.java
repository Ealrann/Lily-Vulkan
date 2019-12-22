package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.nuklear.Nuklear.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.api.util.AdapterSetRegistry;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor;
import org.sheepy.lily.vulkan.nuklear.draw.DrawCommandData;
import org.sheepy.lily.vulkan.nuklear.draw.DrawTaskMaintainer;
import org.sheepy.lily.vulkan.nuklear.pipeline.util.NuklearImageInstaller;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.resource.image.VkImageArrayDescriptor;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = NuklearLayoutTask.class, lazy = false)
public final class NuklearLayoutTaskAdapter
		implements IPipelineTaskAdapter<NuklearLayoutTask>, IAllocableAdapter<IGraphicContext>
{
	private static final String NK_CONVERT_FAILED = "nk_convert failed: ";

	private final AdapterSetRegistry<IPanelAdapter> PANEL_REGISTRY = new AdapterSetRegistry<>(	IPanelAdapter.class,
																								List.of(GraphicPackage.Literals.GRAPHICS_PIPELINE__SCENE_PART,
																										PresentationPackage.Literals.UI__CURRENT_UI_PAGE,
																										PresentationPackage.Literals.UI_PAGE__PANELS));

	private final DrawTaskMaintainer drawTaskMaintainer;
	private final NuklearLayoutTask task;
	private final List<Long> texturePtrs = new ArrayList<>();
	private final GraphicsPipeline pipeline;

	private boolean dirty = true;
	private boolean vertexUpdated = false;
	private IGraphicContext context;

	private Extent2D currentExtent;
	private NuklearContextAdapter nuklearContextAdapter;
	private Window window;
	private NuklearImageInstaller imageInstaller = null;

	public NuklearLayoutTaskAdapter(NuklearLayoutTask task)
	{
		this.task = task;
		pipeline = ModelUtil.findParent(task, GraphicsPipeline.class);

		final var drawTask = task.getDrawTask();
		final var vertexBuffer = task.getVertexBuffer();

		drawTaskMaintainer = new DrawTaskMaintainer(drawTask, vertexBuffer);
	}

	@Load
	public void load()
	{
		PANEL_REGISTRY.startRegister(pipeline);
		setupImageCapability();
	}

	@Dispose
	public void dispose()
	{
		PANEL_REGISTRY.stopRegister(pipeline);
	}

	private void setupImageCapability()
	{
		final List<FileResource> imagePaths = collectImages();
		final var imageArray = task.getImageArray();
		if (imageArray != null && imagePaths.isEmpty() == false)
		{
			imageInstaller = new NuklearImageInstaller(pipeline, imagePaths, imageArray);
		}
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		this.context = context;
		window = context.getWindow();
		nuklearContextAdapter = task.getContext().adaptNotNull(NuklearContextAdapter.class);

		final var descriptorSet = pipeline.getDescriptorSetPkg().getDescriptorSets().get(0);
		reloadTexturePtrs(descriptorSet);

		// Prepare a first render before the opening of the window
		layout(List.of());
	}

	private List<FileResource> collectImages()
	{
		final List<FileResource> images = new ArrayList<>();

		final var panelAdapters = PANEL_REGISTRY.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			panelAdapter.collectImages(images);
		}

		return List.copyOf(images);
	}

	@Override
	public void free(IGraphicContext context)
	{
		this.context = null;
	}

	public void layout(List<IInputEvent> events)
	{
		final var nkContext = nuklearContextAdapter.getNkContext();
		final var uiContext = new UIContext(window, nkContext, getImageMap(), events);

		final var extent = context.getSurfaceManager().getExtent();
		if (extent != currentExtent)
		{
			dirty = true;
			currentExtent = extent;
		}

		final var panelAdapters = PANEL_REGISTRY.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			dirty |= panelAdapter.layout(uiContext);
		}
	}

	private Map<FileResource, NkImage> getImageMap()
	{
		if (imageInstaller != null)
		{
			return Map.copyOf(imageInstaller.imageMap());
		}
		else
		{
			return Map.of();
		}
	}

	@Override
	public void update(NuklearLayoutTask task, int index)
	{
		// if (nk_item_is_any_active(nkContext))
		// {
		// dirty = true;
		// }

		if (dirty)
		{
			vertexUpdated = fillVertexBuffer();

			if (vertexUpdated == true)
			{
				final var commands = prepareDrawCommands();
				drawTaskMaintainer.reloadTasks(commands, currentExtent);
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

		nuklearContextAdapter.clearFrame();
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

	private void reloadTexturePtrs(DescriptorSet descriptorSet)
	{
		texturePtrs.clear();
		for (final var descriptor : descriptorSet.getDescriptors())
		{
			final var adapter = descriptor.adaptNotNull(IDescriptorAdapter.class);
			final var vkDescriptor = adapter.getVkDescriptor();
			if (descriptor instanceof SampledImageDescriptor)
			{
				final long ptr = ((VkImageDescriptor) vkDescriptor).getSamplerPtr();
				texturePtrs.add(ptr);
			}
			else if (descriptor instanceof Texture2DArrayDescriptor)
			{
				final var ptrs = ((VkImageArrayDescriptor) vkDescriptor).getViewPtrs();
				for (int i = 0; i < ptrs.length; i++)
				{
					final var ptr = ptrs[i];
					texturePtrs.add(ptr);
				}
			}
		}
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
				final int descriptorIndex = texturePtrs.indexOf(texturePtr);

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
	public void record(NuklearLayoutTask task, RecordContext context)
	{
		dirty = !vertexUpdated;
	}

	@Override
	public boolean needRecord(NuklearLayoutTask task, int index)
	{
		return dirty;
	}

	public boolean isDirty()
	{
		return dirty;
	}
}
