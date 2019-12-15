package org.sheepy.lily.vulkan.demo.test.composite.instance;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.model.cadence.GenericCadence;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceModelFactory;

public class MainCompositeInstanceTest
{
	public static int MAX_COUNT = 150;
	public static InstanceModelFactory FACTORY = new InstanceModelFactory();

	public static void main(String[] args)
	{
		LilyLauncher.launch(FACTORY.application);
	}

	@Adapter(scope = GenericCadence.class, name = InstanceModelFactory.CADENCE_NAME)
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

			if (count == MAX_COUNT)
			{
				FACTORY.application.setRun(false);
			}
		}
	}
}
