package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.resource.Constants;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

@Statefull
@Adapter(scope = Constants.class)
public class ConstantsAdapter extends AbstractConstantsAdapter
{
	protected Constants constants;

	protected boolean needPush = true;

	public ConstantsAdapter(Constants constants)
	{
		this.constants = constants;
	}

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == ResourcePackage.Literals.CONSTANTS__DATA)
		{
			needPush = true;
		}
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

	public static ConstantsAdapter adapt(Constants object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ConstantsAdapter.class);
	}
}
