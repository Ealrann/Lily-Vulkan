package org.sheepy.lily.vulkan.demo.test.composite.instance;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceModelFactory;

public class MainCompositeInstanceTest
{
	public static void main(String[] args)
	{
		final var factory = new InstanceModelFactory();
		final var mainLoop = new MainLoop(factory);

		LilyLauncher.launch(factory.application, mainLoop);
	}

	static final class MainLoop implements IMainLoop
	{
		private final InstanceModelFactory factory;

		private IProcessAdapter processAdapter;
		private int count = 0;

		public MainLoop(InstanceModelFactory factory)
		{
			this.factory = factory;
		}

		@Override
		public void step(Application application)
		{
			factory.taskManager.configure();

			processAdapter.run();
			processAdapter.waitIdle();

			factory.taskManager.nextInstance();

			count++;

			if (count == 100)
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
