package org.sheepy.lily.vulkan.nuklear.pipeline;

import org.lwjgl.system.MemoryUtil;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.nio.ByteBuffer;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

@ModelExtender(scope = NuklearPushConstants.class)
@Adapter
public class NuklearPushConstantsAdapter implements IRecordableAdapter
{
	public static final int STAGE_FLAGS = EShaderStage.VERTEX_BIT_VALUE | EShaderStage.FRAGMENT_BIT_VALUE;
	public static final int SIZE = 16 * 4 + 4;

	private final ByteBuffer buffer;
	private final NuklearPushConstants pushConstants;

	public NuklearPushConstantsAdapter(NuklearPushConstants pushConstants)
	{
		this.pushConstants = pushConstants;
		buffer = MemoryUtil.memAlloc(SIZE);
		fillBuffer();
	}

	@Override
	public void record(RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(pushConstants, AbstractPipeline.class);
		final var pipelineAdapter = pipeline.adaptNotNull(IPipelineAllocation.class);
		final long layoutId = pipelineAdapter.getVkPipelineLayout().getPtr();
		final var commandBuffer = context.commandBuffer;

		vkCmdPushConstants(commandBuffer, layoutId, STAGE_FLAGS, 0, buffer);
	}

	@Dispose
	public void dispose()
	{
		MemoryUtil.memFree(buffer);
	}

	private void fillBuffer()
	{
		final int width = pushConstants.getWidth();
		final int height = pushConstants.getHeight();

		buffer.putFloat(2.0f / width);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(-2.0f / height);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(-1.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(-1.0f);
		buffer.putFloat(1.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(1.0f);

		buffer.putInt(pushConstants.getCurrentDescriptor());

		buffer.flip();
	}
}
