package org.sheepy.lily.vulkan.common.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.test.TestUtils;

public class VulkanApplicationTest
{
	@Test
	public void testNewWindow()
	{
		Application application = TestUtils.newBasicApplication();

		ApplicationLauncher.launch(application);

		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		ApplicationLauncher.stop(application);
	}

	@Test
	public void testEnableDisableApplication()
	{
		Application application = TestUtils.newBasicApplication();
		var engine = VulkanApplicationUtil.getEngine(application);
		engine.setEnabled(false);

		ApplicationLauncher.launch(application);

		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		assertEquals(false, VulkanApplicationUtil.getWindow(application).isOpenned());

		engine.setEnabled(true);

		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		assertEquals(true, VulkanApplicationUtil.getWindow(application).isOpenned());

		ApplicationLauncher.stop(application);
	}
}
