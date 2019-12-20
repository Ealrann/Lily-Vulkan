package org.sheepy.lily.vulkan.common.window;

import java.util.Random;

import org.joml.Vector2i;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.test.BasicModelFactory;
import org.sheepy.lily.vulkan.common.test.TestUtils;

public class WindowTest
{
	@Test
	public void testNewWindow()
	{
		final var application = TestUtils.newBasicApplication();
		LilyLauncher.launch(application, () ->
		{
			final int expectedWidth = BasicModelFactory.WIDTH;
			final int expectedHeight = BasicModelFactory.HEIGHT;

			Assertions.assertTrue(WindowTestUtil.checkWindowSize(	application,
																	expectedWidth,
																	expectedHeight));

			application.setRun(false);
		});
	}

	@Test
	public void testResizeWindow()
	{
		final var application = TestUtils.newBasicApplication();
		final var step = new TestResizeWindowCadenceAdapter(application);
		LilyLauncher.launch(application, step);
	}

	public static final class TestResizeWindowCadenceAdapter implements Runnable
	{
		private final Random random = new Random();
		private final int timeoutMs;
		private final long setSizeDate;
		private final Application application;

		private int expectedWidth = BasicModelFactory.WIDTH;
		private int expectedHeight = BasicModelFactory.HEIGHT;
		private int index = 0;

		public TestResizeWindowCadenceAdapter(Application application)
		{
			this.application = application;
			timeoutMs = 1000;
			setSizeDate = System.currentTimeMillis();
		}

		@Override
		public void run()
		{
			final boolean expectedSize = WindowTestUtil.checkWindowSize(application,
																		expectedWidth,
																		expectedHeight);
			if (expectedSize == true)
			{
				expectedWidth = random.nextInt(700) + 201;
				expectedHeight = random.nextInt(700) + 201;

				application.getScene().setSize(new Vector2i(expectedWidth, expectedHeight));

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
					} catch (final InterruptedException e)
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
	}
}
