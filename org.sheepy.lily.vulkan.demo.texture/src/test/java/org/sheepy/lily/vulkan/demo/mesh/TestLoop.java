package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.model.application.Application;

public class TestLoop extends MeshMainLoop
{
	private final int stepCount;

	private int stepIndex = 0;

	public TestLoop(MeshModelFactory factory, int stepCount)
	{
		super(factory);
		this.stepCount = stepCount;
	}

	@Override
	public void step(Application application)
	{
		super.step(application);

		if (stepIndex >= stepCount)
		{
			LilyLauncher.stop(application);
		}

		stepIndex++;
	}

}
