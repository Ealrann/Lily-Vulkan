package org.sheepy.vulkan.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.vulkan.VulkanApplicationLauncher;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.test.TestUtils;

public class VulkanApplicationTest
{
	private VulkanApplicationAdapter applicationAdapter = null;

	@Test
	public void testNewWindow()
	{
		applicationAdapter = (VulkanApplicationAdapter) VulkanApplicationLauncher
				.launch(TestUtils.newBasicApplication());

		applicationAdapter.close();
	}

	@Test
	public void testEnableDisableApplication()
	{
		VulkanApplication application = TestUtils.newBasicApplication();

		application.setEnabled(false);

		applicationAdapter = (VulkanApplicationAdapter) VulkanApplicationLauncher
				.launch(TestUtils.newBasicApplication());

		assertEquals(null, VulkanApplicationUtil.getWindow(application));

		application.setEnabled(true);

		assertNotEquals(null, VulkanApplicationUtil.getWindow(application));

		applicationAdapter.close();
	}
}
