package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAllocation;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.resource.transfer.IDataFlowCommand;

import java.util.function.Consumer;

public interface InternalTransferBufferAllocation extends ITransferBufferAllocation, INotifier<InternalTransferBufferAllocation.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Runnable, Features> TransferQueueChange = Feature.newFeature();
	}

	void addTransferCommand(IDataFlowCommand command);
	boolean isEmpty();

	IFlushRecorder recordFlush();

	interface IFlushRecorder
	{
		void flush(IRecordable.RecordContext context);
	}
}
