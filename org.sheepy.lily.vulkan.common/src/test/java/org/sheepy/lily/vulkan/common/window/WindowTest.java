package org.sheepy.lily.vulkan.common.window;

import java.util.Random;

import org.joml.Vector2i;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.cadence.GenericCadence;
import org.sheepy.lily.vulkan.common.test.BasicModelFactory;
import org.sheepy.lily.vulkan.common.test.TestUtils;

public class WindowTest
{
	private static final String testNewWindowCadenceName = "testNewWindowCadenceName";
	private static final String testResizeWindowCadenceName = "testResizeWindowCadenceName";

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
		final var cadence = CadenceFactory.eINSTANCE.createGenericCadence();
		cadence.setName(testNewWindowCadenceName);
		application.getEngines().get(0).setCadence(cadence);
		IAdapterRegistry.INSTANCE.register(TestNewWindowCadenceAdapter.class);
		LilyLauncher.launch(application);
	}

	@Statefull
	@Adapter(scope = GenericCadence.class, name = testNewWindowCadenceName)
	public static final class TestNewWindowCadenceAdapter implements ICadenceAdapter
	{
		private final Application application;

		public TestNewWindowCadenceAdapter(GenericCadence cadence)
		{
			application = ModelUtil.getApplication(cadence);
		}

		@Override
		public void run()
		{
			final int expectedWidth = BasicModelFactory.WIDTH;
			final int expectedHeight = BasicModelFactory.HEIGHT;

			Assertions.assertTrue(WindowTestUtil.checkWindowSize(	application,
																	expectedWidth,
																	expectedHeight));

			application.setRun(false);
		}
	}

	@Test
	public void testResizeWindow()
	{
		final var cadence = CadenceFactory.eINSTANCE.createGenericCadence();
		cadence.setName(testResizeWindowCadenceName);
		application.getEngines().get(0).setCadence(cadence);
		IAdapterRegistry.INSTANCE.register(TestResizeWindowCadenceAdapter.class);
		LilyLauncher.launch(application);
	}

	@Statefull
	@Adapter(scope = GenericCadence.class, name = testResizeWindowCadenceName)
	public static final class TestResizeWindowCadenceAdapter implements ICadenceAdapter
	{
		private final Application application;

		private final Random random = new Random();
		private int expectedWidth = BasicModelFactory.WIDTH;
		private int expectedHeight = BasicModelFactory.HEIGHT;
		private int index = 0;
		private final int timeoutMs;
		private final long setSizeDate;

		public TestResizeWindowCadenceAdapter(GenericCadence cadence)
		{
			application = ModelUtil.getApplication(cadence);
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
