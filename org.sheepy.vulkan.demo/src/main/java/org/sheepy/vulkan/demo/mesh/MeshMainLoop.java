package org.sheepy.vulkan.demo.mesh;

import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.common.api.util.UPSMeter;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;

public class MeshMainLoop implements IMainLoop
{
	public MeshModelFactory factory;

	private IProcessAdapter processAdapter;

	private UPSMeter meter;
	private long start = 0;

	@Override
	public void load(Application application)
	{
		var graphicProcess = factory.graphicProcess;

		processAdapter = IProcessAdapter.adapt(graphicProcess);
		processAdapter.allocatePart();

		meter = new UPSMeter(2000);
		start = System.currentTimeMillis();
	}

	@Override
	public void step(Application application)
	{
		updateUniformBuffer();
		processAdapter.prepare();
		processAdapter.execute();
		meter.tick();
	}

	private void updateUniformBuffer()
	{
		if (factory.uniformBufferManager != null)
		{
			final long current = System.currentTimeMillis();
			final float progress = (current - start) / 1000f;

			factory.uniformBufferManager.update(progress);
		}
	}
}
