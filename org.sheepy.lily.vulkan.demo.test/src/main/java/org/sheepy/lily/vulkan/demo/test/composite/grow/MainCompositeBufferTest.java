package org.sheepy.lily.vulkan.demo.test.composite.grow;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.model.cadence.GenericCadence;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.ModelFactory;

public class MainCompositeBufferTest
{
	public static int MAX_COUNT = 200;
	public static ModelFactory FACTORY = new ModelFactory();

	public static void main(String[] args)
	{
		LilyLauncher.launch(FACTORY.application);
	}

	@Adapter(scope = GenericCadence.class, name = ModelFactory.CADENCE_NAME)
	public static final class CadenceAdapter implements ICadenceAdapter
	{
		private IProcessAdapter processAdapter;
		private int count = 0;

		@Load
		public void load()
		{
			processAdapter = FACTORY.process.adaptNotNull(IProcessAdapter.class);
		}

		@Override
		public void run()
		{
			FACTORY.taskManager.configure();

			processAdapter.run();
			processAdapter.waitIdle();

			FACTORY.taskManager.nextInstance();

			count++;

			// System.out.println("Step " + count);
			if (count == MAX_COUNT)
			{
				FACTORY.application.setRun(false);
			}
		}
	}
}
