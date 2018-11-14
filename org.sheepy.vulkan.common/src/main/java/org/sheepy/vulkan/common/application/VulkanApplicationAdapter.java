package org.sheepy.vulkan.common.application;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.AbstractAdapter;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.api.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.common.window.IWindowListener;
import org.sheepy.vulkan.common.window.Surface;
import org.sheepy.vulkan.model.IProcessPool;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanPackage;

public class VulkanApplicationAdapter extends AbstractAdapter
		implements IVulkanApplicationAdapter
{
	protected VulkanApplication application;
	protected VulkanApplicationManager manager;
	private IWindowListener resizeListener;

	private boolean listeningResize = true;

	@Override
	public void notifyChanged(Notification notification)
	{
		if (listeningResize)
		{
			if (notification.getFeature() == VulkanPackage.Literals.VULKAN_APPLICATION__SIZE)
			{
				SVector2i newSize = (SVector2i) notification.getNewValue();
				manager.window.setSize(newSize.x, newSize.y);
			}
		}

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
		application = (VulkanApplication) target;
		resizeListener = new ResizeListener();
		
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

		resizeListener = null;
		application = null;
	}

	private void startVulkanApplication()
	{
		manager = new VulkanApplicationManager(application);
		manager.initLogicalDevice();
		manager.loadPipelinePool();
		manager.window.addListener(resizeListener);
	}

	private void stopVulkanApplication()
	{
		manager.window.removeListener(resizeListener);
		manager.stop();
	}

	private void resize(Surface surface)
	{
		listeningResize = false;

		try
		{
			SVector2i size = new SVector2i();
			size.x = surface.width;
			size.y = surface.height;

			application.setSize(size);
			manager.resize(surface);
		} finally
		{
			listeningResize = true;
		}
	}

	@Override
	public void prepare()
	{
		manager.prepare();
	}

	@Override
	public void execute(IProcessPool processPool)
	{
		VulkanApplicationManager.execute(processPool);
	}

	@Override
	public boolean shouldClose()
	{
		return manager.window.shouldClose();
	}

	@Override
	public void close()
	{
		stopVulkanApplication();
	}

	public VulkanApplicationManager getManager()
	{
		return manager;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.VULKAN_APPLICATION == eClass;
	}

	public static VulkanApplicationAdapter adapt(VulkanApplication application)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(application, VulkanApplicationAdapter.class);
	}

	class ResizeListener implements IWindowListener
	{
		@Override
		public void onWindowResize(Surface surface)
		{
			resize(surface);
		}
	}
}
