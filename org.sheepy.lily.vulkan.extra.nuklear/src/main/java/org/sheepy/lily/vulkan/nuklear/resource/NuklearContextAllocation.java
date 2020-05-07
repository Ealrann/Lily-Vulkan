package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.nuklear.*;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.nuklear.input.NuklearInputCatcher;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;

import java.nio.ByteBuffer;
import java.util.Objects;

import static org.lwjgl.glfw.GLFW.glfwSetClipboardString;
import static org.lwjgl.glfw.GLFW.nglfwGetClipboardString;
import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.nmemAllocChecked;
import static org.lwjgl.system.MemoryUtil.nmemFree;

@ModelExtender(scope = NuklearContext.class)
@Allocation(context = ExecutionContext.class)
public class NuklearContextAllocation implements IAllocation
{
	public static final int NULL_TEXTURE_DESCRIPTOR_INDEX = 0;
	public static final int FONT_TEXTURE_DESCRIPTOR_INDEX = 1;

	private static final int VERTEX_SIZE = 20;

	private static final int BUFFER_INITIAL_SIZE = 4 * 1024;
	private static final NkDrawVertexLayoutElement.Buffer VERTEX_LAYOUT;

	static
	{
		VERTEX_LAYOUT = NkDrawVertexLayoutElement.create(4);
		VERTEX_LAYOUT.position(0).attribute(NK_VERTEX_POSITION).format(NK_FORMAT_FLOAT).offset(0);
		VERTEX_LAYOUT.position(1).attribute(NK_VERTEX_TEXCOORD).format(NK_FORMAT_FLOAT).offset(8);
		VERTEX_LAYOUT.position(2).attribute(NK_VERTEX_COLOR).format(NK_FORMAT_R8G8B8A8).offset(16);
		VERTEX_LAYOUT.position(3).attribute(NK_VERTEX_ATTRIBUTE_COUNT).format(NK_FORMAT_COUNT).offset(0);
		VERTEX_LAYOUT.position(4).flip();
	}

	private final NuklearContext nuklearContext;
	private final NkDrawNullTexture nkNullTexture = NkDrawNullTexture.create();
	private final NkConvertConfig config = NkConvertConfig.create();
	private final NuklearLayoutTaskAdapter layoutTaskAdapter;

	private final NkAllocator ALLOCATOR;
	private NkBuffer cmds;
	private NkContext nkContext;

	private NkBuffer vbuf;
	private NkBuffer ebuf;

	public NuklearContextAllocation(NuklearContext nuklearContext,
									ExecutionContext context,
									@AllocationDependency(features = NuklearPackage.NUKLEAR_CONTEXT__FONT, type = NuklearFontAllocation.class) NuklearFontAllocation fontAllocation)
	{
		this.nuklearContext = nuklearContext;
		this.ALLOCATOR = NkAllocator.calloc()
									.alloc((handle, old, size) -> nmemAllocChecked(size))
									.mfree((handle, ptr) -> nmemFree(ptr));

		final var layoutTask = nuklearContext.getLayoutTask();
		this.layoutTaskAdapter = layoutTask.adaptNotNull(NuklearLayoutTaskAdapter.class);

		allocate(context, fontAllocation);
	}

	private void allocate(ExecutionContext context, NuklearFontAllocation fontAllocation)
	{
		final var nulkearFontAdapter = nuklearContext.getFont().adapt(NuklearFontAdapter.class);
		final var defaultFont = nulkearFontAdapter.defaultFont;
		final var engine = VulkanModelUtil.getEngine(nuklearContext);
		final var inputManager = engine.adaptNotNull(IVulkanEngineAdapter.class).getInputManager();
		final var inputCatcher = NuklearInputCatcher.INSTANCE;
		final var defaultNkFont = fontAllocation.fontMap.get(defaultFont);

		nkContext = NkContext.create();
		cmds = NkBuffer.create();
		nk_init(nkContext, ALLOCATOR, defaultNkFont);
		nk_buffer_init(cmds, ALLOCATOR, BUFFER_INITIAL_SIZE);

		nkContext.style().window().fixed_background().data().color().a((byte) 150);

		inputManager.setInputCatcher(inputCatcher);
		inputCatcher.configure(nkContext, context.getWindow(), layoutTaskAdapter);

		nkContext.clip().copy((handle, text, len) -> {
			if (len == 0)
			{
				return;
			}

			try (final var stack = MemoryStack.stackPush())
			{
				final ByteBuffer str = stack.malloc(len + 1);
				MemoryUtil.memCopy(text, MemoryUtil.memAddress(str), len);
				str.put(len, (byte) 0);
				glfwSetClipboardString(context.getWindow().getPtr(), str);
			}
		}).paste((handle, edit) -> {
			final long text = nglfwGetClipboardString(context.getWindow().getPtr());
			if (text != 0)
			{
				nnk_textedit_paste(edit, text, nnk_strlen(text));
			}
		});

		nkNullTexture.texture().ptr(NULL_TEXTURE_DESCRIPTOR_INDEX);
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

	@Dispose
	public void dispose()
	{
		Objects.requireNonNull(ALLOCATOR.alloc()).free();
		Objects.requireNonNull(ALLOCATOR.mfree()).free();
		ALLOCATOR.free();

		final var imageDescriptor = nuklearContext.getImageArrayDescriptor();
		if (imageDescriptor != null)
		{
			imageDescriptor.getImages().clear();
		}
	}

	@Free
	public void free()
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
