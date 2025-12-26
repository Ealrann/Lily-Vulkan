package org.sheepy.lily.vulkan.nuklear.logic;

import org.lwjgl.nuklear.*;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.core.window.Window;

import java.nio.ByteBuffer;
import java.util.Objects;

import static org.lwjgl.glfw.GLFW.glfwSetClipboardString;
import static org.lwjgl.glfw.GLFW.nglfwGetClipboardString;
import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.nmemAllocChecked;
import static org.lwjgl.system.MemoryUtil.nmemFree;

public record NuklearState(NkAllocator allocator, NkContext nkContext, NkBuffer cmds, NkBuffer vbuf, NkBuffer ebuf, NkDrawNullTexture nkNullTexture, NkConvertConfig config)
{
	private static final int BUFFER_INITIAL_SIZE = 4 * 1024;
	private static final int VERTEX_SIZE = 20;

	public static final int NULL_TEXTURE_DESCRIPTOR_INDEX = 0;

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

	public void free()
	{
		Objects.requireNonNull(nkContext.clip().copy()).free();
		Objects.requireNonNull(nkContext.clip().paste()).free();

		nk_free(nkContext);
		nk_buffer_free(cmds);

		vbuf.free();
		ebuf.free();

		Objects.requireNonNull(allocator.alloc()).free();
		Objects.requireNonNull(allocator.mfree()).free();
		allocator.free();
	}

	public static NuklearState build(final NkUserFont defaultNkFont, final Window window)
	{
		final var ALLOCATOR = NkAllocator.calloc()
										 .alloc((handle, old, size) -> nmemAllocChecked(size))
										 .mfree((handle, ptr) -> nmemFree(ptr));

		final var nkContext = NkContext.create();
		final var cmds = NkBuffer.create();
		nk_init(nkContext, ALLOCATOR, defaultNkFont);
		nk_buffer_init(cmds, ALLOCATOR, BUFFER_INITIAL_SIZE);

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
				glfwSetClipboardString(window.getPtr(), str);
			}
		}).paste((handle, edit) -> {
			final long text = nglfwGetClipboardString(window.getPtr());
			if (text != 0)
			{
				nnk_textedit_paste(edit, text, nnk_strlen(text));
			}
		});
		nkContext.style().window().fixed_background().data().color().a((byte) 150);

		final var vbuf = NkBuffer.calloc();
		final var ebuf = NkBuffer.calloc();

		final var nkNullTexture = NkDrawNullTexture.create();
		nkNullTexture.texture().ptr(NULL_TEXTURE_DESCRIPTOR_INDEX);
		nkNullTexture.uv().set(0.5f, 0.5f);

		final var config = NkConvertConfig.create();
		config.tex_null(nkNullTexture);
		config.vertex_layout(VERTEX_LAYOUT);
		config.vertex_size(VERTEX_SIZE);
		config.vertex_alignment(4);
		config.circle_segment_count(20);
		config.curve_segment_count(20);
		config.arc_segment_count(20);
		config.global_alpha(1.0f);
		config.shape_AA(NK_ANTI_ALIASING_ON);
		config.line_AA(NK_ANTI_ALIASING_ON);

		return new NuklearState(ALLOCATOR, nkContext, cmds, vbuf, ebuf, nkNullTexture, config);
	}
}
