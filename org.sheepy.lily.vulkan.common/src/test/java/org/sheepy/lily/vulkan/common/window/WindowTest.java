package org.sheepy.lily.vulkan.common.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.joml.Vector2i;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.common.application.VulkanApplicationUtil;
import org.sheepy.lily.vulkan.common.test.BasicModelFactory;
import org.sheepy.lily.vulkan.common.test.TestUtils;

public class WindowTest
{
	private Application application;

	@BeforeEach
	public void init()
	{
		application = TestUtils.newBasicApplication();
		ApplicationLauncher.launch(application);
	}

	@AfterEach
	public void clean()
	{
		ApplicationLauncher.stop(application);
		application = null;
	}

	@Test
	public void testNewWindow()
	{
		int expectedWidth = BasicModelFactory.WIDTH;
		int expectedHeight = BasicModelFactory.HEIGHT;

		WindowTestUtil.checkWindowSize(application, expectedWidth, expectedHeight);
	}

	@Test
	public void testResizeWindow()
	{
		Random random = new Random(System.currentTimeMillis());
		int newWidth = random.nextInt(500) + 1;
		int newHeight = random.nextInt(500) + 1;

		var window = VulkanApplicationUtil.getWindow(application);
		window.addListener(new IWindowListener()
		{
			@Override
			public void onResize(Vector2i size)
			{
				assertEquals(newWidth, size.x);
				assertEquals(newHeight, size.y);
			}
		});

		application.setSize(new Vector2i(newWidth, newHeight));
	}
}
