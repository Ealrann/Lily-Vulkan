package org.sheepy.vulkan.common.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.common.test.TestUtils;

public class VulkanApplicationTest
{
	ICadencer cadencer = ICadencer.INSTANCE;

	@Test
	public void testNewWindow()
	{
		Application application = TestUtils.newBasicApplication();

		cadencer.start(application);

		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		cadencer.stop();
	}

	@Test
	public void testEnableDisableApplication()
	{
		Application application = TestUtils.newBasicApplication();
		var engine = VulkanApplicationUtil.getEngine(application);
		engine.setEnabled(false);

		cadencer.start(application);

		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		assertEquals(null, VulkanApplicationUtil.getWindow(application));

		engine.setEnabled(true);

		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		assertNotEquals(null, VulkanApplicationUtil.getWindow(application));

		cadencer.stop();
	}
}
