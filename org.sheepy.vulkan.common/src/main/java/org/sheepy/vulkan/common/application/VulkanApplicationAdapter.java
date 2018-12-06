package org.sheepy.vulkan.common.application;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.VulkanPackage;

public class VulkanApplicationAdapter extends AbstractStatefullAdapter
		implements IVulkanApplicationAdapter
{
	protected VulkanApplication application;
	private IVulkanEngineAdapter engineAdapter;

	@Override
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == VulkanPackage.Literals.VULKAN_APPLICATION__ENABLED)
		{
			if (application != null
					&& notification.getNewBooleanValue() != notification.getOldBooleanValue())
			{
				if (application.isEnabled())
				{
					startVulkanApplication();
				}
				else
				{
					stopVulkanApplication();
				}
			}
		}
	}

	@Override
	public void setTarget(Notifier target)
	{
		super.setTarget(target);
		application = (VulkanApplication) target;
		VulkanEngine engine = application.getEngine();
		engineAdapter = IVulkanEngineAdapter.adapt(engine);

		IServiceAdapterFactory.INSTANCE.setupRootForAutoAdapters(application);
		
		if (application.isEnabled())
		{
			startVulkanApplication();
		}
	}

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		if (application != null)
		{
			if (application.isEnabled())
			{
				stopVulkanApplication();
			}
		}

		application = null;
		super.unsetTarget(oldTarget);
	}

	private void startVulkanApplication()
	{
		engineAdapter.start();
	}

	private void stopVulkanApplication()
	{
		engineAdapter.stop();
	}

	@Override
	public void allocate()
	{
		engineAdapter.allocate();
	}

	@Override
	public void free()
	{
		engineAdapter.free();
	}

	@Override
	public void pollEvents()
	{
		engineAdapter.pollEvents();
	}

	@Override
	public void close()
	{
		stopVulkanApplication();
	}

	@Override
	public IWindow getWindow()
	{
		return engineAdapter.getWindow();
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.VULKAN_APPLICATION == eClass;
	}

	public static VulkanApplicationAdapter adapt(VulkanApplication application)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(application, VulkanApplicationAdapter.class);
	}

}
