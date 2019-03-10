package org.sheepy.lily.vulkan.common.window;

import java.util.Random;

import org.joml.Vector2i;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.test.BasicModelFactory;
import org.sheepy.lily.vulkan.common.test.TestUtils;

public class WindowTest
{
	private Application application;

	@BeforeEach
	public void init()
	{
		application = TestUtils.newBasicApplication();
	}

	@AfterEach
	public void clean()
	{
		application = null;
	}

	@Test
	public void testNewWindow()
	{
		ApplicationLauncher.launch(application, new IMainLoop()
		{

			@Override
			public void step(Application application)
			{
				int expectedWidth = BasicModelFactory.WIDTH;
				int expectedHeight = BasicModelFactory.HEIGHT;

				Assertions.assertTrue(
						WindowTestUtil.checkWindowSize(application, expectedWidth, expectedHeight));

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

	@Test
	public void testResizeWindow()
	{
		int timeoutMs = 1000;
		long setSizeDate = System.currentTimeMillis();

		ApplicationLauncher.launch(application, new IMainLoop()
		{
			Random random = new Random();
			int expectedWidth = BasicModelFactory.WIDTH;
			int expectedHeight = BasicModelFactory.HEIGHT;

			int index = 0;

			@Override
			public void step(Application application)
			{
				boolean expectedSize = WindowTestUtil.checkWindowSize(application, expectedWidth,
						expectedHeight);
				if (expectedSize == true)
				{
					expectedWidth = random.nextInt(500) + 1;
					expectedHeight = random.nextInt(500) + 1;

					application.setSize(new Vector2i(expectedWidth, expectedHeight));

					index++;
				}
				else
				{
					if (System.currentTimeMillis() > (setSizeDate + timeoutMs))
					{
						Assertions.fail("Window was not resized");
					}
					else
					{
						try
						{
							Thread.sleep(5);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}

				if (index == 5)
				{
					application.setRun(false);
				}
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
