package org.sheepy.lily.vulkan.demo.test;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.demo.test.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.demo.test.model.ModelFactory;

public class MainCompositeBufferTest
{
	public static void main(String[] args)
	{
		final var factory = new ModelFactory();
		final var mainLoop = new MainLoop(factory);

		LilyLauncher.launch(factory.application, mainLoop);
	}

	static final class MainLoop implements IMainLoop
	{
		private final ModelFactory factory;

		private IProcessAdapter processAdapter;
		private int count = 0;

		public MainLoop(ModelFactory factory)
		{
			this.factory = factory;
		}

		@Override
		public void step(Application application)
		{
			processAdapter.run();
			processAdapter.getQueue().waitIdle();

			final var providers = factory.resourceContainer.compositeBuffer.getDataProviders();
			final var targetBuffers = factory.resourceContainer.targetBuffers;
			for (int i = 0; i < targetBuffers.size(); i++)
			{
				final var buffer = targetBuffers.get(i).adapt(IBufferAdapter.class);
				final var provider = providers.get(i).adapt(TestDataProviderAdapter.class);

				buffer.invalidate();
				if (provider.check(buffer.mapMemory()) == false)
				{
					throw new AssertionError("Not valid !!");
				}
			}

			count++;

			// System.out.println("End step " + count);
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
