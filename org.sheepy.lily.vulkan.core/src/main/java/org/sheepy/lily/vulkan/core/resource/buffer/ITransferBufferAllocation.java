package org.sheepy.lily.vulkan.core.resource.buffer;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.core.execution.RecordContext;

public interface ITransferBufferAllocation extends IAdapter, INotifier<ITransferBufferAllocation.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Runnable, Features> TransferQueueChange = IFeature.newFeature();
	}

	boolean isEmpty();

	void flush(RecordContext context);
}
