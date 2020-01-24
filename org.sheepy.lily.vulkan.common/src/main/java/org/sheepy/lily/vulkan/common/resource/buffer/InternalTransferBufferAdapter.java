package org.sheepy.lily.vulkan.common.resource.buffer;

import java.util.function.Consumer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter.IRecordContext;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;

public interface InternalTransferBufferAdapter extends ITransferBufferAdapter
{
	void addTransferCommand(IDataFlowCommand command);
	boolean isEmpty();

	IFlushRecorder recordFlush();

	static interface IFlushRecorder
	{
		void flush(IRecordContext context);
	}

	static interface IDataFlowCommand
	{
		IMemoryTicket getMemoryTicket();
		EFlowType getFlowType();
		void execute(MemoryStack stack, VkCommandBuffer commandBuffer);
		Consumer<IMemoryTicket> getPostAction();
	}

	static enum EFlowType
	{
		PUSH,
		FETCH
	}
}
