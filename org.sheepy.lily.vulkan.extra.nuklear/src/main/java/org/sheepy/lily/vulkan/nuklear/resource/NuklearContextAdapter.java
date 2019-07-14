package org.sheepy.lily.vulkan.nuklear.resource;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.lwjgl.nuklear.NkAllocator;
import org.lwjgl.nuklear.NkBuffer;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkConvertConfig;
import org.lwjgl.nuklear.NkDrawCommand;
import org.lwjgl.nuklear.NkDrawNullTexture;
import org.lwjgl.nuklear.NkDrawVertexLayoutElement;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.nuklear.draw.DrawCommandData;
import org.sheepy.lily.vulkan.nuklear.input.NuklearInputCatcher;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.IStagingBuffer;
import org.sheepy.vulkan.resource.staging.IStagingBuffer.MemoryTicket.EReservationStatus;

@Statefull
@Adapter(scope = NuklearContext.class)
public class NuklearContextAdapter implements IResourceAdapter
{
	private static final int VERTEX_SIZE = 20;
	public static final long INDEXED_BUFFER_SIZE = (long) Math.pow(2, 19);
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);
	public static final long VERTEX_BUFFER_SIZE = INDEXED_BUFFER_SIZE - INDEX_BUFFER_SIZE;
	public static final long INDEX_OFFSET = INDEXED_BUFFER_SIZE - INDEX_BUFFER_SIZE;

	private static final int BUFFER_INITIAL_SIZE = 4 * 1024;
	private static final String NK_CONVERT_FAILED = "nk_convert failed: ";
	private static final NkDrawVertexLayoutElement.Buffer VERTEX_LAYOUT;
	static
	{
		VERTEX_LAYOUT = NkDrawVertexLayoutElement.create(4);
		VERTEX_LAYOUT.position(0).attribute(NK_VERTEX_POSITION).format(NK_FORMAT_FLOAT).offset(0);
		VERTEX_LAYOUT.position(1).attribute(NK_VERTEX_TEXCOORD).format(NK_FORMAT_FLOAT).offset(8);
		VERTEX_LAYOUT.position(2).attribute(NK_VERTEX_COLOR).format(NK_FORMAT_R8G8B8A8).offset(16);
		VERTEX_LAYOUT.position(3).attribute(NK_VERTEX_ATTRIBUTE_COUNT).format(NK_FORMAT_COUNT)
				.offset(0);
		VERTEX_LAYOUT.position(4).flip();
	}

	private final NuklearContext nuklearContext;
	private final NkAllocator ALLOCATOR;

	private NkBuffer cmds;
	private NkContext nkContext;
	private final NkDrawNullTexture nkNullTexture = NkDrawNullTexture.create();
	private final NkConvertConfig config = NkConvertConfig.create();

	private NkBuffer vbuf;
	private NkBuffer ebuf;

	private final List<Long> texturePtrs = new ArrayList<>();

	public NuklearContextAdapter(NuklearContext context)
	{
		this.nuklearContext = context;
		ALLOCATOR = NkAllocator.calloc().alloc((handle, old, size) -> nmemAllocChecked(size))
				.mfree((handle, ptr) -> nmemFree(ptr));
	}

	@Dispose
	public void dispose()
	{
		Objects.requireNonNull(ALLOCATOR.alloc()).free();
		Objects.requireNonNull(ALLOCATOR.mfree()).free();
		ALLOCATOR.free();
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var font = nuklearContext.getFont();
		final var fontAdapter = NuklearFontAdapter.adapt(font);
		final var nullTexture = nuklearContext.getNullTexture();
		final var nullTextureAdapter = ISampledImageAdapter.adapt(nullTexture);
		final var defaultFont = fontAdapter.getNkFont();
		final var layoutTask = nuklearContext.getLayoutTask();
		final var pipeline = ModelUtil.findParent(layoutTask, GraphicsPipeline.class);
		final var descriptorSet = pipeline.getDescriptorSetPkg().getDescriptorSets().get(0);
		final var layoutTaskAdapter = (NuklearLayoutTaskAdapter) IPipelineTaskAdapter
				.adapt(layoutTask);
		final var engine = VulkanModelUtil.getEngine(nuklearContext);
		final var inputManager = IVulkanEngineAdapter.adapt(engine).getInputManager();
		final var inputCatcher = NuklearInputCatcher.INSTANCE;

		reloadTexturePtrs(descriptorSet);

		nkContext = NkContext.create();
		cmds = NkBuffer.create();
		nk_init(nkContext, ALLOCATOR, defaultFont);
		nk_buffer_init(cmds, ALLOCATOR, BUFFER_INITIAL_SIZE);

		nkContext.style().window().fixed_background().data().color().a((byte) 150);

		inputManager.setInputCatcher(inputCatcher);
		inputCatcher.configure(nkContext, context.getWindow(), layoutTaskAdapter);

		nkContext.clip().copy((handle, text, len) -> {
			if (len == 0)
			{
				return;
			}

			try (var stack2 = MemoryStack.stackPush())
			{
				final ByteBuffer str = stack2.malloc(len + 1);
				MemoryUtil.memCopy(text, MemoryUtil.memAddress(str), len);
				str.put(len, (byte) 0);

				glfwSetClipboardString(context.getWindow().getId(), str);
			}
		}).paste((handle, edit) ->
		{
			final long text = nglfwGetClipboardString(context.getWindow().getId());
			if (text != 0)
			{
				nnk_textedit_paste(edit, text, nnk_strlen(text));
			}
		});

		nkNullTexture.texture().ptr(nullTextureAdapter.getSamplerPtr());
		nkNullTexture.uv().set(0.5f, 0.5f);

		vbuf = NkBuffer.calloc();
		ebuf = NkBuffer.calloc();

		config.null_texture(nkNullTexture);
		config.vertex_layout(VERTEX_LAYOUT);
		config.vertex_size(VERTEX_SIZE);
		config.vertex_alignment(4);
		config.circle_segment_count(20);
		config.curve_segment_count(20);
		config.arc_segment_count(20);
		config.global_alpha(1.0f);
		config.shape_AA(NK_ANTI_ALIASING_ON);
		config.line_AA(NK_ANTI_ALIASING_ON);
	}

	public boolean fillVertexBuffer(IStagingBuffer stagingBuffer, Buffer vertexBuffer)
	{
		boolean res = true;

		try
		{
			final var vertexBufferAdapter = IBufferAdapter.adapt(vertexBuffer);
			final var bufferPtr = vertexBufferAdapter.getPtr();

			final long vertexBufferSize = VERTEX_BUFFER_SIZE;
			final long indexBufferSize = INDEX_BUFFER_SIZE;
			final var vertexOffset = 0;

			final var vertexMemoryTicket = stagingBuffer.reserveMemory(vertexBufferSize);
			final var indexMemoryTicket = stagingBuffer.reserveMemory(indexBufferSize);

			if (vertexMemoryTicket.getReservationStatus() == EReservationStatus.SUCCESS
					&& indexMemoryTicket.getReservationStatus() == EReservationStatus.SUCCESS)
			{
				final var vertexMemoryMap = vertexMemoryTicket.getMemoryPtr();
				final var indexMemoryMap = indexMemoryTicket.getMemoryPtr();
				final var indexOffset = vertexBufferSize;

				final var vertexPushCommand = IDataFlowCommand.newPipelinePushCommand(
						vertexMemoryTicket, bufferPtr, vertexOffset,
						EPipelineStage.VERTEX_INPUT_BIT, EAccess.VERTEX_ATTRIBUTE_READ_BIT);

				final var indexPushCommand = IDataFlowCommand.newPipelinePushCommand(
						indexMemoryTicket, bufferPtr, indexOffset, EPipelineStage.VERTEX_INPUT_BIT,
						EAccess.VERTEX_ATTRIBUTE_READ_BIT);

				nnk_buffer_init_fixed(vbuf.address(), vertexMemoryMap, vertexBufferSize);
				stagingBuffer.addStagingCommand(vertexPushCommand);

				nnk_buffer_init_fixed(ebuf.address(), indexMemoryMap, indexBufferSize);
				stagingBuffer.addStagingCommand(indexPushCommand);

				// load draw vertices & elements directly into vertex + element buffer
				final int result = nk_convert(nkContext, cmds, vbuf, ebuf, config);
				if (result != 0)
				{
					System.err.println(NK_CONVERT_FAILED + result);
				}
			}
			else
			{
				res = false;
			}
		} catch (final Throwable t)
		{
			t.printStackTrace();
		}

		return res;
	}

	private void reloadTexturePtrs(DescriptorSet descriptorSet)
	{
		texturePtrs.clear();
		for (final var descriptor : descriptorSet.getDescriptors())
		{
			if (descriptor instanceof SampledImage)
			{
				final var adapter = ISampledImageAdapter.adapt((SampledImage) descriptor);
				final long ptr = adapter.getSamplerPtr();
				texturePtrs.add(ptr);
			}
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		Objects.requireNonNull(nkContext.clip().copy()).free();
		Objects.requireNonNull(nkContext.clip().paste()).free();

		nk_free(nkContext);
		nk_buffer_free(cmds);

		nkContext = null;
		cmds = null;

		vbuf.free();
		ebuf.free();
		vbuf = null;
		ebuf = null;
	}

	public List<DrawCommandData> prepareDrawCommands()
	{
		final List<DrawCommandData> res = new ArrayList<>();
		int drawedIndexes = 0;
		int previousDrawedIndexes = 0;

		for (NkDrawCommand cmd = nk__draw_begin(nkContext, cmds); cmd != null; cmd = nk__draw_next(
				cmd, cmds, nkContext))
		{
			final int elemCount = cmd.elem_count();
			if (elemCount <= 0)
			{
				continue;
			}
			else
			{
				drawedIndexes += elemCount;

				final var texturePtr = cmd.texture().ptr();
				final int descriptorIndex = texturePtrs.indexOf(texturePtr);

				res.add(new DrawCommandData(cmd, descriptorIndex));
			}
		}

		if (DebugUtil.DEBUG_ENABLED && previousDrawedIndexes != drawedIndexes)
		{
			System.out.println("Nuklear Index count:" + drawedIndexes);
			previousDrawedIndexes = drawedIndexes;
		}

		return res;
	}

	public void clearFrame()
	{
		nk_clear(nkContext);
	}

	public NkContext getNkContext()
	{
		return nkContext;
	}

	public static final NuklearContextAdapter adapt(NuklearContext context)
	{
		return IAdapterFactoryService.INSTANCE.adapt(context, NuklearContextAdapter.class);
	}
}
