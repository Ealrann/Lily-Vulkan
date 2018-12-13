package org.sheepy.vulkan.common.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.common.api.application.ApplicationLauncher;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.common.test.TestUtils;

public class VulkanApplicationTest
{
	@Test
	public void testNewWindow()
	{
		Application application = TestUtils.newBasicApplication();

		ApplicationLauncher.launch(application);

		ApplicationLauncher.close(application);
	}

	@Test
	public void testEnableDisableApplication()
	{
		Application application = TestUtils.newBasicApplication();
		var engine = VulkanApplicationUtil.getEngine(application);
		engine.setEnabled(false);

		ApplicationLauncher.launch(application);

		assertEquals(null, VulkanApplicationUtil.getWindow(application));

		engine.setEnabled(true);

		assertNotEquals(null, VulkanApplicationUtil.getWindow(application));

		ApplicationLauncher.close(application);
	}
}
