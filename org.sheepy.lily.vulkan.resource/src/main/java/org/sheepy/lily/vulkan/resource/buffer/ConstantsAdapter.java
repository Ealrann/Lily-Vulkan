package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.Constants;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

public class ConstantsAdapter extends AbstractConstantsAdapter
{
	protected Constants constants;

	protected boolean needPush = true;

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);

		if (notification.getFeature() == ResourcePackage.Literals.CONSTANTS__DATA)
		{
			needPush = true;
		}
	}

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		constants = (Constants) target;
	}

	@Override
	public boolean needRecord()
	{
		return needPush;
	}

	@Override
	protected int getSize()
	{
		return constants.getData().capacity();
	}

	@Override
	public ByteBuffer getData()
	{
		return constants.getData();
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.CONSTANTS == eClass;
	}

	public static ConstantsAdapter adapt(Constants object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ConstantsAdapter.class);
	}
}
