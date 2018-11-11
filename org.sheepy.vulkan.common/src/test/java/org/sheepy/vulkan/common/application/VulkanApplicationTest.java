package org.sheepy.vulkan.common.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sheepy.vulkan.api.VulkanApplicationLauncher;
import org.sheepy.vulkan.common.application.VulkanApplicationAdapter;
import org.sheepy.vulkan.common.test.TestUtils;
import org.sheepy.vulkan.model.VulkanApplication;

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
