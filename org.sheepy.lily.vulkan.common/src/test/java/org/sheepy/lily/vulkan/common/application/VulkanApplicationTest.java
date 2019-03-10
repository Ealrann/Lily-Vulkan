package org.sheepy.lily.vulkan.common.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.test.TestUtils;

public class VulkanApplicationTest
{
	@Test
	public void testNewWindow()
	{
		Application application = TestUtils.newBasicApplication();

		ApplicationLauncher.launch(application, new IMainLoop()
		{
			@Override
			public void step(Application application)
			{
				assertEquals(true, VulkanApplicationUtil.getWindow(application).isOpenned());
				application.setRun(false);
			}

			@Override
			public void load(Application application)
			{}

			@Override
			public void free(Application application)
			{}
		});
	}
}
