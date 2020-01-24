package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.common.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.common.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

@Statefull
@Adapter(scope = NuklearPushConstants.class)
public class NuklearPushConstantsAdapter implements IPipelineTaskAdapter<NuklearPushConstants>
{
	public static final int STAGE_FLAGS = EShaderStage.VERTEX_BIT_VALUE
			| EShaderStage.FRAGMENT_BIT_VALUE;
	public static final int SIZE = 16 * 4 + 4;

	private final ByteBuffer buffer;
	private final NuklearPushConstants pushConstants;

	private boolean needRecord = true;

	public NuklearPushConstantsAdapter(NuklearPushConstants pushConstants)
	{
		this.pushConstants = pushConstants;
		buffer = MemoryUtil.memAlloc(SIZE);
		fillBuffer();
	}

	@Override
	public void record(NuklearPushConstants pushConstant, IRecordContext context)
	{
		final var pipeline = ModelUtil.findParent(pushConstant, IPipeline.class);
		final var pipelineAdapter = pipeline.<IVkPipelineAdapter<?>> adaptNotNullGeneric(IPipelineAdapter.class);
		final long layoutId = pipelineAdapter.getVkPipelineLayout().getId();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdPushConstants(commandBuffer, layoutId, STAGE_FLAGS, 0, buffer);

		needRecord = false;
	}

	@Override
	public boolean needRecord(NuklearPushConstants task, int index)
	{
		return needRecord;
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

		needRecord = true;
	}
}
