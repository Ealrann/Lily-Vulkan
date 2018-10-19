package org.sheepy.vulkan.application;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanPackage;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.window.IWindowListener;
import org.sheepy.vulkan.window.Surface;

public class VulkanApplicationAdapter extends AbstractSheepyAdapter
		implements IVulkanApplicationAdapter
{
	protected VulkanApplication application;
	protected VulkanApplicationManager manager;

	private boolean listeningResize = true;

	private final IWindowListener resizeListener = new IWindowListener()
	{
		@Override
		public void onWindowResize(Surface surface)
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
	};

	@Override
	public boolean isSingleton()
	{
		return false;
	}

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
	protected void load()
	{
		application = (VulkanApplication) target;
		if (application.isEnabled())
		{
			startVulkanApplication();
		}
	}

	@Override
	protected void unload()
	{
		if (application != null)
		{
			if (application.isEnabled())
			{
				stopVulkanApplication();
			}
		}
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

	@Override
	public void prepare()
	{
		manager.prepare();
	}

	@Override
	public void execute(AbstractProcessPool<?> processPool)
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

	public static VulkanApplicationAdapter adapt(VulkanApplication application)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(application, VulkanApplicationAdapter.class);
	}
}
