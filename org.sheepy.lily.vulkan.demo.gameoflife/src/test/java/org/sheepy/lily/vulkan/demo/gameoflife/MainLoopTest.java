package org.sheepy.lily.vulkan.demo.gameoflife;

import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.vulkan.demo.gameoflife.model.ModelFactory;

public class MainLoopTest extends MainLoop
{
	private int stepIndex = 0;
	private final int stepCount;

	public MainLoopTest(ModelFactory factory, int stepCount)
	{
		super(factory);
		this.stepCount = stepCount;
	}

	@Override
	public void compute()
	{
		super.compute();

		if (stepIndex >= stepCount)
		{
			ApplicationLauncher.stop(factory.application);
		}

		stepIndex++;
	}
}
