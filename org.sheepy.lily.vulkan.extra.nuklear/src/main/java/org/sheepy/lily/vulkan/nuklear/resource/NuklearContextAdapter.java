package org.sheepy.lily.vulkan.nuklear.resource;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;
import java.util.Objects;

import org.lwjgl.nuklear.NkAllocator;
import org.lwjgl.nuklear.NkBuffer;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkConvertConfig;
import org.lwjgl.nuklear.NkDrawNullTexture;
import org.lwjgl.nuklear.NkDrawVertexLayoutElement;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.nuklear.input.NuklearInputCatcher;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = NuklearContext.class)
public class NuklearContextAdapter implements IVulkanResourceAdapter
{
	private static final int VERTEX_SIZE = 20;
	public static final long INDEXED_BUFFER_SIZE = (long) Math.pow(2, 19);
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);
	public static final long VERTEX_BUFFER_SIZE = INDEXED_BUFFER_SIZE - INDEX_BUFFER_SIZE;
	public static final long INDEX_OFFSET = INDEXED_BUFFER_SIZE - INDEX_BUFFER_SIZE;

	private static final int BUFFER_INITIAL_SIZE = 4 * 1024;
	private static final NkDrawVertexLayoutElement.Buffer VERTEX_LAYOUT;
	static
	{
		VERTEX_LAYOUT = NkDrawVertexLayoutElement.create(4);
		VERTEX_LAYOUT.position(0).attribute(NK_VERTEX_POSITION).format(NK_FORMAT_FLOAT).offset(0);
		VERTEX_LAYOUT.position(1).attribute(NK_VERTEX_TEXCOORD).format(NK_FORMAT_FLOAT).offset(8);
		VERTEX_LAYOUT.position(2).attribute(NK_VERTEX_COLOR).format(NK_FORMAT_R8G8B8A8).offset(16);
		VERTEX_LAYOUT	.position(3)
						.attribute(NK_VERTEX_ATTRIBUTE_COUNT)
						.format(NK_FORMAT_COUNT)
						.offset(0);
		VERTEX_LAYOUT.position(4).flip();
	}

	private final NuklearContext nuklearContext;
	private final NkDrawNullTexture nkNullTexture = NkDrawNullTexture.create();
	private final NkConvertConfig config = NkConvertConfig.create();

	private NkAllocator ALLOCATOR;
	private NkBuffer cmds;
	private NkContext nkContext;

	private NkBuffer vbuf;
	private NkBuffer ebuf;
	private NuklearLayoutTaskAdapter layoutTaskAdapter;

	public NuklearContextAdapter(NuklearContext context)
	{
		this.nuklearContext = context;
	}

	@Load
	private void load()
	{
		ALLOCATOR = NkAllocator	.calloc()
								.alloc((handle, old, size) -> nmemAllocChecked(size))
								.mfree((handle, ptr) -> nmemFree(ptr));

		final var layoutTask = nuklearContext.getLayoutTask();
		layoutTaskAdapter = layoutTask.adaptNotNull(NuklearLayoutTaskAdapter.class);
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
		final var fontAdapter = font.adaptNotNull(NuklearFontAdapter.class);
		final var defaultFont = fontAdapter.getDefaultFont();
		final var nullTexture = nuklearContext.getNullTexture();
		final var nullTextureAdapter = nullTexture.adaptNotNull(ISampledImageAdapter.class);
		final var engine = VulkanModelUtil.getEngine(nuklearContext);
		final var inputManager = engine.adaptNotNull(IVulkanEngineAdapter.class).getInputManager();
		final var inputCatcher = NuklearInputCatcher.INSTANCE;
		final var defaultNkFont = fontAdapter.fontMap.get(defaultFont);

		nkContext = NkContext.create();
		cmds = NkBuffer.create();
		nk_init(nkContext, ALLOCATOR, defaultNkFont);
		nk_buffer_init(cmds, ALLOCATOR, BUFFER_INITIAL_SIZE);

		nkContext.style().window().fixed_background().data().color().a((byte) 150);

		inputManager.setInputCatcher(inputCatcher);
		inputCatcher.configure(nkContext, context.getWindow(), layoutTaskAdapter);

		nkContext.clip().copy((handle, text, len) ->
		{
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

	public boolean isDirty()
	{
		return layoutTaskAdapter.isDirty();
	}

	public void clearFrame()
	{
		nk_clear(nkContext);
	}

	public NkContext getNkContext()
	{
		return nkContext;
	}

	public NkBuffer getCmds()
	{
		return cmds;
	}

	public NkBuffer getVBuf()
	{
		return vbuf;
	}

	public NkBuffer getEBuf()
	{
		return ebuf;
	}

	public NkConvertConfig getConfig()
	{
		return config;
	}
}
