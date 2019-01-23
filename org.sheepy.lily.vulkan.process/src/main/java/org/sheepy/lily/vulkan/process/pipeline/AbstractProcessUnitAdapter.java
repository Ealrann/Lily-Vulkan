package org.sheepy.lily.vulkan.process.pipeline;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.vulkan.common.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

public abstract class AbstractProcessUnitAdapter<T extends AbstractCommandBuffer>
		extends AbstractDeepAllocableAdapter implements IProcessUnitAdapter<T>
{
	protected boolean recordNeeded = false;

	@Override
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == ProcessPackage.Literals.IPROCESS_UNIT__ENABLED
				&& notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
	}
	
	@Override
	public void setRecordNeeded(boolean value)
	{
		recordNeeded = value;
	}

	@Override
	public boolean isRecordNeeded()
	{
		return recordNeeded;
	}

}
