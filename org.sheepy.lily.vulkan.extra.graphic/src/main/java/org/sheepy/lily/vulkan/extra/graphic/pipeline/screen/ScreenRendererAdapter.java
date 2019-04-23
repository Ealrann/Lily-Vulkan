package org.sheepy.lily.vulkan.extra.graphic.pipeline.screen;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.extra.graphic.model.ScreenRenderer;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

@Statefull
@Adapter(scope = ScreenRenderer.class)
public class ScreenRendererAdapter extends GraphicsPipelineAdapter
{
	private static final ScreenVertexDescriptor VERTEX_DESCRIPTOR = new ScreenVertexDescriptor();

	private final ByteBuffer datas;

	private final GPUBufferBackend buffer;

	public ScreenRendererAdapter(ScreenRenderer pipeline)
	{
		super(pipeline);

		final int size = 8 * Float.BYTES;
		datas = MemoryUtil.memAlloc(size);

		final FloatBuffer floatDatas = datas.asFloatBuffer();
		floatDatas.put(-1).put(-1); // { -1.0f, -1.0f }
		floatDatas.put(1).put(-1); // { 1.0f, -1.0f }
		floatDatas.put(-1).put(1); // { -1.0f, 1.0f }
		floatDatas.put(1).put(1); // { 1.0f, 1.0f }

		final BufferInfo info = new BufferInfo(size,
				EBufferUsage.VERTEX_BUFFER_BIT_VALUE | EBufferUsage.TRANSFER_DST_BIT_VALUE, false);
		buffer = new GPUBufferBackend(info, false);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		buffer.pushData((IExecutionContext) context, datas);
		super.allocate(stack, context);
	}

	@Override
	public void collectResources(List<Object> collectIn)
	{
		super.collectResources(collectIn);
		collectIn.add(buffer);
	}

	@Dispose
	public void dispose()
	{
		MemoryUtil.memFree(datas);
	}

	@Override
	public void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index)
	{
		final long[] vertexBuffers = new long[1];
		final long[] offsets = new long[1];

		vertexBuffers[0] = buffer.getAddress();
		offsets[0] = 0;

		vkCmdBindPipeline(vkCommandBuffer, bindPoint, getPipelineId());
		pushConstants(vkCommandBuffer);
		bindDescriptor(vkCommandBuffer, bindPoint, new Integer[] {
				0
		});
		vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
		vkCmdBindVertexBuffers(vkCommandBuffer, 1, vertexBuffers, offsets);
		vkCmdDraw(vkCommandBuffer, 4, 1, 0, 0);
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return VERTEX_DESCRIPTOR;
	}
}
