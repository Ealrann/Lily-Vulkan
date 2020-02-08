package org.sheepy.lily.vulkan.core.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.core.test.TestUtils;

public class VulkanApplicationTest
{
	@Test
	public void testNewWindow()
	{
		final Application application = TestUtils.newBasicApplication();

		LilyLauncher.launch(application, () ->
		{
			assertEquals(true, VulkanApplicationUtil.getWindow(application).isOpenned());
			application.setRun(false);
		});
	}
}
