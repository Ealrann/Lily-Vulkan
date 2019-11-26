package org.sheepy.lily.vulkan.demo.test.composite.grow;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.ModelFactory;

public class MainCompositeBufferTest
{
	public static void main(String[] args)
	{
		final var factory = new ModelFactory();
		final var mainLoop = new MainLoop(factory, 200);

		LilyLauncher.launch(factory.application, mainLoop);
	}

	static final class MainLoop implements IMainLoop
	{
		private final ModelFactory factory;
		private final int maxCount;

		private IProcessAdapter processAdapter;
		private int count = 0;

		public MainLoop(ModelFactory factory, int maxCount)
		{
			this.factory = factory;
			this.maxCount = maxCount;
		}

		@Override
		public void step(Application application)
		{
			factory.taskManager.configure();

			processAdapter.run();
			processAdapter.waitIdle();

			factory.taskManager.nextInstance();

			count++;

			// System.out.println("Step " + count);
			if (count == maxCount)
			{
				factory.application.setRun(false);
			}
		}

		@Override
		public void load(Application application)
		{
			processAdapter = factory.process.adaptNotNull(IProcessAdapter.class);
		}

		@Override
		public void free(Application application)
		{}
	}
}
