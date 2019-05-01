package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.nuklear.NkBuffer;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkConvertConfig;
import org.lwjgl.nuklear.NkDrawNullTexture;
import org.lwjgl.nuklear.NkDrawVertexLayoutElement;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearVertexDescriptor.GuiVertex;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.IStagingBuffer;
import org.sheepy.vulkan.resource.indexed.IndexedBuffer;

public class NuklearVertexBuffer implements IAllocable
{
	private static final String NK_CONVERT_FAILED = "nk_convert failed: ";

	public static final NuklearVertexDescriptor VERTEX_DESCRIPTOR = new NuklearVertexDescriptor();

	public static final int VERTEX_BUFFER_SIZE = 512 * 1024;
	public static final int INDEX_BUFFER_SIZE = 128 * 1024;

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

	private final NkDrawNullTexture nkNullTexture = NkDrawNullTexture.create();
	private final NkConvertConfig config = NkConvertConfig.create();

	private IndexedBuffer<?> indexedBuffer;

	private NullTexture nullTexture = null;
	private NkBuffer vbuf;
	private NkBuffer ebuf;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		nkNullTexture.texture().ptr(nullTexture.getSamplerAddress());
		nkNullTexture.uv().set(0.5f, 0.5f);

		vbuf = NkBuffer.calloc();
		ebuf = NkBuffer.calloc();

		indexedBuffer = new IndexedBuffer<GuiVertex>(VERTEX_DESCRIPTOR, VERTEX_BUFFER_SIZE,
				INDEX_BUFFER_SIZE);

		indexedBuffer.allocate(stack, context);

		config.null_texture(nkNullTexture);
		config.vertex_layout(VERTEX_LAYOUT);
		config.vertex_size(NuklearVertexDescriptor.SIZE_OF);
		config.vertex_alignment(4);
		config.circle_segment_count(20);
		config.curve_segment_count(20);
		config.arc_segment_count(20);
		config.global_alpha(1.0f);
		config.shape_AA(NK_ANTI_ALIASING_ON);
		config.line_AA(NK_ANTI_ALIASING_ON);
	}

	@Override
	public void free(IAllocationContext context)
	{
		indexedBuffer.free(context);
		indexedBuffer = null;

		vbuf.free();
		ebuf.free();
		vbuf = null;
		ebuf = null;
	}

	public void update(IStagingBuffer stagingBuffer, NkContext ctx, NkBuffer cmds)
	{
		final var vertexBuffer = indexedBuffer.getVertexBufferAddress();
		final var vertexOffset = indexedBuffer.getVertexMemoryOffset();

		final var vertexMemoryMap = stagingBuffer.reserveMemory(VERTEX_BUFFER_SIZE);
		nnk_buffer_init_fixed(vbuf.address(), vertexMemoryMap, VERTEX_BUFFER_SIZE);
		stagingBuffer.pushSynchronized(vertexMemoryMap, vertexBuffer, vertexOffset,
				EPipelineStage.VERTEX_INPUT_BIT, EAccess.VERTEX_ATTRIBUTE_READ_BIT);

		final var indexBuffer = indexedBuffer.getIndexBufferAddress();
		final var indexOffset = indexedBuffer.getIndexMemoryOffset();

		final var indexMemoryMap = stagingBuffer.reserveMemory(INDEX_BUFFER_SIZE);
		nnk_buffer_init_fixed(ebuf.address(), indexMemoryMap, INDEX_BUFFER_SIZE);
		stagingBuffer.pushSynchronized(indexMemoryMap, indexBuffer, indexOffset,
				EPipelineStage.VERTEX_INPUT_BIT, EAccess.VERTEX_ATTRIBUTE_READ_BIT);

		// load draw vertices & elements directly into vertex + element buffer
		final int result = nk_convert(ctx, cmds, vbuf, ebuf, config);
		if (result != 0)
		{
			System.err.println(NK_CONVERT_FAILED + result);
		}
	}

	public void bind(VkCommandBuffer commandBuffer)
	{
		// Bind vertex and index buffer
		final long[] pBuffer = {
				indexedBuffer.getVertexBufferAddress()
		};
		final long[] offsets = {
				0
		};
		vkCmdBindVertexBuffers(commandBuffer, 0, pBuffer, offsets);

		vkCmdBindIndexBuffer(commandBuffer, indexedBuffer.getIndexBufferAddress(), 0,
				VK_INDEX_TYPE_UINT16);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public void setNullTexture(NullTexture nullTexture)
	{
		this.nullTexture = nullTexture;
	}
}
